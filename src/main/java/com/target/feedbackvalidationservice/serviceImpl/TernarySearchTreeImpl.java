package com.target.feedbackvalidationservice.serviceImpl;

import org.springframework.stereotype.Service;

import com.target.feedbackvalidationservice.model.TernarySearchTreeNode;
import com.target.feedbackvalidationservice.service.TernarySearchTree;

@Service
public class TernarySearchTreeImpl implements TernarySearchTree{
	
	TernarySearchTreeNode root;
	
	@Override
	public void insert(String word) {
		TernarySearchTreeNode temp = root;
		insert(temp, word, 0);
	}

	private void insert(TernarySearchTreeNode temp, String word, int pos) {
		
		if (word.isEmpty() || pos > word.length() - 1) {
			return;
		} else {
			if(root==null) {
				root = new TernarySearchTreeNode();
				root.setData(word.charAt(pos));
				if(root.getEq()==null) {
					TernarySearchTreeNode node = new TernarySearchTreeNode();
					root.setEq(node);
				}
				insert(root.getEq(), word, pos + 1);
			}else if (temp.isDataEmpty() && pos<word.length()) {
				temp.setData(word.charAt(pos));
				if(pos==(word.length()-1))
					temp.setEnd(true);
				if(temp.getEq()==null) {
					TernarySearchTreeNode node = new TernarySearchTreeNode();
					temp.setEq(node);
				}
				insert(temp.getEq(), word, pos + 1);
			} else if (word.charAt(pos) == temp.getData() && pos == (word.length() - 1)) {
				temp.setEnd(true);
				return;
			} else if (word.charAt(pos) == temp.getData()) {
				if(temp.getEq()==null) {
					TernarySearchTreeNode node = new TernarySearchTreeNode();
					temp.setEq(node);
				}
				temp = temp.getEq();
				insert(temp, word, pos + 1);
			} else if (word.charAt(pos) < temp.getData()) {
				if(temp.getLeft()==null) {
					TernarySearchTreeNode node = new TernarySearchTreeNode();
					temp.setLeft(node);
				}
				temp = temp.getLeft();
				insert(temp, word, pos);
			} else if (word.charAt(pos) > temp.getData()) {
				if(temp.getRight()==null) {
					TernarySearchTreeNode node = new TernarySearchTreeNode();
					temp.setRight(node);
				}
				temp = temp.getRight();
				insert(temp, word, pos);
			}
		}
	}

	
	@Override
	public boolean search(String feedback) {
		TernarySearchTreeNode temp = root;
		Boolean flag = false;
		String[] words = feedback.split(" ");
		for(String word : words) {
			word = word.toLowerCase();
			flag = search(temp, word, 0);
			if(flag) {
				break;
			}
		}
		return flag;
	}
	
	private boolean search(TernarySearchTreeNode temp, String word, int pos) {
		if (word.isEmpty() || pos > (word.length() - 1) || temp==null || temp.isDataEmpty()) {
			return false;
		} else {
			if (word.charAt(pos) == temp.getData() && pos == (word.length() - 1) && temp.isEnd()) {
				return true;
			} else if (word.charAt(pos) == temp.getData() && pos < (word.length() - 1)) {
				temp = temp.getEq();
				return search(temp, word, pos + 1);
			} else if (word.charAt(pos) < temp.getData()) {
				temp = temp.getLeft();
				return search(temp, word, pos);
			} else {
				temp = temp.getRight();
				return search(temp, word, pos);
			}
		}
	}
}
