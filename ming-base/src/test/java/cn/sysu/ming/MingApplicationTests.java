package cn.sysu.ming;

import cn.sysu.ming.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MingApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        System.out.println(productService.findById(1));
    }

}
