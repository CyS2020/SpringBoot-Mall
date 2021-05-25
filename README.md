### 项目总结
#### 事务
- @Transactional 注解底层是由数据库来决定的, 常用的引擎有InnoDB和MyISAM(不支持事务)
- 事务一定是数据库的事务, 而不是java代码的事务, 出现RuntimeException的时候回滚
- Redis所有单个命令的执行都是原子性的, redis不支持回滚操作

#### 主键与索引
- 表关系、表结构、唯一索引、单索引及组合索引、时间戳
- 主键一定是唯一性索引，唯一性索引并不一定就是主键。
- 一个表中可以有多个唯一性索引，但只能有一个主键。
- 主键列不允许空值, 而唯一性索引列允许空值

#### 运行jar包
- java -jar mall-0.0.1-SNAPSHOT.jar 命令运行主程序
- java -cp [jar包的路径] [com.google.xxx.class]

#### 使用社区版IDEA创建SpringBoot项目
- 创建maven项目
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

#### Model层(模型层)
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
- 此项目中为了(比较小)就没有将用mybatis生成dao层和pojo的系统独立出来, 商城系统-支付系统-MyBatis系统

#### 用户模块开发
- Content-Type:application/json 这是调用API的请求头
- 开发顺序: Dao -> Service -> Controller
- 单元测试: Service层(主要的业务逻辑)
- Mybatis打印SQL语句

#### 前端请求方式
- body使用x-www-form-urlencoded来请求: 后端可以使用对象中的域来接收(配合@RequestParam), 或者使用对象来接收(无需注解)
- body使用raw + json格式来请求: 后端使用对象来接收(配合@RequestBody), 使用@Valid验证对象中字段是否符合要求, @NotBlank/@NotNull/@NotEmpty
- url中使用的入参注解@PathVariable来绑定传入的参数, 不是url中带的则需要使用上面方式定义form对象来接收

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
- 不可变：商品图片、收货地址; 可变：状态、价格(波动)
- 订单中需要将一些会变化的数据存贮起来, 不能用到的时候去数据库里查询不能代表下单时的数据了

#### 基础知识
- 关于Linux命令, vim命令, docker命令的补充学习; java的http客户端学习
- 外网无法访问的调试技巧curl http://127.0.0.1:8080/xxx接口xxx

#### centos7环境
- 配置静态网址, 每次启动虚拟机linux执行systemctl restart network.service连接外网
- 在root目录下: vim .bash_profile 根目录下配置环境变量并source .bash_profile
- 配置环境变量后: 使用ngnix来启动Nginx服务端程序运行容器类似于Tomcat, 使用java运行jar包
- systemctl status firewalld.service查看防火墙状态 systemctl stop firewalld.service关闭防火墙
- systemctl daemon-reload systemctl restart docker.service 启动docker
- 安装mysql, 修改访问密码, 重启mysql并开启远程访问的ip地址(使用数据库服务器的地址), Navicat连接成功
- systemctl start  mysqld.service启动mysql systemctl status mysqld.service查看mysql状态
- docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:3.8.2-management 启动rabbitmq
- docker run -d -p 6379:6379 redis:5.0.7 启动redis 并在管理界面创建相应的队列payNotify
- 下载运行natapp使用内网穿透访问虚拟机ip地址, 接收微信和支付宝发来的异步通知
- 运行两个jar包, 即mall项目与pay项目, 一定要先运行natapp再启动pay项目, 保证natapp在Online状态

#### 反向代理
- http://192.168.1.4/api/products  前端访问的
- http://192.168.1.4:8080/products 后端提供的
- 通过修改nginx配置文件来进行反向代理cd /user/local/nginx/conf/ 

### Spring常用注解
#### `spring-boot-starter-test`
- `@RunWith(SpringRunner.class)` : 注解是一个测试启动器，可以加载Springboot测试注解。
- `@SpringBootTest` : 通过@RunWith 和 @SpringBootTest启动spring容器。

#### `spring-boot-starter-web`
- `@Component` : 调用无参构造器创建一个bean对象, 并把对象存入spring的IOC容器, 交由spring容器进行管理
- `@Controller` : 作用@Component相同, 一般用于表现层注解
- `@Service` : 作用@Component相同, 一般用于业务层注解
- `@Repository` : 作用@Component相同, 一般用于持久层注解
- `@Bean` : 用于把当前方法的返回值作为bean对象存入spring的IOC容器中, 一般是需要初始化数据的类
- `@Configuration` : 搭配@Bean使用在方法中设置必要信息, 一般用于配置类
- `@Autowired` : 是spring动态装配bean的注解, 默认按照类型进行装配(byType)
- `@ConfigurationProperties(prefix = "xxx")` : 参数配置在application.properties或application.yml文件中, 搭配@Component使用
- `@SpringBootApplication` : 目的是开启自动配置 = @Configuration + @EnableAutoConfiguration + @ComponentScan。
<br/>

