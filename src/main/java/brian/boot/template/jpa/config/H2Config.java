package brian.boot.template.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class H2Config {

    @Autowired
    Environment env;

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( env.getProperty("datasource.driver-class-name") );
        dataSource.setUrl( env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));

        return dataSource;
    }

    @Bean
    @Profile("test")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "brian.boot.template.jpa.domain" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("jpa.show-sql"));
        properties.setProperty("hibernate.format_sql", env.getProperty("jpa.properties.hibernate.format_sql"));
//        properties.setProperty("hibernate.naming-strategy", env.getProperty(".jpa.hibernate.naming-strategy"));
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        em.setJpaProperties(properties);

        return em;
    }
}
