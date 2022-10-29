package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.twitter.to.kafka.service.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.impl.TwitterKafkaStreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

    private final TwitterKafkaStreamRunner streamRunner;
    private final TwitterToKafkaServiceConfigData config;

    public TwitterToKafkaServiceApplication(TwitterKafkaStreamRunner twitterKafkaStreamRunner, TwitterToKafkaServiceConfigData config) {
        this.streamRunner = twitterKafkaStreamRunner;
        this.config = config;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("application running");
        List<String> list = config.getTwitterKeywords();
        LOG.info(list.toString());
        String welcomeMessage = config.getWelcomeMessage();
        LOG.info(welcomeMessage);
        this.streamRunner.start();
    }
}
