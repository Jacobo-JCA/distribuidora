package com.example.distribuidora;

import com.example.distribuidora.model.Order;
import com.example.distribuidora.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DistribuidoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistribuidoraApplication.class, args);
    }


}
