package com.wk.task1spring.config;

import com.wk.task1spring.controller.ClientController;
import com.wk.task1spring.dao.CashFlowDao;
import com.wk.task1spring.dao.ClientDao;
import com.wk.task1spring.dao.TariffDao;
import com.wk.task1spring.dao.impl.CashFlowDaoImpl;
import com.wk.task1spring.dao.impl.ClientDaoImpl;
import com.wk.task1spring.dao.impl.TariffDaoImpl;
import com.wk.task1spring.service.ClientService;
import com.wk.task1spring.service.impl.ClientServiceImpl;
import com.wk.task1spring.util.SettingReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * @author Denis Khalaev
 */
@Configuration
@ComponentScan(basePackages = {"com.wk.task1spring.dao", "com.wk.task1spring.service"})
@EnableWebMvc
public class SpringConfig {


    @Bean
    public ClientService getClientService() {
        return new ClientServiceImpl();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public ClientDao getClientDao() {
        return new ClientDaoImpl();
    }

    @Bean
    public TariffDao getTariffDao() {
        return new TariffDaoImpl();
    }

    @Bean
    public CashFlowDao getCashFlowDao() {
        return new CashFlowDaoImpl();
    }

    @Bean
    public ClientController clientController() {
        return new ClientController();
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        SettingReader settingReader = SettingReader.getInstance("connection/connection.properties");
        dataSource.setUrl(settingReader.getSetting("url"));
        dataSource.setUsername(settingReader.getSetting("username"));
        dataSource.setPassword(settingReader.getSetting("password"));
        dataSource.setDriverClassName(settingReader.getSetting("driver"));
        return dataSource;
    }

}
