package net.dyy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.entity.FlowerType;

/**
 * 花朵类别servlet
 * @author Dyy
 */
@WebServlet("/flowerTypeServlet")
public class FlowerTypeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// ajax 查询花朵类别信息
	public void ajaxFlowerTypes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 加载花朵全部类型
		List<FlowerType> list =  flowerTypeService.ajaxLoadAllTypes();

		// 返回 json
		response.getWriter().println(JSON.toJSONString(list));
	}

}
