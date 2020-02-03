package com.marshal.epoch.auth.component;

import com.alibaba.fastjson.JSON;
import com.marshal.epoch.auth.entity.OauthAccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @auth: Marshal
 * @date: 2019/3/6
 * @desc: 自定义TokenStore, 获取token后将token同时存入数据库和redis
 */
@Component
@Slf4j
public class EpochRedisTokenStore extends RedisTokenStore {

    public EpochRedisTokenStore(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AccessToken accessToken = super.readAccessToken(tokenValue);
        return accessToken;
    }

    @Override
    public void removeAccessToken(String tokenValue) {
        super.removeAccessToken(tokenValue);
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        super.storeAccessToken(token, authentication);
    }
}
