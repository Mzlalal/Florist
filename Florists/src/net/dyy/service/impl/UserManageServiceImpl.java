package net.dyy.service.impl;

import net.dyy.dao.UserDao;
import net.dyy.dao.impl.UserDaoImpl;
import net.dyy.entity.Users;
import net.dyy.service.UserManageService;
import net.dyy.utils.PageBean;

public class UserManageServiceImpl implements UserManageService{
	UserDao dao = new UserDaoImpl();

	@Override
	public Users selectById(Long id) {
		try {
			return dao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean<Users> selectUsersByPage(PageBean<Users> pageBean) {
		try {
			return dao.selectUsersByPage(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(Users users) {
		try {
			return dao.addUser(users);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteUserById(Long id) {
		try {
			return dao.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
