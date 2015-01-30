package com.demo.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.demo.domain.Good;
import com.demo.service.GoodService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class GoodAction extends BaseAction<Good> {


	/** 列表 */
	public String list() throws Exception {
		List<Good> goodList = goodService.findAll();
		ActionContext.getContext().put("goodList", goodList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		goodService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		goodService.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Good good = goodService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(good);
		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Good good = goodService.getById(model.getId());

		// 2，设置要修改的属性
		good.setName(model.getName());
		good.setPrice(model.getPrice());

		// 3，更新到数据库
		goodService.update(good);

		return "toList";
	}

}
