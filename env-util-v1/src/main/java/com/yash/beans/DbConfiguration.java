package com.yash.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {

    @Value("${sqlite.db.provider.name}")
    private String sqlliteDb;

    @Bean
    public HibernateJpaVendorAdapter getVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(false);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.SQLiteDialect");

        return  adapter;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:"+sqlliteDb);
        return dataSourceBuilder.build();
    }
    @Primary
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sessionFactory(@Autowired final DataSource hpcDataSource, @Autowired HibernateJpaVendorAdapter adapter) throws Exception {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(hpcDataSource);
        factoryBean.setPersistenceUnitName("sqliteDb");
        factoryBean.setPackagesToScan("com.yash.ocp.db.model");
        factoryBean.setJpaVendorAdapter(adapter);

        return factoryBean;
    }
}
