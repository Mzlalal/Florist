package net.dyy.entity;

public class Shopcar {

	private long userId;
	private long flowerId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(long flowerId) {
		this.flowerId = flowerId;
	}

	@Override
	public String toString() {
		return "Shopcar [userId=" + userId + ", flowerId=" + flowerId + "]";
	}

}
