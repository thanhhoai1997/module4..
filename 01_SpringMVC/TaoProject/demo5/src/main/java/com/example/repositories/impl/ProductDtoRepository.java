package com.example.repositories.impl;

import com.example.dto.PaginateDto;
import com.example.dto.ProductDto;
import com.example.dto.ProductDtopMapper;
import com.example.model.MapperCategory;
import com.example.repositories.IProductDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductDtoRepository implements IProductDtoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<ProductDto> getDataProductDto() {
        List<ProductDto> list = new ArrayList<>();
        String sql = "select\n" +
                "p.id as id_product\n" +
                ",p.id_category,\n" +
                "p.sizes,\n" +
                "p.name,\n" +
                "p.price,\n" +
                "p.sale,\n" +
                "p.title,\n" +
                "p.highlight,\n" +
                "p.new_product,\n" +
                "p.details,\n" +
                "c.id as id_color,\n" +
                "c.name as name_color,\n" +
                "c.code as code_color,\n" +
                "c.img,\n" +
                "p.created_at,\n" +
                "p.updated_at\n" +
                "from\n" +
                "products as p\n" +
                "inner join colors as c\n" +
                "on p.id=c.id_product" +

                " order by rand()" +
                "limit 12";
        list = jdbcTemplate.query(sql,new ProductDtopMapper());
        return list;
    }

    @Override
    public List<ProductDto> getDataProductDtoNew() {
        List<ProductDto> list = new ArrayList<>();
        String sql = "select\n" +
                "p.id as id_product\n" +
                ",p.id_category,\n" +
                "p.sizes,\n" +
                "p.name,\n" +
                "p.price,\n" +
                "p.sale,\n" +
                "p.title,\n" +
                "p.highlight,\n" +
                "p.new_product,\n" +
                "p.details,\n" +
                "c.id as id_color,\n" +
                "c.name as name_color,\n" +
                "c.code as code_color,\n" +
                "c.img,\n" +
                "p.created_at,\n" +
                "p.updated_at\n" +
                "from\n" +
                "products as p\n" +
                "inner join colors as c\n" +
                "on p.id=c.id_product\n" +
                "where p.highlight = true\n" +
                "and p.new_product = true\n" +
                "order by rand()\n" +
                "limit 12\n"
                ;
        list = jdbcTemplate.query(sql,new ProductDtopMapper());
        return list;
    }
    @Override
     public List<ProductDto> getAllProductById(int id){

        String sql = "select\n" +
                "p.id as id_product\n" +
                ",p.id_category,\n" +
                "p.sizes,\n" +
                "p.name,\n" +
                "p.price,\n" +
                "p.sale,\n" +
                "p.title,\n" +
                "p.highlight,\n" +
                "p.new_product,\n" +
                "p.details,\n" +
                "c.id as id_color,\n" +
                "c.name as name_color,\n" +
                "c.code as code_color,\n" +
                "c.img,\n" +
                "p.created_at,\n" +
                "p.updated_at\n" +
                "from\n" +
                "products as p\n" +
                "inner join colors as c\n" +
                "on p.id=c.id_product\n" +
                "where 1=1\n" +
                "and id_category =" + id ;


        List<ProductDto> list = jdbcTemplate.query(sql,new ProductDtopMapper());

        return list;


    }
    @Override
    public List<ProductDto> getAllProductPaginates(int start, int end){

        String sql = "select\n" +
                "p.id as id_product\n" +
                ",p.id_category,\n" +
                "p.sizes,\n" +
                "p.name,\n" +
                "p.price,\n" +
                "p.sale,\n" +
                "p.title,\n" +
                "p.highlight,\n" +
                "p.new_product,\n" +
                "p.details,\n" +
                "c.id as id_color,\n" +
                "c.name as name_color,\n" +
                "c.code as code_color,\n" +
                "c.img,\n" +
                "p.created_at,\n" +
                "p.updated_at\n" +
                "from\n" +
                "products as p\n" +
                "inner join colors as c\n" +
                "on p.id=c.id_product\n" +

                "limit" + " " + start + "," + end  ;


        List<ProductDto> list = jdbcTemplate.query(sql,new ProductDtopMapper());

        return list;


    }
}
