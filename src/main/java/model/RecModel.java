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
	private String mView;
	
	@Column
	private String mDownload;

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

	public String getmView() {
		return mView;
	}

	public void setmView(String mView) {
		this.mView = mView;
	}

	public String getmDownload() {
		return mDownload;
	}

	public void setmDownload(String mDownload) {
		this.mDownload = mDownload;
	}
	
	public RecModel(){
		
	}
	
	public RecModel(String mContentID,String mVisitorID,String mContentName,String mCategoryName,String mView,String mDownload){
		this.setmContentID(mContentID);
		this.setmCategoryName(mCategoryName);
		this.setmContentName(mContentName);
		this.setmVisitorID(mVisitorID);
		this.setmView(mView);
		this.setmDownload(mDownload);
	}
}
