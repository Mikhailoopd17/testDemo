package com.example.demo;

//import com.example.demo.config.DataConfig;
import com.example.demo.config.JettyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource(value = "classpath:application.properties")
})
@EntityScan(basePackages = {"com.example.demo.pojo"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{
                        DemoApplication.class,
                        JettyConfig.class
                }, args);
    }

}
