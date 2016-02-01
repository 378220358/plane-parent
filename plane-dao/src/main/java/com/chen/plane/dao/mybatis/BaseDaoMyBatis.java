package com.chen.plane.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * »ù´¡dao
 */
@Repository
public class BaseDaoMyBatis extends SqlSessionDaoSupport {

	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public SqlSession getSqlSession() {
		return super.getSqlSession();
	}
}
