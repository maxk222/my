package com.mygithub.restexample.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Baike {

	// 百科关键字 id 将对 MongoDB id
	private String id;
	private String desc;
	private List<String> tag = new ArrayList<String>();
	private Date crateDate = null;
	private Date updateDate = null;
}
