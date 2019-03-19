package net.dyy.dao;


import net.dyy.entity.Type;
import net.dyy.utils.PageBean;

/**
 * 类型增删改查
 * @author Dyy
 *
 */
public interface TypeDao {
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
	 * 检测是否存在
	 * @param typeName
	 * @return
	 */
	int typeExisted(String typeName);

	/**
	 * 更新类型
	 * @param id
	 * @return
	 */
	int updateTypeById(Long id,String typeName);

}
