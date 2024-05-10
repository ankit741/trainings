# Introduction

### What is cloud computing?

Cloud computing is the on-demand delivery of compute power, database, storage, applications, and other IT resources through a cloud services platform through the internet with pay-as-you-go pricing. Traditionally, a developer looking to build an application had to procure, set up, and maintain physical infrastructure and the application. This is where cloud computing comes in.

A cloud services platform provides rapid access to flexible and low-cost IT resources that you can use to build and maintain software and databases, and create applications to delight customers. You don’t need to make large upfront investments in hardware and spend a lot of time on the heavy lifting of managing that hardware. You can access as many resources as you need, almost instantly, and only pay for what you use. On-demand, pay-as-you-go access to services is fundamental to the cloud computing model.

**Types of cloud computing**

**Public cloud**

Public clouds are owned and operated by third-party cloud service providers, which deliver computing resources like servers and storage over the internet. Microsoft Azure is an example of a public cloud. With a public cloud, all hardware, software, and other supporting infrastructure is owned and managed by the cloud provider. You access these services and manage your account using a web browser.

**Private cloud**

A private cloud refers to cloud computing resources used exclusively by a single business or organization. A private cloud can be physically located on the company's onsite datacenter. Some companies also pay third-party service providers to host their private cloud. A private cloud is one in which the services and infrastructure are maintained on a private network.

**Hybrid cloud**

Hybrid clouds combine public and private clouds, bound together by technology that allows data and applications to be shared between them. By allowing data and applications to move between private and public clouds, a hybrid cloud gives your business greater flexibility and more deployment options and helps optimize your existing infrastructure, security, and compliance.

### Advantages of cloud computing

The cloud provides developers with greater flexibility, scalability, and faster time to innovation. With cloud computing, you can

* **Pay as you go** - Pay only when you use computing resources, and only for how much you use.
* **Benefit from massive economies of scale** - AWS aggregates usage from hundreds of thousands of customers in the cloud, which leads to higher economies of scale. This translates into lower pay-as-you-go prices.
* **Stop guessing capacity ** - When you make a capacity decision prior to deploying an application, you often end up either sitting on expensive idle resources or dealing with limited capacity. With cloud computing, you can access as much or as little capacity as you need, and scale up and down as required with only a few minutes notice.
* **Increase speed and agility** - IT resources are only a click away, which means that you reduce the time to make resources available to your developers from weeks to minutes. This dramatically increases agility for the organization, because the cost and time it takes to experiment and develop is significantly lower.
* **Realize cost savings** - Companies can focus on projects that differentiate their business instead of maintaining data centers. With cloud computing, you can focus on your customers, rather than on the heavy lifting of racking, stacking, and powering physical infrastructure.
* **Go global in minutes** - Applications can be deployed in multiple Regions around the world with a few clicks. This means that you can provide lower latency and a better experience for your customers at a minimal cost.

### What are the types of cloud computing services?

With the growing popularity of cloud computing, several different service models have emerged to help meet specific needs of different users. Each type of cloud service provides you with different levels of abstraction, control, flexibility, and management. Understanding the differences between Infrastructure as a Service (IaaS), Platform as a Service (PaaS), and Software as a Service (SaaS) can help you decide what service type is right for your needs as a developer.

**Infrastructure as a Service (IaaS)**

Infrastructure as a Service (IaaS) contains the basic building blocks for cloud IT, and typically provides access to networking features, computers (virtual or on dedicated hardware), and data storage space. IaaS provides you with the highest level of flexibility and management control over your IT resources and is most like existing IT resources that many developers are familiar with today.

**Platform as a Service (PaaS)**

Platform as a Service (PaaS) removes the need for you to manage the underlying infrastructure (usually hardware and operating systems) and allows you to focus on the deployment and management of your applications. This helps you be more efficient because you don't need to worry about resource procurement, capacity planning, software maintenance, patching, or any of the other undifferentiated heavy lifting involved in running your application.

**Software as a Service (SaaS)**

Software as a Service (SaaS) provides you with a completed product that is run and managed by the service provider. In most cases, people referring to SaaS are referring to end-user applications. With a SaaS offering you do not have to think about how the service is maintained or how the underlying infrastructure is managed; you only need to think about how you will use that piece of software. A common example of a SaaS application is web-based email which you can use to send and receive email without having to manage feature additions to the email product or maintain the servers and operating systems that the email program is running on.

**Serverless computing**

Overlapping with PaaS, serverless computing focuses on building app functionality without spending time continually managing the servers and infrastructure required to do so. The cloud provider handles the setup, capacity planning, and server management for you. Serverless architectures are highly scalable and event-driven, only using resources when a specific function or trigger occurs.

## Use cases

* Infrastructure scaling
* Disaster recovery

* Data storage
* Application development

* Big data analytics


### What is AWS cloud?

AWS provides on-demand delivery of technology services through the Internet with pay-as-you-go pricing. This is known as cloud computing.

The AWS Cloud encompasses a broad set of global cloud-based products that includes compute, storage, databases, analytics, networking, mobile, developer tools, management tools, IoT, security, and enterprise applications: on-demand, available in seconds, with pay-as-you-go pricing. With over 200 fully featured services available from data centers globally, the AWS Cloud has what you need to develop, deploy, and operate your applications, all while lowering costs, becoming more agile, and innovating faster.

Cloud computing provides developers with the ability to focus on what matters most and avoid infrastructure procurement, maintenance, and capacity planning, or undifferentiated heavy lifting.

### AWS Regions

* AWS has Regions all around the world
* Names can be us-east-1, eu-west-3…
* A region is a cluster of data centers
* Most AWS services are region-scoped

### AWS Availability Zones

* Each region has many availability zones
  (usually 3, min is 3, max is 6). Example:
* ap-southeast-2a
  ap-southeast-2b
  ap-southeast-2c
* Each availability zone (AZ) is one or more
  discrete data centers with redundant power,
  networking, and connectivity
* They're separate from each other, so that
  they're isolated from disasters
* They're connected with high bandwidth,
  ultra-low latency networking

### AWS Points of Presence (Edge Locations)

* Amazon has 400+ Points of Presence (400+ Edge Locations & 10+
  Regional Caches) in 90+ cities across 40+ countries
* Content is delivered to end users with lower latency
