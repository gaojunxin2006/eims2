package cn.linguo.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import cn.linguo.dao.SupplierMapper;
import cn.linguo.entity.Page;
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



	public int insertSelective3(Supplier entity) throws Exception {

		//抽取出来的方法

		System.out.println("SupplierServiceImpl \t插入的对象是："+entity);


		return supplierMapper.insertSelective3(entity);
	}


	public void insertSelective(Supplier entity) throws Exception {

	}




	//根据条件 查询分页数据
	public Page<Supplier> selectPage(Page<Supplier> page) {

		System.out.println("SupplierServiceImpl \t 根据条件查询分页数据："+page);

		page.setPageList(supplierMapper.pageSelectList(page));

		page.setTotalRecord(supplierMapper.pageCount(page));

		return page;

	}




	//多条件查询
	public Page<Supplier> SelectListPage(Page<Supplier> page) {

		page.setPageList(supplierMapper.SelectListPage(page));

		page.setTotalRecord(supplierMapper.CountPage(page));

		System.out.println("SupplierServiceImpl \t 根据多条件查询分页数据："+page);

		return page;

	}





	//通用 根据主键批量删除多条记录
	public Integer deleteList(String[] pks) throws Exception {

		System.out.println("SupplierServiceImpl \t 根据主键批量删除多条记录："+ Arrays.toString(pks));


		Integer i = supplierMapper.deleteList(pks);

		return i;


	}







}
