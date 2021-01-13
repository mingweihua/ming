package cn.sysu.ming;

import cn.sysu.ming.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class MingApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    void contextLoads() {
        String test = stringRedisTemplate.opsForValue().get("test");
        System.out.println(test);
    }

}
