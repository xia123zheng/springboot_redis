package com.xz.spring_redis.config;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @author vic
 * @desc redis config bean
 *
 */
@Component//spring boot1.5以上版本@ConfigurationProperties取消location注解后的替代方案 cannot resolve method location   与@EnableConfigurationProperties是替代关系
//没有使用@Component或@Confinguration，因此此对象不会注册到Spring容器中，需要@EnableConfigurationProperties
@PropertySource("classpath:application.properties")//使用@PropertySource来指定自定义的资源目录

public class RedisConfig {

    private static Logger logger = Logger.getLogger(RedisConfig.class);

    private String hostName;

    private int port;

    //private String password;

    private int timeout;


    //@Bean    //此处注入JedisPoolConfig对象没有意义，不需要
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean//@Bean注解将一个配置类的方法的返回值定义为一个bean，注册到spring里面
    public JedisPool getJedisPool(){
        JedisPoolConfig config = getRedisConfig();
        JedisPool pool = new JedisPool(config,hostName,port);
        logger.info("init JredisPool ...");
        return pool;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    /**
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     **/

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

}
