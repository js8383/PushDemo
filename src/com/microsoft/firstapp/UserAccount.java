package com.microsoft.firstapp;


/**
 * Info of a user
 */
public class UserAccount {

	
	@com.google.gson.annotations.SerializedName("Username")
	private String signUsername;

	@com.google.gson.annotations.SerializedName("Password")
	private String signPassword;
	
	@com.google.gson.annotations.SerializedName("Email")
	private String signEmail;

	
	@com.google.gson.annotations.SerializedName("id")
	private String mId;
	
	public UserAccount() {

	}


	public UserAccount(String user, String psd, String email) {
		this.setUsername(user);
		this.setPassword(psd);
		this.setEmail(email);
	}


	public final void setUsername(String text) {
		signUsername = text;
	}
	
	public final void setPassword(String text) {
		signPassword = text;
	}
	
	public final void setEmail(String text) {
		signEmail = text;
	}

	/**
	 * Returns the item id
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the item id
	 * 
	 * @param id
	 *            id to set
	 */
	public final void setId(String id) {
		mId = id;
	}



	@Override
	public boolean equals(Object o) {
		return o instanceof UserAccount && ((UserAccount) o).mId == mId;
	}
}