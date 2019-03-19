package net.dyy.dao;

import net.dyy.dto.FlowerUserDTO;
import net.dyy.entity.Flower;
import net.dyy.utils.PageBean;

/**
 * 花朵类别的dao类
 *
 * @author Dyy
 *
 */
public interface FlowerDao {

	/**
	 * 通过id查询花朵信息
	 * @param id
	 * @return Flower
	 */
	Flower loadFlowerById(Long id);

	/**
	 *  通过id 查询花朵数量
	 * @param id
	 * @return int花朵数量
	 */
	int getFlowerAmount(Long id);

	/**
	 * 分页查询花朵信息
	 * @param pageBean
	 * @return pageBean
	 */
	PageBean<FlowerUserDTO> loadFlowerByPage(PageBean<FlowerUserDTO> pageBean);

	/**
	 *  获取当前花朵表总行数
	 * @param pb
	 * @return int花朵总页数
	 */
	int getTotalCount(PageBean pb);

	/**
	 * 通过花朵id 删除花朵
	 * @param id
	 * @return 0 失败 1 成功
	 */
	int deleteFlowerById(Long id);

	/**
	 * 通过花朵id 更新花朵库存
	 * @param id decNum 减少的数量
	 * @return 0 失败 1 成功
	 */
	int updateFlowerAmount(Long id, int decNum);
}
