package com.demo.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.demo.domain.Shop;
import com.demo.service.ShopService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ShopAction extends BaseAction<Shop> {

	/** 列表 */
	public String list() throws Exception {
		List<Shop> shopList = shopService.findAll();
		ActionContext.getContext().put("shopList", shopList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		shopService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		
		shopService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备回显的数据
		Shop shop = shopService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(shop);

		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		Shop shop = shopService.getById(model.getId());

		// 2，设置要修改的属性
		shop.setName(model.getName());
		shop.setLocation(model.getLocation());

		// 3，更新到数据库
		shopService.update(shop);

		return "toList";
	}
}
