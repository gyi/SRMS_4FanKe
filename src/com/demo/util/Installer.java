package com.demo.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.domain.Privilege;
import com.demo.domain.Role;
import com.demo.domain.User;

@Component
public class Installer {

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 执行安装
	 */
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();

		// ==============================================================
		// 保存权限数据
		System.out.println("开始保存权限数据");
		Privilege menu, menu1, menu2, menu3, menu4;

		menu = new Privilege((long) 0, "系统管理", null, null);
		menu1 = new Privilege((long) 1, "店铺管理", "/shop_list", menu);
		menu2 = new Privilege((long) 2, "货物管理", "/good_list", menu);
		menu3 = new Privilege((long) 3, "用户管理", "/user_list", menu);
		menu4 = new Privilege((long) 4, "销售记录管理", "/rec_list", menu);
		// menu5 = new Privilege((long)5,"角色权限管理", "/role_list", menu);
		session.saveOrUpdate(menu);
		session.saveOrUpdate(menu1);
		session.saveOrUpdate(menu2);
		session.saveOrUpdate(menu3);
		session.saveOrUpdate(menu4);
		// session.saveOrUpdate(menu5);

		session.saveOrUpdate(new Privilege((long) 11, "店铺列表", "/shop_list", menu1));
		session.saveOrUpdate(new Privilege((long) 12, "店铺删除", "/shop_delete", menu1));
		session.saveOrUpdate(new Privilege((long) 13, "店铺添加", "/shop_add", menu1));
		session.saveOrUpdate(new Privilege((long) 14, "店铺修改", "/shop_edit", menu1));

		session.saveOrUpdate(new Privilege((long) 21, "货物列表", "/good_list", menu2));
		session.saveOrUpdate(new Privilege((long) 22, "货物删除", "/good_delete", menu2));
		session.saveOrUpdate(new Privilege((long) 23, "货物添加", "/good_add", menu2));
		session.saveOrUpdate(new Privilege((long) 24, "货物修改", "/good_edit", menu2));

		session.saveOrUpdate(new Privilege((long) 31, "用户列表", "/user_list", menu3));
		session.saveOrUpdate(new Privilege((long) 32, "用户删除", "/user_delete", menu3));
		session.saveOrUpdate(new Privilege((long) 33, "用户添加", "/user_add", menu3));
		session.saveOrUpdate(new Privilege((long) 34, "用户修改", "/user_edit", menu3));
		session.saveOrUpdate(new Privilege((long) 35, "修改密码", "/user_editPassword",
				menu3));
		session.saveOrUpdate(new Privilege((long) 36, "初始化密码", "/user_initPassword",
				menu3));

		session.saveOrUpdate(new Privilege((long) 41, "记录列表", "/rec_list", menu4));
		session.saveOrUpdate(new Privilege((long) 42, "记录删除", "/rec_delete", menu4));
		session.saveOrUpdate(new Privilege((long) 43, "记录录入", "/rec_add", menu4));
		session.saveOrUpdate(new Privilege((long) 44, "记录导入", "/rec_import", menu4));
		session.saveOrUpdate(new Privilege((long) 45, "记录导出", "/rec_export", menu4));
		session.saveOrUpdate(new Privilege((long) 46, "记录汇总", "/rec_sum", menu4));
		System.out.println("保存权限数据完毕");
		
		// ==============================================================
		// 保存角色数据
		// 设置管理员权限
		System.out.println("-----------1-----------");
		List<Privilege> adminPrivileges=new ArrayList();
		adminPrivileges=(List<Privilege>)session.createQuery("from Privilege").list();
		Set<Privilege> adminPrivileges2=new HashSet();
		for(Privilege privilege:adminPrivileges){
			adminPrivileges2.add(privilege);
		}
		System.out.println("-----------2-----------");
		Role admin = new Role();
		admin.setName("管理员");
		admin.setPrivileges(adminPrivileges2);
		admin.setId((long) 1);
		session.saveOrUpdate(admin);

		// ==============================================================
		// 保存超级管理员用户
		System.out.println("开始保存超级管理员用户");
		User userOri=(User)session.get(User.class, (long)1);
		if(userOri==null){
			User user = new User();
			//user.setId((long) 1);
			user.setLoginName("sadmin");
			user.setName("超级管理员");
			user.setPassword(DigestUtils.md5Hex("1"));
			//user.setRole(admin);
			session.saveOrUpdate(user); // 保存
		}
		System.out.println("保存超级管理员用户完毕");
		
		// 设置收银员权限
		System.out.println("-----------3-----------");
		Set<Privilege> staffPrivileges=new HashSet();
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)0));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)2 ));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)4));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)21));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)22));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)23));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)24));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)41));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)42));
		staffPrivileges.add((Privilege)session.get(Privilege.class,(long)43));
		System.out.println("-----------4-----------");
		Role staff = new Role();
		staff.setName("收银员");
		staff.setPrivileges(staffPrivileges);
		staff.setId((long) 2);
		session.saveOrUpdate(staff);
		System.out.println("-----------5-----------");
		// --------------------
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
		System.out.println("sdfsdfdsfdsf");
	}
}