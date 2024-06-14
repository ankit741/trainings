# TPS and Peak TPS

Transaction per second (TPS) is the number of transactions executed per second. In other words, it can be calculated based on how many transactions are executed over a certain duration of the test and then calculate it for a second.

For example, if a vuser executes 6 transactions every minute, then the TPS would be 6 transactions/60 sec = 0.10 TPS

There's an important fact hidden in the above example. It also tells us that if the vuser is able to complete 6 transactions in 60 seconds that means response time for each transaction is 10 sec. i.e.

0.10 transactions –> 1 second

1 transaction –> 10 seconds


**Example1** :  Let’s say that we have set Pacing to zero and Think Time to zero.

A vuser performs 5 transactions and response time for each transaction is 10 seconds. Then it will take 5*10 = *50 seconds to complete 5 transactions. i.e. 5/50 = 0.1 TPS. *Here, you can see that TPS is controlled by response time.

[![Example 1](https://theperformanceengineer.com/wp-content/uploads/2013/09/tps-11.png?w=360&h=57)](https://theperformanceengineer.com/wp-content/uploads/2013/09/tps-11.png)

 **Example2** :  Let’s say that we have set pacing to 15 sec and Think Time to zero.

A vuser performs 5 transactions and response time for each transaction is 10 seconds. But the fact that now pacing is greater than response times, it will override the response times and it will control the transaction rate.  Thence it will take 5*15 = 75 seconds to complete 5 iterations.  i.e. 5/75 = 0.06667 TPS [This is the most correct way of setting up your test scenario to simulate consistent TPS load on the system under test.]

[![Example 2](https://theperformanceengineer.com/wp-content/uploads/2013/09/tps-21.png?w=700&h=75)](https://theperformanceengineer.com/wp-content/uploads/2013/09/tps-21.png)

In the second example, as long as the average response times are less than 15 seconds, it will always take 75 seconds to complete 5 iterations i.e. generate 0.06667 TPS

In both the above examples, we also assumed that think time was set to Zero. If, say, it was 2 seconds, total time taken to complete 5 transactions would still be 5*15 = 75 seconds i.e. generate (5/75) = 0.06667 TPS

[![Response time plus Think time](https://theperformanceengineer.com/wp-content/uploads/2013/09/tps-4-thinktime.png?w=700)](https://theperformanceengineer.com/wp-content/uploads/2013/09/tps-4-thinktime.png)

Once you understand this concept, rest understanding of Little’s law is easy.

If pacing is set to zero, then

**Number of vusers = TPS * (Response Time + Think Time)**

If pacing is ≠ zero and pacing > (response time + Think Time) , then the above formula would look like this

**Number of vusers = TPS * (Pacing)**

The fact that TPS is a rate of transactions w.r.t. time, it is also called as throughput.

So Little’s law is

Average number of users in the system = average response time * throughput

**N  =  ( R + Z )  *  X**

Where, N = Number of users

R = average response time (now you know, it can be pacing too)

Z = Think Time

X = Throughput (i.e. TPS)

Example, If N = 100, R = 2 sec, 100= (2+Z)*X and hence –> If Z=18, X = 5

NOTE: Please do let me know if you see any flaws in the above theory.


# How to set an ideal thread pool size

We all know that thread creation in Java is not free. The actual overhead varies across platforms, but thread creation takes time, introducing latency into request processing, and requires some processing activity by the JVM and OS. This is where the Thread Pool comes to the rescue.

The thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing.

In this post, I want to talk about how to set an optimal thread pool size. A well-tuned thread pool can get the most out of your system and help you survive peak loads. On the other hand, even with a thread pool in place, thread handling could be a bottleneck.



## Why should I set a limit for my thread pool?

There is a lovely pre-configured thread pool - Executors.newChachedThreadPool Why don't we just use it?

Let's look at how it works:

```
/**ThreadPoolconstructor*/
publicThreadPoolExecutor(intcorePoolSize,
intmaximumPoolSize,
longkeepAliveTime,
TimeUnitunit,
BlockingQueueworkQueue){...}

/**CachedThreadPool*/
publicstaticExecutorServicenewCachedThreadPool(){
returnnewThreadPoolExecutor(0,Integer.MAX_VALUE,
60L,TimeUnit.SECONDS,
newSynchronousQueue());
}
```

Do you see this SynchronousQueue? It means that each new task will create a new thread if all existing threads are busy. In the case of high load, at best we will get a thread "starvation" situation, at worst OutOfMemoryError.

It is better to maintain control and not allow clients to "DDoS/throttle" our service.


## Know your limits

Before you start sizing a thread pool you have to understand what you are limited to. And I don’t only mean hardware.

For example if a worker thread depends on a database, the thread pool is limited by the database's connection pool size. Does it make any sense to have 1000 running threads in front of a database connection pool with 100 connections?

Or if a worker thread calls an external service which can handle only a few requests simultaneously, the thread pool is limited by the throughput of this service as well.

It is obvious but we often forget it.

Of course, one of the most important resources for thread pool is CPU. We can get the total number of CPUs that we have as follows:

```
int numOfCores = Runtime.getRuntime().availableProcessors();
```

It was a classic way to get number of CPUs for many years. But be careful with this command if you run your service in a container environment. *Without specifying any constraints, a containerized process will be able to see the hardware on the host OS.

*Here are some nice articles on this topic: [Better Containerized JVMs in JDK10](https://mjg123.github.io/2018/01/10/Java-in-containers-jdk10.html)

and: [Nobody puts Java in a container](https://jaxenter.com/nobody-puts-java-container-139373.html).

Other constraints like memory, file handles, socket handles, could be critical as well.

## Just give me the formula!

Brian Goetz in his famous book "Java Concurrency in Practice" recommends the following formula:

```
 Number of threads = Number of Available Cores * (1 + Wait time / Service time)
```

**Waiting time** - is the time spent waiting for IO bound tasks to complete, say waiting for HTTP response from remote service.

(not only IO bound tasks, it could be time waiting to get monitor lock or time when thread is in WAITING/TIMED_WAITING state)

**Service time** - is the time spent being busy, say processing the HTTP response, marshaling/unmarshaling, any other transformations etc.

Wait time / Service time - this ratio is often called  *blocking coefficient* .

A computation-intensive task has a blocking coefficient close to 0, in this case, the number of threads is equal to the number of available cores. If all tasks are computation intensive, then this is all we need. Having more threads will not help.

*For example:*

A worker thread makes a call to a microservice, serializes response into JSON and executes some set of rules. The microservice response time is 50ms, processing time is 5ms. We deploy our application to a server with a dual-core CPU:

```
  2 * (1 + 50 / 5) = 22 // optimal thread pool size
```

But this example is oversimplified. Besides an HTTP connection pool, your application may have requests from JMS and probably a JDBC connection pool.

If you have different classes of tasks it is best practice to use multiple thread pools, so each can be tuned according to its workload.

In case of multiple thread pools, just add a target CPU utilization parameter to the formula.

Target CPU utilization [0..1], 1 - means thread pull will keep the processors fully utilized).

The formula becomes:

```
 Number of threads = Number of Available Cores * Target CPU utilization * (1 + Wait time / Service time)
```

## Little's law

At this step we can get an optimal thread pool size, we know our theoretical upper bounds and we have some metrics in place. But how does the number of parallel workers change the latency or throughput?

[Little&#39;s law](https://en.wikipedia.org/wiki/Little%27s_law) can be used to answer this question. The law says that the number of requests in a system equals the rate at which they arrive, multiplied by the average amount of time it takes to service an individual request. We can use this formula to calculate how many parallel workers there should be to handle a predefined throughput at a particular latency level.

```
L = λ * W

L - the number of requests processed simultaneously
λ – long-term average arrival rate (RPS)
W – the average time to handle the request (latency)
```

Using this formula, we can calculate the system capacity, or how many instances running in parallel we need in order to handle the required number of requests per second with a stable response time.

Let's get back to our example. We have a service with average response time 55ms (50 wait time + 5 service time) and thread pool size with 22 worker threads.

Applying Little's law formula we get:

```
22/0.055=400//thenumberofrequestspersecondourservicecanhandlewithastableresponsetime
```

## Conclusion

These formulas are not a silver bullet and cannot magically fit any projects but they could be a great starting point for your project. The disadvantage of the formulas is that they focus on the average number of requests in the system and might not suit for various traffic burst patterns. You can start with the values calculated by these formulas and then adjust your thread pool properties after load testing.

And one more time - “measure don’t guess”!
