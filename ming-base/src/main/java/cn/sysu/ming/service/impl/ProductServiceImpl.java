package cn.sysu.ming.service.impl;

import cn.sysu.ming.mapper.ProductMapper;
import cn.sysu.ming.pojo.Product;
import cn.sysu.ming.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findById(int id) {
        return productMapper.selectByPrimaryKey(id);
    }
}
