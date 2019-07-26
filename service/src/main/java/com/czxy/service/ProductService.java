package com.czxy.service;

import com.czxy.dao.ProductMapper;
import com.czxy.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/22 20:08
 */
@Service
@Transactional
public class ProductService {
    @Resource
    private ProductMapper productMapper;

    public List<Product> findAll(){
        return productMapper.selectAll();
    }

    public Product findById(Integer id){
        return productMapper.selectByPrimaryKey(id);
    }
}
