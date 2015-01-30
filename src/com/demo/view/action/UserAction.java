package com.demo.view.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.demo.domain.Role;
import com.demo.domain.Shop;
import com.demo.domain.User;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private Long shopId;
	private Long roleId;

	/** 列表 */
	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备数据，shop
		List<Shop> shopList = shopService.findAll();
		ActionContext.getContext().put("shopList", shopList);
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 封装到对象中（model为实体，使用model，甚至未封装的属性）
		model.setRole(roleService.getById(roleId));
		model.setShop(shopService.getById(shopId));
		// 加密密码字符串
		String md5Digest = DigestUtils.md5Hex("1");
		model.setPassword(md5Digest);
		// 保存到数据库
		userService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备数据，shop
		//String id = request.getParameter("id");
		//System.out.println(id);
		//ActionContext context = ActionContext.getContext(); 
		//String id = (String) context.get("id");
		
		String ids = ServletActionContext.getRequest().getParameter("id"); 
		
		List<Shop> shopList = shopService.findAll();
		ActionContext.getContext().put("shopList", shopList);

		// 准备回显的数据
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if (user.getShop() != null) {
			shopId = user.getShop().getId();
		}

		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中获取原对象
		User user = userService.getById(model.getId());

		// 2，设置要修改的属性
		user.setName(model.getName());
		if(roleId!=null){
			user.setRole(roleService.getById(roleId));
		}
		if(shopId!=null){
			user.setShop(shopService.getById(shopId));
		}
		
		// 3，更新到数据库
		userService.update(user);

		return "toList";
	}

	/** 密码初始化为1 */
	public String initPassWord() throws Exception {
		// 1，从数据库中获取原对象
		User user = userService.getById(model.getId());

		// 2，设置要修改的属性
		// 加密密码字符串
		String md5Digest = DigestUtils.md5Hex("1");
		user.setPassword(md5Digest);

		// 3，更新到数据库
		userService.update(user);
		return "toList";
	}

	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	/** 登录 */
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(
				model.getLoginName(), model.getPassword());
		if (user == null) {
			addFieldError("login", "用户名或密码不正确！");
			return "loginUI";
		} else {
			// 登录用户
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
	}

	/** 注销 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

	/** 修改密码页面 */
	public String pwEditUI() throws Exception {
		return "pwEditUI";
	}

	/** 修改密码 */
	public String pwEdit() throws Exception {
		User user = userService.getById(model.getId());
		String md5Digest = DigestUtils.md5Hex(model.getPassword());
		user.setPassword(md5Digest);
		userService.update(user);
		return "toIndex";
	}

	// ===getters and setters====
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
