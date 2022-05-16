# SpringBoot 启动流程
```java
public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
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

## 执行run方法

### `Ioc`容器初始化过程的三个步骤:

1、Resource定位             
2、BeanDefinition的载入     
3、注册BeanDefinition

> 如何解析包含 @ComponentScan @Import 等等？

`org.springframework.context.annotation.ConfigurationClassParser`的`doProcessConfigurationClass`

