<h1 align="center">Polaris API 接口开放平台</h1>
<p align="center"><strong>Papi 是一个为用户和开发者提供全面API接口调用服务的平台 🛠</strong></p>
<div align="center">
	<a target="_blank" href="https://github.com/polarisronx/Papi-backend">
    	<img alt="" src="https://github.com/qimu666/qi-api/badge/star.svg?theme=gvp"/>
	</a>
    <img alt="Maven" src="https://raster.shields.io/badge/Maven-3.8.2-red.svg"/>
    <img alt="SpringBoot" src="https://raster.shields.io/badge/SpringBoot-2.7+-green.svg"/>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
        <img alt="" src="https://img.shields.io/badge/JDK-1.8+-green.svg"/>
	</a></div>

## 为什么是 Papi

Papi 为广大的用户和开发者提供了大量实用的、新奇的接口。

- 如果您是狂热的 Java 开发者，您可以前往 <a href="https://github.com/polarisronx/Papi-backend">Polaris API </a> 的源码进行研究，我们欢迎您一起交流，一起玩点好玩的。
- 如果您是用 API 调用需求的用户，且有 Java 开发的经验，您可以实用 maven 引入 <a href="https://github.com/polarisronx/Papi-backend">papi-client-sdk</a> 依赖包在本地轻松调用接口。
- 如果您没有 Java 开发的基础或您只是好奇，您可以前往 <a href="https://api.papi.icu">Papi 在线开放平台</a> 在线尝试。

## 网站指南

<a href="https://api.papi.icu">Papi 在线开放平台</a> 

<a href="https://doc.papi.icu">Papi 开发者文档</a>

> 我们也推荐您前往我们新开发的 <a href="bi.papi.icu">Polaris BI</a> 智能分析平台体验，目前正在内测✨

## 源码指南

<a href="https://github.com/polarisronx/Papi-backend">Papi 后端项目</a>

<a href="https://github.com/polarisronx/Papi-frontend">Papi 前端项目</a>

<a href="https://github.com/polarisronx/papi-gateway">Papi 网关</a>

<a href="https://github.com/polarisronx/papi-client-sdk">Papi SDK</a>

<a href="https://github.com/polarisronx/papi-interface">Papi 接口</a>

## 快速启动

### 前端

环境要求：Node.js >= 16，yarn 或 npm 包依赖工具

1. 安装依赖：npm 或 yarn 均可

```bash
yarn install
npm install
```

2. 启动：npm 或 yarn 均可

```bash
yarn run start
npm run start
```

3. 部署：npm 或 yarn 均可

```bash
yarn run build
npm run build
```

### 后端

1. 执行sql目录下ddl.sql在数据库中生成对应库表；
2. 启动 Redis、nacos；
3. 修改项目配置application.yaml；
4. 依次启动 papi-main papi-gateway papi-interface

## 主要技术选型

### 前端

- React 18.2.0
- Echarts 可视化库 5.5.0
- Ant Design Pro 开发脚手架 3.3.0
- Ant Design 组件库 5.3.3
- Ant Design Pro Components 2.6.48
- UmiJS 前端框架 4.1.1
- Openapi 生成工具 1.0.1

### 后端

- Java 1.8 （向上兼容）
- Springboot 2.7.0
- Spring Cloud 2021.0.7
- Spring Cloud Alibaba 2022.0.0.0.RC1
- Dubbo  3.2.5
- Nacos 2.3.0
- Hutool 5.8.16
- Caffeine 2.9.2
- Redisson 3.21.3
- MySQL 8.0.31 （兼容5.x版本）
- Redis 7.2.0 （兼容低版本）
- Knife4j 4.0.0
- Aliyun OSS  3.17.1

## 开发简介

### 项目结构

<img src="https://github.com/polarisronx/Papi-backend/doc/images/papi-architecture.png" style="zoom:80%;" />

## 主要功能

### 1 登录和注册

您可以 <a href="https://api.papi.icu">Papi 在线开放平台</a> 的登录和注册页面完成登录和注册，目前支持账号密码登录（注册）和邮箱验证码登录（注册）。

请您接受我们为您配置的浏览器留存 token，这样登录状态有效周期内（目前是 4 天），系统将会自动为您登录。

![](https://github.com/polarisronx/Papi-backend/doc/images/login&register.png)

### 2 接口发布

您可以 <a href="https://api.papi.icu">Papi 在线开放平台</a> 的发射中心向名为互联网的“星云”发射你超炫酷的接口，与全宇宙的小伙伴一起共享你的创意！

![](https://github.com/polarisronx/Papi-backend/doc/images/add.png)

<img src="https://github.com/polarisronx/Papi-backend/doc/images/add2.png" style="zoom:67%;" />

<img src="https://github.com/polarisronx/Papi-backend/doc/images/add3.png" style="zoom:67%;" />

但请注意：上传的接口需要满足一定的规范，在上传前请务必仔细阅读文档 <a href="https://doc.papi.icu">Papi 开发者文档</a>

### 3 接口在线调试

您可以 <a href="https://api.papi.icu">Papi 在线开放平台</a> 的接口市场选择自己心仪的接口并在线调试。

<img src="https://github.com/polarisronx/Papi-backend/doc/images/interface-market.png" style="zoom: 67%;" />

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240710091557.png)

当然，在您调试前，先了解一下接口的参数、错误码、代码实例也是十分必要的✨

![](https://github.com/polarisronx/Papi-backend/doc/images/tool.png)

### 4 接口客户端调用 SDK

- 不需要springboot，不需要任何框架！甚至不需要其他依赖！
- 不需要不需要任何工具类！不需要实现Http请求！
- 不需要高深的Java开发经验和技巧！

只需要 Java基础 JDK，和寥寥几句代码，即可轻松调用 papi 丰富的接口！

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240710135353.png)

此外，papi-client-sdk 已经登陆 **Maven 中心仓库**，只需要在 pom 文件中引入即可快速启动🎉

![](https://github.com/polarisronx/Papi-backend/doc/images/maven-papi.png)

(maven 上传有延迟，1.0.3版本已经发布)

```xml
<dependency>
    <groupId>io.github.polarisronx</groupId>
    <artifactId>papi-client-sdk</artifactId>
    <version>1.0.3</version>
</dependency>
```

您可以手动实例化 papi-client

```java
// 01 配置开发密钥
Credential credential = new Credential("polaris", "abcdefgh");
// 02 配置接口和请求参数
HttpProfile httpProfile = new HttpProfile("localhost:8123", "/api/v1/roman/intToRoman", "GET");
HttpConnection httpConnection = new HttpConnection();
// 03 创建papi客户端
PapiClient papi = new PapiClient(credential, httpProfile,httpConnection);
```

也可以引入springboot框架，用配置文件注入属性自动装配 papi-client 实例

![](https://github.com/polarisronx/Papi-backend/doc/images/papi-yml.png)

然后在spring扫描路径的类下

```java
@Resource
PapiClient papiClient;
```

### 5 接口调用统计分析

您可以 <a href="https://api.papi.icu">Papi 在线开放平台</a> 的管理页面查看接口调用的统计分析，去发现你最惯用的接口。

目前功能还十分单一，仅对管理员权限用户开放，后续完善后会对所有用户开放。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240711144449.png)

### 6 个性化设置

开发者可以在个人中心和设置中心修改个性化的信息，包括头像、昵称、密码等，以满足个人需求。

# 开发记录 note

![](https://github.com/polarisronx/Papi-backend/doc/images/images/Papi-request-detail.png)

## 1 前端项目目录结构

![](https://github.com/polarisronx/Papi-backend/doc/images/image (3).png)

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240304104906.png)

后端准备多个dto

![](https://github.com/polarisronx/Papi-backend/doc/images/image0304.png)

前端自动生成 openAPI

modalForm 模态框

添加表单项的校验规则

![](https://github.com/polarisronx/Papi-backend/doc/images/image (4).png)

## 2 接口信息管理

> 修改接口信息

回顾以前谷粒学苑中修改讲师的方法。当时是用 Vue 来实现的。

1. 修改的界面没有设置弹窗，也不特别设置一个修改的页面，而是设置一个隐藏路由（菜单栏不显示，只有访问到该页面才会跳转显示）。修改沿用了添加的组件。

   ```vue
   {
   	path: 'edit/:id',  
   	name: 'EduTeacherEdit',  // 路由的名称
   	component: () => import('@/view/edu/teacher/save'),  // 对应项目中的路径
   	meta: {title: '编辑讲师', noCache: true},
   	hidden: true
   }
   ```

2. 在页面中设置修改按钮，用 \<router-link> 实现路由的跳转，Scope 能传回当前数据表的数据，根据id进入到要修改的讲师

   ```vue
   <router-link :to="'/teacher/eidt/' + scope.row.id">
   	<el-button type="primary" size="mini" icon="el-icon-edit">修改</el-button>
   </router-link>
   ```

3. 根据id查找讲师原有的信息，进行数据回显

4. 由于修改和添加都共用了 save 的页面，要进行不同的操作。区别在于修改在路径中有id而添加没有。

   **获取页面当前的路由的方法：<font color='red'> $router.params.id</font>**

   ```vue
   created(){ // 页面渲染前调用
   	console.log('created')
   	if (this.$router.params && this.$router.params.id){ 如果有 id 参数就调用这个方法
   		const id = this.$router.params.id
   		this.getInfoById(id) // 根据id查询讲师信息进行数据回显 
   	}
   }
   ```

5. 在页面中，不论是修改还是添加都是点击保存来提交，这个按钮对应了同一个方法 saveOrUpdate()，要在这个方法中判断是修改还是添加。区别在于，添加的讲师id是自动生成的，要传给后端的 teacher 里没有id，而修改有id。

   ```vue
   saveOrUpdate(){
   	// 根据teacher是否有id判断是修改还是添加
   	if(!this.teacher.id){
   		// 添加
   		this.saveTeacher()
   	}else{
   		// 修改
   		this.updateTeacher()
   	}
   }
   ```

回到项目中，现在用的是 React。

1. 首先，修改与添加modal大致相同，不同之处在于，修改是有原数据的，所以modal中要传进来值，然后设置表单内的初始值initialValues

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240306150939.png)

2. 在页面中，会把currentRow传到 modal 中的values中来。但是有一个问题，就是initialValues只会初始化一次，点其他行修改时，里面的数据还是最开始的。所以要用一个监听，当换不同的行，数据发生了变化以后要进行修改。

3. 在React中用useEffect()来监听数据的变化，注意form要传入proTableRef，这样才能访问到表单实例

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240307203743.png)

   - 在组件中写的内容会直接显式在页面上

     ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240307203924.png)

4. 在实测时发现报错，提示没有传入id。溯源：用户点击提交，实际上执行了onSubmit，并执行了 handleUpdate()方法，并传进Value的参数，这个参数来自我们的内部组件UpdateModal这个模态窗里用户输入的信息。而UpdateModal模态窗内的columns是由外部定义的，在这些columns 中，我们把id列的属性定义为了index。这样定义的结果是，id列不会出现在表单项里，也就不会被填入表单。

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240307204606.png)![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240307205223.png)

5. 我们需要保存用户当前点击的数据项的 id，这里有个现成的 **<font color='red'>选中行</font>currentRow**，直接用这个去取id就行了。

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240307205911.png)

   我们在点击修改时执行了选中行和让修改模态框显示

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240307211314.png)
   
   在表格中的render函数中，行记录的数据存储在record中
   
   ````typescript
   render:(_,record)=>[]
   ````
   
   

> 删除接口

又一个**React的<font color='red'>钩子</font>actionRef.current?.reload()** 用于删除成功则自动刷新表单

## 3 接口调用客户端

>接口模拟

新建一个项目，创建几个测试用的接口。

> 客户端

新建一个客户端类，用hutool的Http调用工具去调用我们项目中的接口

## 4 API签名认证

笔记参考 tricks.md

## 5 SDK开发

每次调用接口都需要自己写客户端，并且写签名认证、传递签名参数等一系列东西非常麻烦，需要开发一个SDK就像mybatis一样，引入starter 依赖，在pom中配置，就可以轻松使用。 

## 6 发布和下线接口

> 后端

接口存在 + 接口可用 + 管理员权限 --> 发布接口 状态字段 置为 1 

接口存在 + 管理员权限 --> 下线接口 状态字段 置为 0 

管理员权限 切面 AOP

> 前端

上线和下线不同时出现

```
record.status===0?<Button><\Button>
```

## 7 主页接口信息

> ### 01 接口列表

index

> ### 02 查看接口信息

interfaceinfo

**1 添加路由**

```typescript
// 1 让这个路由可以接收动态参数，在点击查看之后可以跳到对应的接口页面，通过id来区分不同的接口。

path: '/interface_info/:id'

// 定义了路由的路径，其中:id是一个参数占位符，表示在实际路径中可以传递一个具体的ID值作为参数。
```

```typescript
//2 让这个页面在菜单栏中隐藏，查看接口不需要放在菜单栏上。

hidelnMenu: true

// 表示该路由在菜单中是否隐藏，如果设置为true，则该路由不会在菜单中显示。
```

router.ts 完整内容

```typescript
export default [
  { 
    name: '主页',
    icon: 'smile',
    path: '/',
    component: './Index'
  },
  {
    name: '接口详情页',
    icon: 'BarChartOutlined',
    path: '/interface_details',
    component: './InterfaceInfo',
    hideInMenu: true, // 在菜单隐藏
  },
  {
    name:'登录',
    path: '/user',
    layout: false, //通过配置 layout: false 可以单独关闭某一个路由的全局布局
    routes: [{ path: '/user/login', component: './User/Login' }] },
  {
    name: '管理页面',
    path: '/admin',
    icon: 'crown',
    access: 'canAdmin',
    routes: [
      { name: '接口管理', icon:'table', path: '/admin/interface_info', component: './Admin/InterfaceInfo' },
    ],
  },
  // { name: '表格', icon: 'table', path: '/list', component: './TableList' },
  // { path: '/', redirect: '/welcome' },
  { path: '*', layout: false, component: './404' },
];

```

**2 获取URL里的id查询接口信息并在页面上显示**

