# ChainSample
 提供链式调用服务，比如进入首页会有多个Dialog或其他串行的逻辑执行，这可以帮助一个一个的链式执行。
 
 #### 用法：

1、设置链的总大小，如果设置以后，则后面添加链到达这个大小就自动执行
```
ChainManager.INSTANCE.setChainSize(KEY, 4);
```

2、如果没有设置链的大小，需要手动执行开始
```
ChainManager.INSTANCE.start(KEY);
```

3、添加一个元素
```
ChainManager.INSTANCE.add(KEY, chain);
```

4、链完成
```
ChainManager.INSTANCE.finish(KEY);
```

每一个链元素需要继承 BaseChain，并重写serialNumber和handle方法
```
public class TestChain extends BaseChain {

    public TestChain(Context context) {
        super(context);
    }

    @Override
    protected void handle() {
        // 真正的执行
        
        handleNext(); // 执行下一个
    }

    @Override
    protected int serialNumber() {
        // 序号，优先级，越小优先级越高
        return 100;
    }
}
```
