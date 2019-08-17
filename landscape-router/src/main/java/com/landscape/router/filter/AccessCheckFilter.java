package com.landscape.router.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 2019-08-12
 *
 * @author eddie
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccessCheckFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        //赋予最高执优先级
        return Ordered.HIGHEST_PRECEDENCE;
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //TODO 验证逻辑
        return chain.filter(exchange.mutate().request(exchange.getRequest()).build());
    }


}