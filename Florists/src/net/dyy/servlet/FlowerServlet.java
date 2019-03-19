package net.dyy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.dto.FlowerUserDTO;
import net.dyy.entity.Flower;
import net.dyy.utils.Condition;
import net.dyy.utils.PageBean;

/**
 * 花朵信息servlet
 * @author Dyy
 */
@WebServlet("/flowerServlet")
public class FlowerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 通过 id 查找花朵信息
	public Object loadFlowerById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String id = request.getParameter("id");

		// 通过 id 查找花朵信息
		Flower flower =  flowerService.loadFlowerById(Long.parseLong(id));

		// 保存花朵信息
		request.setAttribute("flower", flower);

		// 转发页面
		return request.getRequestDispatcher("pages/public/comm_detail.jsp");
	}

	// ajax分页查询花朵信息
	public void ajaxFlowerPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String currentPage = request.getParameter("currentPage");
		String typeId = request.getParameter("typeId");
		String flowerName = request.getParameter("flowerName");

		// 设置条件
		Condition condition = new Condition();
		if (typeId != null && Integer.parseInt(typeId) > 0) {
			condition.setFlowerTypeId(Integer.parseInt(typeId));
		}

		if (flowerName != null && "".equals(flowerName)) {
			condition.setFlowerName(flowerName);
		}

		// 实例化分页对象
		PageBean<FlowerUserDTO> pageBean = new PageBean<FlowerUserDTO>();

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = flowerService.loadFlowerByPage(pageBean);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(pageBean));

	}


	// 分页查询花朵信息
	public Object loadFlowerPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentPage = request.getParameter("currentPage");
		String typeId = request.getParameter("typeId");
		String flowerName = request.getParameter("flowerName");

		// 设置条件
		Condition condition = new Condition();
		if (typeId != null && Integer.parseInt(typeId) > 0) {
			condition.setFlowerTypeId(Integer.parseInt(typeId));
		}

		if (flowerName != null && "".equals(flowerName)) {
			condition.setFlowerName(flowerName);
		}

		// 实例化分页对象
		PageBean<FlowerUserDTO> pageBean = new PageBean<FlowerUserDTO>();

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		if (currentPage == null) {
			currentPage = "1";
		}

		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = flowerService.loadFlowerByPage(pageBean);

		System.out.println(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("currentPage", currentPage);
		// response 使用json 转换 传送 pageData

		return request.getRequestDispatcher("pages/public/comms.jsp");
	}

	// 分页查询花朵数量信息
	public void ajaxFlowerAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String id = request.getParameter("id");

		// 获取数量信息
		int amount = flowerService.getFlowerAmount(Long.parseLong(id));

		// response 使用 json 转换 传送 数量
		response.getWriter().println(JSON.toJSONString(amount));

	}

}
