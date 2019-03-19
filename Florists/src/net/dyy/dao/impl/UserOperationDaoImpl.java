package net.dyy.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import net.dyy.dao.UserOperationDao;
import net.dyy.entity.Users;
import net.dyy.utils.JdbcUtils;

/**
 * 用户常规操作实现类
 *
 * @author Dyy
 *
 */
public class UserOperationDaoImpl implements UserOperationDao {

	@Override
	public Users userLogin(String username, String userpwd) {
		Users user = null;

		try {
			String sql = "select * from users where user_name = ? and user_pwd = ?";

			Object[] values = { username, userpwd };

			user = JdbcUtils.getQueryRunner().query(sql, JdbcUtils.getRsHander(Users.class), values);
		} catch (SQLException e) {
			e.printStackTrace();
			return user;
		}
		return user;
	}

	@Override
	public int userUpdate(Users user) {
		StringBuffer sql = new StringBuffer();

		sql.append(" update users set ");
		sql.append(" user_name = ?, user_pwd = ?, user_sex = ?, user_address = ?, user_birth = ?, user_phone = ? ");
		sql.append(" where user_id = ? ");

		Object[] values = { user.getUserName(), user.getUserPwd(), user.getUserSex(), user.getUserAddress(),
				user.getUserBirth(), user.getUserPhone(), user.getUserId() };

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int userRegister(Users user) {
		StringBuffer sql = new StringBuffer();

		sql.append(
				" insert into users ( user_name, user_pwd, user_sex, user_address, user_birth, user_phone, user_type, user_credit ) ");
		sql.append(" values ");
		sql.append(" ( ?, ?, ?, ?, ?, ?, default, default ); ");

		Object[] values = { user.getUserName(), user.getUserPwd(), user.getUserSex(), user.getUserAddress(),
				user.getUserBirth(), user.getUserPhone() };

		try {
			return JdbcUtils.getQueryRunner().update(sql.toString(), values);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return 0;
	}

	@Override
	public int userExisted(String username) {
		String sql = "select count(*) from users where user_name = ?";

		Integer flag = null;
		try {
			flag = JdbcUtils.getQueryRunner().query(sql, new ScalarHandler<Long>(), username).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public Users loadUserById(Long id) {
		String sql = "select * from users where user_id = ?";

		Users user = null;
		try {
			user = JdbcUtils.getQueryRunner().query(sql, JdbcUtils.getRsHander(Users.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
