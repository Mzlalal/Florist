package net.dyy.dao;

import java.util.List;

import net.dyy.entity.FlowerType;

/**
 * 花朵类别的dao类
 * @author Dyy
 *
 */
public interface FlowerTypeDao {
	/**
	 * 查询所有花朵类别
	 * @return
	 */
	List<FlowerType> loadAllFlowerTypes();

}