之前在Vue中获取当前页面的URL参数 **$router.params.id**。

umi-React中也有自己的**钩子**

1. **<font color='red'>userMatch</font>**可以获取整个页面路径的详情，如

```tsx
//使用useMatch钩子将当前的URL与指定的路径/interface_details/:id进行匹配
//并将匹配结果赋给match变量
const match = useMatch('interface_detail/:id');
//使用JSON.stringify将match变量的值转为JSON字符串
alert(JSON.stringify(match))
```

![](https://github.com/polarisronx/Papi-backend/doc/images/image316.png)

2. 但我们这并不需要这么全的信息，只需获取路由中的参数，可以用 useParams 的钩子函数

## 8 接口调用

前端不可以直接调用接口，而应该由后端转接。原因在于，如果模拟接口可以直接被调用，那么存在安全风险。通常情况下，前端虽然可以直接调用模拟接口，但我们不会将模拟接口暴露给外部，而是将其隐藏起来。用户或开发者在调用时可能根本不知道模拟接口的地址。假设，模拟接口的地址是aaa.com/api，后端地址是
bbb.com/api，而 aaa.com/api并不对用户开放，用户根本不知道它的存在。

## 9 创建用户-接口信息表

创建用户-接口表 后端管理

修改调用次数要考虑并发

- 设计数据库表

  用户id和接口id构成一个联合主键，也可以另外新建一个用户接口关系id作为主键。

  要不要考虑加接口调用时间？不，这样太占用空间，真要有不如体现在日志中。

<font color='green'>**todo 用户调用次数统计时，需要考虑并发的问题，需要分布式锁，这里没有实现**</font>

## 10 网关

> 如何实现用户调用后次数加1

1. 抽取通用代码？
2. AOP切面？拦截器？
3. 网关？

AOP独立于接口，在每个接头调用后次数加一

1.2 适用于单个项目内的接口被调用。但是接口可能由不同团队开发，分布在不同项目内，这时如果要开发团队都引入这段逻辑，不太方便。应该通过网关来解决，由网关来负责为用户找到接口的地址，并统计次数，而不用关心接口在哪个项目。

- 思考实现的细节

  怎样是用户调用完？如果是网络原因等导致的失败，而不是参数错误等原因，应视为请求完成。

  除了统计用户调用次数，还应该给用户分配调用次数

> **什么是网关？有什么用？**

类似于火车站。各个服务理解为火车，可以引导用户去哪列火车，检票。

功能有：统一路由、负载均衡、统一鉴权、跨域、统一业务处理（缓存、通用业务）、访问控制、发布控制、流量染色、接口保护（请求限制、脱敏、降级熔断、限流、超时）、统一日志和文档。knife4j API 接口文档。

**1 路由**

起到请求转发的功能。网关记录各个接口、服务的信息，根据用户访问的地址和参数将请求转发到对应的接口（服务）。

如 /a  转发到 接口A

/b  转发到 接口B

**2 负载均衡**

/c 转发到 服务A、集群A（转发到其中一个节点）

**3 统一鉴权**

相比于我们在项目中设计鉴权逻辑，网关的鉴权更侧重于统一。

**4 处理跨域**

不用在单个项目单独处理跨域

**5 统一业务逻辑**

把一些每个项目中都要做的通用逻辑都放在网关统一

**6 访问控制**

区别于鉴权，访问控制是独立于项目业务之外的对访问的黑白名单设置，如限制 DDOS IP，禁止试图攻击网站的IP访问

**7 发布控制**

流量控制，类似于灰度发布，比如在发布一个新版本时，让80%的流量依旧访问旧版本，20%访问新版本。

**8 流量染色**

分布式链路追踪，找到出现问题的地方。区分流量来源。添加请求标识，如给来自网关的请求加请求头，越过网关直接访问的请求就不能访问

filter 中可以 addRequestHeader

> 网关的核心概念

路由router、断言predicate、过滤器filter

filter可以对请求做处理，如添加请求参数、请求头、服务降级等

> 网关的配置

```yaml
spring:
	cloud:
		gateway:
			routes: 
			#这是配置路由的属性。
			- id: after_route: 
			#这是路由的唯一标识符，用于区分不同的路由。
			  uri: https://example.org 
			  #这是路由将请求转发到的目标URI，即请求经过此路由后将被转发到https://example.org这个地址。
			  predicates: #这是断言的配置属性，用于定义请求是否满足路由条件。
			  - Cookie=mycookie,mycookievalue:
			  # 这是一个断言条件，它指定了请求必须具有名为mycookie的Cookie，且其值必须为mycookievalue，才能匹配这个路由。
```

"-" 表示列表，可以配置多项

> 网关的分类

1. 全局网关（接入层网关）：全局网关通常层级较高，可能覆盖多个项目或微服务，并负责将用户的请求转发到不同的业务、项目、接口或服务。它主要用于请求的负载均衡、请求日志等功能，较少涉及具体的业务逻辑。
2. 业务网关（微服务网关）：体现业务逻辑，将请求转发到不同的业务/项目/接口/服务。

网关技术选型

1. Nginx（全局网关）、Kong（付费）

   相比之下，Nginx是比较推荐的全局网关，也称为接入层网关。Nginx可以部署前端和后端，还能提供文件访问服务等多种功能，非常灵活。我们甚至可以在Nginx中编写业务逻辑，但是并不推荐这样做，因为它并不像Spring Cloud Gateway那样方便。

2. SpringCloud gateway，性能高，可用java开发

   Gateway取代了zuul，使用NIO和多路复用的技术，底层采用了native和React模型，能实现更高的并发量。

## 11 网关实操

> 路由转发

路径前缀断言

> 业务逻辑

全局过滤器 globalFilter

- **exchange**(路由交换机):我们所有的请求的信息、响应的信息、响应体、请求体都能从这里拿到。

  ```java
  ServerHttpRequest req = exchange.getRequest();
  ```

- **chain**(责任链模式):因为我们的所有过滤器是按照从上到下的顺序依次执行，形成了一个链条。所以这里用了一个chain，如果当前过滤器对请求进行了过滤后发现可以放行，就要调用责任链中的next方法，相当于直接找到下一个过滤器，这里称为 filter。有时候我们需要在责任链中使用next，而在这里它使用了filter来找到下一个过滤器，从而正常地放行请求。

- 拦截请求：

  ```java
  ServerHttpRequset = resp = exchange.getResponse();
  response.setStatusCode(HttpStatus.FORBIDDEN);
  return response.setComplete();
  ```

  这个**<font color='red'>Mono</font>**其实是**响应式编程**的一种对象，类似于前端的 Promise。如果你熟悉前端的异步操作，那么可以将Mono理解为类似的概念。在这段代码中，我们直接返回了这个Mono，它并不包含响应参数。相当于我们告诉程序，请求处理完成了，不需要再执行其他操作了。

**问题**：预期是等模拟接口调用完成，才记录响应日志、统计调用次数，但是发现chain.filter()方法放行，Filter过滤器return执行完了之后才执行的接口方法。因为是chain.filter()异步的，没有立即去执行接口方法，Gateway的架构里也可以看到，是执行完所有的Filter值才拿到服务的代理对象执行的。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240325211736.png)

解决方法：利用**Response装饰者**，增强原有Response的处理能力。

**<font color='red'>ServerHttpResponseDecorated</font>**(HttpResponse originalResponse) 类似与AOP增强了方法，这个装饰类增强了Response类，而这里面写的逻辑都是在调用接口获取响应后执行了，就能够引入并替换原先Filter中的逻辑。 

**这样哪怕它是异步的，当最后执行这个方法时，装饰器也能做额外的事情。这就是装饰者利用装饰增强原有方法的处理能力。**

todo 网关项目内是没有mybatis的，不能做数据库的增删改查，可以调用 backend 项目中的接口

- Http请求（HttpClient、RestTemplate、OpenFeign）
- RPC（Dubbo）

### 基于gateway的自定义负载均衡

dubbo-nacos踩坑

nacos不要用这个依赖，papi-gateway作为消费者注册到nacos一直注册不上，虽然能够调到papi-main提供的服务，但是不能获取到其他微服务，在这里想要用服务名负载均衡地调用papi-interface却是不能了。

```xml
<dependency>
    <groupId>com.alibaba.nacos</groupId>
    <artifactId>nacos-client</artifactId>
    <version>2.3.0</version>
</dependency>
```

改用下面这个依赖就行了

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

负载均衡

```yaml
spring:
  application:
    name: papi-gateway
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
        namespace: b765d215-8484-45ec-a86f-07048c01dd47
        group: ${spring.profiles.active}
        username: nacos
        password: nacos
    loadbalancer:
      nacos:
        enabled: false
    gateway:
      routes:
        - id: papi-route
#          uri: http://localhost:8123
          uri: lb://papi-interface
          predicates:
            - Path=/api/**
```

### 基于Gateway的流量染色

给通过网关的请求都加统一请求头，不来自网关的请求不携带指定请求头将被拒绝

[网关gateway token验证成功后添加请求头操作_gateway添加请求头-CSDN博客](https://blog.csdn.net/qq_51456123/article/details/125735344)

## 14 接口调用统计分析

> ### <font color='red'>**调用接口的过程：**</font>

1. **前端 8000** 点击调用 
2. **后端 7529** controller /Invoke  
3. **sdk** 后端由LoginUser获取AK和SK获取客户端 papiClient
4. **sdk** 后端由客户端通过Http协议调用接口，同时会添加用户签名认证所需的请求头 
5. **网关 8090** 请求打到网关，网关鉴权、转发
6. **接口项目 8123** 接口调用

## 12 RPC

> 调用另一个项目里的方法

**1.复制代码和依赖、环境**

可能有环境依赖和代码问题，常量、配置等冲突或不同；

**2.HTTP请求**(提供一个接口，供其他项目调用)

**3.RPC**

**4．客户端SDK**（把公共的代码打个jar包，其他项目去引用）

> RPC

像调用本地方法一样调用远程方法

和直接Http调用的区别

1. 对开发者更透明，减少了沟通成本

   在调用本地方法时，我们可以直接传递参数给方法，比如接口统计的方法。但是Http请求需要调用方做更多的操作来配合才能使用。如yuapi-client-sdk项目里，你需要自行封装HTTP请求，将参数打包成一个参数映射(map)，然后按照客户端工具类的方式发送请求。此外，你还需要解析返回值，将其中的code、data以及 message等信息提取出来。

2. 向远程服务器发送请求时，可以选择性能更高的协议（RPC可以用Http，但可以选择其他如TCP/IP）

3. ##### 服务治理（下游服务新增，重启，下线时如何不影响上游调用者）

   - RPC：能做到自动通知，不影响上游
   - HTTP：需要事先通知，修改Nginx/HAProxy配置

**RPC主要用于公司内部服务调用，性能消耗低，传输效率高，服务治理方便**。**HTTP主要用于对外的异构环境，浏览器调用，APP接口调用，第三方接口调用等等。**

> Dubbo

Dubbo3 使用的协议是 Triple协议，是基于 HTTP 的开放协议，旨在解决 Dubbo2 私有协议带来的互通性问题，Tripe 基于 gRPC 和 gRPC-Web 设计而来，保留了两者的优秀设计，Triple 做到了完全兼容 gRPC 协议，并可同时运行在 HTTP/1 和 HTTP/2 之上。

Dubbo 缺省协议采用单一长连接和 NIO 异步通讯，适合于小数据量大并发的服务调用，以及服务消费者机器数远大于服务提供者机器数的情况。

> RPC 实操

Dubbo+nacos 

要实现的业务功能

1. backend项目作为服务提供者，提供3个方法:

  a．实际情况应该是去数据库中查是否已分配给用户

  b.从数据库中查询模拟接口是否存在，以及请求方法是否匹配(还可以校验请求参数)

  c．调用成功，接口调用次数+1 invokeCount

2. gateway 项目作为服务调用者，调用这3个方法

- 什么是IDL？
- 如何使用：
  - 引入依赖
  - 提供者主类@EnableDubbo
  - 提供者接口的实现@DubboService
  - 消费者@DubboReference注入

## 13 抽取公共服务

项目名: yuapi-common

目的:让方法、实体类在多个项目间复用，减少重复编写。

服务抽取:

1.数据库中查是否已分配给用户秘钥（根据accessKey拿到用户信息，返回用户信息，为空表示不存在)

2．从数据库中查询模拟接口是否存在（(请求路径、请求方法、请求参数，返回接口信息，为空表示不存在)

3．接口调用次数＋1 invokeCount (accessKey、secretKey(标识用户)，请求接口路径)

步骤:

1. 新建干净的maven项目，只保留必要的公共依赖

2. 抽取service接口和实体类

3. install本地 maven包
4. 让服务提供者引入common包，测试是否正常运行
5. 让服务消费者引入common包

- **公共包里的接口用Inner前缀与其他相区分，并且只需说明结构即可，具体实现在其他项目完成。**
- **且接口不用继承mybatis的IService，在其他项目实现时直接用注入的mapper即可**

**<font color='green'>todo 流量染色</font>**

<font color='green'>**todo 获取接口host**</font>

<font color='green'>**todo sdk中针对不同请求调用不同接口方法**</font>

**<font color='green'>todo 让其他用户上传接口</font>**

有同学问:如何让其他用户上传自己编写的接口?
需要提供一个注册机制。在这个机制下，其他用户可以上传他们自己编写的接口信息。为了简化流程，可以设计一个用户友好的界面。在这个界面上，用户可以输入他们的接口信息，包括服务器地址(host)、请求路径等内容。也可以规定，在接入我们的平台时，用户必须使用我们提供的SDK或遵循一定的要求。
如何进行接入和要求的遵循?在用户上传接口的时候，我们需要对接口信息进行测试调用，以确保接口的正常运行，这可以通过我们的平台来完成。同时，我们也可以要求用户标明该接口是否是由我们的网关调用，这可能需要用户在代码中加入判断代码，或者引入我们提供的SDK来实现。
接口信息的组织和存储:当用户上传接口信息时，这些信息将被存储在InterfaceInfo接口中。除了URL外，还应该添加一个host字段，用于明确区分不同服务器的地址。这样，可以更清晰地区分请求路径和服务器地址，提高接口信息的可读性和可维护性。



