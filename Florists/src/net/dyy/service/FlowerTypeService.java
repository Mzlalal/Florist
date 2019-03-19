package net.dyy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.dyy.entity.FlowerType;

/**
 * 花朵类别的service类
 * @author Dyy
 *
 */
public interface FlowerTypeService {
	/**
	 *  加载所有花朵类型
	 * @param request
	 */
	void loadAllFlowerTypes(HttpServletRequest request);

	/**
	 *  ajax 加载所有花朵类型
	 * @return List<FlowerType>
	 */
	List<FlowerType> ajaxLoadAllTypes();

}
