package cn.sysu.ming.controller;

import cn.sysu.ming.pojo.Product;
import cn.sysu.ming.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("hello")
    public String test() {

        log.info("#日志# ======= 测试拦截器---log");
        return "Hello, ming";
    }

    @RequestMapping("product/{id}")
    public Product product(@PathVariable("id") int id) {
        log.info("#日志# ======= 根据id查找product，id为：" + id);
        return productService.findById(id);
    }

    @RequestMapping("redis/set")
    public String redisSet() {
        log.info("#日志# ======= 测试redis的set ");
        Product product = productService.findById(1);
        redisTemplate.opsForValue().set("product1",product);
        return "success";
    }

    @RequestMapping("redis/get")
    public Product redisGet() {
        log.info("#日志# ======= 测试redis的get ");
        Product product1 = (Product) redisTemplate.opsForValue().get("product1");
        return product1;
    }

    @RequestMapping("stringRedisTemplate/set")
    public String stringRedisTemplateSet() {
        log.info("#日志# ======= 测试redis的set ");
        stringRedisTemplate.opsForValue().set("test","stringRedisTemplate");
        return "success";
    }

    @RequestMapping("stringRedisTemplate/get")
    public String stringRedisTemplateGet() {
        log.info("#日志# ======= 测试redis的get ");
        String test = stringRedisTemplate.opsForValue().get("test");
        return test;
    }
}
