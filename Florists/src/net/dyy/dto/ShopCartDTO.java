package net.dyy.dto;

public class ShopCartDTO {
	private long userId;
	private String userName;
	private long flowerId;
	private String flowerName;
	private String flowerCover;
	private long carAmount;
	private long flowerAmount;
	private long flowerPrice;
	private String flowerDesc;

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

	public long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(long flowerId) {
		this.flowerId = flowerId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public long getCarAmount() {
		return carAmount;
	}

	public void setCarAmount(long carAmount) {
		this.carAmount = carAmount;
	}

	public long getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerPrice(long flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public String getFlowerDesc() {
		return flowerDesc;
	}

	public void setFlowerDesc(String flowerDesc) {
		this.flowerDesc = flowerDesc;
	}

	public long getFlowerAmount() {
		return flowerAmount;
	}

	public void setFlowerAmount(long flowerAmount) {
		this.flowerAmount = flowerAmount;
	}

	@Override
	public String toString() {
		return "ShopCartDTO [userId=" + userId + ", userName=" + userName + ", flowerId=" + flowerId + ", flowerName="
				+ flowerName + ", flowerCover=" + flowerCover + ", carAmount=" + carAmount + ", flowerAmount="
				+ flowerAmount + ", flowerPrice=" + flowerPrice + ", flowerDesc=" + flowerDesc + "]";
	}

	public String getFlowerCover() {
		return flowerCover;
	}

	public void setFlowerCover(String flowerCover) {
		this.flowerCover = flowerCover;
	}

}
