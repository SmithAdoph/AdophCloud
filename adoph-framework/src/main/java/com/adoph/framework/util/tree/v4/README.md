### 扁平结构转树形结构工具类
> 基于Lambda实现一个快捷易用的树形转换工具，此思想来源于Mybatis-plus的LambdaQuery实现。核心主要是依赖lambda获取到
> [SerializedLambda](https://github.com/SmithAdoph/AdophCloud/blob/master/adoph-framework/src/main/java/com/adoph/framework/util/SerializedLambdaUtils.java) ，
> 再通过SerializedLambda获取到对应的方法名，最后结合MethodHandle进行方法调用（性能有待考究。这里使用反射也同样能够实现，但是我们知道反射在性能上一直存在一些诟病。
> 而MethodHandle是模拟字节码层次的方法调用，虚拟机在这方面的优化空间会更大）。 

#### [代码示例](https://github.com/SmithAdoph/AdophCloud/blob/master/adoph-framework/src/main/java/com/adoph/framework/util/tree/v4/TreeUtils.java) 
```java
List<Menu> menuList = TreeUtils.builder(list, "0") // 构造参数：list待转换集合，根节点父id（可选）
                .id(Menu::getId) // id标识
                .pid(Menu::getPid) // pid标识
                .children(Menu::getChildren) // 子节点集
                .sort(Menu::getSort) // 排序字段（仅支持Byte、Short、Integer、Long等数值类型）
                .build();
