    生产者
      1.创建生产者SpringBoot工程
      2.引入依赖坐标
      <dependency>
      <groupld> org.springframework.boot</groupld>
      <artifactld> spring-boot-starter-amqp </artifactld>
      </dependency>
    3.编写yml配置,基本信息配置
    4.定义交换机，队列以及绑定关系的配置类
    5.注入RabbitTemplate,调用方法，完成消息发送
    
    消费者
    1.创建消费者SpringBoot工程
    2.引入start,依赖坐标
    <dependency>
    <groupld> org.springframework .boot</groupld>
    < artifactld> spring boot starter- amqp</artifactld>
    </dependency>
    3.编写yml配置,基本信息配置
    4.定义监听类，使用@RabbitListener注解完成队列监听。
    
    小结
    ●SpringBoot提供 了快速整合RabbitMQ的方式
    ●基本信息再yml中配置，队列交互机以及绑定关系在配置类中使用Bean的方式配置
    ●生产端直接注入 RabbitTemplate完成消息发送
    ●消费端直接使用@RabbitListener完成消息接收
