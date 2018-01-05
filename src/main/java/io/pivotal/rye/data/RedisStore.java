package io.pivotal.rye.data;

import io.pivotal.rye.config.RedisConnectionConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

@Component
public class RedisStore {
    Jedis jedis;

    public RedisStore(
            @Autowired RedisConnectionConfig config
            )
    {
        JedisShardInfo shardInfo = new JedisShardInfo(config.host, config.port);
        if(!"".equals(config.auth)) {
            shardInfo.setPassword(config.auth);
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
