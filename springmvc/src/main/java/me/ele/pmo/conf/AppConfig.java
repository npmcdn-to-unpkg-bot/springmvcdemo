package me.ele.pmo.conf;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by kimi on 6/23/16.
 */
@PropertySource(value = "classpath:conf/database.properties")
@org.springframework.context.annotation.Configuration
@EnableJpaRepositories(basePackages = {"me.ele.pmo.repository"})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AppConfig {
    @Autowired
    private Environment env;

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "driver1";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "password1";
    private static final String PROPERTY_NAME_DATABASE_URL = "url1";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "username1";

    @Bean
    public DataSource dataSource() throws PropertyVetoException, SQLException {
        String environment = env.getRequiredProperty("env");
        /*ComboPooledDataSource dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
        if (environment != null && environment.equals("test")) {
            dataSource.setDriverClass(env.getRequiredProperty("driver"));
            dataSource.setJdbcUrl(env.getRequiredProperty("url"));
            dataSource.setUser(env.getRequiredProperty("username"));
            dataSource.setPassword(env.getRequiredProperty("password"));
            dataSource.setIdleConnectionTestPeriod(60);
            dataSource.setMaxPoolSize(20);
            dataSource.setMaxIdleTimeExcessConnections(600);
            dataSource.setPreferredTestQuery("SELECT 1");
        } else {
            dataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
            dataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
            dataSource.setUser(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
            dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
            dataSource.setIdleConnectionTestPeriod(60);
            dataSource.setMaxPoolSize(20);
            dataSource.setMaxIdleTimeExcessConnections(600);
            dataSource.setPreferredTestQuery("SELECT 1");
        }*/

        /*
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        if (environment != null && environment.equals("test")) {
            dataSource.setDriverClassName(env.getRequiredProperty("driver"));
            dataSource.setUrl(env.getRequiredProperty("url"));
            dataSource.setUsername(env.getRequiredProperty("username"));
            dataSource.setPassword(env.getRequiredProperty("password"));
        } else {
            dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
            dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
            dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
            dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        }*/

        DruidAbstractDataSource dataSource = new DruidDataSource();
        dataSource.setFilters(env.getRequiredProperty("filters"));
        dataSource.setMaxActive(Integer.parseInt(env.getRequiredProperty("maxActive")));
        dataSource.setInitialSize(Integer.parseInt(env.getRequiredProperty("initialSize")));
        dataSource.setMaxWait(Long.parseLong(env.getRequiredProperty("maxWait")));
        dataSource.setMinIdle(Integer.parseInt(env.getRequiredProperty("minIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getRequiredProperty("timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getRequiredProperty("minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(env.getRequiredProperty("validationQuery"));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getRequiredProperty("testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getRequiredProperty("testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(env.getRequiredProperty("testOnReturn")));
        dataSource.setRemoveAbandoned(Boolean.parseBoolean(env.getRequiredProperty("removeAbandoned")));
        dataSource.setLogAbandoned(Boolean.parseBoolean(env.getRequiredProperty("logAbandoned")));
        dataSource.setMaxOpenPreparedStatements(Integer.parseInt(env.getRequiredProperty("maxOpenPreparedStatements")));
        dataSource.setRemoveAbandonedTimeout(Integer.parseInt(env.getRequiredProperty("removeAbandonedTimeout")));
        if (environment != null && environment.equals("test")) {
            dataSource.setDriverClassName(env.getRequiredProperty("driver"));
            dataSource.setUrl(env.getRequiredProperty("url"));
            dataSource.setUsername(env.getRequiredProperty("username"));
            dataSource.setPassword(env.getRequiredProperty("password"));
        } else {
            dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
            dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
            dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
            dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        }

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException, SQLException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource());
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        bean.setHibernateProperties(properties);
        bean.setPackagesToScan("me.ele.pmo.model");
        return bean;
    }

    @Bean
    public org.mybatis.spring.SqlSessionFactoryBean sqlSessionFactory() throws PropertyVetoException, SQLException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setFailFast(true);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        Resource[] mapperResource = new Resource[]{new ClassPathResource("mapper/ProjectMapper.xml"), new ClassPathResource("mapper/Project1Mapper.xml")};
        sqlSessionFactoryBean.setMapperLocations(mapperResource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws PropertyVetoException, SQLException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("me.ele.pmo.model");
        factory.setDataSource(dataSource());
        Properties jpaProperties = new Properties();
        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto", "false");
        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql", "true");
        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql", "true");
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    @Autowired
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        JpaDialect jpaDialect = new HibernateJpaDialect();
        txManager.setEntityManagerFactory(entityManagerFactory);
        txManager.setJpaDialect(jpaDialect);
        return txManager;
    }
}
