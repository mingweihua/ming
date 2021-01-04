package cn.sysu;

import cn.sysu.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class MingHttpApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
        Product product = restTemplate.getForObject("http://localhost:8080/product/2",Product.class);
        System.out.println(product);
    }

}
