# 三、第三课 (第2周第1课）jvm日志分析调优

## 一、环境准备

### 1）将jdk11改为jdk8

```
1)环境变量修改java_home
2)环境变量修改path:%java_home%\bin并提前
3)环境变量Path值最前面的C:\ProgramData\Oracle\Java\javapath;去掉。
4)还不行就删除window32内的java,javaw,jaaws文件
```



### 2）编译GCLogAnalysis.java，生成class文件

```
E:\学习\极客学习\java进阶训练营\软件\JDK\JVM环境准备>javac -d . GCLogAnalysis.java //  -d . 是因为没有package
```

### 3）执行class文件,正确执行为止

```
E:\学习\极客学习\java进阶训练营\软件\JDK\JVM环境准备>java GCLogAnalysis
```

### 4）GC日志分析

设置堆内存2g,4g,512m,256m ,设置GC为并行GC,然后打印GC日志明细-XX:+PrintGCDetails或者GC概况-XX:+PrintGC，还有打印时间戳-XX:+PrintGCDateStamps，打印到日志文件 -Xloggc:gc.demo.log ，然后观察打印出的GC日志进行分析，

```
E:\学习\极客学习\java进阶训练营\软件\JDK\JVM环境准备>java -XX:+UseParallelGC -Xmx256m -Xms256m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
-XX:+UseSerialGC		//串行
-XX:+UseParallelGC		//并行
-XX:+UseConcMarkSweepGC	//并发
-XX:+UseG1GC			//G1
-----------------------------------------------------------
正在执行...
2021-01-16T17:37:58.630+0800: [GC (Allocation Failure) [PSYoungGen: 65512K->10740K(76288K)] 65512K->24582K(251392K), 0.0063778 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-16T17:37:58.650+0800: [GC (Allocation Failure) [PSYoungGen: 76276K->10738K(76288K)] 90118K->48081K(251392K), 0.0060320 secs] [Times: user=0.03 sys=0.13, real=0.01 secs]
2021-01-16T17:37:58.777+0800: [Full GC (Ergonomics) [PSYoungGen: 28648K->0K(58368K)] [ParOldGen: 142455K->145117K(175104K)] 171103K->145117K(233472K), [Metaspace: 2710K->2710K(1056768K)], 0.0347102 secs] [Times: user=0.16 sys=0.00, real=0.04 secs]
2021-01-16T17:37:58.817+0800: [GC (Allocation Failure) [PSYoungGen: 29696K->9295K(58368K)] 174813K->154412K(233472K), 0.0021164 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-16T17:37:58.819+0800: [Full GC (Ergonomics) [PSYoungGen: 9295K->0K(58368K)] [ParOldGen: 145117K->148762K(175104K)] 154412K->148762K(233472K), [Metaspace: 2710K->2710K(1056768K)], 0.0308398 secs] [Times: user=0.25 sys=0.00, real=0.03 secs]
2021-01-16T17:37:58.856+0800: [Full GC (Ergonomics) [PSYoungGen: 29458K->0K(58368K)] [ParOldGen: 148762K->155718K(175104K)] 178220K->155718K(233472K), [Metaspace: 2710K->2710K(1056768K)], 0.0316955 secs] [Times: user=0.24 sys=0.08, real=0.03 secs]
2021-01-16T17:37:59.467+0800: [Full GC (Allocation Failure) [PSYoungGen: 29241K->29241K(58368K)] [ParOldGen: 175012K->174992K(175104K)] 204253K->204234K(233472K), [Metaspace: 2710K->2710K(1056768K)], 0.0328357 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:47)
        at GCLogAnalysis.main(GCLogAnalysis.java:24)
Heap
 PSYoungGen      total 58368K, used 29696K [0x00000000fab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 29696K, 100% used [0x00000000fab00000,0x00000000fc800000,0x00000000fc800000)
  from space 28672K, 0% used [0x00000000fe400000,0x00000000fe400000,0x0000000100000000)
  to   space 28672K, 0% used [0x00000000fc800000,0x00000000fc800000,0x00000000fe400000)
 ParOldGen       total 175104K, used 174992K [0x00000000f0000000, 0x00000000fab00000, 0x00000000fab00000)
  object space 175104K, 99% used [0x00000000f0000000,0x00000000faae4350,0x00000000fab00000)
 Metaspace       used 2741K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
  ---------------------------分析------------------------------
  youngGC分析：
  2021-01-16T17:37:58.630+0800:				   //时间戳
  [
      GC (Allocation Failure) 				   //GC分配失败
      [
      	PSYoungGen: 65512K->10740K(76288K)	  	//young区从65M->10M回收了55M(容量：76M),65/76=85%的时候开始YoungGC
      ] 
      65512K->24582K(251392K), 				   //堆内存从65M->24M(容量251M),回收了41M
      0.0063778 secs						  //youngGC时长6.3毫秒
  ] 
  [Times: user=0.00 sys=0.00, real=0.01 secs]	//CPU信息,可参考top
-----------------------------------------------------------------
fullGC分析
2021-01-16T17:37:58.777+0800: 					//时间戳
[
	Full GC (Ergonomics) 						//FullGC
	[
		PSYoungGen: 28648K->0K(58368K)			//Young区从28M->0M(容量58),回收了28M
    ] 
	[
		ParOldGen: 142455K->145117K(175104K)	 //old区从142M->145M(容量175M),没有回收,甚至还增加了3M
	] 		
	171103K->145117K(233472K), 					//堆内存从171M->145M(容量233M),回收了26M
	[
		Metaspace: 2710K->2710K(1056768K)		//元数据区从2M->2M(1056M)，无变化
	], 
	0.0347102 secs							  //FullGC时长 34毫秒
] 
[Times: user=0.16 sys=0.00, real=0.04 secs]		//CPU信息，可参考top


```

