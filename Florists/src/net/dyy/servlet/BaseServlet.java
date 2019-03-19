package net.dyy.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dyy.service.FlowerService;
import net.dyy.service.FlowerTypeService;
import net.dyy.service.OrderDetailService;
import net.dyy.service.OrderManageService;
import net.dyy.service.OrderService;
import net.dyy.service.SellerManageService;
import net.dyy.service.ShopCartService;
import net.dyy.service.TypeService;
import net.dyy.service.UserManageService;
import net.dyy.service.UserOperationService;
import net.dyy.service.impl.FlowerServiceImpl;
import net.dyy.service.impl.FlowerTypeServiceImpl;
import net.dyy.service.impl.OrderDetailServiceImpl;
import net.dyy.service.impl.OrderManageServiceImpl;
import net.dyy.service.impl.OrderServiceImpl;
import net.dyy.service.impl.SellerManageServiceImpl;
import net.dyy.service.impl.ShopCartServiceImpl;
import net.dyy.service.impl.TypeServiceImpl;
import net.dyy.service.impl.UserManageServiceImpl;
import net.dyy.service.impl.UserOperationServiceImpl;
import net.dyy.utils.WebUtils;



/**
 * 项目中通用的Servlet，希望所有的servlet都继承此类
 * baseServlet 中 使用反射技术 调用子类的方法
 * @author Dyy
 *
 */
public abstract class BaseServlet extends HttpServlet {

	// 创建Service
	protected UserOperationService userOperationService = new UserOperationServiceImpl();
	protected FlowerTypeService flowerTypeService = new FlowerTypeServiceImpl();
	protected FlowerService flowerService = new FlowerServiceImpl();
	protected ShopCartService shopCartService = new ShopCartServiceImpl();
	protected OrderService orderService = new OrderServiceImpl();
	protected OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	protected UserManageService userManageService = new UserManageServiceImpl();
	protected SellerManageService sellerManageService = new SellerManageServiceImpl();
	protected OrderManageService orderManageService = new OrderManageServiceImpl();
	protected TypeService typeService = new TypeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// (保存跳转的资源)  方法返回值
		Object returnValue = null;

		// 获取操作类型;  【约定 > 俗成： 操作类型的值，必须对应servlet中的方法名称】
		String methodName = request.getParameter("method");  // listTable

		try {
			// 1. 获取当前运行类的字节码
			Class clazz = this.getClass();
			// 2. 获取当前执行的方法的Method类型
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			// 3. 执行方法
			returnValue = method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "找不到页面!");
			returnValue = "/error";
		}

		// 跳转
		WebUtils.goTo(request, response, returnValue);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
