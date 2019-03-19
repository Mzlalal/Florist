package net.dyy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.entity.Orders;
import net.dyy.utils.Condition;
import net.dyy.utils.PageBean;
import net.dyy.utils.WebUtils;

/**
 * 订单 servlet
 */
@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// ajax分页查询订单信息
	public void ajaxOrderPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String currentPage = request.getParameter("currentPage");

		// 设置条件
		Condition condition = new Condition();

		try {
			condition.setUserId(WebUtils.getUser(request).getUserId());
		} catch (NullPointerException e) {
			// 未登录  返回登录
			response.getWriter().println("login");
			return;
		}

		// 实例化分页对象
		PageBean<Orders> pageBean = new PageBean<Orders>();

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = orderService.loadOrderByPage(pageBean);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(pageBean));
	}

	// ajax 生成订单
	public void ajaxCreateOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (WebUtils.getUser(request) == null) {
			// 返回登录
			response.getWriter().println("login");
			return;
		}

		// 获取参数
		String orderTitle = request.getParameter("orderTitle");
		String orderDate = request.getParameter("orderDate");
		String orderType = request.getParameter("orderType");
		String[] ids = request.getParameterValues("flowerId");

		int flowerAmount = Integer.parseInt(request.getParameter("amount"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		long orderId = 0;

		for (String temp : ids) {
			long flowerId = Long.parseLong(temp);

			// 获取当前库存
			int nowAmount = flowerService.getFlowerAmount(flowerId);

			if (nowAmount <  flowerAmount) {
				response.getWriter().println("库存不足");
				return;
			}

			try {
				// 获取用户id
				long userId = WebUtils.getUser(request).getUserId();

				List<Object> values = new ArrayList<Object>();

				values.add(userId);
				values.add(orderTitle);
				values.add(orderDate);
				values.add(Integer.parseInt(orderType));
				values.add(address);
				values.add(phone);

				orderId = orderService.createOrder(values);

				if (orderId > 0) {
					// 创建订单
					orderDetailService.createOrederDetail(orderId, flowerId, flowerAmount);

					// 更新花朵数量
					flowerService.updateFlowerAmount(flowerId, flowerAmount);
				}
			}catch (Exception e) {
				e.getStackTrace();
				return;
			}
		}

		response.getWriter().println(orderId);

	}
}
