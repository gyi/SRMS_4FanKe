package com.demo.view.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.demo.domain.Rec;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RecAction extends BaseAction<Rec> {
	
	private Long goodId;
	private Long userId;
	private Long shopId;
	private Long quantity;
	private Double price;

	/** 列表 */
	public String list() throws Exception {
		List<Rec> recList = recService.findAll();
		ActionContext.getContext().put("recList", recList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		recService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {

		// 封装到对象中（model为实体，使用model，甚至未封装的属性）
		model.setGood(goodService.getById(goodId));
		//model.setUser(userService.getById((long)1));
		//model.setShop(shopService.getById((long)1));
		//price = quantity * goodService.getById(goodId).getPrice();
		//model.setPrice(price);
		model.setDateTime(new Date());
		// 保存到数据库
		recService.save(model);

		return "toList";
	}

	public Long getGoodId() {
		return goodId;
	}

	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	

}
