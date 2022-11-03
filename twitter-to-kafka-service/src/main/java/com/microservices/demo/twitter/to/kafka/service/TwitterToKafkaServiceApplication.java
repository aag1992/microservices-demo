package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

    private final StreamRunner streamRunner;
    private final TwitterToKafkaServiceConfigData config;

    public TwitterToKafkaServiceApplication(StreamRunner twitterKafkaStreamRunner, TwitterToKafkaServiceConfigData config) {
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
