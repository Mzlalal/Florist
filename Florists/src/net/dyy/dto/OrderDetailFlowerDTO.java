package net.dyy.dto;

/**
 * 订单详情花朵信息DTO
 *
 * @author Dyy
 *
 */
public class OrderDetailFlowerDTO {
	private long userId;
	private String userName;
	private long orderId;
	private long flowerId;
	private String orderDate;
	private int orderAmount;
	private String flowerName;
	private int flowerPrice;
	private String flowerCover;
	private String flowerDesc;
	private long sellerId;
	private String sellerName;
	private String orderTitle;
	private String finalAddress;
	private String finalPhone;

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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public int getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerPrice(int flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public String getFlowerCover() {
		return flowerCover;
	}

	public void setFlowerCover(String flowerCover) {
		this.flowerCover = flowerCover;
	}

	public String getFlowerDesc() {
		return flowerDesc;
	}

	public void setFlowerDesc(String flowerDesc) {
		this.flowerDesc = flowerDesc;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(long flowerId) {
		this.flowerId = flowerId;
	}

	@Override
	public String toString() {
		return "OrderDetailFlowerDTO [userId=" + userId + ", userName=" + userName + ", orderId=" + orderId
				+ ", flowerId=" + flowerId + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount
				+ ", flowerName=" + flowerName + ", flowerPrice=" + flowerPrice + ", flowerCover=" + flowerCover
				+ ", flowerDesc=" + flowerDesc + ", sellerId=" + sellerId + ", sellerName=" + sellerName
				+ ", orderTitle=" + orderTitle + ", finalAddress=" + finalAddress + ", finalPhone=" + finalPhone + "]";
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
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
}
