package com.boot.wego.dao.mapper;

import com.boot.wego.entity.Personal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalMapper {
    int deleteByPrimaryKey(String name);

    int insert(Personal record);

    int insertSelective(Personal record);

    Personal selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Personal record);

    int updateByPrimaryKey(Personal record);
}