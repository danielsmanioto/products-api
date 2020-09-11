package com.dsmanioto.productsapi.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collections;

@ConfigurationProperties
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value( "${mongo.databaseName}" )
    private String databaseName;

    @Value( "${mongo.databaseUser}" )
    private String databaseUser;

    @Value( "${mongo.databasePassword}" )
    private String databasePassword;

    @Value( "${mongo.databaseAuth}" )
    private String databaseAuth;

    @Value( "${mongo.databaseHost}" )
    private String databaseHost;

    @Value( "${mongo.databasePort}" )
    private String databasePort;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.credential(
                MongoCredential.createCredential(databaseUser, databaseAuth, databasePassword.toCharArray())).applyToClusterSettings(settings -> {
            settings.hosts(Collections.singletonList(new ServerAddress(databaseHost, Integer.valueOf(databasePort))));
        });
    }

}