package net.dyy.admin;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.dyy.entity.Type;
import net.dyy.servlet.BaseServlet;
import net.dyy.utils.Condition;
import net.dyy.utils.PageBean;
import net.dyy.utils.WebUtils;

@WebServlet("/typeMange")
public class TypeMangeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void  loadAllTypeByPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数
		String currentPage = request.getParameter("currentPage");
		String typeId = request.getParameter("typeId");
		String typeName = request.getParameter("typeName");

		if (currentPage == "" || currentPage == null){
			currentPage = "1";
		}

		// 设置条件
		Condition condition = new Condition();

		if (typeId != null && typeId!= "" && WebUtils.isNumeric(typeId)) {
			condition.setTypeId(Integer.parseInt(typeId));
		}

		if (typeName != null && !"".equals(typeName)) {
			condition.setTypeName(typeName);
		}

		// 实例化分页对象
		PageBean<Type> pageBean = new PageBean<Type>();
		pageBean.setPageCount(10);

		// 设置条件
		pageBean.setCondition(condition);

		// 设置当前页
		pageBean.setCurrentPage(Integer.parseInt(currentPage));

		// 获取分页数据
		pageBean = typeService.selectTypesByPage(pageBean);

		request.setAttribute("currentPage", pageBean.getCurrentPage());
		request.setAttribute("totalPage", pageBean.getTotalPage());
		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(pageBean));
	}

	// 添加类别
	public void selectTypeById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		Long id = Long.parseLong(request.getParameter("id"));

		// 类别查询
		Type type = typeService.selectById(id);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(JSON.toJSONString(type));
	}

	// 添加类别
	public void addType(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		Type type = new Type();

		type.setTypeName(request.getParameter("typeName"));

		System.out.println(type);

		// 类别注册
		int flag = typeService.addType(type);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(flag);
	}

	// 删除类别
	public void deleteTypeById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		String typeId = request.getParameter("id");

		// 类别删除
		int flag = typeService.deleteTypeById(Long.parseLong(typeId));

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(flag);
	}

	// 更逊类别
	public void updateTypeById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 获取参数信息
		String tempId = request.getParameter("id");
		String typeName = request.getParameter("typeName");

		long typeId = Long.parseLong(tempId);

		// response 使用json 转换 传送
		response.getWriter().println(typeService.updateTypeById(typeId,typeName));
	}

	/**
	 * 判断是否存在类别
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void typeExisted(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取参数
		String typeName = request.getParameter("typename");

		// 类别删除
		boolean flag = typeService.typeExisted(typeName);

		// response 使用json 转换 传送 pageBean
		response.getWriter().println(flag);
	}

}
