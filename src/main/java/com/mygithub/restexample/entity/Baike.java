package com.mygithub.restexample.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Baike implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2957747842742477309L;
	
	// 百科关键字 id 将对 MongoDB id
	private String id;
	private String desc;
	private List<String> tag = new ArrayList<String>();
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date crateDate = null;
	private Date updateDate = null;
}
