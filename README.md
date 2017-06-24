# SimpleKotlinBoilerplate

![image](https://github.com/githubwing/GankClient-Kotlin/raw/master/img/pic1.png)
![image](https://github.com/githubwing/GankClient-Kotlin/raw/master/img/pic2.png)

gank.io kotlin实现的干货集中营客户端

风格采用了Material Design. 多数控件都是design包里面的。



## 项目模式

* [Kotlin](https://github.com/JetBrains/kotlin)
* [MVP,fork from Mosby](ArchitectureTemplate)
* [Dagger2.11-rc2](https://github.com/google/dagger)
* [Rxjava](https://github.com/ReactiveX/RxJava)
* DataBinding
* [Retrofit](https://github.com/square/retrofit)
* [Okhttp3](https://github.com/square/okhttp)
* [DeepLinkDispatch](https://github.com/airbnb/DeepLinkDispatch)
* [Gson](https://github.com/google/gson)
* [Glide](https://github.com/bumptech/glide)
* [ByeBurger](https://github.com/githubwing/ByeBurger)

## Kotlin
 支持Android Studio 3.0的kotlin,kotlin支持和java一起编码，kotlin可以简化很多代码量

## MVP 
采用mosby提供的MVP架构方式。

## Dagger2

  项目中,主要进行presenter、model、retrofit Api等类的注入操作。
  
  支持Dagger2.11-rc2版本中的
  
  - dagger-android
  - dagger-android-support
 
  
## Rxjava + Retrofit + okhttp3
  主要用于网络访问。
  
## DeepLinkDispatch
  基于路由进行页面转发。
  
   **GankClientUri** 定义一些路由规则、URI等
   
   **GankRouter** 统一由此进行路由操作

## GSON
  用于json的解析操作。
  
## Glide
  用于图片的加载。
  
## ByeBurGer
  用于导航栏以及悬浮按钮滑动隐藏。
  
## Thanks

https://github.com/githubwing/GankClient-Kotlin