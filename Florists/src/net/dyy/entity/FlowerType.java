package net.dyy.entity;

public class FlowerType {

	private long typeId;
	private String typeName;

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
		return "FlowerType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
