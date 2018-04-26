package com.techvision.common;
public class KnightPosition {
		int[] currentPos;
		int[] prev;
		public KnightPosition(int[] currentPos, int[] prev, int count) {
			super();
			this.currentPos = currentPos;
			this.prev = prev;
			this.count = count;
		}
		public int[] getCurrentPos() {
			return currentPos;
		}
		public void setCurrentPos(int[] currentPos) {
			this.currentPos = currentPos;
		}
		public int[] getPrev() {
			return prev;
		}
		public void setPrev(int[] prev) {
			this.prev = prev;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		int count;
	}