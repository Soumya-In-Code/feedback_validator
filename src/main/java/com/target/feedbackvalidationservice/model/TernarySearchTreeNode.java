package com.target.feedbackvalidationservice.model;

public class TernarySearchTreeNode {
	
	Character data;
	TernarySearchTreeNode left, right, eq;
	boolean end;
	
	public Character getData() {
		return data;
	}
	public void setData(Character data) {
		this.data = data;
	}
	public TernarySearchTreeNode getLeft() {
		return left;
	}
	public void setLeft(TernarySearchTreeNode left) {
		this.left = left;
	}
	public TernarySearchTreeNode getRight() {
		return right;
	}
	public void setRight(TernarySearchTreeNode right) {
		this.right = right;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public TernarySearchTreeNode getEq() {
		return eq;
	}
	public void setEq(TernarySearchTreeNode eq) {
		this.eq = eq;
	}
	
	public boolean isDataEmpty() {
		return (null==getData()) ? true : false;
	}
	
}
