
## RxBus：用RxJava实现EventBus ##
项目引入了RxJava之后，想减少包的依赖，决定使用RxJava实现EventBus。
详细介绍：[http://www.jianshu.com/p/099f35b8f4b4](http://www.jianshu.com/p/099f35b8f4b4)

## 使用方法 ##
#### 发送事件 ####
```
RxBus.getDefault().post(new TestEvent ());
```
#### 订阅事件 ####
```
RxBus.getDefault().subscribe(this, new Callback<TestEvent>() {
    @Override
    public void onEvent(TestEvent event) {
        // TODO 事件处理
    }
});
```
#### 取消事件订阅 ####
```
RxBus.getDefault().unsubscribe(this);
```