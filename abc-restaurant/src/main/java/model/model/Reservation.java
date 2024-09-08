package model;

public class Reservation {
	private int mID;
	private String mDate;
	private String mTime;
	private String mType;
	private String mStatus;
	private int mCustID;
	
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public int getmCustID() {
		return mCustID;
	}
	public void setmCustID(int mCustID) {
		this.mCustID = mCustID;
	}
	
}
