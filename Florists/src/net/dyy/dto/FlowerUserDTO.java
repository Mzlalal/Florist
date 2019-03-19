package net.dyy.dto;

public class FlowerUserDTO {

	private long flowerId;
	private String flowerName;
	private String flowerDesc;
	private long flowerPrice;
	private long flowerAmount;
	private String flowerCover;
	private long userId;
	private String userName;
	private long typeId;
	private String typeName;

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

	public String getFlowerDesc() {
		return flowerDesc;
	}

	public void setFlowerDesc(String flowerDesc) {
		this.flowerDesc = flowerDesc;
	}

	public long getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerPrice(long flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

	public long getFlowerAmount() {
		return flowerAmount;
	}

	public void setFlowerAmount(long flowerAmount) {
		this.flowerAmount = flowerAmount;
	}

	public String getFlowerCover() {
		return flowerCover;
	}

	public void setFlowerCover(String flowerCover) {
		this.flowerCover = flowerCover;
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

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "FlowerUserDTO [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerDesc=" + flowerDesc
				+ ", flowerPrice=" + flowerPrice + ", flowerAmount=" + flowerAmount + ", flowerCover=" + flowerCover
				+ ", userId=" + userId + ", userName=" + userName + ", typeId=" + typeId + ", typeName=" + typeName
				+ "]";
	}

}
