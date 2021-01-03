package cn.sysu.ming.config;
import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {


    //@Bean
    //@ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource() {
        //return new DruidDataSource();
        return null;
    }
}
