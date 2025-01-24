package com.microservice.second_service.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("second-service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {
    private String first;
    private String last;

}
