package net.dyy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dyy.dto.OrderDetailFlowerDTO;

/**
 * 订单 servlet
 */
@WebServlet("/orderDetailServlet")
public class OrderDetailServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 通过 id 查询订单详情
	public Object loadOrderDetailById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String id = request.getParameter("id");

		List<OrderDetailFlowerDTO> list = orderDetailService.loadOrderDetailById(Long.parseLong(id));

		request.setAttribute("detailInfo", list);

		return request.getRequestDispatcher("pages/user/myOrderDetail.jsp");
	}
}
