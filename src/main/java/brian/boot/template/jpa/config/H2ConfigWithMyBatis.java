package brian.boot.template.jpa.config;

//@Configuration
////@PropertySource({ "classpath:persistence-multiple-db.properties" })
//@EnableJpaRepositories(
//        basePackages = "brian.boot.template.jpa.domain.mybatis",
//        entityManagerFactoryRef = "entityManager",
//        transactionManagerRef = "productTransactionManager"
//)
public class H2ConfigWithMyBatis {
//    @Autowired
//    private Environment env;
//
//    /**
//     * Entity Manager
//     *
//     * @return
//     */
//    @Bean(name = "entityManager2")
//    public LocalContainerEntityManagerFactoryBean entityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan( new String[] { "org.baeldung.persistence.multiple.model.product" });
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);
//
//        return em;
//    }
//
//    private DataSource dataSource() {
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName( env.getProperty("mybatis.datasource.driver-class-name") );
//        dataSource.setUrl( env.getProperty("mybatis.spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("mybatis.datasource.username"));
//        dataSource.setPassword(env.getProperty("mybatis.datasource.password"));
//
//        return dataSource;
//    }
//
//    /**
//     * Transaction Manager
//     *
//     * @return
//     */
//    @Bean
//    public PlatformTransactionManager productTransactionManager() {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManager().getObject());
//        return transactionManager;
//    }
}