![image-20210116180138557](../../../预习资料/JVM/资料/image-20210116180138557.png)

```
E:\学习\极客学习\java进阶训练营\软件\JDK\JVM环境准备>java -XX:+UseG1GC -Xmx8g -Xms8g -XX:+PrintGC GCLogAnalysis
正在执行...
[GC pause (G1 Evacuation Pause) (young) 408M->129M(8192M), 0.0206221 secs]
[GC pause (G1 Evacuation Pause) (young) 485M->229M(8192M), 0.0238964 secs]
[GC pause (G1 Evacuation Pause) (young) 585M->317M(8192M), 0.0208292 secs]
[GC pause (G1 Evacuation Pause) (young) 673M->411M(8192M), 0.0208435 secs]
[GC pause (G1 Evacuation Pause) (young) 767M->511M(8192M), 0.0226546 secs]
[GC pause (G1 Evacuation Pause) (young) 867M->614M(8192M), 0.0226399 secs]
[GC pause (G1 Evacuation Pause) (young) 970M->709M(8192M), 0.0222086 secs]
[GC pause (G1 Evacuation Pause) (young) 1065M->802M(8192M), 0.0221853 secs]
[GC pause (G1 Evacuation Pause) (young) 1158M->898M(8192M), 0.0222847 secs]
[GC pause (G1 Evacuation Pause) (young) 1254M->989M(8192M), 0.0225967 secs]
[GC pause (G1 Evacuation Pause) (young) 1469M->1119M(8192M), 0.0345848 secs]
执行结束!共生成对象次数:15525
```

### 5) 得出结论：

​		1）堆内存太小，会导致oom

​		2) 堆内存太大，会导致STW时间过长，暂停时间过长,影响吞吐量

​		3）不影响性能情况下，堆尽量小，效率最大化。机器使用最大化

​		4)  系统健康情况正常下，youngGC>>FullGC

## 二、Minor GC/Major GC

![image-20210116183849275](../../../预习资料/JVM/资料/image-20210116183849275.png)

## 三、gc日志查看工具

https://gceasy.io

![image-20210116194232336](../../../预习资料/JVM/资料/image-20210116194232336.png)

GCViewer：

![image-20210116202438851](../../../预习资料/JVM/资料/image-20210116202438851.png)

## 四、JVM线程堆栈数据分析

![image-20210116200909223](../../../预习资料/JVM/资料/image-20210116200909223.png)

## 五、线程分析工具

命令行：jstack -l

图形工具：jcmd 工具, jconsole, jvisualvm, Java Mission Control 等

线上工具：https://fastthread.io

## 六、内存分析与工具



```
思考：
1000个对象有一个属性和一个对象有1000个属性，哪个占用内存空间比较大？？？
1000*(12+4+x)>1*(12+4+1000*x)
Integer/Long/Double包装类型比int,long,double多一倍内存占用
```

![image-20210116202543298](../../../预习资料/JVM/资料/image-20210116202543298.png)

![image-20210116202609015](../../../预习资料/JVM/资料/image-20210116202609015.png)

![image-20210116204535236](../../../预习资料/JVM/资料/image-20210116204535236.png) 

## 七、内存常见错误

### 1.OOM:堆内存不够

![image-20210116210655042](../../../预习资料/JVM/资料/image-20210116210655042.png)

### 2.元数据区空间不够

![image-20210116210800713](../../../预习资料/JVM/资料/image-20210116210800713.png)

### 3.线程数量上限错误

![image-20210116210946849](../../../预习资料/JVM/资料/image-20210116210946849.png)

## 八、内存dump分析工具

### 1、Eclipse MAT

### 2、jhat

## 九、JVM调优经验

### 1.分配速率过高

![image-20210116211445830](../../../预习资料/JVM/资料/image-20210116211445830.png)

分配速率计算

![image-20210116212147215](../../../预习资料/JVM/资料/image-20210116212147215.png)

![image-20210116212343851](../../../预习资料/JVM/资料/image-20210116212343851.png)

### 2.过早提升速率

![image-20210116212527568](../../../预习资料/JVM/资料/image-20210116212527568.png)

计算方法

![image-20210116212648827](../../../预习资料/JVM/资料/image-20210116212648827.png)

影响

![image-20210116212903771](../../../预习资料/JVM/资料/image-20210116212903771.png)

解决

![image-20210116213046236](../../../预习资料/JVM/资料/image-20210116213046236.png)

## 十、GC疑难情况问题分析

### 1.工具

#### a) 阿里Arthas 诊断分析工具

#### b)排查过程

![image-20210116213811458](../../../预习资料/JVM/资料/image-20210116213811458.png)



#### c)真实案例

参见：22-JVM问题排查分析下篇：案例实战.md.pdf

#### d)面试题汇总

参见： 24-JVM相关的常见面试问题汇总.md.pdf