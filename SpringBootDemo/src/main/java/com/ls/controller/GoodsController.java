package com.ls.controller;

import com.github.pagehelper.PageInfo;
import com.ls.entity.Goods;
import com.ls.service.GoodsService;
import org.assertj.core.util.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yyb
 * @time 2020/3/6
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/Goods", produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public String t() {
        return "11";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Goods> add() {
        logger.info("GoodsController.add start");
        Goods goods=new Goods();
        goods.setUserid(11);
        goods.setName("goods");
        goods.setPrice(BigDecimal.ONE);
        goods.setAddress("杭州");
        goods.setCreatedate(new Date());
        return ResponseEntity.ok(goodsService.create(goods));
    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST)
    public ResponseEntity<String> addList() {
        logger.info("GoodsController.addList start");
        for(int i=0;i<10;i++){
            add();
        }
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Goods> getById(@PathVariable("id") Integer id) {
        logger.info("GoodsController.getById start");
        return ResponseEntity.ok(goodsService.getById(id));
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Goods>> findByName(@PathVariable("name") String name) {
        logger.info("GoodsController.findByName start");
        return ResponseEntity.ok(goodsService.getByMap(Maps.newHashMap("name",name),0,10));
    }



}


