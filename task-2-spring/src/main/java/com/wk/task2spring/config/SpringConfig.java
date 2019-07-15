package com.wk.task2spring.config;

import com.wk.task2spring.connector.ConnectorToTaskOne;
import com.wk.task2spring.converter.Converter;
import com.wk.task2spring.converter.impl.ConverterImpl;
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
    ConnectorToTaskOne connectorToTaskOne(){
        return new ConnectorToTaskOne();
    }



}
