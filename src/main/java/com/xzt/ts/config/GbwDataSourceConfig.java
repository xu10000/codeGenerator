package com.xzt.ts.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.xzt.ts.mapper.gbw",
        // 此处非常关键，必须与最后函数的名称对应起来!
        sqlSessionTemplateRef  = "gbwDbSqlSessionTemplate")
public class GbwDataSourceConfig {
    private static final String propertiesUrl = "spring.datasource.gbw";
    private static final String xmlLocationPath = "classpath:mapper/gbw/*Mapper.xml";
    private static final String propertiesBeanName = "gbwDataSource";
    private static final String factoryBeanName  = "gbwSqlSessionFactory";
    private static final String managerBeanName  = "gbwTransactionManager";
    private static final String templateBeanName  = "gbwDbSqlSessionTemplate";

    @Bean(name = propertiesBeanName)
    @ConfigurationProperties(prefix = propertiesUrl)//指向yml配置文件中的数据库配置
    public DataSource dbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Resource
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    @Bean(name = factoryBeanName)
    public SqlSessionFactory dbSqlSessionFactory(@Qualifier(propertiesBeanName) DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Interceptor[] plugins = {mybatisPlusInterceptor};
        // ！！！此处必须设置分页插件的bean，否则不会生效！！！！
        bean.setPlugins(plugins);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(xmlLocationPath));
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setCacheEnabled(false);
//        configuration.setLogImpl(StdOutImpl.class);
//        bean.setConfiguration(configuration);
        //这个的getResources指向的是你的mapper.xml文件，相当于在yml中配置的mapper-locations，此处配置了yml中就不用配置，或者说不会读取yml中的该配置。
        return bean.getObject();
    }

    @Bean(name = managerBeanName)
    public DataSourceTransactionManager dbTransactionManager(@Qualifier(propertiesBeanName) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = templateBeanName)
    public SqlSessionTemplate gbwDbSqlSessionTemplate(@Qualifier(factoryBeanName) SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}