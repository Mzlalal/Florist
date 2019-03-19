package net.dyy.dao;


import net.dyy.entity.Users;
import net.dyy.utils.PageBean;

/**
 * 用户增删改查
 * @author Dyy
 *
 */
public interface UserDao {
	/**
	 * 根据id查找用户
	 * @param id
	 * @return Users
	 */
	Users selectById(Long id);

	/**
	 * 分页查询用户
	 * @param id
	 * @return Users
	 */
	PageBean<Users> selectUsersByPage(PageBean<Users> pageBean);

	/**
	 * 添加用户
	 * @param users
	 * @return int
	 */
	int addUser(Users users);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteUserById(Long id);

}
