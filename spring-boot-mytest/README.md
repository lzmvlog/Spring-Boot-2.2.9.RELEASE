# SpringBoot 启动流程

```java
public static ConfigurableApplicationContext run(Class<?>[]primarySources,String[]args){
        // 两件事：1、初始化SpringApplication 2、执行run方法
        return new SpringApplication(primarySources).run(args);
}
```

## 初始化SpringApplication

1、读取`SpringBootMyTestApplication`类的所有信息

2、推断当前SpringBoot应用类型是 `WebApplicationType.SERVLET` 还是 `WebApplicationType.REACTIVE`

3、初始化`classpath`下 `META-INF/spring.factories` 中已配置得 `ApplicationContextInitializer`

4、初始化`classpath`下所有已配置得 `ApplicationListener`

5、根据调用栈，推断出 main 方法得类名

> 如何根据调用栈判断得？

## 执行run方法

1、初始化`classpath`下 `META-INF/spring.factories` 中已配置得 `SpringApplicationRunListener`

2、构建应用上下文

（1）、获取`初始化SpringApplication`时配置的`WebApplicationType`

（2）、配置 `environment` 系统环境，配置`configureProfiles`激活文件

`public static final String ACTIVE_PROFILES_PROPERTY_NAME = "spring.profiles.active";`

（3）、获取`systemEnvironment`配置的系统变量`SystemEnvironmentPropertySource`替换成`OriginAwareSystemEnvironmentPropertySource`,
`ConfigFileApplicationListener`加载项目配置文件的监听器，获取配置文件

3、初始化上下文
创建 `AnnotationConfigServletWebServerApplicationContext`Context上下文时，IOC容器也进行了创建
![AnnotationConfigServletWebServerApplicationContext](img/AnnotationConfigServletWebServerApplicationContext.png)

4、刷新应用上下文的准备阶段

注册bean的流程

> Spring容器在启动的时候，会将类解析成Spring内部的beanDefinition,并将beanDefinition存储到org.springframework.beans.factory.support.DefalutListableBeanFactory的Map中

> ((DefaultListableBeanFactory)((AnnotationConfigServletWebServerApplicationContext)context).beanFactory).beanDefinitionMap

> springBootMyTestApplication -> {AnnotatedGenericBeanDefinition@4533} "Generic bean: class [com.example.springbootmytest.SpringBootMyTestApplication]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null"

> SpringBoot自动化配置原理？


### `Ioc`容器初始化过程的三个步骤:

1、Resource定位             
2、BeanDefinition的载入     
3、注册BeanDefinition

> 如何解析包含 @ComponentScan @Import 等等？

`org.springframework.context.annotation.ConfigurationClassParser`的`doProcessConfigurationClass`

