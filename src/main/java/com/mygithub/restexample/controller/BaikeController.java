package com.mygithub.restexample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mygithub.restexample.entity.Baike;
import com.mygithub.restexample.service.BaikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@Api(tags = "用户接口")
@RequestMapping("baike")
@RequiredArgsConstructor
public class BaikeController {

	private final static Logger logger = LoggerFactory.getLogger(BaikeController.class);
	
	private final BaikeService service;
	
    @ApiOperation("获取所有百科资料")
    @GetMapping
    public List<Baike> findAll(HttpSession session) throws Exception {
    	logger.info("获取所有百科资料");
    	List<Baike> list = service.findAll();
    	session.setAttribute("baikeList", list);
    	return list;
    }
    
    @ApiOperation("获取单个百科")
    @GetMapping("/{id}")
    public Baike findById(@PathVariable("id") String id) throws Exception {
    	Baike baike = service.findById(id);
    	return baike;
    }

    @ApiOperation("增加百科")
    @GetMapping("/addBaike")
    public Baike addBaike(Baike baike) throws Exception {
    	baike = service.addBaike(baike);
        return baike;
    }
}
