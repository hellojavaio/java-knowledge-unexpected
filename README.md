# java-knowledge-unexpected
Basic knowledge that is easy to make mistakes.

```
    _                        _                        _          _                                                        _           _ 
   (_) __ ___   ____ _      | | ___ __   _____      _| | ___  __| | __ _  ___       _   _ _ __   _____  ___ __   ___  ___| |_ ___  __| |
   | |/ _` \ \ / / _` |_____| |/ / '_ \ / _ \ \ /\ / / |/ _ \/ _` |/ _` |/ _ \_____| | | | '_ \ / _ \ \/ / '_ \ / _ \/ __| __/ _ \/ _` |
   | | (_| |\ V / (_| |_____|   <| | | | (_) \ V  V /| |  __/ (_| | (_| |  __/_____| |_| | | | |  __/>  <| |_) |  __/ (__| ||  __/ (_| |
  _/ |\__,_| \_/ \__,_|     |_|\_\_| |_|\___/ \_/\_/ |_|\___|\__,_|\__, |\___|      \__,_|_| |_|\___/_/\_\ .__/ \___|\___|\__\___|\__,_|
 |__/                                                              |___/                                 |_|                           
```

## 类型提升

大部分人会认为下面的2段代码是等价的：
```java
Object o1 = true ? new Integer(1) : new Double(2.0);
```
等同于：
```java
Object o2;

if (true)
    o2 = new Integer(1);
else
    o2 = new Double(2.0);
```
让你失望了。来做个简单的测试吧：
```java
System.out.println(o1);
System.out.println(o2);
```
打印结果是：
```
1.0
1
```
哦！如果『需要』，条件运算符会做数值类型的类型提升，这个『需要』有非常非常非常强的引号。因为…… 你觉得下面的程序会抛出 NullPointerException 吗？
```java
Integer i = new Integer(1);
if (i.equals(1))
    i = null;
Double d = new Double(2.0);
Object o = true ? i : d; // NullPointerException!
System.out.println(o);
```


```java
Object o1 = true
  ? (Object) new Integer(1) 
  : new Double(2.0);
System.out.println(o1);
```
才能得到正确的结果`1`

## 判断的非原子性

`boolean b = (a != (a = 2));` 单线程下这个是肯定是有问题的,因为一个元素不可能与自己不等.但是这是多步操作,在别的线程里面可能已被修改


## LICENSE

### [CC-BY-SA-3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/cn/)

[![](LICENSE.png)](https://creativecommons.org/licenses/by-nc-sa/3.0/cn/)