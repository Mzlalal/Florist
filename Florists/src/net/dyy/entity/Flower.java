package net.dyy.entity;

public class Flower {

	private long flowerId;
	private String flowerName;
	private String flowerDesc;
	private long flowerPrice;
	private long flowerAmount;
	private String flowerCover;
	private FlowerType type;
	private Users users;

	public long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(long flowerId) {
		this.flowerId = flowerId;
	}

	public FlowerType getType() {
		return type;
	}

	public void setType(FlowerType type) {
		this.type = type;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Flower [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerDesc=" + flowerDesc
				+ ", flowerPrice=" + flowerPrice + ", flowerAmount=" + flowerAmount + ", flowerCover=" + flowerCover
				+ ", type=" + type + ", users=" + users + "]";
	}

}
