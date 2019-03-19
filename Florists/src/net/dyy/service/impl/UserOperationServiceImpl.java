package net.dyy.service.impl;

import javax.servlet.http.HttpServletRequest;

import net.dyy.dao.UserOperationDao;
import net.dyy.dao.impl.UserOperationDaoImpl;
import net.dyy.entity.Users;
import net.dyy.service.UserOperationService;

public class UserOperationServiceImpl implements UserOperationService{

	UserOperationDao dao = new UserOperationDaoImpl();

	@Override
	public Users userLogin(String username, String userpwd,HttpServletRequest request) {
		try {
			Users user = dao.userLogin(username, userpwd);
			// 保存用户信息
			request.getSession().setAttribute("user", user);
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int userRegister(Users user) {
		try {
			return dao.userRegister(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int userExisted(String username) {
		try {
			return dao.userExisted(username);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int userUpdate(Users user,HttpServletRequest request) {
		try {
			int flag = dao.userUpdate(user);
			// 更新用户数据
			if (flag > 0) {
				request.getSession().setAttribute("user", dao.loadUserById(user.getUserId()));;
			}
			return flag;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Users loadUserById(Long id) {
		try {
			return dao.loadUserById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
