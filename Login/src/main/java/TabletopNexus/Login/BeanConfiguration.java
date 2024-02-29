package TabletopNexus.Login;

import TabletopNexus.Login.Classes.User;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@EnableRedisRepositories
public class BeanConfiguration {

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // Add some specific configuration here. Key serializers, etc.
        //System.out.println("i am here");
        return template;
    }
}
