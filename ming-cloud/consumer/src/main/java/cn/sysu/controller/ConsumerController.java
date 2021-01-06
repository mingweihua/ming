package cn.sysu.controller;

import cn.sysu.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    //负载均衡--方式1
    @Autowired
    private LoadBalancerClient client;

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


    //负载均衡--方式1
    @RequestMapping("/ribbon/{id}")
    public Product getProductByRibbon(@PathVariable("id") int id) {
        log.info("负载均衡--方式1");
        //根据服务id获取实例
        ServiceInstance instance = client.choose("service");
        String url = "http://"+ instance.getHost()+ ":" + instance.getPort()+ "/product/" + id;
        Product product = restTemplate.getForObject(url,Product.class);
        return product;
    }

    //负载均衡--方式2，拦截RestTemplate，通过@LoadBalaced
    //注意当是使用方式2，再用方式1的请求会报错。同理使用方式1，再用方式2也会报错
    @RequestMapping("/ribbon2/{id}")
    public Product getProductByRibbon2(@PathVariable("id") int id) {
        log.info("负载均衡--方式2");
        //只需要提供含有serviceId的url即可
        String url = "http://service/product/" + id;
        Product product = restTemplate.getForObject(url,Product.class);
        return product;
    }

}
