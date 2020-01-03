package cn.linguo.service;

import java.util.List;



public interface BaseService<T> {

	//添加一条记录
		public int insert(T entity) throws Exception;
		//根据主键修改记录
		public int updateByPK(T entity);
		//删除一条记录
		public int deleteByPk(T entity);
		//查询多条记录
		public List<T> select(T entity);
}
