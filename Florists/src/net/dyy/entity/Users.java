package net.dyy.entity;

public class Users {

	private long userId;
	private String userName;
	private String userPwd;
	private long userSex;
	private String userAddress;
	private String userBirth;
	private String userPhone;
	private long userType;
	private long userCredit;

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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public long getUserSex() {
		return userSex;
	}

	public void setUserSex(long userSex) {
		this.userSex = userSex;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public long getUserType() {
		return userType;
	}

	public void setUserType(long userType) {
		this.userType = userType;
	}

	public long getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(long userCredit) {
		this.userCredit = userCredit;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userSex=" + userSex
				+ ", userAddress=" + userAddress + ", userBirth=" + userBirth + ", userPhone=" + userPhone
				+ ", userType=" + userType + "]";
	}

}
