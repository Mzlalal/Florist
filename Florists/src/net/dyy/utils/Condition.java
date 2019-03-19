package net.dyy.utils;

/**
 * 封装条件
 *
 * @author Mzlalal
 *
 */
public class Condition {

	// 花的类别
	private long flowerTypeId;
	// 花的名称
	private String flowerName;
	// 用户id
	private long userId;
	// 用户名
	private String userName;
	// 订单id
	private long orderId;
	// 订单名
	private String orderName;
	// 花朵类别
	private long typeId;
	// 花朵类别名
	private String typeName;


	public long getFlowerTypeId() {
		return flowerTypeId;
	}
	public void setFlowerTypeId(long flowerTypeId) {
		this.flowerTypeId = flowerTypeId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Condition [flowerTypeId=" + flowerTypeId + ", flowerName=" + flowerName + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long i) {
		this.typeId = i;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
