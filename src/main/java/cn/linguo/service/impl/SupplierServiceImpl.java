package cn.linguo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.linguo.dao.SupplierMapper;
import cn.linguo.entity.Supplier;
import cn.linguo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierMapper supplierMapper;


	public int insert(Supplier entity) {
		// TODO Auto-generated method stub
		System.out.println("SupplierServiceImpl \t插入的对象是："+entity);
		return supplierMapper.insert(entity);
	}


	public int updateByPK(Supplier entity) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int deleteByPk(Supplier entity) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Supplier> select(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}




	public void insertSelective(Supplier entity) throws Exception {

		System.out.println("SupplierServiceImpl \t插入的对象是："+entity);
		supplierMapper.insertSelective(entity);

	}
}
