package net.dyy.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.entity.Users;
import net.dyy.servlet.BaseServlet;
import net.dyy.utils.Condition;
import net.dyy.utils.PageBean;
import net.dyy.utils.WebUtils;

@WebServlet("/sellerMange")
public class SellerManageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void  loadAllSellerByPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数
		String currentPage = request.getParameter("currentPage");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");

		if (currentPage == "" || currentPage == null){
			currentPage = "1";
		}

		// 设置条件
		Condition condition = new Condition();
		if (userId != null && userId!= "" && WebUtils.isNumeric(userId)) {
			condition.setUserId(Integer.parseInt(userId));
		}

		if (userName != null && !"".equals(userName)) {
			condition.setUserName(userName);
		}

		// 实例化分页对象
		PageBean<Users> pageBean = new PageBean<Users>();
		pageBean.setPageCount(10);

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = sellerManageService.selectSellerByPage(pageBean);

		request.setAttribute("currentPage", pageBean.getCurrentPage());
		request.setAttribute("totalPage", pageBean.getTotalPage());
		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(pageBean));
	}

	// 添加商家
	public void selectSellerById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		Long id = Long.parseLong(request.getParameter("id"));

		// 商家查询
		Users user = sellerManageService.selectSellerById(id);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(user));
	}

	// 添加商家
	public void addSeller(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		Users user = new Users();
		user.setUserName(request.getParameter("username"));
		user.setUserPwd(request.getParameter("password"));
		user.setUserSex(Integer.parseInt(request.getParameter("sex")));
		user.setUserBirth(request.getParameter("birth"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhone(request.getParameter("phone"));

		System.out.println(user);

		// 商家注册
		int flag = sellerManageService.addSeller(user);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(flag);
	}

	// 删除商家
	public void deleteSellerById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		String userId = request.getParameter("id");

		// 商家删除
		int flag = sellerManageService.deleteSellerById(Long.parseLong(userId));

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(flag);
	}


}
