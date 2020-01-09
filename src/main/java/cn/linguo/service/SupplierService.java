package cn.linguo.service;


import cn.linguo.entity.Supplier;

public interface SupplierService extends BaseService<Supplier> {

	//插入供应商数据
	void insertSelective(Supplier entity) throws Exception;






}
