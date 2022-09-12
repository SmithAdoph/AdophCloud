### 扁平结构转树形结构-工具类

#### 代码示例
[file] src/main/java/com/adoph/framework/util/tree/v4/TreeUtils.java
```java
List<Menu> menuList = TreeUtils.builder(list, "0") // 构造参数：list待转换集合，根节点父id
                .id(Menu::getId) // id标识
                .pid(Menu::getPid) // pid标识
                .children(Menu::getChildren) // 子节点集
                .sort(Menu::getSort) // 排序字段（仅支持Byte、Short、Integer、Long等数值类型）
                .build();
