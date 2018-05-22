/**
 * 
 */
package com.techvision.common;

/**
 * @author nkakki
 *
 */
public class DLLNode {
	int data;
	DLLNode next;
	DLLNode prev;
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	public DLLNode(int data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the next
	 */
	public DLLNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(DLLNode next) {
		this.next = next;
	}
	/**
	 * @return the prev
	 */
	public DLLNode getPrev() {
		return prev;
	}
	/**
	 * @param prev the prev to set
	 */
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
}
