package net.dyy.service.impl;

import net.dyy.dao.TypeDao;
import net.dyy.dao.impl.TypeDaoImpl;
import net.dyy.entity.Type;
import net.dyy.service.TypeService;
import net.dyy.utils.PageBean;

public class TypeServiceImpl implements TypeService {

	TypeDao dao = new TypeDaoImpl();

	@Override
	public Type selectById(Long id) {
		try {
			dao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Type> selectTypesByPage(PageBean<Type> pageBean) {
		try {
			dao.selectTypesByPage(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addType(Type type) {
		try {
			return dao.addType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteTypeById(Long id) {
		try {
			return dao.deleteTypeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean typeExisted(String typeName) {
		try {
			return dao.typeExisted(typeName) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTypeById(Long id, String typeName) {
		try {
			return dao.updateTypeById(id, typeName) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
