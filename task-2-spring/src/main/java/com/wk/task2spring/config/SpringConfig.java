package com.wk.task2spring.config;

import com.wk.task2spring.connector.TaskOneConnector;
import com.wk.task2spring.converter.Converter;
import com.wk.task2spring.converter.impl.ConverterImpl;
import com.wk.task2spring.thread.Interrogator;
import com.wk.task2spring.util.SettingReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Denis Khalaev
 */
@Configuration
public class SpringConfig {

    @Bean
    Converter converter() {
        return new ConverterImpl();
    }

    @Bean
    TaskOneConnector taskOneConnector() {
        return new TaskOneConnector();
    }

    @Bean
    Interrogator interrogator() {
        return new Interrogator();
    }

    @Bean
    SettingReader settingReader() {
        return new SettingReader();
    }
}
