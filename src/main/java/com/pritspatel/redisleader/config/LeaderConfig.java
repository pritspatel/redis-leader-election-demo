package com.pritspatel.redisleader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.integration.support.leader.LockRegistryLeaderInitiator;
import org.springframework.integration.support.locks.LockRegistry;

/**
 * Created by priteshpatel on 3/3/19.
 */
@Configuration
public class LeaderConfig {

    @Bean
    public RedisLockRegistry lockRegistry(RedisConnectionFactory connectionFactory) {
        return new RedisLockRegistry(connectionFactory, "sample", 10000);
    }

    @Bean
    public LockRegistryLeaderInitiator leaderInitiator(LockRegistry lockRegistry) {
        return new LockRegistryLeaderInitiator(lockRegistry, new LeaderCandidate());
    }
}
