# OOAD
深入浅出面向对象分析与设计 学习笔记 代码

******************************

Guitar:吉他


V1.0
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


V1.1
```java
问题：
    search(Guitar)接受客户的吉他参数，容易出现参数大小写、单词拼写错误问题
解决方案：
    使用String.toLowerCase()方法，能避免参数大小写问题，对于单词拼写错误无能为力
    使用枚举，限制参数的可能值，可以有效避免参数拼写错误问题
思路：
    吉他制造商(Builder)、类型(Type)、木材材料(Wood)使用枚举
    吉他型号不固定，不能使用枚举
    吉他序列号、价格也不能使用枚举
```


V1.2
```java
问题：
    search(Guitar)只返回符合条件的库存中第一把吉他
解决方案：
    返回符合客户规格的所有吉他
思路：
    返回结果改成列表(List)
```

V1.3
```java
问题：
    Guitar类构造方法参数过多
解决方案：
    Guitar参数(一般特性)封装成对象
思路：
    将Guitar一般特性(Builder、Model、Type、Wood)封装成GuitarSpec对象
```


V1.4
```java
问题：
    Guitar类与Inventory类耦合度高，当增加吉他特性时，需要同时修改GuitarSpec与Inventory类
解决方案：
    降低耦合度，委托
思路：
    Inventory的search(Guitar)将搜索工作委托给GuitarSpec类matches(GuitarSpec)
```


V1.5
```java
需求：
    为曼陀林(Mandolin)添加搜索功能
解决方案：
    直接在Inventory类中添加一个列表，用来存储Mandolin，相关的逻辑重新实现一遍，会造成代码的重复。
    把Guitar和Mandolin共性抽取到一个基类(抽象类)中
思路：
    1.新建Instrument、InstrumentSpec抽象类
        Instrument:
            serialNumber:序列号
            price:价格
            getSpec():InstrumentSpec

        InstrumentSpec:
            builder:制造商
            model:型号
            type:类型（原声吉他、电吉他）
            backWood:木料
            topWood:木料
            matches(InstrumentSpec):boolean

    2.Guitar、Mandolin继承自Instrument,并重写getSpec()方法
      Guitar:
        getSpec():GuitarSpec
      Mandolin:
        getSpec():MandolinSpec

    3.GuitarSpec、MandolinSpec继承自InstrumentSpec，并重写matches(InstrumentSpec)方法
      GuitarSpec:
        numStrings:int
        matches(InstrumentSpec):boolean

      MandolinSpec:
        style:Style  //枚举类
        matches(InstrumentSpec):boolean

      Style:
        A,F;
        toString()

    4.Inventory中新增search(MandolinSpec)方法，用于搜索Mandolin
        search(MandolinSpec): List<Mandolin>

    5.修改测试用例，并运行通过。


```

V1.6
```java
需求：
    为更多的乐器(Banjo、Dobro、Bass、Fiddle...)添加搜索功能

解决方案：
    让这些乐器分别继承Instrument，并分别创建各自的规格对象，显然是不可取的：
        1.导致大量的子类；
        2.每新增一种乐器，都需要修改Instrument类中的addInstrument(String,double,InstrumentSpec)方法，增加判断语句；
        3.新增search(BanjoSpec)、search(DobroSpec)...

    运用OO原则，让应用更具灵活性
        1.将变化之物封装起来；
        2.对接口编码，而不是对实现；
        3.应用程序中的每一个类只有一个改变的理由。(SRP)

思路：
    1.Instrument类变成非抽象类：
        serialNumber: String
        price: double
        getSpec(): InstrumentSpec
    2.InstrumentSpec类封装每种乐器的不同特性
        properties: Map
        getProperty(String): Object
        getProperties(): Map
        matches(InstrumentSpec): boolean
    3.去掉子类(Guitar、Mandolin、Banjo...)，及相关特性类(GuitarSpec、MandolinSpec、BanjoSpec...)
    4.新增枚举类InstrumentType:代表各种具体乐器
    5.修改Inventory类搜索方法：
        search(InstrumentSpec): List<Instrument>
    6.修改相关测试用例，运行通过。

```


******************************
超棒狗门

V1.0
```java
    DogDoor: 扮演与狗门硬件之间的接口
        open: boolean
        open(): void
        close(): void
    Remote: 遥控器（操控狗门）
        dogDoor: DogDoor
        pressButton(): void

```

V1.1
```java
    自动关门
```

V1.2
```java
问题：
    自动关门后，Fido被关在门外的处理
处理：
    替换路径
```

V1.3
```java
问题：
    叫声自动识别器
处理：
    BarkRecongnizer:
        door: DogDoor
        recongnize(String): void

```

V1.4
```java
问题：
    未能自动关闭狗门
处理：
    将自动关闭狗门功能从Remote中取出，放入DogDoor的open()方法中
```