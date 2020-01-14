package cn.linguo.action;

import javax.annotation.Resource;

import cn.linguo.entity.Page;
import cn.linguo.entity.Supplier;
import cn.linguo.service.SupplierService;
import com.lowagie.text.PageSize;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/supplier")
public class SupplierAction extends BaseAction {


	@Resource
	private SupplierService supplierService;




	@RequestMapping(value="/insert")
	@ResponseBody
	public Object insert(Supplier supplier){
		System.out.println("这个方法执行了。。。。\t:"+supplier);
		int i=0;
		try {

			System.out.println("SupplierAction \t准备向数据库插入数据。。。。。。。");
			i=supplierService.insertSelective3(supplier);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
//		return "forward:/WEB-INF/jsp/main.jsp";
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


	//单条件查询,map对象来接受，map可以自动转成json
	@RequestMapping("/selectPage")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object supplierlist(Page<Supplier> page){
		System.out.println("SupplierAction ---跳转供应商明细页面:"+page);

		Page<Supplier> page2 = supplierService.selectPage(page);
//
//		Map<String,Object> pageMap=new HashMap<String, Object>();
//
//		pageMap.put("total",page2.getTotalRecord());
//
//		pageMap.put("rows",page2.getPageList());

		return page2.getPageMap();


	}



	//多条件查询,map对象来接受，map可以自动转成json
	@RequestMapping("/selectPageDy")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object supplierlistDy(Page<Supplier> page,Supplier supplier){
		System.out.println("SupplierAction ---多条件查询条件:"+page);

		page.setParamEntity(supplier);

		Page<Supplier> page2 = supplierService.SelectListPage(page);

		Map<String,Object> pageMap=new HashMap<String, Object>();

		pageMap.put("total",page2.getTotalRecord());

		pageMap.put("rows",page2.getPageList());

		return pageMap;


	}





	//根据主键，批量删除，删除多条记录
	@RequestMapping(value="/deleteList")
	@ResponseBody
	public Object deleteList(String ids[]){
		System.out.println("SupplierAction ---根据主键，批量删除，删除多条记录 要删除的记录id是：。。。。\t:"+ Arrays.toString(ids));
		Integer i=0;

		try {
			i = supplierService.deleteList(ids);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("SupplierAction \t 删除记录执行结果"+i );


		return i;
	}



	@RequestMapping("/add.do")
	public String addPage(){
		System.out.println("SupplierAction \t 跳转添加供应商页面" );

		return "forward:/WEB-INF/supplier/add.jsp";
	}


	//修改供应商资料
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Supplier supplier){
		System.out.println("SupplierAction 更新供应商资料这个方法执行了。。。。\t:"+supplier);
		int i=0;
		try {


			i=supplierService.updateByPK(supplier);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;


	}





}
