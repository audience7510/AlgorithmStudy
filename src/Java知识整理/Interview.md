# 面试整理
## 集合框架
### ArrayList与LinkedList区别
1. 是否保证线程安全。 ArrayList 和 LinkedList 都是不同步的，不保证线程安全  
2. 底层数据结构。 Arraylist 底层使用的是 Object 数组；LinkedList 底层使用的是 双向链表 数据结构（JDK1.6之前为循环链表，JDK1.7取消了循环）  
3. 插入和删除是否受元素位置的影响。ArrayList 采用数组存储，所以插入和删除元素的时间复杂度受元素位置的影响。 比如：执行add(E e) 方法的时候， ArrayList 会默认在将指定的元素追加到此列表的末尾，这种情况时间复杂度就是O(1)。但是如果要在指定位置 i 插入和删除元素的话（add(int index, E element) ）时间复杂度就为 O(n-i)。因为在进行上述操作的时候集合中第 i 和第 i 个元素之后的(n-i)个元素都要执行向后位/向前移一位的操作。  
LinkedList 采用链表存储，所以对于add(E e)方法的插入，删除元素时间复杂度不受元素位置的影响，近似 O（1），如果是要在指定位置i插入和删除元素的话（(add(int index, E element)） 时间复杂度近似为o(n))因为需要先移动到指定位置再插入
4. 是否支持快速随机访问。ArrayList根据索引拿到元素支持，LinkedList不支持  
5. 空间内存占用。ArrayList的空 间浪费主要体现在在list列表的结尾会预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗比ArrayList更多的空间（因为要存放直接后继和直接前驱以及数据）  

### ArrayList扩容机制
在往ArrayList add元素的时候，如果ArrayList 已有元素数量+1 大于 ArrayList 存储元素的总长度，就会触发扩容。首先ArrayList会计算新数组的长度，长度比老数组扩大0.5倍，如果新的容量小于 需要要扩容的容量，新的容量等于要扩容的容量。如果已经大于了最大的容量Integer.MAX_VALUE，则用最大容量处理。最后调用copyOf将原来的数组copy到扩大后的容量中
### HashMap
#### HashMap底层实现
#### HashMap 的长度为什么是2的幂次方
#### HashMap 和 Hashtable 的区别
## 并发
### Synchronized
作用：1、修饰实例方法 2、修饰静态方法 3修饰代码块
### volatile
### ThreadLocal
### ConcurrentHashMap
### 线程池
### 原子类
### AQS
### CAS
## JVM
### JVM内存模型
### JVM垃圾回收
## Spring
## Mysql
## Redis
## 网络
## MQ
## Nginx
## Docker
## Dubbo
## Zookeeper
## SpringBoot
## SpringCloud