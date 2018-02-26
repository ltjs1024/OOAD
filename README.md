# OOAD
深入浅出面向对象分析与设计 学习笔记 代码

V1.0

Guitar:吉他

```java
serialNumber:序列号
price:价格
builder:制造商
model:型号
type:类型（原声吉他、电吉他）
backWood:木料
topWood:木料
```

Inventory:库存
```java
// 吉他库存列表
guitars:List
// 添加,创建吉他对象，并将其加入库存中
addGuitar(String,double,String,String,String,String,String):void
// 接受吉他序号，返回该吉他的对象
getGuitar(String):Guitar
// 搜索，接受客户的理想吉他细节，从库存中匹配并返回吉他
search(Guitar):Guitar
```





