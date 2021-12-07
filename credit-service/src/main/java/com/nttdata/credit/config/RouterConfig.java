package com.nttdata.credit.config;

import com.nttdata.credit.handler.CreditHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(CreditHandler handler){
        return route(GET("/credit/{id}"), handler::findById)
                .andRoute(GET("/credit/customer/{documentNumber}"), handler::findByCustomerDocumentNumber)
                .andRoute(POST("/credit"), handler::create);
    }
}
