package com.hmc.getaway.config.bean;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.DefaultBlockRequestHandler;
import com.hmc.common.constant.SystemStatusEnum;
import com.hmc.common.constant.WebResBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * @author HHF
 * @Description
 * @create 2020-07-02 上午 10:16
 */
@Component
@Slf4j
public class CustomBlockRequestHandler implements BlockRequestHandler {
    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable ex) {
        return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS).contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject(this.buildErrorResult(exchange,ex)));
    }

    private WebResBean buildErrorResult(ServerWebExchange exchange,Throwable ex) {
        log.error("资源访问频繁【{}】|【{}】 ", exchange.getRequest().getURI(),exchange.getRequest().getRemoteAddress());
        return WebResBean.createResBean(SystemStatusEnum.TOO_MANY_REQUESTS);
    }

}
