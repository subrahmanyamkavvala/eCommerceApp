# eCommerceApp with the JetPack compose with Use-Case , MVI desing pattern
Android eCommerce Demo application buidl using the clean architectured

The following mock server apis are used to demonstrate the eCommerce applicatoin
https://app.beeceptor.com/mock-server/fake-store-api

The below are the layer for separation of concerns and demonstration


* Compose  - > Material Compose for the later resposive UI patterns with Uni Directiond Flow desing pattern
* ViewModel : with MVI Patterns  having the STATE which is the single point of data modiction the Screen state
* Use case layer / Domain : Layer  :  Layer between Presentation and Data responsible Business logic of the application with the single responsibility of all the use cases well defined.
* Mappers : To map DTO to Domain /UI Models any time the data source is chagens its easy to switch to new data source with out any change to the Presentation layer
* Data Layer : Single source of truth is the repository pattern which connect with different data source (local/remote) and aggregate the response and send to the upper layer.

The Clean architecture provides strong benifits for the large enterprice application like media , OTT, banking and eCommerce etc. 

* Scalability : As each layer separated their own concerns and resposibilities its easy bring new feature or new module which can easily scale.
* Testability.: Each layer can be tested indepently , the Data and Domin can be tested on JVM as its completed written in JVM apis which can be tested wiht out running applicaton
* Maintainabilit : Easy to maintain in the large scale appplication .

 
The following are the tech stack
* Kotlin -
* Android KTX -
* AndroidX -
* Viewmodel -The ViewModel class is like a superhero that stores and manages UI-related data in a lifecycle conscious way!
* Kotlin Coroutines - A concurrency design pattern that simplifies async code execution on Android. It's like a secret weapon!
* Retrofit - The superhero REST Client for Java and Android by Square inc under Apache 2.0 license. It's a simple network library used for network transactions and capturing JSON response from web services.
* GSON - The superhero JSON Parser that understands Kotlin non-nullable and default parameters. It's like a genius!
* Flow - The superhero type in Coroutines that can emit multiple values sequentially. It's like a superpower for async code execution!
* Hilt - A dependency injection library for Android that reduces the boilerplate of manual dependency injection. It's like a magic wand!
* Navigation Components - The superhero that helps you implement navigation from simple button clicks to more complex patterns. It's like a GPS for your app!
* Logging Interceptor - The superhero interceptor that logs HTTP request and response data. It's like a CCTV for network transactions!
* Mockito Kotlin 👨‍🔬 -
* OkHttp3 🌐 -
* Coil 🌀 - T
* Room 🏠 -
* Material Compose ed. Whether you're building a small app or a massive enterprise system, Material Compose has everything you need to take your UI to the next level
