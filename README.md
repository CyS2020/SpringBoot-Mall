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
        <!-- 用于生成dao和pojo的插件, 非必选项 -->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.7</version>
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

#### 微信支付账户
- appid: 微信公众账号或开放平台APP的唯一标识
- mch_id: 微信支付分配的商户收款账号
- mchKey: 用于交易过程生成签名的密钥
- notify_url: 用于接收微信发送的异步通知的链接(地址)

#### 支付宝支付账户
- 商户应用公钥、商户用用私钥(写入代码)、支付宝公钥(写入代码)、支付宝私钥(对于我们未知)
- 发起支付: 商户(商户应用私钥签名) -> 支付宝(商户应用公钥验签) 
- 异步通知: 支付宝(支付宝私钥签名) -> 商户(支付宝公钥验签)
- 这种方式为RSA非对称加密, RSA签名不等于加密(java代码是不一样的), 支付内容加密一般使用AES密钥(对称)
- app_id + private_key + ali_pay_public_key + notify_url + return_url

#### 转账过程
- 建行(张三) -> 网联 -> 农行(李四) 给你转钱了(request请求)
- 建行(张三) <- 网联 <- 农行(李四) 我收到钱了(request请求) 支付成功结果此处为准:即平台发来的异步通知
- 跳转会直接跳到浏览器中打开, 而get请求会获得网页的html源码
- 微信支付中模式二不需要在微信支付后台开发配置中设置扫码回调链接
- notify_url是用来接收支付平台的异步通知的, notify_url不一定必须用域名, 也可以使用ip地址
- 云服务器的公网ip可以直接访问系统, 家庭宽带公网ip也不行, 使用natapp软件

#### 重复发起支付
```
业务系统订单号    支付系统订单号    支付平台
     1111             2222       ->     
     1111             3333       ->
```
- 发起第二次支付前, 把上一次的支付订单关闭(调用支付平台的API)
- ajax 请求后端的api(通过订单号查询支付状态), 如果是已支付则进行跳转

#### 模块的分割
- 一般来说商城系统, 支付系统, 包括用于生产dao层和pojo的mybatis系统都是各自独立的
- 此项目中为了(比较小)就没有将用mybatis生成dao层和pojo的系统独立出来

#### 用户模块开发
- Content-Type:application/json 这是调用API的请求头
- 开发顺序: Dao -> Service -> Controller
- 单元测试: Service层(主要的业务逻辑)
- Mybatis打印SQL语句

#### 前端请求方式
- body使用x-www-form-urlencoded来请求: 后端可以使用对象中的域来接收(配合@RequestParam), 或者使用对象来接收(无需注解)
- body使用raw + json格式来请求: 后端使用对象来接收(配合@RequestBody), 使用@Valid验证对象中字段是否符合要求, @NotBlank/@NotNull/@NotEmpty
- url中使用注解@PathVariable来绑定传入的参数
#### cookie session 跨域
- 域名与域名不一样、IP与IP地址不一样、域名与IP(localhost与127.0.0.1)比较都算跨越
- cookie不安全session安全, 后端开发只操作session, session与cookie不分家, session就是用到了cookie来实现的, cookie是实现Session的一种方式
- 服务端需要通过session来识别具体的用户, 服务端要为特定用户创建特定的session, 用于标识这个用户并且跟踪
- 那么问题来了session如何来识别具体的用户呢？客户端会将cookie信息发送到服务端, cookie里面记录一个Session ID
- session是抽象的概念, cookie是具体的概念, cookie是session一种具体的实现方式
```
       前端        ->           后端
cookie(sessionId)  ->   session(HttpSession)
```
#### 耗时
- http(请求微信api) > 内网 + 磁盘(mysql) > 内存
- 代码中最忌讳的就是在for循环中做http、sql

#### pageSize与pageNum
- pageSize表示一页显示几条数据, 根据这个数据来分页, 一页显示pageSize条数据, 一共total/pageSize页
- pageNum表示显示第几页, 根据刚才划分的页total/pageSize页, 指定显示哪一页

#### NoSQL数据库
- Redis(高性能), MongoDB(海量数据), Elasticsearch/HBase(大数据)

#### 订单
- 不可变：商品图片、收货地址; 可变：状态
