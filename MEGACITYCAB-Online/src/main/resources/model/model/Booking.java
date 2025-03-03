package model;

public class Booking {
	public int getmCustomerID() {
		return mCustomerID;
	}
	public void setmCustomerID(int mCustomerID) {
		this.mCustomerID = mCustomerID;
	}
	public String getmPickupAddress() {
		return mPickupAddress;
	}
	public void setmPickupAddress(String mPickupAddress) {
		this.mPickupAddress = mPickupAddress;
	}
	public String getmDropAddress() {
		return mDropAddress;
	}
	public void setmDropAddress(String mDropAddress) {
		this.mDropAddress = mDropAddress;
	}
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
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	private int mID;
	private int mCustomerID;
	private String mPickupAddress;
	private String mDropAddress;
	private String mRideType;
	private int mDriverID;
}
