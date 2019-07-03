package com.mosaiker.winsperconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class WinsperConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WinsperConsumerApplication.class, args);
  }

}



