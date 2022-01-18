package com.prototype.mongodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDbConfig {

	@Value("${spring.data.mongodb.uri}")
	private String connectUri;

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(connectUri);
	}

}
