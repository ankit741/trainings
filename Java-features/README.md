# JDK Features
## New Features of JDK9 (September 2017)
- Modular
- Factory methods are provided, such as List.of(), Set.of(), Map.of(), and Map.ofEntries().
- Interfaces support private methods.
- Optional Class Improvements
- JAR Packages Compatible with Multiple Versions
- JShell Tool
- Improvement of Try-with-resources
- Improvements to the Stream API
- Set G1 as the JVM default garbage collector
- APIs that support HTTP2.0 and WebSocket
### Its important features are mainly API optimization (such as Client API supporting HTTP2) and JVM using G1 as the default garbage collector.

## New Features of JDK10 (March 2018)
- Local variable type inference, similar to JS, can use var to modify local variables. After compilation, the true type of the value is inferred.
- Improvements to Immutable Collections
- Parallel Full Garbage Collector G1 to Optimize G1 Latency
- Thread local handshake allows thread callbacks to be executed without executing a global VM safe point. A single thread can be stopped.
- New orElseThrow() method in Optional
- Class Data Sharing
- Unicode Language Label Extension
- Root Certificates
- Its important features are local variable type inference is realized through the var keyword, making Java language a weak type language and G1 garbage collection of JVM changing from single thread to multi-thread parallel processing, thus reducing G1 pause time.

## New Features of JDK11 (September 2018) (LTS Version)
- Add some string processing methods
- Local Variable Syntax for Lambda Parameters
- HTTP Client Rewrite supports HTTP/1.1, HTTP/2, and WebSockets.
- Run a single Java source code file, such as java Test.java
- ZGC: Scalable and low-latency garbage collector. ZGC can be seen as a more fine-grained memory management strategy than G1. Since the continuous allocation and recycling of the memory will generate a large amount of memory fragmentation space, a defragmentation policy is required. The thread for memory reference needs to be logically suspended during defragmentation. This process is called Stop the world. The thread logic can only continue to run when the process is complete. (Parallel Reclaim)
- Support for TLS 1.3 Protocol
- Flight Recorder, a Data Collection Framework for OS, JVM, and a JDK-based Event
- Enhancements to the Stream, Optional, and Collection APIs
### Its important features are improvements for JDK9 and JDK10, mainly for stream, collection, and other APIs and a new ZGC garbage collector.

## New Features of JDK12 (March 2019)
- Switch expression extension with a return value
- Add NumberFormat to format complex numbers
- Character strings support the transform and indent operations
- Add Method Files.mismatch (Path, Path)
- Teeing Collector
- Support for Unicode 11
- Shenandoah GC, New GC Algorithm
- The optimization of the G1 collector divides the garbage of the GC into a mandatory and an optional part. The mandatory part will be recycled, while the optional part may not be recycled, improving the efficiency of the GC.
### Its important features are the switch expression syntax extension, G1 collector optimization, and new Shenandoah GC garbage collection algorithm.

## New Features of JDK13 (September 2019)
- The switch expression is extended. The switch expression adds the yield keyword to return the result. The function is similar to return. If no result is returned, break is used.
- Text blocks are upgraded to """. It introduced text blocks. You can use three double quotation marks (""") to indicate text blocks. You do not need to use line break escape characters inside text blocks.
- SocketAPI refactoring, the underlying implementation of Socket is optimized, and NIO is introduced.
- FileSystems.newFileSystem New Method
- ZGC is optimized to enhance ZGC to release unused memory and return the in-heap memory space marked as idle for a long time to the operating system. It aims to ensure that the heap size is not less than the configured minimum heap memory size. If the maximum heap size is the same as the minimum heap memory size, the memory will not be released to the operating system.
### Its important features are ZGC optimization, releasing memory back to the operating system, and introducing NIO to the underlying socket implementation.

## New Features of JDK14 (March 2020)
- Instanceof pattern matching and instanceof type matching syntax simplification can directly assign values to objects, such as if(obj instanceof String str). If obj is a string type, directly assign values to str variables.
- Introduce the record type, which is similar to the @Data annotation of Lombok. It can automatically generate constructors, equals, getters, and other methods like Lombok.
- Switch Expression-Standardization
- Improve the NullPointerExceptions prompt information, print the null pointer exception thrown by the specific method, avoid the trouble that it is impossible to judge which function throws the exception when multiple functions in the same line of code are called, and facilitate exception troubleshooting
- Delete a CMS garbage collector
- New Features of JDK15 (September 2020)
- EdDSA Digital Signature Algorithm
- Sealed Classes (Preview): The sealed keyword is used to modify abstract classes to only restrict specified subclasses to implement or inherit abstract classes to avoid abuse of abstract classes.
- Hidden Classes
- Remove the Nashorn JavaScript engine
- Improve java.net.DatagramSocket and java.net.MulticastSocket underlying implementation.
- New Features of JDK16 (March 2021)
- Allows use of C ++ 14 features in the JDK C ++ source code
- ZGC performance optimization removes the ZGC thread stack processing from the safe point to the concurrent phase.
- Add Unix Domain Socket Channel
- Elastic Meta-space Capability
- Provide the jpackage tool for packaging standalone Java applications
- JDK16 is equivalent to the formal introduction of some features of JDK14 and JDK15, such as instanceof pattern matching, record introduction, etc. JDK16 became the final version.

## New Features of JDK17 (September 2021) (LTS version)
- Free Java License
- JDK 17 will replace JDK 11 as the next long-term support release.
- Spring 6 and Spring Boot 3 require JDK17.
- Remove experimental AOT and JIT compilers
- Restore always-strict floating-point definitions
- The sealed class is formally introduced to restrict the implementation of abstract classes.
- Unify log asynchronous refresh. Logs are written to the cache and then asynchronously refreshed.
### Although JDK17 is an LTS version, it does not introduce prominent features (like JDK8 and JDK11), mainly integrating and improving the previous versions.
