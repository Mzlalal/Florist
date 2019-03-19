package net.dyy.service;


import net.dyy.entity.Type;
import net.dyy.utils.PageBean;

/**
 * 类型增删改查
 * @author Dyy
 *
 */
public interface TypeService {
	/**
	 * 根据id查找类型
	 * @param id
	 * @return Types
	 */
	Type selectById(Long id);

	/**
	 * 分页查询类型
	 * @param id
	 * @return Types
	 */
	PageBean<Type> selectTypesByPage(PageBean<Type> pageBean);

	/**
	 * 添加类型
	 * @param type
	 * @return int
	 */
	int addType(Type type);

	/**
	 * 删除类型
	 * @param id
	 * @return
	 */
	int deleteTypeById(Long id);

	/**
	 * 更新类型
	 * @param id
	 * @return
	 */
	boolean updateTypeById(Long id,String typeName);

	/**
	 * 检测是否存在
	 * @param typeName
	 * @return
	 */
	boolean typeExisted(String typeName);
}
