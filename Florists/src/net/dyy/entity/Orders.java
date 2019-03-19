package net.dyy.entity;

public class Orders {

	private long orderId;
	private long userId;
	private String orderTitle;
	private String orderDate;
	private int orderType;
	private String finalAddress;
	private String finalPhone;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getFinalAddress() {
		return finalAddress;
	}

	public void setFinalAddress(String finalAddress) {
		this.finalAddress = finalAddress;
	}

	public String getFinalPhone() {
		return finalPhone;
	}

	public void setFinalPhone(String finalPhone) {
		this.finalPhone = finalPhone;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", orderTitle=" + orderTitle + ", orderDate="
				+ orderDate + ", orderType=" + orderType + ", finalAddress=" + finalAddress + ", finalPhone="
				+ finalPhone + "]";
	}

}
