package net.dyy.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.dto.OrderDetailFlowerDTO;
import net.dyy.servlet.BaseServlet;
import net.dyy.utils.Condition;
import net.dyy.utils.PageBean;
import net.dyy.utils.StringUtil;

/*
 * 订单管理
 */
@WebServlet("/orderMange")
public class OrderManageServlet extends BaseServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 3574274413865320110L;

	/**
	 * 查询订单分页
	 */
	public void  loadAllOrdersByPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数
		String currentPage = request.getParameter("currentPage");
		String orderId = request.getParameter("orderId");
		String orderName = request.getParameter("orderName");

		if (currentPage == "" || currentPage == null){
			currentPage = "1";
		}

		// 设置条件
		Condition condition = new Condition();
		if (orderId != null && orderId!= "" && Integer.parseInt(orderId) > 0) {
			condition.setOrderId(Integer.parseInt(orderId));
		}

		if (orderName != null && !"".equals(orderName)) {
			condition.setOrderName(orderName);
		}

		// 实例化分页对象
		PageBean<OrderDetailFlowerDTO> pageBean = new PageBean<OrderDetailFlowerDTO>();
		pageBean.setPageCount(10);

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = orderService.loadOrderByPage(pageBean);

		request.setAttribute("currentPage", pageBean.getCurrentPage());
		request.setAttribute("totalPage", pageBean.getTotalPage());
		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(pageBean));
	}

	/**
	 * 删除订单
	 */
	public void deleteOrderById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取参数
		String orderId = request.getParameter("id");

		if (StringUtil.isEmpty(orderId)) {
			// response 使用json 转换 传送 pageBean
			response.getWriter().println("ID为空!");
		}

		response.getWriter().println(orderService.deleteOrderById(orderId));
	}

	/**
	 * 修改订单
	 */
	public void updateOrderById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取参数
		String orderId = request.getParameter("orderId");
		String phone = request.getParameter("finalPhone");
		String address = request.getParameter("finalAddress");

		if (StringUtil.isEmpty(orderId)) {
			// response 使用json 转换 传送 pageBean
			response.getWriter().println("ID为空!");
		}

		response.getWriter().println(orderService.updateOrderById(orderId, phone, address));
	}

	// 通过ID查询订单收货电话 收货地址
	public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取参数
		String orderId = request.getParameter("id");

		// 返回结果
		response.getWriter().println(JSON.toJSONString(orderService.selectById(orderId)));
	}
}
