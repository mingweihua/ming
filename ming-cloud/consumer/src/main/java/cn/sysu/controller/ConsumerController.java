package cn.sysu.controller;

import cn.sysu.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("{id}")
    public Product product(@PathVariable("id") int id) {
        //根据服务id获取实例
        List<ServiceInstance> instances = discoveryClient.getInstances("service");
        //从实例中取ip和端口
        ServiceInstance instance = instances.get(0);
        String url = "http://"+ instance.getHost()+ ":" + instance.getPort()+ "/product/" + id;
        Product product = restTemplate.getForObject(url,Product.class);
        return product;
    }

}
