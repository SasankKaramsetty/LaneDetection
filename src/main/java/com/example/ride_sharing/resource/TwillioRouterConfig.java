package com.example.ride_sharing.resource;
import com.example.ride_sharing.resource.TripOTPHandler;
import org.springframework.web.reactive.function.server.RouterFunction;

import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
public class TwillioRouterConfig {
    @Autowired
    private TripOTPHandler handler;

    @Bean
    public RouterFunction<ServerResponse> handleSMS() {
        return RouterFunctions.route()
                .POST("/router/sendOTP", handler::sendOTP)
                .POST("/router/validateOTP", handler::validateOTP)
                .build();
    }
}