- `@RequestMapping` : 映射HTTP请求，也就是通过它来指定控制器可以处理哪些URL请求, 主要有path、method、params属性
- `@PostMapping` : 注解将HTTP的POST请求映射到特定的处理程序方法, 等于@RequestMapping(method = RequestMethod.POST)
- `@DeleteMapping` : 注解将HTTP的DELETE请求映射到特定的处理程序方法, 等于@RequestMapping(method = RequestMethod.DELETE)
- `@PutMapping` : 注解将HTTP的PUT请求映射到特定的处理程序方法, 等于@RequestMapping(method = RequestMethod.PUT)
- `@GetMapping` : 注解将HTTP的GET请求映射到特定的处理程序方法, 等于@RequestMapping(method = RequestMethod.GET)
- `@PathVariable` : 将 URL 中的占位符绑定到控制器的处理方法的参数中，占位符使用{}括起来
- `@RequestBody` : 用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的), 前端使用POST方式进行提交, spring组装json为对象
- `@RequestParam` : 用来处理body使用x-www-form-urlencoded来请求; url中的?后面参数也可以用@RequestParam来接收
- `@ResponseBody` : 将java对象转为json格式的数据, 将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区
- `@RestController` : 相当于@ResponseBody ＋ @Controller, @Controller注解会返回一个ModelAndView; 如果需要返回到指定页面, 则需要用 @Controller配合视图解析器InternalResourceViewResolver才行; 如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
<br/>

- `@Valid` : 对象属性字段的规则检测, 对象属性需要进行验证; 在定义对象的字段上使用@NotNull、@NotBlank、@NotEmpty常用作入参检验

#### `mybatis-spring-boot-starter`
- `@Mapper` : 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类, 需要注意的是:这个接口中不可以定义同名的方法，因为会生成相同的id也就是说这个接口是不支持重载的
- `@Select("select * from mall_category where id = #{id}")` : 对于多个参数来说, 每个参数之前都要加上@Param注解, 要不然会找不到对应的参数进而报错
- `@MapperScan(basePackages = "xxx")` : 想要每个接口都要变成实现类, 那么需要在每个接口类上加上@Mapper注解比较麻烦解决这个问题用@MapperScan, 是在Springboot启动类上面添加

### linux命令
#### 文件和目录
- `cd` 进入个人的主目录
- `cd /home` 进入 '/ home' 目录; 
- `cd ..` 返回上一级目录
- `pwd` 显示工作路径
- `ls` 查看目录中的文件
- `ls -l` 显示文件和目录的详细资料 
- `mkdir dir1` 创建一个叫做 'dir1' 的目录' 
- `mkdir -p /tmp/dir1/dir2` 创建一个目录树 
- `rm -rf dir1` 删除一个叫做 'dir1' 的目录并同时删除其内容 
- `mv dir1 new_dir` 重命名/移动 一个目录到新目录里
- `cp file1 file2` 复制一个文件 
- `chmod +x a.txt` 给所有用户给予a.txt文件可执行权限
- `scp local_file remote_username@remote_ip:remote_folder` 从本地复制到远程

#### 其他命令
- `su root` 切换为root身份需要输入密码
- ·`vim .bash_profile` 根目录下配置环境变量用cd直接进入根目录
- `source .bash_profile` 使环境变量生效
- `yum list` 列出所有可安裝的软件清单命令
- `yum install <package_name>` 仅安装指定的软件命令
- `yum update <package_name>`仅更新指定的软件命令
- `yum remove <package_name>` 删除软件包命令
- `wget  https:// xxx .tar.gz .zip` 下载安装包
- `tar -xzvf test.tar.gz` 解压文件
- `unzip test.zip` 解压文件需要安装zip程序
- `./configure --prefix=/usr/local/test` 配置
- `make` 编译
- `make install` 安装
- `./` 表示执行当前目录下的某个文件
- `ps -ef | grep java` 显示当前java进程
- `kill -9 xxid` 杀死进程
- `systemctl daemon-reload` 重新加载某个服务的配置文件
- `systemctl start *d.service` 启动服务
- `systemctl stop *d.service` 停止服务
- `systemctl restart *d.service` 重启服务
- `systemctl reload *d.service` 重新加载服务配置文件
- `systemctl status *d.service` 查询服务运行状态

### spring框架思考
- 依赖注入是服务与服务(组件)之间的关系，如果你本身不是服务或者组件，内部注入不注入的没什么用
- 常用注入方式: 构造器注入，属性注入，方法参数注入
- 配置方式: xml配置，注解配置，java配置。涉及基本(数据库)配置用xml，涉及业务配置用注解，涉及第三方jar包中的类用java配置
- AOP的作用: 某写已经存在的方法上追加功能，且源码无需修改，通知类代码有则使用注解，无则使用@DeclareParents连接目标类与代理类
- 实现AOP的操作: 1.编写通知类打上@Aspect注解, 2.编写切点方法打上@Pointcut注解, 3.方法上设置通知注解, 4.编写通知方法执行逻辑

### 关于serlvet的思考
1. 任何web应用程序，必然包括 接收请求、处理请求、响应请求，然而接收与响应是共性的，且没有差异。
2. 响应与接收抽取成web服务器，而处理逻辑是不同的抽取成servlet，定义了一套接口，遵循这个接口就能处理请求
3. 使用java代码实现servlet的处理逻辑就是后端开发了，开发后的程序需要运行在servlet容器上例如tomcat
4. web服务器处理http请求时，负责处理静态请求，遇到动态请求交给servlet容器，servlet容器根据url找到对应的servlet应用程序(映射器)，spring框架核心组件DispatcherServlet
5. tomcat等servlet容器，将请求的http报文转为HttpServletRequest、HttpServletResponse(空)对象，处理后数据填入会填入HttpServletResponse返回
6. 后端的入参来自HttpServletRequest我们在控制器中参数列表内容来自这里，然而我们基本不会用到这个类，框架会帮我们解析参数列表，这就涉及到Controller参数绑定，前后端对象的定义
7. servlet容器会为每一个servlet请求创建一个新的java线程，spring能在多线程的环境下将各个线程隔离，用的就是ThreadLocal
