package brian.boot.template.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class H2ConfigWithHibernate {

    @Autowired
    Environment env;

    @Bean(name = "entityManager1")
    @Profile("test")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "brian.boot.template.jpa.domain.hibernate" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.properties.hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show-sql"));
        properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.properties.hibernate.format_sql"));
//        properties.setProperty("hibernate.naming-strategy", env.getProperty(".jpa.hibernate.naming-strategy"));
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        em.setJpaProperties(properties);

        return em;
    }

    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( env.getProperty("hibernate.datasource.driver-class-name") );
        dataSource.setUrl( env.getProperty("hibernate.spring.datasource.url"));
        dataSource.setUsername(env.getProperty("hibernate.datasource.username"));
        dataSource.setPassword(env.getProperty("hibernate.datasource.password"));

        return dataSource;
    }

    /**
     * Transaction Manager
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }
}
