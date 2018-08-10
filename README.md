# LiveDataDemo

MainActivity 中实现了LifecycleRegistryOwner
在一个自定义view中添加了注解，与activity生命周期保持一致，运行可看见跟随activity 的周期变化。




Main2Activity
使用了MutableLiveData 它是 livedata的子类，并且写成 观察者模式对数据实时进行操作。

demo 比较简陋 目前就酱。 后续会在这个分支更新，或者是在其他分支上进行完善。