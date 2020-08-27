package com.liberty.gorilla.framework.core;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ComponentScan({"com.liberty.gorilla.framework"})
@SpringBootApplication()
public class GorillaApplicationStartRun {

    private static final String[] APPLICATION_CONFIG_FILE_NAME = new String[]{"application.properties", "application.yml"};

    public GorillaApplicationStartRun() {
    }

    public static void main(String[] args) throws Exception {

        SpringApplication application = new SpringApplication(GorillaApplicationStartRun.class);
        application.setBannerMode(Banner.Mode.LOG);
        ConfigurableApplicationContext applicationContext = application.run(args);
        getApplicationProperties();
        System.out.println("**Gorilla***应用:已启动成功!");
    }

    private static Properties getApplicationProperties() {
        Properties properties = new Properties();
        try {
            ClassPathResource classPathResource = new ClassPathResource("application.properties");
            InputStream is  = classPathResource.getInputStream();
            properties.load(is);
        } catch (IOException e) {
            System.out.println("未读取到配置文件[application.properties,application.yml]");
        }
        return properties;
    }

    public static Properties properties() {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        return yaml.getObject();
    }

}
