package cn.linguo.action;

import javax.annotation.Resource;

import cn.linguo.entity.Supplier;
import cn.linguo.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/supplier")
public class SupplierAction extends BaseAction {


	@Resource
	private SupplierService supplierService;




	@RequestMapping(value="/insert")
	public String insert(Supplier supplier){
		System.out.println("这个方法执行了。。。。\t:"+supplier);
		try {

			System.out.println("SupplierAction \t准备向数据库插入数据。。。。。。。");
			supplierService.insertSelective3(supplier);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/WEB-INF/jsp/main.jsp";
//		return "forward:/main.jsp";
	}



	@RequestMapping("/doAjax")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---测试json格式:"+supplier);
		supplier.setSupName("改过名字的-supName1");
		return supplier;
	}



	@RequestMapping("/supplierlist.do")
	public String supplierlist(){

		System.out.println("SupplierAction \t 跳转供应商明细页面。。。。。。。");

		return "forward:/WEB-INF/supplier/supplierlist.jsp";



	}



}
