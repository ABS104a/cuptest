package com.abs104a.cuptest.data;

public class Cup {
	
	//現在のカップに入っている量
	private final int now;
	//このカップの最大容量
	final private int capacity;
	
	/**
	 * インスタンス生成，カップの最大容量を決定する
	 * @param capacity　カップの最大容量
	 */
	public Cup(int capacity){
		this.capacity = capacity;
		now = 0;
	}
	
	private Cup(int now,int capacity){
		this.now = now;
		this.capacity = capacity;
	}
	
	/**
	 * 現在の内容を返す
	 * @return
	 */
	public int getNow(){
		return now;
	}
	
	/**
	 * このカップを満タンにする
	 * @return 現在の容量
	 */
	public Cup full(){
		return new Cup(capacity,capacity);
	}
	
	/**
	 * 自分のカップをからにする
	 * @return ゼロ
	 */
	public Cup empty(){
		return new Cup(0,capacity);
	}
	
	/**
	 * 自カップへの移し替えを行う
	 * 自分A→引数cupBへ内容を移し替える
	 * @param cup 相手のカップ
	 * @return 自分のカップの容量
	 */
	public Cup[] pour(Cup cup){
		Cup[] result = new Cup[2];
		int _sum = now + cup.now;
		result[CUP_OTHER] = new Cup(Math.min(cup.capacity, _sum),cup.capacity);
		result[CUP_MINE] = new Cup(Math.max(0, _sum - cup.capacity),capacity);
		return result;
	}
	
	public static final int CUP_MINE = 0;
	public static final int CUP_OTHER = 1;
}
