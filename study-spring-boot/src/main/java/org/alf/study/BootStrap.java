package org.alf.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:/bootstrap.xml")
@ComponentScan(basePackages="org.alf.study.service.impl")
@SpringBootApplication
public class BootStrap {

	public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
	}

}
