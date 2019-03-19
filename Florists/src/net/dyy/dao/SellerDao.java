package net.dyy.dao;


import net.dyy.entity.Users;
import net.dyy.utils.PageBean;

/**
 * 用户增删改查
 * @author Dyy
 *
 */
public interface SellerDao {
	/**
	 * 根据id查找用户
	 * @param id
	 * @return Users
	 */
	Users selectSellerById(Long id);

	/**
	 * 分页查询用户
	 * @param id
	 * @return Users
	 */
	PageBean<Users> selectSellerByPage(PageBean<Users> pageBean);

	/**
	 * 添加用户
	 * @param users
	 * @return
	 */
	int addSeller(Users users);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteSellerById(Long id);
}
