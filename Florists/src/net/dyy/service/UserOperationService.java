package net.dyy.service;

import javax.servlet.http.HttpServletRequest;

import net.dyy.entity.Users;

/**
 * 用户常规操作
 * @author Dyy
 *
 */
public interface UserOperationService {
	/**
	 * 用户登录
	 * @param username
	 * @param userpwd
	 * @return Users对象
	 */
	Users userLogin(String username , String userpwd , HttpServletRequest request);

	/**
	 * 用户注册
	 * @param user
	 * @return 0 失败 1 成功
	 */
	int userRegister(Users user);

	/**
	 * 用户登录
	 * @param username
	 * @return Users对象
	 */
	int userExisted(String username);

	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	Users loadUserById(Long id);

	/**
	 * 更新用户信息
	 * @param user
	 * @return 0 失败 1 成功
	 */
	int userUpdate(Users user,HttpServletRequest request);
}
