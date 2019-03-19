package net.dyy.entity;

/**
 * 花朵类别实体类
 * @author Dyy
 *
 */
public class Type {
	// 花朵类别
	private long typeId;
	// 花朵类别名
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

}
