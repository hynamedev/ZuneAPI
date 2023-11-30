package me.hyname;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import me.hyname.adapter.Adapter;
import me.hyname.storage.Storage;

@SpringBootApplication
public class ZuneAPIService {

    Logger logger = LogManager.getRootLogger();

    Storage storage;
    Adapter adapter;
    RequestMappingHandlerMapping mappings;

    public static void main(String[] args) {
        SpringApplication.run(ZuneAPIService.class, args);
    }

    public ZuneAPIService(Storage storage, Adapter adapter, RequestMappingHandlerMapping mappings) {
        this.storage = storage;
        this.adapter = adapter;
        this.mappings = mappings;
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing ZuneAPI Service");

        StringBuilder initialEndpoints = new StringBuilder();
        initialEndpoints.append("\nFollowing endpoints are loaded [method -> REST Operation - REST Path]:\n");
        mappings.getHandlerMethods().forEach((k,v) -> {

            // get the REST operation(s)
            String ops = k.getMethodsCondition().getMethods().toString();
            // get the paths; PathPatterns can be null
            Optional<PathPatternsRequestCondition> pathPatts = Optional.ofNullable(k.getPathPatternsCondition());
            String paths = "";
            if(pathPatts.isPresent()) {
                paths = pathPatts.get().getPatternValues().toString();
            }
            
            String methodName = v.getMethod().getName();
            
            initialEndpoints.append(methodName + " -> " + ops + " - " + paths + "\n");
        });

        logger.debug(initialEndpoints);

        logger.info("Initialized ZuneAPI Service");
    }

    @PreDestroy
    void shutdown() {
        List<String> failures = new ArrayList<>();
        logger.info("Shutting down ZuneAPI Service");
        
        if(!storage.shutdown()) {
            failures.add("Database connection");
        }

        if (failures.isEmpty()) {
            logger.info("Successfully shutdown ZuneAPI Service");
        } else {
            logger.error("The following items failed to shut down properly: " + failures);
        }
    }

}