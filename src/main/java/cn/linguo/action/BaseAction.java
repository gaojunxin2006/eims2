package cn.linguo.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/base")
public class BaseAction {


	@Resource
	public ServletContext application;




	//方法通过folder @PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样

	@RequestMapping("/goURL/{folder}/{file}")
	public String goURL(@PathVariable String folder,@PathVariable String file){

		System.out.println("BaseAction 传来的跳转路径是：goURL.folder|file======="+folder+"/"+file);



		return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
	}










}
