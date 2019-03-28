# base-model

### Guides

* 项目采取Spring Cloud体系 正式环境请更改`application.yml`中`eureka.client.serviceUrl.defaultZone`
  同时`enabled`设置为`ture`
* 包具体作用请阅读包下`package-info.java`

## 领域模型
* DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
* DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。
* BO（Business Object）：业务对象，由 Service 层输出的封装业务逻辑的对象。
* AO（Application Object）：应用对象，在 Web 层与 Service 层之间抽象的复用对象模型，极为贴近展示层，复用度不高。
* VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。
* Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止 使用 Map 类来传输。

## 约定
1. 基于阿里巴巴Java开发手册1.4.0版本规范
2. [强制] 必须有代码注释，如果可能返回null，必须明确标注，注释规范见附录1
3. [强制] 必须明确方法需要的参数，尊循代码亦是注释风格
4. [强制] if块里面最多只有一级if关系，不可反复嵌套if，逻辑不清晰
5. [强制] 代码交付前，必须进行单元测试，测试范围见阿里开发手册
6. [强制] 开线程使用ThreadPool进行管理ExecutorService
7. [强制] 枚举类中，不能有setXXX方法！！

## 开发要求插件
必备：
* Alibaba Java Coding Guidelines plugin support.
* IntelliJ Lombok plugin

可选：
* Free Mybatis plugin

## 类头注释
Preferences -> Editor -> File And Code Templates
设置包含： class && interface && enum && Annotation-Type && package-info
```Java
/**
 *@author ${USER}
 *@createTime ${YEAR}-${MONTH}-${DAY}
 *@description ${DESCRIPTION}
 */
```

## Git
遵循GitFlow工作流

