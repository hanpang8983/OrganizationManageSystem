package com.isunmoon.oa.web;

import java.util.List;

public class PageModel {
	// 查询结果
	private List datas;
	// 查询的首地址
	private int total;
	
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
