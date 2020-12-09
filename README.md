### 知识点
#### 主键与索引
- 表关系、表结构、唯一索引、单索引及组合索引、时间戳
- 主键一定是唯一性索引，唯一性索引并不一定就是主键。
- 一个表中可以有多个唯一性索引，但只能有一个主键。
- 主键列不允许空值, 而唯一性索引列允许空值

#### 运行jar包
- java -jar mall-0.0.1-SNAPSHOT.jar 命令运行主程序

#### 使用社区版IDEA创建SpringBoot项目
- 继承springBoot项目版本自己确定
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.7.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```
- 基本的依赖和插件
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.0</version>
    </dependency>
</dependencies>
    
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.7</version>
            <!-- 不重复生成java代码会覆盖之前生成的文件 -->
            <configuration>
                <overwrite>true</overwrite>
            </configuration>
        </plugin>
    </plugins>
</build>
```
- 创建.gitignore文件忽略有些文件提交
- 配置文件resources/application.yml文件, 主要是数据库信息
- 在resources文件加下创建templates和static包
- 创建xxxApplication.java并编写程序main函数
- 创建xxxApplicationTest.java并作为单元测试的主类


#### java对象
- po: persistent object 持久层对象
- pojo: plain ordinary java object 普通java对象只有属性+get/set方法

#### Modle层(模型层)
- dao层：dao层叫数据访问层, 全称为data access object, 属于一种比较底层, 比较基础的操作, 具体到对于某个表、某个实体的增删改查, 取出数据封装后返回给service层
- service层：service层叫服务层, 被称为服务, 肯定是相比之下比较高的层, 比如取得连接、关闭数据库连接、事务回滚, 一些复杂的逻辑业务, 相当于将几种操作封装起来

#### 框架理解
- 想要框架去执行某些文件xml中的方法需要让框架找到xml, 则需要application.yml配置文件
- java代码与框架交互，要么通过注解要么配置xml, 将调用转向注解或者xml的具体行为，java定义抽象

#### mybatis三剑客
- Mybatis-generator: 用来生成pojo、mapper、xml文件
- Mybatis-plugin: 用来查找方法对应的xml中的sql语句(Free MyBaits plugin)
- Mybaits-PageHelper: 数据库分页插件

#### Spring
- IOC 控制反转, DI依赖注入从不同角度描述同一件事情; 原来代码直接new实现类写死代码, 现在通过创建合适的实现类注入到服务中, 可以注入不同的实现类只要实现接口即可, 即我给你配置了什么类你就用什么类就行 了, 代码的控制权发生了变化, 以前是你决定用什么; 例如伐木工人砍树需要创建(new)一把斧子然后执行砍树操作, 现在给伐木工人一把斧子然后执行砍树操作, 至于是什么类型的斧子并不重要(只要实现了砍树功能接口)
- AOP面向切片编程, 横向抽取机制, 例如给类添加性能检测, 事务控制, 日志打印等无法, 并不能使用纵向继承这些功能. spring aop就是将切面所定义的横向逻辑织入到切面所制定的连接点中; spring aop使用包括: 目标类、注解(非必须项)、切面类(定义切点和通知)
- MVC: Model(模型)、View(视图)、Controller(控制器);主要包含四个接口: DispatcherServlet(整个Web应用的控制器)、HandlerMapping、Controller(单个Http请求处理过程中的控制器)和ViewResolver

#### BigDecimal类
- 使用BigDecimal.valueOf(0.01), 不要使用new BigDecimal(0.01)将来精度会出问题
- 上述与new BigDecimal("0.01")等价, 注意查看源码实现
