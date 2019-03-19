package net.dyy.entity;

public class OrderDetail {

	private long orderId;
	private long flowerId;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(long flowerId) {
		this.flowerId = flowerId;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", flowerId=" + flowerId + "]";
	}

}
