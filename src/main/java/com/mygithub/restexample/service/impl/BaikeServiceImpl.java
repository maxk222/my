package com.mygithub.restexample.service.impl;

import com.mygithub.restexample.entity.Baike;
import com.mygithub.restexample.service.BaikeService;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaikeServiceImpl implements BaikeService {

	private final static Logger logger = LoggerFactory.getLogger(BaikeServiceImpl.class);
	
	private final MongoTemplate mongoTemplate;

	@Override
	public List<Baike> findAll() {
		logger.info("获取所有百科资料");
		List<Baike> list = mongoTemplate.findAll(Baike.class);
		return list;
	}
	
	@Cacheable(cacheNames = "baike", key = "#id")
	@Override
	public Baike findById(String id) {
		logger.info("获取单个百科");
		Baike baike = mongoTemplate.findById(id, Baike.class);
		return baike;
	}

	@Override
	public Baike addBaike(Baike baike) {
		baike.setCrateDate(new Date());
    	mongoTemplate.insert(baike);
		return baike;
	}
	
}
