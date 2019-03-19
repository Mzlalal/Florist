package net.dyy.service.impl;

import net.dyy.dao.SellerDao;
import net.dyy.dao.impl.SellerDaoImpl;
import net.dyy.entity.Users;
import net.dyy.service.SellerManageService;
import net.dyy.utils.PageBean;

public class SellerManageServiceImpl implements SellerManageService{
	SellerDao dao = new SellerDaoImpl();

	@Override
	public Users selectSellerById(Long id) {
		try {
			return dao.selectSellerById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean<Users> selectSellerByPage(PageBean<Users> pageBean) {
		try {
			return dao.selectSellerByPage(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addSeller(Users users) {
		try {
			return dao.addSeller(users);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteSellerById(Long id) {
		try {
			return dao.deleteSellerById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
