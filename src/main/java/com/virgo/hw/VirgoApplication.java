package com.virgo.hw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * javadoc init start
 * @author wang chenkai
 */
@SpringBootApplication
@EnableAsync
@EnableFeignClients
@MapperScan("com.virgo.hw.mapper")
public class VirgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirgoApplication.class, args);
	}

}
