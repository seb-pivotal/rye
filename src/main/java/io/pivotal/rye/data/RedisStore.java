package io.pivotal.rye.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

@Component
public class RedisStore {
    Jedis jedis;

    public RedisStore(
            @Value("${redis.host}") String host,
            @Value("${redis.port}") int port,
            @Value("${redis.auth}") String password)
    {
        JedisShardInfo shardInfo = new JedisShardInfo(host, port);
        if(!"".equals(password)) {
            shardInfo.setPassword(password);
        }
        jedis = new Jedis(shardInfo);
    }

    public void set(String key, String value) {
        jedis.set(key, value);
    }

    public String get(String key) {
        return jedis.get(key);
    }
}
