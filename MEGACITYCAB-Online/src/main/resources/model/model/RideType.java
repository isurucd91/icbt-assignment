package model;

public class RideType {
	public String getmRideType() {
		return mRideType;
	}
	public void setmRideType(String mRideType) {
		this.mRideType = mRideType;
	}
	public int getmDriverID() {
		return mDriverID;
	}
	public void setmDriverID(int mDriverID) {
		this.mDriverID = mDriverID;
	}
	public String getmRideDetails() {
		return mRideDetails;
	}
	public void setmRideDetails(String mRideDetails) {
		this.mRideDetails = mRideDetails;
	}
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	private int mID;
	private String mRideType;
	private int mDriverID;
	private String mRideDetails;
}
