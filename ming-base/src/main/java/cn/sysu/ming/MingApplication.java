package cn.sysu.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.sysu.ming.mapper")
public class MingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingApplication.class, args);
    }

}