## 14 接口调用统计分析

各接口的总调用次数占比（饼图）取调用最多的前3个接口，从而分析出哪些接口没有人用(降低资源、或者下线)，高频接口(增加资源、提高收费)。

> #### 后端

查询各接口的总调用次数，在 UserInterfaceInfo 表中按 InterfaceId 分组查询。

但是我们要进行展示，需要获取接口名，则又需要再 InterfaceInfo表中进行查询。



## 15 观摩大厂的API平台

排名不分先后

大厂必备的提供给开发者来在线调试自家的服务和接口的平台。

### TencentCloud 

腾讯 云API 平台 [云 API_云产品接口_云资源管理_云运维开发 - 腾讯云 (tencent.com)](https://cloud.tencent.com/product/api)

> ##### 01 腾讯API调试方式

- 下载SDK

- API explorer 在线调试

  https://console.cloud.tencent.com/api/explorer

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329105337.png)

> ##### 02 SDK信息

欢迎使用腾讯云开发者工具套件（SDK）3.0，SDK 3.0是云 API 3.0平台的配套工具。目前已经支持 CVM、VPC、CBS 等产品，后续所有的云服务产品都会陆续接入。新版 SDK 实现了统一化，具有各个语言版本的 SDK 使用方法相同，接口调用方式相同，错误码相同以及返回包格式相同等优点。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329105445.png)

> ##### 03 SDK使用文档

[Java-SDK 中心-腾讯云 (tencent.com)](https://cloud.tencent.com/document/sdk/Java#d006b724-ca4d-462d-90f8-b4f14748ac6e)

使用上述引用方式会将腾讯云所有产品的 SDK 下载到本地。如果您只需要特定产品的 SDK，可以将 artifactId 替换为 tencentcloud-sdk-java-cvm/cbs/vpc 等。代码中的使用方式和整体 SDK 相同，可参考示例。您也可以在 [Maven 仓库 ](https://search.maven.org/search?q=tencentcloud-sdk-java)中查询最新版本，可节省存储空间。

> ##### 04 SDK-JAVA 源码分析

[TencentCloud/tencentcloud-sdk-java: Tencent Cloud API 3.0 SDK for Java (github.com)](https://github.com/TencentCloud/tencentcloud-sdk-java)

**源码结构**

主路径下是不同功能模块的对应SDK包

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329114259.png)![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329114354.png)

**单个模块源码结构**

- **models**包

  主要是对应一个API接口的一个Request和Response封装类（用于发送请求时的参数和接收响应结果的封装类），也有一些该模块下特有的一些其他方法

  ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329115521.png)

- **AaClient**

  客户端类，主要是三部分：属性、构造器、方法

  ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329115857.png)

  **构造器**：构造器中需要传入credential（凭证，后面讲），region（地区），ClientProfile（定义客户端的属性而封装的类，主要是设置签名方法、Http属性、语言、是否debug等）

  **方法**：调用API的入口方法（不是具体的业务，执行这个方法就会发送请求到对应的主机来执行业务），参数是在models中的Request封装类，返回类型是Response的封装类。里面执行了相对通用的发送请求的方法 internalRequest()，主要是根据不同的API (actionName)来发送请求（后面细讲）。

  ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329125804.png)

- **AaErrorCode**

  定义了不同错误类型的枚举类

  ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329130641.png)

**源码通用结构：Common包**

Common包结构

1. Exception

   通用的异常类

2. HttpConnection

   获取Http连接，定义了doRequest()、getRequest()、PostRequest()等发起请求的方法

3. Profile

   定义客户端、Http连接属性的封装类、枚举类。

4. Provider

   定义了针对不同使用场景的用户凭证 （里面的类继承了Credential）

5. 通用结构

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329131824.png)

   - AbstractClient：抽象类，定义了客户端的一些基础结构，其他模块的客户端在此基础上实现

   - Credential：定义了用户调用接口许可的凭证，如密钥ID和密钥。

     ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329133815.png)

   - sign：定义前面生成方法，加密算法等

     ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329134206.png)

   - AbtractModel：抽象类，定义了Request和Response的一些基础结构，其他模块的Request和Response在此基础上实现

**细看前面提到的发起请求的方法 internalRequest()**

1. 先看表层

```java
protected String internalRequest(AbstractModel request, String actionName)
            throws TencentCloudSDKException {
	// CircuitBreaker 断路器，对调用过程起到一个流程控制和记录的作用
    CircuitBreaker.Token breakerToken = null;
    if (regionBreaker != null) {
        breakerToken = regionBreaker.allow();// 放行
        if (!breakerToken.allowed) {
            endpoint = service + "." + profile.getBackupEndpoint();
        }
    }
	// 记录响应信息
    Response okRsp;
    try {
        okRsp = internalRequestRaw(request, actionName);
    } catch (IOException e) {
        // network failure, consider region failure
        if (breakerToken != null) {
            breakerToken.report(false); // 记录错误信息
        }
        throw new TencentCloudSDKException("", e);
    }
	// 响应成功的返回
    String strResp;
    try {
        strResp = okRsp.body().string();
    } catch (IOException e) {
        String msg = "Cannot transfer response body to string, because Content-Length is too large, or Content-Length and stream length disagree.";
        log.info(msg);
        throw new TencentCloudSDKException(msg, e);
    }
	// 响应失败的返回
    JsonResponseModel<JsonResponseErrModel> errResp;
    try {
        Type errType = new TypeToken<JsonResponseModel<JsonResponseErrModel>>() {
        }.getType();
        errResp = gson.fromJson(strResp, errType);
    } catch (JsonSyntaxException e) {
        String msg = "json is not a valid representation for an object of type";
        log.info(msg);
        throw new TencentCloudSDKException(msg, e);
    }

    if (errResp.response.error != null) {
        if (breakerToken != null) {// 如果响应失败，断路器不为空，进行一些故障排查
            JsonResponseErrModel error = errResp.response;
            boolean regionOk = error.requestId != null
                && !error.requestId.isEmpty()
                && error.error.code != null
                && !error.error.code.equals("InternalError");
            breakerToken.report(regionOk);
        }
        throw new TencentCloudSDKException(
            errResp.response.error.message,
            errResp.response.requestId,
            errResp.response.error.code);
    }

    return strResp;
}
```

还有一个重载方法，这个更简洁

```java
protected <T> T internalRequest(AbstractModel request, String actionName, Class<T> typeOfT)
            throws TencentCloudSDKException {
        CircuitBreaker.Token breakerToken = null;
        if (regionBreaker != null) {
            breakerToken = regionBreaker.allow();
            if (!breakerToken.allowed) {
                endpoint = service + "." + profile.getBackupEndpoint();
            }
        }

        try {
            Response resp = internalRequestRaw(request, actionName);
            if (Objects.equals(resp.header("Content-Type"), "text/event-stream")) {
                return processResponseSSE(resp, typeOfT, breakerToken);
            }
            // 处理返回的响应，typeOfT会传进各个模块中定义的Response类
            return processResponseJson(resp, typeOfT, breakerToken);
        } catch (IOException e) {
            // network failure, consider region failure
            if (breakerToken != null) {
                breakerToken.report(false);
            }
            throw new TencentCloudSDKException("", e);
        }
    }
```

2. 实际上还包了一层，**okRsp = internalRequestRaw(request, actionName)** 才是实际有作用的，点进这个方法

这个方法前面的我们不关心，就是获取一些属性，设置签名的算法，实际作用的是框出来的 **doRequest**和**doRequestWithTC3**。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329142339.png)

3. **doRequest()**比较简洁，先看

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329142825.png)

   **对于<font color='red'>get</font>请求**：

   把 **<font color='red'>协议 protocol + 请求域名 endpoint + 请求路径 path + ? + 请求参数 strParam</font>** 拼接起来就是API接口调用的路径

   getRequest()方法中，将请求地址、请求头放入创建请求，然后doRequest()执行。

   **对于<font color='red'>post</font>请求**：

   把 <font color='red'>**协议 protocol + 请求域名 endpoint + 请求路径 path** </font>拼接起来就是API接口调用的路径。

   postRequest()方法中，请求参数以**application/x-www-form-urlencoded**键值对参数类型放在请求体中，将请求地址、请求头放入创建请求，然后doRequest()执行。

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329145129.png)

   关于请求参数 StrParam 的特别说明：请求参数由两部分组成，一是API接口本身要传递的参数，这个由不同模块自己的Request已经封装好了，二是API接口名，因为对于通用的请求发起方法来说，不知道实际要请求的是哪个接口。

4. **doRequestWithTC3()**相比doRequest()主要是多了在请求头中添加签名的过程，考虑了鉴权的问题。

   ```java
   private Response doRequestWithTC3(String endpoint, AbstractModel request, String action)
       throws TencentCloudSDKException, IOException {
       /*
          此处省略一大段代码
       */
       String stringToSign =
           "TC3-HMAC-SHA256\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;
       boolean skipSign = request.getSkipSign();
       String authorization = "";
       if (skipSign) {
           authorization = "SKIP";
       } else {
           // 获取签名信息
           String secretId = this.credential.getSecretId();
           String secretKey = this.credential.getSecretKey();
           byte[] secretDate = Sign.hmac256(("TC3" + secretKey).getBytes(StandardCharsets.UTF_8), date);
           byte[] secretService = Sign.hmac256(secretDate, service);
           byte[] secretSigning = Sign.hmac256(secretService, "tc3_request");
           // 生成加密签名
           String signature =
               DatatypeConverter.printHexBinary(Sign.hmac256(secretSigning, stringToSign)).toLowerCase();
           // 最终的签名认证
           authorization =
               "TC3-HMAC-SHA256 "
               + "Credential="
               + secretId
               + "/"
               + credentialScope
               + ", "
               + "SignedHeaders="
               + signedHeaders
               + ", "
               + "Signature="
               + signature;
       }
       // 将签名认证添加到请求头
       Builder hb = new Headers.Builder();
       hb.add("Content-Type", contentType)
           .add("Host", endpoint)
           .add("Authorization", authorization)
           .add("X-TC-Action", action)
           .add("X-TC-Timestamp", timestamp)
           .add("X-TC-Version", this.apiVersion)
           .add("X-TC-RequestClient", SDK_VERSION);
       if (null != request.GetHeader()) {
           for (Map.Entry<String, String> entry : request.GetHeader().entrySet()) {
               hb.add(entry.getKey(), entry.getValue());
           }
       }
       if (null != this.getRegion()) {
           hb.add("X-TC-Region", this.getRegion());
       }
       String token = this.credential.getToken();
       if (token != null && !token.isEmpty()) {
           hb.add("X-TC-Token", token);
       }
       if (this.profile.isUnsignedPayload()) {
           hb.add("X-TC-Content-SHA256", "UNSIGNED-PAYLOAD");
       }
       if (null != this.profile.getLanguage()) {
           hb.add("X-TC-Language", this.profile.getLanguage().getValue());
       }
   
       String protocol = this.profile.getHttpProfile().getProtocol();
       String url = protocol + endpoint + this.path;
       String apigwEndpoint = this.profile.getHttpProfile().getApigwEndpoint();
       if (null != apigwEndpoint) {
           url = protocol + apigwEndpoint;
           hb.set("Host", apigwEndpoint);
       }
       Headers headers = hb.build();
       // 带请求头执行get方法
       if (httpRequestMethod.equals(HttpProfile.REQ_GET)) {
           return this.httpConnection.getRequest(url + "?" + canonicalQueryString, headers);
       } else if (httpRequestMethod.equals(HttpProfile.REQ_POST)) {
           // 带请求头执行post方法
           return this.httpConnection.postRequest(url, requestPayload, headers);
       } else {
           // 不支持post和get之外的方法
           throw new TencentCloudSDKException("Method only support GET, POST");
       }
   }
   ```

----

**最后再来看一个test的实例，还是用最开始的AA（活动防刷）举例**

点击下载工程就能把该API接口相关的SDK下载下来了

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329195657.png)

在IDEA中打开

蒸锅过程大概就是：

1. 传入密钥
2. 设置客户端属性
3. 生成客户端
4. 生成请求参数对象Request
5. 执行方法
6. 拿到响应Response

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329195350.png)

### Aliyun

阿里云也是很强，但功能类似，就不细品了

官网：[阿里云OpenAPI开发者门户 (aliyun.com)](https://api.aliyun.com/)

文档：[OpenAPI Explorer(OpenAPI)-阿里云帮助中心 (aliyun.com)](https://help.aliyun.com/product/74373.html?spm=a2c4g.74407.0.0.785bde53r5xA54)

OpenAPI 门户，英文名称 OpenAPI Portal 或 OpenAPI Explorer。它是一款集 OpenAPI 智能搜索、文档、在线调试、SDK 获取、CodeSample、调用出错诊断、调用统计为一体的产品。您可以在 OpenAPI 门户中调用阿里云各云产品开放的 OpenAPI ，查看 OpenAPI 请求和返回结果。此外， OpenAPI 门户会自动生成相应 OpenAPI 的 SDK 调用示例，帮助您使用阿里云 OpenAPI 。

> 01 功能

OpenAPI 门户提供以下功能：

- OpenAPI 检索

  汇集阿里云多个产品的 OpenAPI ，可以在此集中检索，快速找到您所需要的 API。

- OpenAPI 调用

  无需编写代码，在调用页面中填写请求参数，便可调用 OpenAPI 。

- 查看 OpenAPI 请求

  根据您填写的请求参数自动生成 OpenAPI 请求，并打印到网页上，让您直观地查看到真实发送的 OpenAPI 请求。

- 结构化输出返回结果

  根据 OpenAPI 请求，返回真实的 OpenAPI 调用结果，结构化输出。

- 生成 SDK 调用示例

  根据输入的 OpenAPI 请求参数，自动生成多种语言的 SDK 调用示例。

- 命令行调用

  提供网页版命令行工具，模拟 Linux 操作体验使用命令行调用 OpenAPI 。

![](https://github.com/polarisronx/Papi-backend/doc/images/6c3ebf00103vd.svg)

OpenAPI 门户要求开发者必须登录，通过用户登录身份，系统会自动获取可用的 AK 信息，调用 OpenAPI ，无需用户在调试界面传入 AK 数据，提升 OpenAPI 调试的便捷性。

> 02 界面

界面比较相似

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329104518.png)

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329104818.png)

SDK也很类似

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240329200802.png)

