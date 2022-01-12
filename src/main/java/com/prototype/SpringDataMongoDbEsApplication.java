package com.prototype;

import com.prototype.worker.InitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataMongoDbEsApplication implements CommandLineRunner {

	@Autowired
	InitData initData;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoDbEsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData.updateDataMongo();
		initData.initDataElastic();
	}
}
