package com.wxh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @ClassName: DemoApplication
 * @Description: 整个程序启动类
 * @Author wxh
 * @Date: 2020/7/13 15:31
 * @Version V1.0.0
 * @Since 1.8
 */
@SpringBootApplication
@MapperScan("com.wxh.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
