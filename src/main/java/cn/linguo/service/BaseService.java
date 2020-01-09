package cn.linguo.service;

import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;

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

		//插入一条记录
		public int insertSelective3(Supplier entity) throws Exception;


		//根据关键字查询分页数据
		Page<T> selectPage(Page<T> page);



	//==================================================================================================

	//多条件通过关键字，查询分页数据，返回列表
	Page<Supplier> SelectListPage(Page<T> page);



	//通用 根据主键批量删除多条记录
	Integer deleteList(String pks[]) throws Exception;





}
