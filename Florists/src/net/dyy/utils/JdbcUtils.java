package net.dyy.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import net.dyy.framework.MyBeanProcessor;

/**
 * 数据库操作封装
 *
 * @author Mzlalal
 */
public class JdbcUtils {

	// 连接池
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * DBUtils工具类对象
	 */

	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}

	public static <T> ResultSetHandler<T> getRsHander(Class<T> clazz){
		return new BeanHandler<T>(clazz, new BasicRowProcessor(new MyBeanProcessor()));
	}

	public static <T> BeanListHandler<T> getRsListHander(Class<T> clazz){
		return new BeanListHandler<T>(clazz, new BasicRowProcessor(new MyBeanProcessor()));
	}

}