### 美团

美团部分主要关注它的[SDK自动生成](https://tech.meituan.com/2023/01/05/openplatform-sdk-auto-generate.html)

> #### **01 应用背景**

1. 阅读腾讯的SDK源码可以知道，不同模块不同方法再调用时因为参数等不同，虽然并不需要实现业务功能，但也很难用通用的逻辑来实现，还是需要一个接口有对应SDK，这需要人工开发十分麻烦。

2. 以美团为例，美团开放平台将美团各类业务提供的扩展服务封装成一系列应用程序编程接口（API）对外开放，供第三方开发者使用。开发者可通过调用开放平台提供的OpenAPI获取数据和能力，以实现自身系统与美团系统协同工作的业务逻辑。以外卖业务场景为例，开发者可以在自己为外卖商户开发的应用中通过调用美团开放平台提供的API，提供外卖订单查询、接单、订单管理等一系列功能。如下图所示：

![](https://github.com/polarisronx/Papi-backend/doc/images/42fc2d55ccbed47e618eb1f16a94a5e7121354.png)

3. 美团开放平台提供给开发者的**接口契约较为复杂**，其中包含了业务规则复杂及安全性要求高等原因。若**开发者需要直接从0到1编码对接平台提供的HTTP API，需要关注通信协议、接口契约规范、认证标识传递和安全签名等细节，成本较高**。随着业务的发展，平台支持的OpenAPI数量在近两年增长约一倍，达到近1000个，平台运营和研发人员需要投入越来越多的精力去帮助开发者解决接口对接过程中的疑难问题。因此，提供SDK以帮助开发者提高开发对接效率，变得十分有必要。

> #### **02 SDK 架构**

SDK，英文名称为 Software Development Kit，即软件开发工具包，广义上指辅助开发某一类软件的相关工具、文档和范例的集合。在开放平台的场景，我们为开发者提供的SDK应能为其屏蔽调用OpenAPI的**通信协议、参数传递规范、接口基础契约（如时间戳、安全签名）**等细节，以降低其对接平台API所需的开发成本。具备基本功能的开放平台SDK的架构和功能模块如下所示：

![](https://github.com/polarisronx/Papi-backend/doc/images/a68a0c26f4d404ed8b2745f4ad21687f193061.png)

> #### **03 SDK设计目标**

1. **通信协议封装**（一次性工作）：让开发者无需关注调用API的通信协议和通信逻辑。
2. **接口基础契约封装**（一次性工作）：让开发者无需关注调用API的参数传递格式、时间戳、安全签名、返回Code码处理等细节。
3. **请求参数模型封装**：让开发者便捷地设置API请求参数。
4. **返回参数模型封装**：让开发者便捷地使用API返回的数据。

**<font color='red'>SDK自动生成工具的主要目标 --> 生成参数富模型（3、4）</font>**

自动生成供SDK使用的请求参数模型代码（Request类）、返回参数模型代码（Response类）和调用示例代码（Example），并且代码自动生成机制要支持SDK适配的多种编程语言。

- **主要工作**

请求参数模型（Request类）：需要生成Request Path、鉴权配置、字段强类型定义、字段取值、赋值及校验逻辑等代码。

返回参数模型（Response类）：需要生成接口返回的各个数据字段的强类型定义、取值逻辑及校验规则。调用示例代码则需要包含请求参数赋值、发起接口调用和处理接口返回数据等相关逻辑。

> #### **04 设计方法**

当前主要的代码自动生成技术有：

1. **基于模版编排生成代码**：最原始最简单也是目前应用最广泛的一种代码生成方式。包括后端MVC框架的Controller、Service、DAO层模式化代码一键生成（**<font color='red'>MybatisPlus</font>**），还有前端Vue CLI 和Create-React-App两款脚手架的代码生成，都属于此类。
2. **基于可视化UI生成代码**：目前市场上运用得很广的一门技术，也被称为代码可视化生成工具。从Eclipse的Web可视化编辑器，到.NET Framework提供的MVC，及Winform界面及**<font color='red'>控件代码可视化拖拽生成</font>**，到汽车行业广泛使用的可视化原型搭建工具（自动生成C代码）都属于此类。在近几年比较火的低代码平台（如aPaaS）中，通过可视化UI生成代码的技术也被大量使用。
3. **基于代码语料生成代码**：基于代码语料生产代码的前提是要有足够的语料，例如伪代码/中间语言/描述性代码模板，再基于一套生成规则去生成目标代码。常见的落地场景包括**<font color='red'>RPC框架中基于IDL</font>**（Interface description language，接口描述语言）自动生成多种编程语言的RPC Client和Service代码（**Dubbo**），以及IDE插件中的代码自动生成功能（例如Eclipse的[telosys](https://marketplace.eclipse.org/content/telosys-tools)插件可通过DSL生成多种语言代码）。
4. **基于人工智能技术生成代码**：属于比较前沿的技术范畴，多和AI领域的图像识别和机器学习技术结合。现有的一些典型案例包括：微软开发的可将手绘图转化HTML代码的智能化代码生成工具[sketch2code](https://www.microsoft.com/en-us/ai/ai-lab-sketch2code)，基于AI技术自动生成UI逻辑的[teleporthq](https://github.com/teleporthq)。

由于需要自动生成的OpenAPI参数富模型代码和调用示例代码均具备相对较强的**规则性和模式性**，采用 **代码语料** 生成。基于代码语料自动生成代码需要“**语料**”+“**规则**”两个核心元素，需要：

1. 通过解析API元数据并结合领域专用语言（DSL）作为语料模板，生成代码语料；

2. 基于语料特性为不同的编程语言定制代码生成规则；

3. 最终将“语料”+“规则”输入代码生成器以完成目标代码的生成。

   整体流程如下图所示：

   <img src="https://github.com/polarisronx/Papi-backend/doc/images/d98ed501c083ca9b5207c4c052b3abcc340972.png" style="zoom: 50%;" />

> #### **05 API元数据**

**API元数据是代码语料生成的数据源**，其来源于开放平台实现的零编码API网关底层维护的基础配置。开放平台网关基于API元数据配置化的技术，可做到零编码将业务服务的RPC接口转化为HTTP协议的API进行开放。其基本运行结构如下图所示：

![](https://github.com/polarisronx/Papi-backend/doc/images/49245d3c18d8f755dbefdc6478f689bf230136.png)

API元数据中包含了**<font color='red'>HTTP Method、URL、请求参数、返回参数等</font>**信息。在参数信息中，又以树形结构记录了**每个参数字段的字段名、字段类型、字段描述、校验规则和示例值**，有了这些信息就能够支撑我们为SDK生成参数富模型和调用示例代码。例如“按订单id查询订单详情”，其元数据中和SDK生成相关的数据如下所示：

```properties
APIGroup:waimai
APISubGroup:order
APIName: order_query_by_id
HTTP METHOD: POST
HTTP PATH: /api/order/queryById
Description: 按订单id查询订单详情
Request
  |- orderId LONG NOT_NULL 要查询的订单的id example:1000224201796844308
Response
  |- orderId  LONG NOT_NULL 订单id  example:1000224201796844308
  |- price  LONG NOT_NULL 订单金额（单位为人民币“分”） example:3308
  |- phone  STRING  顾客联系电话   example:"13000000002"
  |- products  ARRAY<Product>  订单商品列表
     |- pid  LONG  商品id   example:"13000000002"
     |- name  String  商品名  example:"珍珠奶茶"
     |- num  INTEGER  商品数量  example:1
     |- price  LONG  商品单价   example:1199
     |- properties  ARRAY<Property>  商品属性列表
        |- name STRING 商品属性名  example:"甜度"
        |- value STRING 商品属性值  example:"七分糖"
     |- remark  STRING  商品备注  example:"请做常温的"
  |- status  INTEGER  订单状态  example:7
```

接下来只要有规范的数据记录格式和读取方式，就能够生成对应的代码

> #### 06 代码语料

**代码语料可以理解为符合编程思想，能让机器立即和实现的代码原料，能够让语言转换引擎直接翻译为代码。**不同语言的语料略有不同，以生成Java SDK中的参数富模型代码为例，需要用到的代码语料包含两部分。第一部分为**类的基本信息**，由元数据解析器在解析API的元数据时生成，其包含的内容和具体生成方式如下表所示：

![](https://github.com/polarisronx/Papi-backend/doc/images/e2d3a67d186f36e9c5b24e47b056e2cb504544.png)

第二部分为**语料模板**，我们以DSL（Domain Specific Language）作为中间语言加以描述，如下所示：

```xml
<@class className=className metaInfo=javaApiMeta baseClass=baseClass interfaces=interfaces classDesc=classDesc package=packageName importPackages=importPackages>
    <#-- 静态字段   -->
    <#if staticFields?? && (staticFields?size > 0) >
        <#list staticFields as param>
            <@staticField param=param/>
        </#list>
    </#if>
    <#-- 字段   -->
    <#if privateFields?? && (privateFields?size > 0) >
        <#list privateFields as param>
            <@field param=param/>
        </#list>
    </#if>
   <#-- Getter/Setter -->
    <#if privateFields?? && (privateFields?size > 0) >
        <#list privateFields as param>
            <@getterMethod param=param/>
            <@setterMethod param=param/>
        </#list>
    </#if>
    
    <#-- 静态字段Getter -->
    <#if staticFields?? && (staticFields?size > 0) >
        <#list staticFields as param>
            <@getterMethod param=param/>
        </#list>
    </#if>

    <#if javaApiMeta?has_content>
        <@deserializeResponse metaInfo=javaApiMeta/>
        <@serializeToJson metaInfo=javaApiMeta/>
    </#if>

    <#-- toString方法 -->
    <#if privateFields?? && (privateFields?size > 0) >
        <@toString className=className params=privateFields/>
    </#if>
</@class>
```

> #### 07 语言转换引擎

**将解析好的API元数据作为输入有了上述的代码语料，执行基于DSL的语言转换引擎，即可生成Java代码。**

语言转换引擎通过执行**<font color='red'>宏命令</font>将要生成的代码类的基本信息在DSL语料模板中进行填充，最终得到Java编程语言的目标类及其附属类的代码**。

以生成Response类代码为例，代码生成的具体执行过程如下图所示：

![](https://github.com/polarisronx/Papi-backend/doc/images/723c582613c49822aeb8f8a6279f7e59636801.png)

Request和Response类中其余的`getter`方法、`setter`方法、类注解等元素的生成原理和步骤均和以上相同，此处不再赘述。在DSL语料模板中所有的元素处理完成后，我们即可得到供Java编程语言使用的请求参数类和返回参数类的完整代码。

对于其他的编程语言（例如Python），我们使用的API元数据和元数据解析逻辑和Java是一致的，不同点在于DSL语料模板和语言转换引擎。当需要对SDK新增一种编程语言的支持时，我们只需要对目标语言建立DSL语料模板并提供相应的转换逻辑，即可支持该语言的请求参数类和返回参数类的代码自动生成。

> #### 08 自动生成API调用示例代码

API调用示例代码可以为开发者呈现出每个请求参数赋值的示例逻辑，可有效降低开发者在对接API时的理解成本。后续我们可以进一步优化DSL语料模板，在示例代码中增加对返回数据结构中各个字段的取值逻辑示范，以进一步降低开发者在处理API返回数据时的理解和开发成本。

通过同样的技术手段，我们还可以自动生成每个OpenAPI的调用示例代码，并将示例代码展示接口文档中供开发者参考。主要操作有：

1. 使用API元数据中的类名和字段信息（元数据中也包含了每个字段的examle值，可用于在代码示例中生成字段赋值的逻辑）填入代码语料中

2. 然后执行语言转换引擎生成目标代码即可。

   Java编程语言为例，用于生成API调用示例代码的**DSL语料模板**如下所示：

   ```xml
   <#setting number_format="computer">
   MeituanClient meituanClient = DefaultMeituanClient.builder(10000L, "xxxxx").build();
   
   <#assign reqVarName = className?uncap_first/>
   ${className} ${reqVarName} = new ${className}();
   
   <#if privateFields?? && (privateFields?size > 0)>
   <#list privateFields as field>
   ${reqVarName}.set${field.fieldName?cap_first}(${field.exampleValue!""});
   </#list>
   </#if>
   
   <#if javaApiMeta.needAuth>
   String appAuthToken = "xxxx";
   MeituanResponse<${javaApiMeta.responseClass}> response = meituanClient.invokeApi(request, appAuthToken);
   <#else >
   MeituanResponse<${javaApiMeta.responseClass}> response = meituanClient.invokeApi(request);
   </#if>
   
   if (response.isSuccess()) {
   <#if javaApiMeta.responseClass == "Void">
       System.out.println("调用成功");
   <#else>
       ${javaApiMeta.responseClass} resp = response.getData();
       System.out.println(resp);
   </#if>
   } else {
       System.out.println("调用失败");
   }
   ```

   在使用API元数据和代码语料模板执行基于DSL的语言转换引擎后，生成的API调用示例代码如下所示：

   ```java
   MeituanClient client = DefaultMeituanClient.builder(developerId, signKey).build();
   //设置请求参数
   OrderQueryByIdRequest request = new OrderQueryByIdRequest();
   request.setOrderId(1000224201796844308L);
   //调用接口
   MeituanResponse<OrderQueryByIdResponse> response = client.invokeApi(req);
   //处理接口返回
   if(response.isSuccess()) {
     OrderQueryByIdResponse orderResponse = response.getData();
     System.out.println(orderResponse);
   } else {
     System.out.println("调用失败");
   }
   ```

> #### 09 持续集成和持续发布

传统由人工编译、测试和上传发布SDK的模式，开发者得到SDK版本更新的周期短则数周，长则数月。我们的目标是将这个周期缩短到分钟级别：**当SDK的基础逻辑和API参数模型有任何变更发生时，通过持续集成和持续发布的能力，在数分钟内将包含此变更的新版本SDK发布给开发者使用**。

![](https://github.com/polarisronx/Papi-backend/doc/images/bf5a87af7adc4bc44249c5f003fba930270816.png)

首先我们监听可能导致SDK需要发布的变更，包括通过Binlog机制监听API元数据的变更，以及通过Git Hook机制监听SDK基础逻辑代码仓库Master分支的变更。一旦监听到有变更产生，通过触发器去触发SDK持续集成和发布流水线的运作。

流水线开始运作后，首先执行SDK构建组件，SDK构建组件会并发执行两个操作：

1. 获取SDK基础逻辑代码（人工编写）并完成静态代码检查；
2. 拉取API元数据并自动生成参数富模型代码。

以上两个操作完成后，执行代码合并和代码编译，将结果提交到流水线执行下一个步骤。接下来由自动化测试组件完成对SDK的单元测试和端到端自动化测试，通过后提交到流水线执行下一个步骤。最后由自动发布组件完成SDK的打包、上传、下载链接生成和版本信息生成等一系列操作，并最终将最新版本SDK发布到官网供开发者下载。

> ### 结语

大厂自有大厂自己的好处，编写SDK的一整套流程几乎不需要人工参与，全自动分钟级的高效完成SDK的发布和变更。







## 拓展1：SDK优化

> #### 记录遇到的问题

1. header请求头不能有换行 \n

2. v3版本构建规范请求

[自研请求体和签名机制_阿里云SDK(Alibaba Cloud SDK)-阿里云帮助中心 (aliyun.com)](https://help.aliyun.com/zh/sdk/product-overview/v3-request-structure-and-signature?spm=a2c4g.11186623.0.0.446746bcU0vmxH#section-mqj-l8f-ak0)

3. 执行对应的方法：在backend中先用通用请求类commonRequest把参数先传进来，根据反射根据action在客户端找到对应的方法，在客户端的方法中new对应的Request，把参数插入，在客户端接收响应时根据由Request的getResponseClass方法得到对应的响应封装类。但是在backend端只能用通用的响应类接收。

   在SDK可以根据接口的不同个性化地选择指定的Request和Response，灵活地设置请求参数和响应参数，而backend端调试依赖于通用的map做为数据的载体。

4. gateway中Post请求获取不到queryParams

5. 在规范请求中 host 放入的是服务终端endpoint，而在后面网关中 host已经被修改为了 网关的地址，可以把endpoint放请求头传过来，但是这样就对外暴露了接口的服务终端，解决办法是根据path和method查数据库找到接口对应的endpoint 。

   ![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240409191959.png)



> #### papi接口上传规范

最后更新日期 2024.05.29

> 接口信息填写

|                 | 描述                                     | 备注             | 示例                 |
| --------------- | ---------------------------------------- | ---------------- | -------------------- |
| 接口名称        | 具有辨识度的帅气名字                     |                  | 随你喜欢             |
| 描述            | 一句话挑明你的来意                       |                  | 言简意赅             |
| 服务终端        | 接口部署所在的服务器终端IP地址+端口号    | ip_address+port  | localhost:1234       |
| 接口路径*       | 接口controller路径                       | /api/*/${action} | /api/a/getYourHeart  |
| 定价            | 接口调用需花费的P钻（按次记）            | number           | 1                    |
| 操作*           | 接口执行的操作                           | action           | getYourHeart         |
| 请求参数*       | 接口请求参数                             | Json格式         | -                    |
| 响应参数*       | 接口响应参数                             | Json格式         | -                    |
| 请求参数封装类* | 包含接口请求所有参数的封装类             |                  | GetYourHeartRequest  |
| 响应参数封装类* | 包含接口响应所有参数的封装类             |                  | GetYourHeartResponse |
| 接口插图        | 接口也需要的漂亮头像                     | url              | https://abc/1.jpg    |
| 接口类型        | 按返回数据分文字类、图片类、文件类和其他 | 默认文字类       | 文字类               |
| 请求参数类型    | 接口请求参数类型                         | contentType      | application/json     |
| 响应参数类型    | 接口响应类型                             | contentType      | application/json     |
| 请求类型        | 请求方法类型                             | Method           | GET                  |

特别说明：

1. 请求参数等需要以Json数据格式填写，参照以下模板：

```json
[
  {
    "type": "int",
    "fieldName": "code",
    "desc": "全局响应状态码"
  },// 对应响应参数请保留该字段
  {
    "type": "int",
    "fieldName": "data.code",
    "desc": "内部响应状态码"
  },// 对应响应参数请保留该字段
  {
    "type": "String",
    "fieldName": "data.roman",
    "required": "true",
    "desc": "罗马数"
  }
]
```

2. 我们推荐为每个接头提供一个专属的请求参数封装类和响应参数封装类，形如

```java
@GetMapping("/romanToInt")
public RomanToIntResponse romanToInt(@RequestParam String roman){
    return new RomanToIntResponse(romanNumeralsService.romanToInt(roman));
}
```

3. 操作字段（action）保持与接口的最后一级路径一致，并与接口请求参数封装类对应，形如

action：`getUsername` ---> path：`/api/a/getUsername` ---> RequestClass：`GetUsernameRequest`

> 接入我们

首先非常感谢你选择我们的平台，与全银河系的小伙伴一起分享你的发现与喜悦。

在上传成功后，我们将在2\~3个工作日内审核你提供的接口，先祝你好运~若遇到问题，请联系我们（QQ907830201，Email：polarisronx@163.com）

以下事项请注意：

1. 在审核完成前，请勿重复提交。
2. 请确保接口部署的服务器IP的填写是正确的，且是公网IP，端口对外开放。可以在个人中心“查看详情”在平台在线调试，或用第三方测试软件先行测试。
3. 平台的所有接口对外开放，一旦提交默认接受平台管理。





## 拓展1+：上传SKD到maven中央仓库

在2024年2月1日，sonatype 终于放弃了原本的maven-central的注册方式，不再支持 [**jira**](https://issues.sonatype.org/) 创建工单处理了

1. 在https://central.sonatype.com/注册账户

polarisronx@163.com Liu907830201@

2. User Token

在头像下拉 View Account

usrname:4KHReXXW

passwoed:nEUthtTz5LomZ/A89xlHN33J9sYNFGmTIQJ89H43bLTp

```xml
<server>
	<id>${server}</id>
	<username>4KHReXXW</username>
	<password>nEUthtTz5LomZ/A89xlHN33J9sYNFGmTIQJ89H43bLTp</password>
</server>
```

![image-20240527201437610](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20240527201437610.png)

3. 添加namespace

这个是对应项目pom.xml中的groupId的，之前都是随便写什么com.atguigu，com.polaris，这个需要验证的，方便起见用github，命名空间就是io.github.polarisronx

4. 配置gpg密钥

需要https//[http://www.gnupg.org/download/](https://link.zhihu.com/?target=http%3A//www.gnupg.org/download/) 下载软件，创建密钥并上传

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240527211109.png)

https//[http://www.gnupg.org/download/](https://link.zhihu.com/?target=http%3A//www.gnupg.org/download/) 这个网站上能查得到就成功

5. 修改maven的配置文件

在D盘的，要填的就是上面的，id随意跟下面的serverId对应即可

```xml
<servers>
    <server>
        <id>central</id>
        <username>..username..</username>
        <password>..password..</password>
    </server>
</servers>
```

6. 修改项目的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.13</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>io.github.polarisronx</groupId>
    <artifactId>papi-client-sdk</artifactId>
    <version>1.0.2</version>
    <name>papi-client-sdk</name>
    <description>papi-client-sdk</description>
    <url>https://github.com/polarisronx/papi-client-sdk.git</url>
    <licenses>
        <license>
            <name>The Apache Software License, Version 2.0</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        </license>
    </licenses>
    <developers>
        <developer>
            <name></name>
            <email></email>
        </developer>
    </developers>
    <scm>
        <connection>scm:git:git://github.com/polarisronx/papi-client-sdk.git</connection>
        <developerConnection>scm:git:ssh://github.com:polarisronx/papi-client-sdk.git</developerConnection>
        <url>http://github.com/polarisronx/papi-client-sdk/tree/master</url>
    </scm>
    <distributionManagement>
        <repository>
            <id>central</id>
            <name>central-releases</name>
            <url>https://s01.oss.sonatype.org/</url>
        </repository>
    </distributionManagement>
    <properties>
        <java.version>8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!--   central发布插件    -->
            <plugin>
                <groupId>org.sonatype.central</groupId>
                <artifactId>central-publishing-maven-plugin</artifactId>
                <version>0.4.0</version>
                <extensions>true</extensions>
                <configuration>
                    <publishingServerId>central</publishingServerId>
                    <tokenAuth>true</tokenAuth>
                </configuration>
            </plugin>
            <!--   source源码插件   官方要求 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-source-plugin</artifactId>
                <version>2.2.1</version>
                <executions>
                    <execution>
                        <id>attach-sources</id>
                        <goals>
                            <goal>jar-no-fork</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <!--   javadoc插件  官方要求  -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>3.6.3</version>
                <configuration>
                    <additionalJOptions>
                        <additionalJOption>-Xdoclint:none</additionalJOption>
                    </additionalJOptions>
                </configuration>
                <executions>
                    <execution>
                        <id>attach-javadocs</id>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-gpg-plugin</artifactId>
                <version>1.5</version>
                <configuration>
                    <!--   没有配置环境变量，可知道GnuPG路径 -->
                    <executable>D:\program files\GnuPG\bin\gpg.exe</executable>
                </configuration>
                <executions>
                    <execution>
                        <id>sign-artifacts</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>sign</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

```

7. 点击插件deploy，然后就可以登录之前的网站publish

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240527211852.png)

参考[2024年2月后如何使用maven central发布自己的jar到中央仓库_central-publishing-maven-plugin-CSDN博客](https://blog.csdn.net/qq_37160346/article/details/136537800)

[如何发布开源组件到Maven中央仓库（新） - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/681731772)

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240710141029.png)

**遇到的问题**

**1. maven 打包错误 Exit code: 1 - javadoc 中文乱码**

解决：idea编辑器：在maven的Runner中增加设置：-DarchetypeCatalog=internal -Dfile.encoding=GBK

参考：[maven打包错误 Exit code: 1 - javadoc_maven打包报错javadoc-CSDN博客](https://blog.csdn.net/u010427387/article/details/120667674)

**2. maven-javadoc-plugin打包错误：未知标记：date**

解决：忽略doc错误

参考：[maven-javadoc-plugin打包错误：未知标记：date_错误: 未知标记: date-CSDN博客](https://blog.csdn.net/qq_30038111/article/details/106279837)

## 拓展2：Redis+JWT 双token登录

> 目标

当前的登录模式：共享Session。利用了spring的共享Session，把Session存在Redis。

用户每次登录，都会把用户信息作为Session的参数放进去，因为spring的集成，每次可以轻松地从请求中拿到Session，再从Session中获取用户信息。

要实现的模式：

注册后，用户登录，在后端验证通过后会生成token（accessToken和RefreshToken）并返回给前端（后端方法返回String）。

前端在后续的请求中会在请求头中添加Token（设为authorization），后端处理请求时会先被拦截器拦截，通过Token获取用户信息，并把信息存在线程域ThreadLocal中，在处理业务时直接从ThreadLocal获取用户。

用户关闭浏览器后，非会话级Cookie不会删除，在有效期内再次进入网站会携带token（后端接收到会把用户信息存在线程域，而前端会首先检查用户登录态initialState去获取用户信息），不需要再次登录。

> 后端

生成token

使用jwt工具包：jose4j (选择参考[各类JWT库(java)的使用与评价 | MONKEYK.博客 (andaily.com)](https://andaily.com/blog/?p=956)，jwt官网：https://jwt.io/)

1.创建token

组成 

- header
  - type
  - algo: RSA_USING_SHA256
- payload
  - Subject: JWT所面向的用户
  - ExpirationTime: 过期时间
  - Issued at: 签发时间
  - NotBeforeMinutesInThePast: 生效时间
  - 自定义String参数：用户相关信息
- signature
  - head+payload+privateKey 加密得到的签名

2.token过期时间设置

参考[双token刷新、续期，access_token和refresh_token实效如何设置-CSDN博客](https://blog.csdn.net/a704397849/article/details/90216739)

aToken 60\*60\*24 1天

rToken 4\*60\*60*24 4天

3.token存储

前端：用户登录后token会被存储在客户端本地的非会话级的Cookie中（借助js-cookie包），后面每次发送请求到后端，在前端拦截器设置了在请求头中添加Key为Authorization的token。

后端：用户登录后生产的token会被存储在Redis，两个token的有效期不同，每次后端发来请求都会被拦截器拦截（MVC提供的拦截器）要求获取请求头中Authorization的token，并与Redis中存储的token进行校验，无效拦截，过期了进行刷新

> 记录遇到的Bug

1. 登录是Post请求，会发一个预请求，预请求不会带自定义请求头，导致一直获取不到authorization的请求头一直被拦截器拦截。

   解决办法：如果是预请求就直接放行

2. 由于登录接口返回token，导致前端在登录后也获取不到用户信息

   解决办法：登录的时候应该同步查询当前登录用户。

3. accessToken过期或者被删除后（但RefreshToken还在），并没有续签，而是直接异常，提醒用户重新登录。

   原因：生成Token的时候claims中有签发时间、过期时间。在校验token是否过期的时候要先解析token内的信息，发现已经过expirationtime不会后台判断就直接抛出异常不会续签了。

   异常：InValidJWTException: The JWT is no longer valid - the evaluation time  " ... " is on or after the Expiration Time;

   解决：token中不再添加过期时间。是否过期由后台根据签发时间iat+ACCESS_TOKEN_EXPIRATION_TIME判断。

   <img src="https://github.com/polarisronx/Papi-backend/doc/images/QQ20240427210107.png" style="zoom: 50%;" /><img src="https://github.com/polarisronx/Papi-backend/doc/images/QQ20240427205743.png" style="zoom:50%;" />

## 拓展3：前端优化

> 01 用户协议，隐私协议

用了ant design的折叠面板组件

遇到问题：不会用组件，熟悉一下以下流程

```tsx
import {Collapse} from 'antd';

const PrivacyAgreement = () => {
    const onCharge = (key) =>{
        ...// 定义要用到的函数
    };
    const text = `...`;// 定义变量
    const {Title,Paragrapg} = Typography;// 定义组件的一些子组件或属性
    return(
    	<div>
        	<Collapse bordered={false}>
            	<Panel>
                	<p>{text}</p>
                </Panel>
            </Collapse>
        </div>
    )  
}
export default PrivacyAgreement;
```

> 02 优化首页

用了一个走马灯。修改了logo。修改了foot信息。

**遇到的问题，**页面没有报错但是一片空白，没有显示。

解决：原因是导错包了，\<link>应该是umi的，但是导成antd的了。



> 03 将后端异常返回给前端

后端的全局异常处理器，会在发生异常时捕捉异常，并把异常信息作为响应返回给前端。

同时前端要在响应拦截器设置

```ts
// 响应拦截器
  responseInterceptors: [
    (response) => {
      // 拦截响应数据，进行个性化处理
      const { data } = response as unknown as ResponseStructure;
      // 打印响应数据用于调试
      console.log('response data:', data);
      const {code} = data;
      // 响应成功，返回响应
      if (data && code === 0) {
        return response;
      } else {
        switch (code) {
          case 40100:
            history.push('/user/login');      
            break;
          default:
            // if (location.pathname.includes("/")) {
            //   break
            // }

            message.error(data.message);
            break;
        }
      }
      return response;
    },
  ],
```

> 04 接口市场页面

优化界面UI 以及增加接口搜索功能

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240428214018.png)

***TODO***：收藏、点赞和评论功能待开发

> 05接口上传功能

采用分页表单组件。

在用户提交前需要输入随机数校验码，防止恶意刷

## 拓展4：Aliyun-OSS 个人设置页&上传头像

头像框点击进入个人页，可以修改用户个人信息。

1. 修改头像
   1. 使用阿里云对象存储服务 Aliyun-OSS，引入SDK，配置客户端，（包括密钥节点等信息）
   2. 上传文件 @RequestPart
   3. 流程：上传文件到阿里云，返回上传结果 UploadResult 类，操作成功把URL取出来给后面更新用。

```java
@Data
public class UploadResult {
    /**
     * 文件唯一标识
     */
    private String uid;
    /**
     * 文件名
     */
    private String name;
    /**
     * 状态
     */
    private String status;
    /**
     * 服务端响应内容，如：'{"status": "success"}'
     */
    private String response;
    /**
     * 图像url
     */
    private String url; //aliyunOssConfig.getPrefix() + newFileName
}
```

文件名命名规则：

```java
"papi/" +new DateTime().toString("yyyy/MM/dd")+ "/user-" + userId + RandomUtil.randomInt(100, 9999) + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
```

2. 修改用户信息

   1. 首先要复现用户原有的信息

      ```tsx
      // 使用 React 的 useRef 创建一个引用以访问 ProTable 中的表单实例
      const proTableRef = useRef<ProFormInstance>();
      // 防止修改的表单内容在初次初始化后就不在变化，要监听Values的变化
      // 用React的useEffect在值发生改变时能更新表单的值
      useEffect(() => {
          if(proTableRef){
              proTableRef.current?.setFieldsValue(currentUser);
          }
      },[currentUser]);
      ```

   2. 获取到表单内用户填的信息 + 上传的头像返回的URL => 更新用户信息。

      不强制每条内容必填，未填的内容作置空处理而不会保留已有内容，而且有提示，这样更灵活一些。

**遇到的问题：**一开始的想法是上传头像和修改信息一个接口，@RequestBody和@RequestPart联合使用。但一想不太现实，头像要先上传到云端，前端能显示头像，然后再把头像的url给后端修改。

**遇到的问题：**图片成功上传到云端但前端无法显示，提交修改也没有改头像。

原因：至少头像上传接口是对的，但是修改信息的接口包括前端都没有收到头像的URL。头像url设置根据前后端以及云端的约定。

```java
private String getFilePath(String sourceFileName) {
    Long userId = UserHolder.getUser().getId();
    return "papi/" +new DateTime().toString("yyyy/MM/dd")+ "/user-" + userId + RandomUtil.randomInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
}

String newFileName = getFilePath(fileName);
fileUploadDto.setUrl(aliyunOssConfig.getPrefix() + newFileName);
```

**遇到的问题：**打开信息设置的页面时，用户原有的头像不显示。

原因：原先想的是写一个方法来loadData，加载用户数据到前端页面。但是这个方法不会随时执行随时更新

解决办法：应该用系统用户登录状态initialState来设置信息而不是寄希望于老是执行方法来获取。

```java
const { initialState, setInitialState } = useModel('@@initialState');
const {loginUser} = initialState || {};
updatedFileList[0] = {
          // @ts-ignore
          uid: loginUser?.userAccount,
          // @ts-ignore
          name: loginUser?.userAvatar?.substring(loginUser?.userAvatar!.lastIndexOf('-') + 1),
          status: "done",
          percent: 100,
          url: loginUser?.userAvatar
        }
```

拓展5：个人中心页&&接口上传

个人中心页有个人信息、个人开发密钥、用户个人上传的接口信息，查看上传的接口状态（审核通过）

接口上传页：

采用分步表单，需要用户输入随机的验证码后确认提交，防止恶意灌水。

优化：管理页审核接口上线

**遇到的问题：把接口的ID由auto的自增改为assigned后，无法上下线操作了。**

**原因**：接口的ID错误。表单内的数据显示ID的类型valueType是index默认是1开始的自增，用这个ID查不到。

valueType改为text后还是报错。原因是assigned生成的ID是由雪花算法生成的19位，在后端用long存储没有问题，但是在前端 JS 默认是整型 number，位数超过了16位的存储范围，数据存储不准确了，所以查不到。

**解决办法**：自己实现了雪花算法，替代了Mybatis里默认的生成算法（implements IdentifierGenerator实现就可以了）。由于JS中的number类型最大精度二进制表示是 2^53，所以生成的全局ID也是53位，分配为 39位时间戳+4位工作机器ID+10位序列号，时间起始标记点作为基准，取2024-01-01 00:00:00（一旦确定不能变动），系统最大可用时限：2041-06-02 21:56:53，每毫秒可产生1024个序列号。这样就不会丢失精度了（下图新的ID15位，是精确的，原ID19位，最后2位都为0）

参考：[雪花算法原理以及JS精度丢失问题-阿里云开发者社区 (aliyun.com)](https://developer.aliyun.com/article/1166385)

<img src="https://github.com/polarisronx/Papi-backend/doc/images/QQ20240504172003.png" style="zoom:80%;" /><img src="https://github.com/polarisronx/Papi-backend/doc/images/QQ20240504172033.png" style="zoom:67%;" />

## 拓展5：Nacos 配置中心

bootstrap 是应用程序的父上下文，也就是说 bootstrap 加载优先于 applicaton。

- boostrap 由父 ApplicationContext 加载，比 applicaton 优先加载
- boostrap 里面的属性不能被覆盖
- 在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；

应用启动时会优先加载bootstrap，bootstrap会从外部配置中心获取配置信息。这里在nacos配置了邮箱、阿里云对象存储的配置（涉及密钥、授权码等）

**遇到的问题：bootstrap不会被识别**

**解决办法：**

```xml
<!--需要引入该jar才能使bootstrap配置文件生效-->
<!--新版的SpringCloud默认没有安装bootstrap依赖，因此不能读取项目bootstrap.yml文件内容-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

**遇到的问题：匹配不到nacos上的配置信息**

原因：配置文件的配置有问题，仔细比对各项配置

```yaml
spring:
  cloud:
    nacos:
      config:
        server-addr: ${host.nacos}
        namespace: b765d215-8484-45ec-a86f-07048c01dd47
        group: ${spring.profiles.active}
        file-extension: yaml
        extension-configs:  # 变化的地方
          - data-id: papi-main-dev.yaml
            group: dev
            refresh: true
```

**遇到的问题：Dubbo注册失败**

Param check invalid:Param 'group' is illegal, illegal characters should not appear in the param.

**原因：不支持设置分组，所以新建一个dubbo的命名空间作隔离**

```yml
dubbo:
  application:
    name: papi-main
  # 设置dubbo的协议为dubbo，随机分配端口
  protocol:
    name: dubbo
    port: 22221
  registry:
    # 配置注册中心为 nacos，使用的地址是 nacos://127.0.0.1:8848
    id: nacos-registry
    address: nacos://${host.nacos}
    parameters:
      # 注意 这里要在 nacos 创建名为 dubbo 的 namespace 环境
      namespace: 742651c4-5b7c-45e8-91ce-a1d2ba31cf02
#      group: ${spring.profiles.active} Param 'group' is illegal
```

## 扩展：多环境配置与部署上线

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240424215901.png)

```ya
spring:
  application:
    name: papi-main
  profiles:
    active: dev
```

参考 AliyunECS.md 由于设计账密信息，不公开。

## 拓展6：SMTP 邮箱登录和邮箱注册

> 登录页和注册页

1. 增加了注册页，

**遇到的问题：**路由配置错误

解决：这个不难，要细心。

**遇到的问题：**没登录的话访问任何页面都会直接跳转到登录页

在app.ts，

```ts
onPageChange: () => {
    const { location } = history;
    if (LOGIN_WHITE_LIST.includes(location.pathname)){
        return; // 如果出现在白名单中，则不重定向
    }
    // 如果没有登录，重定向到 login
    if (!initialState?.loginUser) {
        history.push(loginPath);
    }
},
```

还有，这个initialState是和umi系统管理的，不要随便改，这里踩了很久坑

包括不限于Unhandled Rejection (Error): register failed, invalid key getInitialState from plugin 看.umi文件中，没有plugin-initialState

```java
export async function getInitialState(): Promise<InitialState> {
  // 当页面首次加载时，获取要全局保存的数据，比如用户登录信息
  const state: InitialState = {
    // 初始化用户登录的状态，初始值设为 undefined
    loginUser: undefined,
    settings: Settings,
  }
  if (LOGIN_WHITE_LIST.includes(history.location.pathname)) {
    return state;
  }

  try {
    // 调用 getLoginUserUsingGET() 方法，尝试获取当前已经登录的用户信息
    const res = await getLoginUserUsingGet();
    // 如果从后端获取的数据不为空，则把获取到的用户数据赋给state.loginUser
    if (res.data) {
      state.loginUser = res.data;
    }
  // 如果在获取用户信息的过程中发生了错误，就把页面重定向到登录页面
  } catch (error) {
    history.push(loginPath);
  }
  // 返回修改后的状态
    return state;
  };
```

遇到的问题：接口被拦截

后端的拦截器要设置不拦截登录、下线、注册这些请求。

> 实现邮箱注册和登录

流程参考：图片来源[Springboot----实现邮箱验证码登录(代码部分)_springboot实现邮箱验证码登入-CSDN博客](https://blog.csdn.net/weixin_45750572/article/details/125467669)

![](https://github.com/polarisronx/Papi-backend/doc/images/c62d13dcf1654c20a31a4e2a9c86b2d6.png)

**遇到的问题：knife4j 无法访问。**

原因1：没加前缀/api

原因2：拦截器拦截

原因3：没开放资源：在mvcConfig[knif4j 访问不了_knife4j-springdoc-ui 使用不起作用-CSDN博客](https://blog.csdn.net/lu1171901273/article/details/118227078)

```java
@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 启动成功，访问报js找不到的问题  引入下面的配置
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }
```

原因5：配置冲突或覆盖，在config文件写了配置，在yml里也写了

在yml里配就可以了，

```java
# springdoc-openapi项目配置
springdoc:
  swagger-ui:
    path: /swagger-ui.html
    tags-sorter: alpha
    operations-sorter: alpha
  api-docs:
    path: /v3/api-docs
  group-configs:
    - group: default
      paths-to-match: '/**'
      packages-to-scan: com.polaris.project.controller
knife4j:
  enable: true
  setting:
    language: zh_cn
```

原因6：一些版本的原因：会报No OpenAPI resource found for group: swagger-config错误

[No OpenAPI resource found for group: swagger-config | Knife4j (xiaominfo.com)](https://doc.xiaominfo.com/docs/faq/v4/knife4j-no-openapi)

```java
<!--再添加一个jar-->
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <!--保持版本与Knife4j v4.0的版本一致，避免jar包冲突，因为Knife4j-v4.0.0版本依赖的springdoc版本是1.6.9 -->
  <version>1.6.9</version>
</dependency>
```

还需要加一个jar包

**遇到的问题：邮箱服务配置**

原因1：同5，在yml和config都写了配置，但有冲突或都没写全。

原因2：连接主机失败：改为ssl连接，协议smtps，端口465，还有host是smtp.qq.com不是本机localhost

```yml
  # 邮箱登录配置
  mail:
    #smtp服务主机  qq邮箱则为smtp.qq.com
    host: smtp.qq.com
    port: 465
    #服务协议
    protocol: smtps
    # 编码集
    default-encoding: UTF-8
    #发送邮件的账户
    username: 907830201@qq.com
    #授权码
    password: kiuppzxdnxelbdbg
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true
          ssl:
            enable: true
          socketFactory:
            port: 465
            class: javax.net.ssl.SSLSocketFactory
```

[Got bad greeting from SMTP host: smtp.163.com, port: 465, response: [EOF\] - 楼兰胡杨 - 博客园 (cnblogs.com)](https://www.cnblogs.com/east7/p/13406120.html)

[使用SpringBoot + JavaMailSender 发送邮件报错 Mail server connection failed；Could not connect to SMTP host_org.springframework.mail.mailsendexception: mail s-CSDN博客](https://blog.csdn.net/qq_39128430/article/details/133099368)

**有一个Bug**，就是注册和登录用的同一个邮箱验证码，然后原先是设计邮箱验证码过期前用户不能再次获取验证码，用户注册完要用之前的验证码，但一般的习惯都是再获取一个。

Redis的set可以覆盖已有的值。所以不需要限制过期前不能再次获取。

**遇到的问题：一个天坑！**在退出登录的时候，前端要消除登录态并且清除Cookie，但是用js-cookie的时候死活说没有remove属性

Unhandled Rejection (TypeError): Cannot read property of undefined (reading remove)

**解决：**把remove封装到一个方法里，没有直接使用就行了，应该是前端自己的问题。

```ts
export const delCookie = (label:string) => {
  Cookies.remove(label)
}

delCookie('token');
```

## 拓展7：BITMAP 用户签到和积分奖励

新增字段：用户积分

> BITMAP 用户签到功能

由于签到与积分奖励直接挂钩，防止用户恶意刷取，设置了基于redisson的分布式锁。

基于Redis的BITMAP位图来实现用户签到。

用户签到检测，如果未签到返回-1，如果已经签到统计用户的签到天数。

## 拓展8：Cafferine&Redis 二级缓存

1. 本地缓存

使用caffeine缓存框架，使用Spring的集成CacheManager。

```java
@Configuration
public class CacheManagerConfig {
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager=new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(128)
                .maximumSize(1024)
                .expireAfterWrite(60, TimeUnit.SECONDS));
        return cacheManager;
    }
}
```



2. Redis分布式缓存

用户信息经常需要用到，每次都查数据库性能太差。

根据id查询用户时，如果缓存未命中，则查询数据库，将数据库结果写入缓存，并设置超时时间。

根据id修改用户时，先修改数据库，再删除缓存。（更新动作实际上只有最后一次生效，中间的更新动作意义并不大）

根据id查询用户时，如果查不到用户信息，为防止缓存穿透，将空值插入到Redis。

用户查询缓存

```java
/**
* 获取当前登录用户
*
*/
@Override
public UserVO getLoginUser() {
    //从线程域取出用户信息
    UserDTO user = UserHolder.getUser();
    throwIf(user == null, ErrorCode.NOT_LOGIN_ERROR);
    // 查询缓存(考虑缓存穿透）
    User userEntity = cacheClient.queryWithPassThrough(CACHE_LOGIN_USER, user.getId(), User.class, this::getUserById, CACHE_LOGIN_USER_TTL, TimeUnit.MINUTES);
    throwIf(userEntity == null, ErrorCode.OPERATION_ERROR, "用户不存在");
    return BeanUtil.copyProperties(userEntity, UserVO.class);
}
```

根据id插用户的方法使用本地缓存

```java
@Cacheable(value = "user", key = "'userId:'+#userId")
@Override
public User getUserById (Long userId){
    return getById(userId);
}
```

拓展：黑名单限流



## 拓展9：Vuepress搭建api-doc

1. 安装了nvm可管理Node版本

```powershell
nvm list available
nvm install version   //请把version换成版本号，别直接复制
nvm install lts       //不想输版本号，安装最新长期支持版
nvm use version       //切换版本，请把version换成版本号，别直接复制
nvm uninstall version  //卸载指定版本node，请不要在当前node版本执行
```

2. 配置了yarn的环境变量

   之前没有配置环境变量，不知道是怎么过来的。yarn是装在nodejs路径下的

   [yarn 不是内部或外部命令,也不是可运行的程序（亲测可用）_yarn不是内部或外部命令,也不是可运行的程序-CSDN博客](https://blog.csdn.net/qq_16946803/article/details/108416526)

3. 用更优雅的vuepress模板vuepress-thrmr-reco

   参考一下这个人搭建博客的，也是用的这个框架

[个人博客搭建遇坑流程のVuePress2 📕 - 掘金 (juejin.cn)](https://juejin.cn/post/7140934570370662407)





[Vuepress 2从0-1保姆级入门教程——文档配置篇_vuepress2-CSDN博客](https://blog.csdn.net/passwordgloo/article/details/129114625)



## 拓展10：Django-LSTM-Feign-Nacos预测接口

> ### 概况

- python是深度学习算法更适合的运行环境，LSTM长短时记忆神经网络模型接口采用python前后端开发框架Django开发。

  - 项目名service-django

  - 项目部署地址：localhost:8000

  - 接口路径：/user/lstm_predict

  - 请求方法：POST

  - 请求参数：

    - 数据文件：

      - 请求参数名：`excelData`或`csvData`

      - 请求方法是 `POST`，并且发布请求的 `<form>` 有 `enctype="multipart/form-data"` 的情况下，才会包含数据

        参考[请求和响应对象 | Django 文档 | Django (djangoproject.com)](https://docs.djangoproject.com/zh-hans/3.2/ref/request-response/)

      - 目前支持的文件格式为csv、xlsx

      - 大小不超过3M

      - 数据要求：目前仅支持单步单特征预测，数据形如

    ```bash
    time	target
    2024.01  0.1
    2024.02  0.2
    2024.03  0.3
    ```

    - 时间步time-step
      - 数据类型：整型（int)
      - 推荐值（默认值）：12
    - 训练测试比ratio
      - 数据类型：浮点型（float)
      - 推荐值（默认值）：0.8
    - 轮次epoch
      - 数据类型：整型（int)
      - 推荐值（默认值）：100
    - 批次量batchSize
      - 数据类型：整型（int)
      - 推荐值（默认值）：32

  - 返回结果：测试集的测试结果（matplotlib绘制的图形）

    - 数据编码格式：base64

      参考[Django + Matplotlib：实现数据分析显示与下载为PDF或SVG_matplotlib django-CSDN博客](https://blog.csdn.net/weixin_41861301/article/details/134854798)

- 利用nacos作为统一的服务注册和发现中心，django-project项目作为服务提供者入驻nacos

- springboot项目使用openFeign调用django-project项目的接口

  - 接口路径：/api/v2/dl/lstm

- lstm算法参考：[【Python时序预测系列】基于LSTM实现单变量时间序列预测（源码）_单变量时间序列预测 lstm-CSDN博客](https://blog.csdn.net/sinat_41858359/article/details/135904507)

> ### 遇到的问题

> 1 响应数据格式

本来是想在python端也统一定义一个BaseResponse来作为返回数据类型的，但是python中不如Java中方便（可能是我孤陋寡闻）用户自定义类是不能序列化的，这样不能用于数据传输。所以还是用的 JsonResponse。

如果返回一个User的实例，这时是一个对象，直接返回会报无法序列化的错，采用Django的model_to_dict将数据转换为字典类型。***AttributeError: ‘User‘ object has no attribute ‘get‘***

```python
json_user = model_to_dict(new_user)
```

记录一下其他的序列化方法

```python
'''
    查询所有的用户对象
'''
    queryset = models.User.objects.all()
# 方法一
    data = []
    # 在model中手动写一个方法能返回对象的用字典形式表达
    # 这个方法的缺点就是：
    # 如果字段多了的话，就需要一个一个去写，会很麻烦
    # 返回的是字典类型，所以需要json转换成json格式字符串
    for i in queryset:
        p_tmp = {
            "name": i.name,
            "address": i.address
        }
        data.append(p_tmp)

    import json
    return HttpResponse(json.dumps(data), content_type='application/json')
# 方法二
    data = []
    # django自带的模型转字典方法
    # 缺点就是图片之类的文件无法转换
    # 返回的是字典类型，所以需要json转换成json格式字符串
    from django.forms.models import model_to_dict
    for i in queryset:
        data.append(model_to_dict(i))
    import json
    return HttpResponse(json.dumps(data), content_type='application/json')
# 方法三
    # 导入django自带的序列化器
    from django.core import serializers
    data = serializers.serialize('json', queryset)
    return HttpResponse(data, content_type='application/json')
```

参考 [Django:序列化的几种方法 - 秋寻草 - 博客园 (cnblogs.com)](https://www.cnblogs.com/gcgc/p/11320636.html)

> 2 请求数据格式

请求数据是用application/json的格式发送的，用request.POST.get(）获取不到数据

[django框架request.POST.get(）获取不到数据_django request.post.get 拿不到数据-CSDN博客](https://blog.csdn.net/ezreal_tao/article/details/103266508)

> 3 Java端接受响应数据

python端影响的数据是JSON类型，不能用对象来接收，所以用了一个hashmap集合来接收

```java
@PostMapping ("user/register")
HashMap<String,Object> userRegister(@RequestBody RegisterRequest registerRequest);
```

> 4 Feign的踩坑

***1 No Feign Client for loadBalancing defined. Did you forget to include spring-cloud-starter-loadbalancer?***

由于SpringCloud Feign高版本不使用Ribbon而是使用spring-cloud-loadbalancer，所以需要引用spring-cloud-loadbalancer或者降版本

```xml
<!--使用Spring Cloud LoadBalancer 进行客户端负载均衡-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-loadbalancer</artifactId>
</dependency>
```

***2 SpringCloud Feign报错：Method has too many Body parameters***

[Method has too many Body parameters的处理办法-CSDN博客](https://blog.csdn.net/haishiyizhenfeng/article/details/80607003)

feign传参必须加注解！

***3 resolved [org.springframework.web.httpmediatypenotsupportedexception:content type 'application/x-www-form-urlencoded;charset=utf-8' not supported]***

数据格式不支持，可能是application/json 此类数据格式不一致，也可能是参数名写错。

***4 Caused by: java.lang.IllegalStateException: Body parameters cannot be used with form parameters.***

```java
@PostMapping("/user/lstm_predict")
    HashMap<String,Object> lstmPredictExcel(@RequestBody LstmPredictRequest lstmPredictRequest,@RequestPart(value = "file") MultipartFile excelData);
```

方法的参数顺序颠倒就会报错。

***5 Content type ‘multipart/form-data；boundary=；charset=UTF-8‘ not supported***

multipart/form-data是键值对的形式传递的，用@RequestBody应该用Json的raw传参。

去掉@RequestBody，springMVC会自动将键值属性组装到LstmPredictRequest

***6 2024-06-13 09:29:23.729 ERROR 19388 --- [nio-8123-exec-2] o.a.c.c.C.[.[.[.[dispatcherServlet]      : Servlet.service() for servlet [dispatcherServlet] in context with path [/api] threw exception [Request processing failed; nested exception is feign.codec.EncodeException: Error converting request body] with root cause***

***com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class java.io.FileDescriptor and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.LinkedHashMap["file"]->org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile["inputStream"]->java.io.FileInputStream["fd"])***

序列化时出错。feign不支持文件传输的原因是在对Form参数进行编码时，没有默认的HttpMessageConverters对Form格式的参数进行编码转换，需要自己注入配置。

参考[基于Feign的微服务文件与复杂参数传输_@feignclient 传递文件和多个参数-CSDN博客](https://blog.csdn.net/m_sophia/article/details/118940609)

```java
@Configuration
public class MultipartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
    /**
     * override a new FormEncoder to match complex param
     * param include properties and MultipartFile
     * @return
     */
    @Bean
    Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
}
```

***7 Load balancer does not contain an instance for the service service-django***

python项目相对特殊，如何负载均衡策略不太了解。这里是单实例，不去细究。指定服务的URL

```java
@FeignClient(value = "service-django",url = "http://127.0.0.1:8000/")
```

***8 Feign Timeout***

模型训练耗时很长，设置feign客户端的超时时间

```yaml
feign:
  client:
    config:
      default:
        connectTimeout: 600000 # 设置 Feign 客户端的连接超时时间（单位为毫秒）
        readTimeout: 600000    # 设置 Feign 客户端的读取超时时间（单位为毫秒）
```

> 5 feign、nacos、springboot版本匹配

比较推荐的方法是用dependencyManagement指定springboot、cloud和cloud alibaba的大版本，然后下面不用自己指定feign这些组件的版本，不然会非常麻烦。

> 6 python项目注册到nacos

用了一个GitHub上的网友的组件python-nacos-client

> 7 Django报错

django中遇到错误：***1 Forbidden CSRF cookie not set***

这个是防止CSRF攻击的检查，简单解决：关闭

注释掉`django.middleware.csrf.CsrfViewMiddleware`

[django中遇到错误：Forbidden CSRF cookie not set-天翼云 (ctyun.cn)](https://www.ctyun.cn/zhishi/p-376156)

***UnicodeDecodeError: 'utf-8' codec can't decode byte 0x87 in position 207: invalid start byte***

原因：django框架我不太熟悉，只能是debug。发现报错的时

```python
json.loads(request.body)
```

发现Body里放的是文件，文件不是utf-8自然不能编码。而且发现request.GET和request.GET里都没有参数（此时java端的请求结构如下，LstmPredictRequest因为之前的报错去掉了@RequestBody）

```java
@PostMapping(value = "/user/lstm_predict", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    HashMap<String,Object> lstmPredictExcel(LstmPredictRequest lstmPredictRequest, @RequestPart(value = "file") MultipartFile excelData);
```

解决：发现给lstmPredictRequest加@RequestParam注解在python的django端能在request.GET里获取。但此时是对象，传到django就变字符串了，应该转为Json串传输。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240613120433.png)

```java
//controller
@PostMapping("/lstm")
public LstmPredictResponse lstmPredict(@RequestPart(value = "file") MultipartFile multipartFile,LstmPredictRequest lstmPredictRequest){
    HashMap<String, Object> map =StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), FileType.EXCEL.value)?
        lstmPredictor.lstmPredictExcel(JSONUtil.toJsonStr(lstmPredictRequest), multipartFile)
        : lstmPredictor.lstmPredictCsv(JSONUtil.toJsonStr(lstmPredictRequest),multipartFile);
    return new LstmPredictResponse((String)map.get("predictResult"));
}
//service
@PostMapping(value = "/user/lstm_predict", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    HashMap<String,Object> lstmPredictExcel(@RequestParam String lstmPredictRequest, @RequestPart(value = "file") MultipartFile excelData);
```

方法不讲究高明，能用就好。

> ### 实测

前端还未完善，现使用Postman测试，向springboot项目发起请求，能得到Django项目的返回结果。

![ ](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240613160611.png)

> ### 前端完善，实际部署

这部分花了很长时间，调Bug调到怀疑人生。

简单总结遇到的问题

1. 原先的sdk不支持带有文件的接口

修改后端

- 接收参数

这里有一个非常困扰的问题，就是文件和请求参数如果都放在请求体中，就不能用原先的`@RequestBody`注解（获取Json等文本形式传递的数据）来获取了，一开始非常想当然，接收文件需要用`@RequestPart`,就用了

```java
public BaseResponse<Object> invokeInterfaceInfo(@RequestPart(value="file",required=false)MultipartFile file,@RequestBody InvokeRequest invokeRequest){
    }
```

但这显然不行，许用统一用application/form-data的形式接收，@RequestPart和@RequestParam都可以用于获取键值类型的数据。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240619164036.png)

- 校验文件格式

现在先只支持两种类型的数据

```java
String suffix = null;
String originalFilename = null;
if (file != null) {
    // 校验文件
    long size = file.getSize();
    originalFilename = file.getOriginalFilename();
    // 校验文件大小
    final long ONE_MB = 1024 * 1024L;
    ThrowUtils.throwIf(size > ONE_MB, ErrorCode.PARAMS_ERROR, "文件超过 3M");
    // 校验文件后缀
    suffix = FileUtil.getSuffix(originalFilename);
    final List<String> validFileSuffixList = Arrays.asList("xlsx", "csv");
    ThrowUtils.throwIf(!validFileSuffixList.contains(suffix), ErrorCode.PARAMS_ERROR, "目前仅支持xlsx和csv文件");
}
```

- Request携带文件

（这里的Request是接口的请求参数封装类，在接口调用、SDK等环境中需要使用，不同的接口封装有不同Request类，也有方便系统执行用的通用CommonRequest）这里为了适配携带文件的信息，在AbstractRequest中添加了存储文件和文件名对应关系的字段。

```java
public abstract class AbstractRequest<T extends CommonResponse> {
    public Map<String,String> header = new HashMap<>();
    public Map<String, Object> customizedParams = new HashMap<>();
    public Map<String,MultipartFile> files = new HashMap<>();
    public String info;// 用于必要时传递一些参数
    private boolean skipSign = false;
    private boolean isUnsignedPayload;
    public String method; // 全大写
    public String path;
```

- papiClient调用

单个接口调用可以直接使用对应的Request封装类，而对于系统需要用通用的CommonRequest

```java
// CommonRequest 需要做一些数据转换
public LstmPredictResponse lstmPredict(CommonRequest commonRequest) throws PapiClientSDKException, IOException{
    LstmPredictRequest lstmPredictRequest = new LstmPredictRequest(commonRequest.getMethod(), commonRequest.getPath(), commonRequest.getCustomizedParams());
    lstmPredictRequest.setCustomField(commonRequest.getCustomizedParams());
    lstmPredictRequest.setInfo(commonRequest.getInfo());
    lstmPredictRequest.setFiles(commonRequest.files);
    lstmPredictRequest.setFile(commonRequest.files.get(commonRequest.getInfo()).getBytes());
    return call(lstmPredictRequest,"lstmPredict");
}
// 直接用对应的Request更快速！
public LstmPredictResponse lstmPredict(LstmPredictRequest lstmPredictRequest) throws PapiClientSDKException{
    return call(lstmPredictRequest,"lstmPredict");
}
```

- SDK中发起http请求针对不同类型的调整

这里又有一个非常迷惑的地方，就是原先是用了hutool的httpRequest，代码没有保存，类似于

```java
//链式构建请求
String result2 = HttpRequest.post(url)
	.header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
	.form(paramMap)//表单内容
	.timeout(20000)//超时，毫秒
	.execute().body();
Console.log(result2);
```

把文件或请求参数放在form()中，但很奇怪接收数据的项目那边死活拿不到文件，不管是用@RequestPart还是@RequestParam。最后改用了OKHttp框架，这个框架使用起来没有hutool方便，但是比较灵活，和http请求的一些utils也比较齐全。

```java
switch (requestMethod) {
    // 对于get请求，请求参数直接加在URL后面
    case "GET": {
        httpRequest = new Request.Builder().url(url + "?" + canonicalQueryString).headers(header).get().build();
        httpResponse = this.httpConnection.doRequest(httpRequest);
        break;
    }
    case "POST": {
        // 对于有文件的请求，用multipart/form-data格式
        if(!request.files.isEmpty()){
            MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(actionName + "Request",AbstractRequest.toJsonString(request))
                .addFormDataPart(FileUtil.getSuffix(request.info), request.getInfo(), RequestBody.create(request.getMultipartRequestParams().get(request.getInfo())))
                .build();
            httpRequest = new Request.Builder().url(url).headers(header).post(body).build();
        }else {
            // 对于没有文件的请求，将参数放在请求体中，用application/json格式
            httpRequest = new Request.Builder().url(url).headers(header).post(RequestBody.create(requestPayload)).build();
        }
        httpResponse = this.httpConnection.doRequest(httpRequest);
        break;
    }
    default: {
        throw new PapiClientSDKException("不支持该请求",ErrorCode.OPERATION_ERROR);
    }
}
```

- 对于预测业务的接口

nacos作为注册中心，用openfeign调用python语言的Django项目的接口。这里的接收文件用的注解@RequestParam也是花了好一番劲试错才调通的。

```java
@Resource
private LstmPredictor lstmPredictor;
@PostMapping("/lstm")
public LstmPredictResponse lstmPredict(@RequestParam(value = "xlsx",required = false) MultipartFile xlsxFile,
                                       @RequestParam(value = "csv",required = false) MultipartFile csvFile,
                                       @RequestParam(required = false) String lstmPredictRequest,HttpServletRequest request){
    throwIf(xlsxFile==null&&csvFile==null, ErrorCode.PARAMS_ERROR,"文件不能为空");
    HashMap<String, Object> map = xlsxFile != null ? lstmPredictor.lstmPredictExcel(lstmPredictRequest, xlsxFile)
        : lstmPredictor.lstmPredictCsv(lstmPredictRequest, csvFile);
    return new LstmPredictResponse((String)map.get("data"));
}
```

一些剪影

@RequestParam

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240618093311.png)

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240618094520.png)

```java
case "POST": {
    if(request.files!=null&&!request.files.isEmpty()){
        httpRequest = HttpRequest.post(url+ "?" + actionName + "Request=" + AbstractRequest.toJsonString(request));
        for(Map.Entry<String,MultipartFile> entry:request.files.entrySet()){
            httpRequest.form(entry.getKey(),entry.getValue());
        }
    }else {
        httpRequest = HttpRequest.post(url);
        httpRequest = httpRequest.body(requestPayload);
    }
    break;
}
```

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240618105514.png)

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240618095630.png)

2. python Django项目获取参数

- python项目的获取请求参数和文件

```python
try:    
    data_json = json.loads(request.GET.get('lstmPredictRequest'))
    timeStep = int(data_json.get('timeStep'))
    ratio = float(data_json.get('ratio'))
    epoch = int(data_json.get('epoch'))
    batchSize = int(data_json.get('batchSize'))
    raw_data = pd.read_csv(request.FILES.get('csv'))
    if not raw_data:
        raw_data = pd.read_excel(request.FILES.get('xlsx'))
    if not raw_data:
        return JsonResponse({'code': 1002, 'message': '数据为空', 'data': None})
    img_base64 = lstm(raw_data, timeStep, ratio, epoch, batchSize)
    return JsonResponse({'code': 0, 'message': '调用成功', 'data': img_base64})
except Exception:
    logger.error(traceback.format_exc())
    return JsonResponse({'code': 1001, 'message': '请求失败', 'data': None})
```

- python返回的结果

关于这个我是想简单处理的，LSTM预测的结果一般都用matplotlib画图，而且我不想把文件在本地保存下来，就直接把图片转为流，再转为base64编码格式的字符串，这样在前端直接复现这个图像。

```python
# 将图表保存到BytesIO对象中，而不是磁盘
    img_buffer = io.BytesIO()
    plt.savefig(img_buffer, format='png', bbox_inches='tight')
    plt.close()  # 关闭图表以释放资源
    # 将BytesIO对象的位置重置为开始，以便从头读取
    img_buffer.seek(0)
    # 将图表数据转换为Base64编码
    img_base64 = base64.b64encode(img_buffer.getvalue()).decode('utf-8')
    img_base64 = 'data:image/png;base64,' + img_base64
    print(img_base64)
```

比如说，这是最终的结果：

<img src="https://github.com/polarisronx/Papi-backend/doc/images/QQ20240619190811.png" style="zoom:67%;" />

<img src="https://github.com/polarisronx/Papi-backend/doc/images/QQ20240619190904.png" style="zoom:67%;" />

实际上没有这么这么顺利，不知道为什么base64.b64encode得到的base64字符串长度比我把文件保存下来用第三方工具转换的要短，实际在前端的时候也不是这个样子，只有一个空白的图片。这个找了很久都没看出来哪里的问题，先不细究了。后面如果优化的话，可以把预测数据传回来再在前端用echarts等可视化工具框架复现这个图表，会更优雅一些。

3. 前端以form-data格式发送带有文件和请求参数的数据

前端其实是没那么熟悉的，而且接口大多都是application/json和openapi自动生成request用惯了，不会组装这个有文件和请求参数的数据，花了不少时间

```typescript
/** 此处后端没有提供注释 POST /interfaceInfo/invoke */
export async function invokeInterfaceInfo(
  
  params: API.InterfaceInvokeRequest,
  body: {},
  file?: File,
  options?: { [key: string]: any },
) {
  const formData = new FormData();
  const invokeRequest = JSON.stringify(params)

  if (file) {
    formData.append('file', file);
  }
  formData.append('invokeRequest', invokeRequest);
  return request<API.BaseResponseObject>('/interfaceInfo/invoke', {
    method: 'POST',
    data: formData,
    requestType: 'form',
    ...(options || {}),
  });
}
```

## 拓展11：Gateway自定义负载均衡策略

spring gateway的默认负载均衡策略是轮询，在开发和一般环境已经足够，但是为了提高系统在更高并发下的稳定性，应该根据实例实际的负载情况选择，使相对空闲或处理速度更快的实例承担更多的任务。

> 要点1：服务实例的繁忙程度指标

衡量指标：

1. cpu使用率
2. 内存使用率
3. 磁盘IO使用率
4. 网络带宽使用率

对上诉4个指标加权平均，取综合值来衡量实例的繁忙程度。

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240630161135.png)

每个实例都开放性能监测接口

```java
@RestController
@RequestMapping("/metrics")
public class InstanceMetricsController {
    @Value("${spring.profiles.active}")
    private String profile;
    @GetMapping("/")
    public InstanceMetricsRep getInstanceMetrics(){
        return BeanUtil.copyProperties(new ServerMetrics(profile), InstanceMetricsRep.class);
    }
}
```

> 要点2：监测任务执行:

1. 在网关项目由异步定时任务完成。
2. 微服务注册中心采用nacos，在注册中心上找到所有提供接口服务的instances，并逐一对其的性能情况进行监测。
3. 将结果存储在Redis中，在调用时直接从缓存取。
4. 利用@scheduled注解和scheduledTaskExecutor线程实现定时异步任务，每10秒刷新一次。

[使用@Schedule注解实现定时任务，多线程执行定时任务，Cron表达式详解_定时任务注解-CSDN博客](https://blog.csdn.net/lexiaowu/article/details/131210846)

```java
@Component
@Slf4j
public class ActuatorConfig {
    @Value("${spring.profiles.active}")
    private String profile;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private NacosNamingService nacosNamingService;
    
    @Scheduled(fixedDelay = 10000)
    public void scheduledTasks() throws NacosException{
        log.info("定时任务执行中...");
        // 执行定时任务
        List<Instance> instances = nacosNamingService.getAllInstances("papi-interface",profile);
        for(Instance instance : instances){
            String instanceIp = instance.getIp();
            if("dev".equals(profile)){
                instanceIp="127.0.0.1";
            }
            String instanceId = instance.getInstanceId();
            String url = instanceIp + ":" + instance.getPort() + "/api/metrics/";
            HttpResponse response = HttpRequest.get(url).execute();
            log.info("获取到实例"+instanceId+"的指标信息");
            HashMap<String, Object> map= new HashMap<>(JSONUtil.parseObj(response.body()));
            OptionalDouble average = map.values().stream().mapToDouble(o-> ((BigDecimal)o).doubleValue()).filter(d -> d > 0).average();
            if (average.isPresent()) {
                log.info("实例"+instanceId+"的繁忙程度评估均值：" + average.getAsDouble());
                stringRedisTemplate.opsForValue().set(INSTANCE_METRICS_PREFIX + instanceId, String.valueOf(average.getAsDouble()),100, TimeUnit.SECONDS);
            } else {
                log.error("实例"+instanceId+"的繁忙程度评估均值获取失败");
            }
        }
        log.info("定时任务执行结束...");
    }
}
```

> 要点3：负载均衡策略

设计5种负载均衡策略：

- ROUND_ROBIN和RANDOM是自带的策略。
- HEADER策略是根据特定的请求分配对应的实例，在前端发送请求时设置请求头，其他请求轮询。
- GATEWAY策略是在项目本地或特定IP上部署的实例上轮询，适合在开发环境用。
- LOAD策略是根据实例的负载情况分配。

可在配置文件中设置负载均衡策略。

```java
public enum LoadBalancerTypeEnum {
    /**
     * 根据请求头中的设置获取对应实例
     */
    HEADER,
    /**
     * 在特定IP部署的实例中轮询
     */
    GATEWAY,
    /**
     * 轮循
     */
    ROUND_ROBIN,
    /**
     * 根据实例负载分配
     */
    LOAD,
    /**
     * 随机
     */
    RANDOM;
}
```

具体实现：

在低版本中gateway的负载均衡是由ribbon提供的，但是ribbon已经不再维护了，spring cloud中引入了loadbalancer包。默认的轮询负载均衡策略

org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer

包中，照猫画虎也实现一个这个类就可以。主要要做的就是实现ReactorServiceInstanceLoadBalancer接口和choose()方法

```java
public class RoundRobinLoadBalancer implements ReactorServiceInstanceLoadBalancer {
	public Mono<Response<ServiceInstance>> choose(Request request) {
    }
}
```

实测效果

![](https://github.com/polarisronx/Papi-backend/doc/images/QQ20240630155958.png)

## 拓展12：接口QPS测试

