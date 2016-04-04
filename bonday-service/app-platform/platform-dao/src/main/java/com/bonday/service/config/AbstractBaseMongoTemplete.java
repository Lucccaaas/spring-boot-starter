package com.bonday.service.config;

import com.mongodb.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.util.*;

import javax.annotation.Resource;

import static com.bonday.service.config.ConfigConstants.*;

/**
 * Created by yunge on 16/3/31.
 */
@Configuration
public class AbstractBaseMongoTemplete extends AbstractMongoConfiguration {

    @Resource
    protected Environment environment;

    @Override
    protected String getDatabaseName() {
        String database = System.getenv(MONGODB_DATABASE);
        if (StringUtils.isEmpty(database)) {
            database = environment.getRequiredProperty(MONGODB_DATABASE);
        }
        return database;
    }

    @Override
    public MongoClient mongo() throws Exception {
        String host = environment.getRequiredProperty(MONGODB_HOST, String.class);
        int port = environment.getRequiredProperty(MONGODB_PORT, Integer.class);
        String database = getDatabaseName();
        String username = environment.getRequiredProperty(MONGODB_USERNAME, String.class);
        String password = environment.getRequiredProperty(MONGODB_PASSWORD, String.class);
        int minConnectionsPerHost = environment.getRequiredProperty(MONGODB_MIN_CONNECTIONS_PER_HOST, Integer.class);

        ServerAddress address = new ServerAddress(host, port);
        MongoClientOptions options = MongoClientOptions.builder()
                .socketKeepAlive(true)
                .minConnectionsPerHost(minConnectionsPerHost)
                .build();
        return new MongoClient(address, null, options);
    }

}
