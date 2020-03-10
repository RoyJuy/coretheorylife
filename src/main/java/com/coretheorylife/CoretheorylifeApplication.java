package com.coretheorylife;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableRabbit
@EnableTransactionManagement(order = 100, proxyTargetClass = true)
@MapperScan(basePackages = {"com.coretheorylife.modules.**.dao", "com.coretheorylife.modules.payment.dao.mapper"})
@SpringBootApplication
public class CoretheorylifeApplication {

	private static final Logger logger = LoggerFactory.getLogger(CoretheorylifeApplication.class);

	public static void main(String[] args) {


		ApplicationContext ctx = SpringApplication.run(CoretheorylifeApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		//String[] beanNames = ctx.getBeanNamesForAnnotation(RestController.class);//所有添加该注解的bean
		logger.info("bean总数:{}", ctx.getBeanDefinitionCount());
		int i = 0;
		for (String str : beanNames) {
			logger.info("{},beanName:{}", ++i, str);
		}
	}

}
