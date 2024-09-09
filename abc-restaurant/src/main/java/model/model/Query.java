package model;

public class Query {
	private int mID;
	private String QueryText;
	private String ReplyText;
	private int mCustId;
	
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getQueryText() {
		return QueryText;
	}
	public void setQueryText(String queryText) {
		QueryText = queryText;
	}
	public String getReplyText() {
		return ReplyText;
	}
	public void setReplyText(String replyText) {
		ReplyText = replyText;
	}
	public int getmCustId() {
		return mCustId;
	}
	public void setmCustId(int mCustId) {
		this.mCustId = mCustId;
	}
}