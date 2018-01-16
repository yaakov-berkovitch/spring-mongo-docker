package authclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientURI;
 
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "authclient")
public class ApplicationConfig {
//	@Value("${spring.data.mongodb.uri}")
	private String connectionUri="mongodb://epic_mongodb:27017/paas-auth-db?replicaSet=rs0";

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClientURI mongoClientURI = new MongoClientURI(connectionUri);
        return new SimpleMongoDbFactory(mongoClientURI);
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
 
}
