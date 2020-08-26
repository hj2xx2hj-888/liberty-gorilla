package com.liberty.gorilla.framework.core;



import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.liberty.gorilla.framework"})
@SpringBootApplication()
public class GorillaApplicationStartRun {

    private static final String[] APPLICATION_CONFIG_FILE_NAME = new String[]{"application.properties","application.yml"};
    public GorillaApplicationStartRun() {
    }

    public static void main(String[] args) throws Exception {

        SpringApplication application = new SpringApplication(GorillaApplicationStartRun.class);
        application.setBannerMode(Banner.Mode.LOG);
        ConfigurableApplicationContext applicationContext = application.run(args);
        System.out.println("**Gorilla***应用:已启动成功!");
    }

}
