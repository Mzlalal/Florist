package net.dyy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.dto.ShopCartDTO;
import net.dyy.utils.Condition;
import net.dyy.utils.PageBean;
import net.dyy.utils.WebUtils;

/**
 * 购物车
 * @author Dyy
 */
@WebServlet("/shopCartServlet")
public class ShopCartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// ajax 添加到购物车
	public void ajaxAddToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String id = request.getParameter("id");
		String text = request.getParameter("text");

		// 获取用户 id
		Long userId = WebUtils.getUser(request).getUserId();

		// 返回状态
		int flag = shopCartService.isShopCartExisted(userId, Long.parseLong(id), Integer.parseInt(text));

		response.getWriter().print(flag);
	}

	// ajax分页购物车信息
	public void ajaxShopCartPage(HttpServletRequest request, HttpServletResponse response)
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
		PageBean<ShopCartDTO> pageBean = new PageBean<ShopCartDTO>();

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = shopCartService.loadShopCartById(pageBean);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(pageBean));
	}

	// ajax删除购物车花朵信息
	public void ajaxDeleteShopCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取参数
		Long flowerId = Long.parseLong(request.getParameter("id"));
		Long userId = 0L;
		try {
			userId = WebUtils.getUser(request).getUserId();
		} catch (NullPointerException e) {
			// 未登录  返回登录
			response.getWriter().println("login");
			return;
		}

		// 返回结果
		response.getWriter().println(shopCartService.deleteShopCart(userId, flowerId));
	}

	// ajax查询购物车花朵数量信息
	public void ajaxShopCartNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取参数
		Long flowerId = Long.parseLong(request.getParameter("id"));
		int value = 0;
		try {
			Long userId = WebUtils.getUser(request).getUserId();
			value = shopCartService.loadShopCartNumByid(userId, flowerId);
		} catch (NullPointerException e) {
			response.getWriter().println("");
			return;
		}

		// 返回结果
		response.getWriter().println(value);
	}
}
