# SSM && SSH脚手架

- master分支 为 SSM框架
- SSH分支 为 SSH框架

### 通用部分
---
基本上可以做到上手即用，该有的依赖都以配置完毕

### 项目主要依赖
---
- Spring Framework 5.1.4
- MySQL 8.0 +
- HikariCP
- Lombok
- Logback
- Guava

### 插件
---
- maven-assembly-plugin 自定义打包工具
- maven-compiler-plugin 编译工具

## 脚手架特性
- 生产/开发环境切换
    1. 本地开发使用classpath下的jdbc.properties
    2. 测试环境使用env/config-dev/jdbc.properties
    3. 生产环境使用env/config-pro/jdbc.properties

命令
```
mvn clean -P config-dev package //生产环境
mvn clean -P config-pro package //测试环境
```