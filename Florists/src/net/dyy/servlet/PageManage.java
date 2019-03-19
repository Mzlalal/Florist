package net.dyy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共页面管理
 *
 * @author Dyy
 *
 */
@WebServlet(urlPatterns = { "/index", "/main", "/login", "/error", "/success", "/register", "/update",
		"/sellerRegister", "/myShopCart", "/myOrder", "/mainWelcome", "/userManage","/addUser","/updateUser",
		"/sellerManage","/addSeller","/updateSeller","/orderManage","/updateOrder","/typeManage","/updateType","/addType" })
public class PageManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		switch (path) {
		// 首页
		case "/index":
			request.getRequestDispatcher("pages/user/index.jsp").forward(request, response);
			break;
			// 登录
		case "/login":
			request.getRequestDispatcher("pages/public/login.jsp").forward(request, response);
			break;
			// 注册
		case "/register":
			request.getRequestDispatcher("pages/public/register.jsp").forward(request, response);
			break;
			// 商家注册
		case "/sellerRegister":
			request.getRequestDispatcher("pages/seller/sellerRegister.jsp").forward(request, response);
			break;
			// 订单
		case "/myOrder":
			request.getRequestDispatcher("pages/user/myOrder.jsp").forward(request, response);
			break;
			// 购物车
		case "/myShopCart":
			request.getRequestDispatcher("pages/public/shopCart.jsp").forward(request, response);
			break;
			// 更新
		case "/update":
			request.getRequestDispatcher("pages/user/update.jsp").forward(request, response);
			break;
			// 错误
		case "/error":
			request.getRequestDispatcher("pages/util/error.jsp").forward(request, response);
			break;
			// 成功
		case "/success":
			request.getRequestDispatcher("pages/util/success.jsp").forward(request, response);
			break;
			// 后台首页
		case "/main":
			request.getRequestDispatcher("pages/admin/main.jsp").forward(request, response);
			break;
			// 成功
		case "/mainWelcome":
			request.getRequestDispatcher("pages/admin/mainWelcome.jsp").forward(request, response);
			break;
			// 添加用户
		case "/addUser":
			request.getRequestDispatcher("pages/admin/user/addUser.jsp").forward(request, response);
			break;
			// 修改用户
		case "/updateUser":
			request.getRequestDispatcher("pages/admin/user/updateUser.jsp").forward(request, response);
			break;
			// 用户管理
		case "/userManage":
			request.getRequestDispatcher("pages/admin/user/userManage.jsp").forward(request, response);
			break;
			// 添加商家
		case "/addSeller":
			request.getRequestDispatcher("pages/admin/seller/addSeller.jsp").forward(request, response);
			break;
			// 修改商家
		case "/updateSeller":
			request.getRequestDispatcher("pages/admin/seller/updateSeller.jsp").forward(request, response);
			break;
			// 商家管理
		case "/sellerManage":
			request.getRequestDispatcher("pages/admin/seller/sellerManage.jsp").forward(request, response);
			break;
			// 修改订单
		case "/updateOrder":
			request.getRequestDispatcher("pages/admin/order/updateOrder.jsp").forward(request, response);
			break;
			// 订单管理
		case "/orderManage":
			request.getRequestDispatcher("pages/admin/order/orderManage.jsp").forward(request, response);
			break;
			// 类别管理
		case "/typeManage":
			request.getRequestDispatcher("pages/admin/type/typeManage.jsp").forward(request, response);
			break;
			// 修改类别
		case "/updateType":
			request.getRequestDispatcher("pages/admin/type/updateType.jsp").forward(request, response);
			break;
			// 添加类别
		case "/addType":
			request.getRequestDispatcher("pages/admin/type/addType.jsp").forward(request, response);
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
