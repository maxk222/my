package com.mygithub.restexample.controller;

import java.util.Date;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygithub.restexample.entity.Baike;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@Api(tags = "用户接口")
@RequestMapping("baike")
@RequiredArgsConstructor
public class BaikeController {

	private MongoTemplate mongoTemplate;

    @ApiOperation("获得单个百科")
    @GetMapping("/addBaike")
    public Baike addBaike(Baike baike) throws Exception {
    	baike.setCrateDate(new Date());
    	mongoTemplate.insert(baike);
        return baike;
    }
}
