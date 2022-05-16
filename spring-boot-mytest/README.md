#### `Ioc`容器初始化过程的三个步骤:

1、Resource定位             
2、BeanDefinition的载入     
3、注册BeanDefinition

> 如何解析包含 @ComponentScan @Import 等等？

`org.springframework.context.annotation.ConfigurationClassParser`的`doProcessConfigurationClass`