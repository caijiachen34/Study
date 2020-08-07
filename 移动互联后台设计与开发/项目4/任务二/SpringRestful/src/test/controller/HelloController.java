package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import test.entity.Person;

@Controller
@RequestMapping("/hello")
public class HelloController {
	//get,根据id查询
	@RequestMapping(value="/person/{id}",method=RequestMethod.GET)
	@ResponseBody
	//@PathVariable用于获取请求url的动态参数
	public Person getPerson(@PathVariable("id") int id){
		System.out.println("获取人员信息id="+id);
		Person p=new Person();
		p.setId(id);
		p.setName("jack");
		p.setAge(20);
		return p;
	}
	//delete,根据id删除
	@RequestMapping(value="/person/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Object deletePerson(@PathVariable("id") int id){
		System.out.println("删除人员信息id="+id);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("msg", "msg:删除人员信息成功");
		return jsonObject;
	}
	//post，新增
	@RequestMapping(value="/person",method=RequestMethod.POST)
	@ResponseBody
	public Object addPerson(Person person){
		System.out.println("注册人员信息成功！");
		//自动注入Bean属性获取参数
		System.out.println("id="+person.getId());
		System.out.println("name="+person.getName());
		System.out.println("age="+person.getAge());
		JSONObject jsonObject=new JSONObject();
		System.out.println("addPerson");
		jsonObject.put("msg", "msg:注册人员信息成功");
		return jsonObject;
	}
	//put，更新
	@RequestMapping(value="/person",method=RequestMethod.PUT)
	@ResponseBody
	public Object updatePerson(Person person){
		System.out.println("更新人员信息");
		System.out.println("更新后的人员信息如下：");
		System.out.println("id="+person.getId());
		System.out.println("name="+person.getName());
		System.out.println("age="+person.getAge());
		JSONObject jsonObject=new JSONObject();
		System.out.println("updatePerson");
		jsonObject.put("msg", "msg:更新人员信息成功");
		return jsonObject;
	}
}
