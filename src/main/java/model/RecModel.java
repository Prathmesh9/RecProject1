package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RecModel {

	@Id
	private String mContentID;
	
	@Column
	private String mVisitorID;
	
	@Column
	private String mContentName;
	
	@Column
	private String mCategoryName;
	
	@Column
	private int mView;
	
	@Column
	private int mDownload;

	public String getmContentID() {
		return mContentID;
	}

	public void setmContentID(String mContentID) {
		this.mContentID = mContentID;
	}

	public String getmVisitorID() {
		return mVisitorID;
	}

	public void setmVisitorID(String mVisitorID) {
		this.mVisitorID = mVisitorID;
	}

	public String getmContentName() {
		return mContentName;
	}

	public void setmContentName(String mContentName) {
		this.mContentName = mContentName;
	}

	public String getmCategoryName() {
		return mCategoryName;
	}

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}

	public int getmView() {
		return mView;
	}

	public void setmView(int mView) {
		this.mView = mView;
	}

	public int getmDownload() {
		return mDownload;
	}

	public void setmDownload(int mDownload) {
		this.mDownload = mDownload;
	}
	
	public RecModel(){
		
	}
	
	public RecModel(String mContentID,String mVisitorID,String mContentName,String mCategoryName,int mView,int mDownload){
		this.setmContentID(mContentID);
		this.setmCategoryName(mCategoryName);
		this.setmContentName(mContentName);
		this.setmVisitorID(mVisitorID);
		this.setmView(mView);
		this.setmDownload(mDownload);
	}
}
