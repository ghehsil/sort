package com.ls.dao;

import com.ls.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GoodsDao {

    List<Goods> getByMap(Map<String, Object> map);

    Goods getById(Integer id);

    Integer create(Goods goods);

    int update(Goods goods);

    int delete(Integer id);
}