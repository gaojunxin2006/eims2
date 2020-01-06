package cn.linguo.service;


import cn.linguo.entity.Supplier;

public interface SupplierService extends BaseService<Supplier> {

	  void insertSelective(Supplier entity) throws Exception;



}
