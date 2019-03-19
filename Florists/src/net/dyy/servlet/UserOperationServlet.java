package net.dyy.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.alibaba.fastjson.JSON;

import net.dyy.entity.Users;

/**
 * 用户常规操作servlet 用户登录 用户注销 用户修改信息
 *
 * @author Dyy
 *
 */
@WebServlet("/userOperationServlet")
public class UserOperationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 用户登录
	public Object userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数信息
		String username = request.getParameter("username");
		String userpwd = request.getParameter("password");
		String bakeUrl = request.getParameter("bakeUrl");
		String rand = (String) request.getSession().getAttribute("rand");
		String code = request.getParameter("code");

		request.setAttribute("username", username);
		request.setAttribute("bakeUrl", bakeUrl);

		// 用户对象
		Users user = null;

		if (!rand.equals(code)) {
			request.setAttribute("msg", "验证码错误");
			return request.getRequestDispatcher("/login");
		} else {
			user = userOperationService.userLogin(username, userpwd, request);
		}

		// 如果用户不等于空  返回首页
		if (user != null) {
			return bakeUrl;
		}

		return request.getRequestDispatcher("/login");
	}

	// 用户退出登录
	public Object userLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().removeAttribute("user");

		return "/index";
	}

	// 用户注册
	public Object userRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数信息
		Users user = new Users();
		user.setUserName(request.getParameter("username"));
		user.setUserPwd(request.getParameter("password"));
		user.setUserSex(Integer.parseInt(request.getParameter("sex")));
		user.setUserBirth(request.getParameter("birth"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhone(request.getParameter("phone"));

		System.out.println(user);

		// 用户注册
		int flag = userOperationService.userRegister(user);

		// 调用登录方法
		if (flag > 0) {
			userOperationService.userLogin(user.getUserName(), user.getUserPwd(),request);
		}

		return request.getRequestDispatcher("/index");
	}

	// 商家注册
	public Object sellerRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数信息
		Users user = new Users();
		user.setUserName(request.getParameter("username"));
		user.setUserPwd(request.getParameter("password"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhone(request.getParameter("phone"));

		System.out.println(user);

		// 商家注册
		//		int flag = userOperationService.userRegister(user);

		// 调用登录方法
		//		if (flag > 0) {
		//			userOperationService.userLogin(user.getUserName(), user.getUserPwd(),request);
		//		}

		return request.getRequestDispatcher("/index");
	}

	// 判断用户是否存在
	public Object userExisted(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数
		String username = request.getParameter("username");

		// 判断用户是否存在  1 存在   0 不存在
		int flag = userOperationService.userExisted(username);

		if (flag > 0) {
			response.getWriter().print("error");
		}else {
			response.getWriter().print("success");
		}

		return response;
	}

	// 用户更新信息
	public Object userUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取参数信息
		Users user = new Users();
		user.setUserId(Long.parseLong(request.getParameter("userId")));
		user.setUserName(request.getParameter("username"));
		user.setUserPwd(request.getParameter("password"));
		user.setUserSex(Integer.parseInt(request.getParameter("sex")));
		user.setUserBirth(request.getParameter("birth"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhone(request.getParameter("phone"));

		int flag = userOperationService.userUpdate(user,request);

		String returnValue = "";

		// 1 更新成功 0 更新失败
		if (flag > 0) {
			returnValue="success";
		}else {
			returnValue="error";
		}

		return request.getRequestDispatcher(returnValue);
	}

	// 上传图片
	public void uploadImgs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 实例化上传组件
		ServletFileUpload upload = new ServletFileUpload();

		// 设置上传文件编码
		upload.setHeaderEncoding("utf-8");

		// 使用hashMap 接收数据
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			// 实例化 表单项迭代器
			FileItemIterator iterator = upload.getItemIterator(request);

			// 当 表单条目 有下一条时候
			while (iterator.hasNext()) {
				// 将下一条赋值 给 文件项
				FileItemStream fileItemStream = iterator.next();
				// 打开流 复制给输入流
				InputStream inputStream = fileItemStream.openStream();

				// 如果文件项是表单普通项目 则返回true 若不是普通项目 则返回false
				// 普通项目 使用 getFieldName 获取值 文件项目使用 getName 获取值
				if (fileItemStream.isFormField()) {
					map.put(fileItemStream.getFieldName(), Streams.asString(inputStream,"utf-8"));
				}
				else {
					map.put("imgAdress", fileItemStream.getName());
					// 获取 news 项目真实路径
					String imgPath = request.getSession().getServletContext().getRealPath("layui\\images\\seller");

					// 图片保存路径
					imgPath += "/"+fileItemStream.getName();

					// 输出图片
					FileOutputStream fileOutputStream = new FileOutputStream(imgPath);

					// 缓冲区
					byte[] buffer = new byte[1024];

					// 偏差值
					int length = 0;

					while ((length = inputStream.read(buffer)) > 0) {
						// 输出
						fileOutputStream.write(buffer, 0, length);
					}
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// 获取参数
		System.out.println(map.get("imgAdress"));

		// 实例化 dao 类
		response.getWriter().print(JSON.toJSONString(map));

	}
}

