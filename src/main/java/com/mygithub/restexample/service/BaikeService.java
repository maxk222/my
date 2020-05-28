package com.mygithub.restexample.service;

import java.util.List;

import com.mygithub.restexample.entity.Baike;

public interface BaikeService {

	List<Baike> findAll();

	Baike addBaike(Baike baike);

	Baike findById(String id);

}
