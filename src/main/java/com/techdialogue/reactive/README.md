Reactive ==> (Data flow computing, composition of events, Serverless computing)
1. Elastic and Scalable 
2. Event(message) driven 
3. Responsive
4. Resilient

|Java8 Streams|Reactive Streams|
|:-------------|:------------|
|Pipeline|Pipeline
|Lazy evaluation|Lazy evaluation
|Passing data|Pass data
|0,1 or more data|0, 1 or more data
|---------------|-----------------
|1 channel(data)|3 channels(data, error, complete)
|error, blows up?|error channel(error as data, deal with it downstream)
|seq vs parallel|sync vs async
|no path forking|multiple subscribers
|push at will|backpressure          

3 channels ==> data, error, complete
<br/> data channel -> transmits stream of data
<br/> error channel -> sends error which is treated as data
<br/> complete channel -> sends one complete signal and data channel closes

<br/>Recovery from error onError resumeNext ??

Java 9 Flow API
1. RxJava
2. Akka
3. Spring Reactor