package com.liberty.gorilla.framework.core;


import com.liberty.gorilla.framework.core.properties.GorillaSystemProperties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@ComponentScan({"com.liberty.gorilla.framework","com.liberty.gorilla.application.controller"})
@SpringBootApplication()
public class GorillaApplicationStartRun {

    private static final String[] APPLICATION_CONFIG_FILE_NAME = new String[]{"application.properties", "application.yml"};

    public GorillaApplicationStartRun() {
    }

    public static void main(String[] args) throws Exception {

        SpringApplication application = new SpringApplication(GorillaApplicationStartRun.class);
        application.setBannerMode(Banner.Mode.LOG);
        ConfigurableApplicationContext applicationContext = application.run(args);
        GorillaSystemProperties properties = getApplicationProperties();
        System.out.println(properties.toString());
        System.out.println("**Gorilla***应用:已启动成功!");
    }

    private static GorillaSystemProperties getApplicationProperties() {
        GorillaSystemProperties properties = new GorillaSystemProperties();
        try {
            ClassPathResource classPathResource = new ClassPathResource("application.properties");
            InputStream is = classPathResource.getInputStream();
            properties.load(is);
            Properties propertiesYml = getYmlProperties();
            if (propertiesYml != null) {
                Set<Map.Entry<Object, Object>> entrySet = propertiesYml.entrySet();
                for (Map.Entry<Object, Object> entry : entrySet) {
                    properties.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (IOException e) {
            System.out.println("未读取到配置文件[application.properties,application.yml]");
        }
        return properties;
    }

    public static Properties getYmlProperties() {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        return yaml.getObject();
    }

}
