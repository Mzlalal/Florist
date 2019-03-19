package net.dyy.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.dyy.dao.FlowerTypeDao;
import net.dyy.dao.impl.FlowerTypeDaoImpl;
import net.dyy.entity.FlowerType;
import net.dyy.service.FlowerTypeService;

public class FlowerTypeServiceImpl implements FlowerTypeService{

	FlowerTypeDao dao = new FlowerTypeDaoImpl();

	@Override
	public void loadAllFlowerTypes(HttpServletRequest request) {
		try {
			List<FlowerType> list = dao.loadAllFlowerTypes();

			request.setAttribute("flower_types", list);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FlowerType> ajaxLoadAllTypes() {
		try {
			return dao.loadAllFlowerTypes();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
