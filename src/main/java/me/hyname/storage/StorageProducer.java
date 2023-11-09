package me.hyname.storage;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import me.hyname.storage.impl.MongoStorage;
import me.hyname.storage.impl.NoneStorage;

/**
 * Creates an instance of a specific storage type based on properties loaded from the environment
 */
@Component
public class StorageProducer {

    @Value("${storage.hostname}")
    private String hostname;

    @Value("${storage.port}")
    private int port;

    @Value("${storage.type}")
    private String type;

    StorageType typeEnum;
    
    @PostConstruct
    void init() {
        typeEnum = EnumUtils.getEnum(StorageType.class, type);

        if (typeEnum == null) {
            throw new RuntimeException("Missing property 'storage.type' required");
        }
    }

    @Bean
    public Storage produceStorage() {

        Storage storage = new NoneStorage();

        switch (typeEnum) {
            case MONGODB:
                storage = new MongoStorage(hostname, port);
                break;
        
            case NONE:
                // already created "None" which would be the default.  Could also throw since the storage is effectively not assigned    
                break;

            default:
                break;
        }

        return storage;
    }
}
