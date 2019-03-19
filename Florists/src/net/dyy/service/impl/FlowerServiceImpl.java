package net.dyy.service.impl;

import net.dyy.dao.FlowerDao;
import net.dyy.dao.impl.FlowerDaoImpl;
import net.dyy.dto.FlowerUserDTO;
import net.dyy.entity.Flower;
import net.dyy.service.FlowerService;
import net.dyy.utils.PageBean;

public class FlowerServiceImpl implements FlowerService {
	FlowerDao dao = new FlowerDaoImpl();

	@Override
	public PageBean<FlowerUserDTO> loadFlowerByPage(PageBean<FlowerUserDTO> pageBean) {
		try {
			pageBean = dao.loadFlowerByPage(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return pageBean;
	}

	@Override
	public Flower loadFlowerById(Long id) {
		try {
			return dao.loadFlowerById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getFlowerAmount(Long id) {
		try {
			return dao.getFlowerAmount(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateFlowerAmount(Long id, int decNum) {
		try {
			return dao.updateFlowerAmount(id, decNum);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
