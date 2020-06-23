package com.gcf.mapper;

import com.gcf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface UserMapper {

    @Select("select * from t_product_cfgong")
    @Results({
        @Result(column = "productId",property = "productId",javaType = String.class),
        @Result(column = "serialNo",property = "serialNo",javaType = String.class),
        @Result(column = "remark",property = "remark",javaType = String.class)
    })
    public List<User> getAllUser();

    @Select("select * from t_product_cfgong where productid = #{pid}")
    public User getUserById(String pid);
}
