package net.dyy.entity;

public class Privilege {

	private long privId;
	private String privName;
	private long userId;

	public long getPrivId() {
		return privId;
	}

	public void setPrivId(long privId) {
		this.privId = privId;
	}

	public String getPrivName() {
		return privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Privilege [privId=" + privId + ", privName=" + privName + ", userId=" + userId + "]";
	}

}
