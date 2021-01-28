package com.ls.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ls.dao.GoodsDao;
import com.ls.dataSourceConfig.DynamicDataSourceContextHolder;
import com.ls.entity.Goods;
import com.ls.enums.DatabaseTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GoodsService {
    private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private GoodsDao goodsDao;

    public PageInfo<Goods> getByMap(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        DynamicDataSourceContextHolder.setDatabaseType(DatabaseTypeEnum.USER);
        //DynamicDataSourceContextHolder.resetDatabaseType();
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(goodsDao.getByMap(map));
    }

    public Goods getById(Integer id) {
        DynamicDataSourceContextHolder.setDatabaseType(DatabaseTypeEnum.PRIMARY);
        return goodsDao.getById(id);
    }

    public Goods create(Goods goods) {
        logger.info("GoodsService.create start");
        goodsDao.create(goods);
        return goods;
    }

    public Goods update(Goods goods) {
        goodsDao.update(goods);
        return goods;
    }

    public int delete(Integer id) {
        return goodsDao.delete(id);
    }

}