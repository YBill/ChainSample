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
ChainManager.INSTANCE.add(KEY, lastChain);
```
