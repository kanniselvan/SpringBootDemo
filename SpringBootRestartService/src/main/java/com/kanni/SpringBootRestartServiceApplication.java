package com.kanni;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.ArgumentAware;

import javax.annotation.PreDestroy;

@SpringBootApplication
@RestController
public class SpringBootRestartServiceApplication {


    static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootRestartServiceApplication.class);
        application.addListeners(new ApplicationPidFileWriter("app.pid")); //3way
        context =  application.run();

    }

    @GetMapping("/stop")
    public String stopSpringBoot() {
    System.out.println("Waiting for 1m......");

            if(context.isActive())
                context.close();

        return "spring boot stopped successfully ";
    }

    @GetMapping("/shutdown")
    public String shutdownApplication() {

        int exitCode = SpringApplication.exit(context, (ExitCodeGenerator) () -> 0);
        System.exit(exitCode);
        return "spring boot shutdown successfully ";
    }

    @PreDestroy
    public void onShutDown() {
        System.out.println("closing application context..let's do the final resource cleanup");
    }

}
