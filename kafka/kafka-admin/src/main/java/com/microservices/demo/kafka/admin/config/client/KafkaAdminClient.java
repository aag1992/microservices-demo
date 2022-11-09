package com.microservices.demo.kafka.admin.config.client;

import com.microservices.demo.config.KafkaConfigData;
import com.microservices.demo.config.RetryConfigData;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAdminClient {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminClient.class);

    private KafkaConfigData kafkaConfigData;

    private RetryConfigData retryConfigData;

    private AdminClient adminClient;

    private RetryTemplate retryTemplate;

    public KafkaAdminClient(KafkaConfigData config,
                            RetryConfigData retryConfigData,
                            AdminClient client,
                            RetryTemplate template) {
        this.kafkaConfigData = config;
        this.retryConfigData = retryConfigData;
        this.adminClient = client;
        this.retryTemplate = template;
    }
}
