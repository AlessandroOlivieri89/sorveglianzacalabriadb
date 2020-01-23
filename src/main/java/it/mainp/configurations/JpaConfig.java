package it.mainp.configurations;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
	
	  @Bean (name ="MysqlDataSource")
	    public DataSource getDataSource() 
	    {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
	        dataSourceBuilder.url("jdbc:mysql://localhost:3306/sorveglianzacalabriadb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	        dataSourceBuilder.username("root");
	        dataSourceBuilder.password("admin");
	        return dataSourceBuilder.build();
	    }

}
