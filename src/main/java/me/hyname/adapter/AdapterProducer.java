package me.hyname.adapter;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import me.hyname.adapter.impl.LastFMAdapter;
import me.hyname.adapter.impl.NoneAdapter;

@Component
public class AdapterProducer {

    @Value("${adapter.key}")
    private String key;

    @Value("${adapter.secret}")
    private String secret;

    @Value("${adapter.type}")
    private String type;

    AdapterType typeEnum;
    
    @PostConstruct
    void init() {
        typeEnum = EnumUtils.getEnum(AdapterType.class, type);

        if (typeEnum == null) {
            throw new RuntimeException("Missing property 'adapter.type' required");
        }
    }

    @Bean
    public Adapter producAdapter() {

        Adapter adapter = new NoneAdapter();

        switch (typeEnum) {
            case LASTFM:
                adapter = new LastFMAdapter(key, secret);
                break;
        
            case NONE:
                // already created "None" which would be the default.  Could also throw since the adapter is effectively not assigned    
                break;

            default:
                break;
        }

        return adapter;
    }
}
