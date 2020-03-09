package com.coretheorylife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableRabbit
@EnableTransactionManagement(order = 100, proxyTargetClass = true)
@MapperScan(basePackages = {"com.coretheorylife.modules.**.dao"})
@SpringBootApplication
public class CoretheorylifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoretheorylifeApplication.class, args);
	}

}
