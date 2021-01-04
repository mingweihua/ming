package cn.sysu.controller;

import cn.sysu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{id}")
    public Product product(@PathVariable("id") int id) {
        String url = "http://localhost:8080/product/" + id;
        Product product = restTemplate.getForObject(url,Product.class);
        return product;
    }

}
