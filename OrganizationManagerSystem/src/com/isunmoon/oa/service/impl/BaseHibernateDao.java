package com.isunmoon.oa.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isunmoon.oa.web.PageModel;
import com.isunmoon.oa.web.SystemContext;

public class BaseHibernateDao extends HibernateDaoSupport {
	
	public PageModel serchPageModel(String hql) {
		return this.sercgPageModel(hql, null);
	}

	public PageModel sercgPageModel(String hql, Object[] params) {
		return this.serchPageModel(hql, params, SystemContext.getOffset(), SystemContext.getPageSize());
	}

	public PageModel serchPageModel(String hql, Object[] params, int offset, int pageSize) {
		System.out.println("---serchPageModel方法");
		System.out.println("---offset=" + offset);
		System.out.println("---pageSize=" + pageSize);
		// 获取记录总数
		String countHql = getCountQuery(hql);
		Query query = this.getSession().createQuery(countHql);
		if(params != null && params.length > 0) {
			for(int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		int total = ((Long) query.uniqueResult()).intValue();
		
		// 获取当前页的结果集
		query = super.getSession().createQuery(hql);
		if(params != null && params.length > 0) {
			for(int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List datas = query.setFirstResult(offset).setMaxResults(pageSize).list();
		System.out.println("zhelide" + offset);
		PageModel pageModel = new PageModel();
		pageModel.setDatas(datas);
		pageModel.setTotal(total);
		
		return pageModel;
	}
	
	private String getCountQuery(String hql) {
		// String sql = "select * from User where id=?";
		int index = hql.indexOf("from");
		if(index != -1) {
			String tempSql = "select count(*) " + hql.substring(index);
			return tempSql;
		}else {
			throw new RuntimeException("无效的查询hql语句！");
		}
	}
	
}
