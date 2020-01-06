package cn.linguo.action;

import javax.annotation.Resource;

import cn.linguo.entity.Supplier;
import cn.linguo.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
			supplierService.insertSelective(supplier);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/jsp/main.jsp";
//		return "forward:/main.jsp";
	}
	
	@RequestMapping("/doAjax")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}

}
