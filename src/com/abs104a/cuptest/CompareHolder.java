package com.abs104a.cuptest;

public final class CompareHolder {
	
	private final CompareHolder[] children;
	private final CompareHolder rootHolder;
	
	private final Cup tmpResult_A;
	private final Cup tmpResult_B;
	
	private final int position;
	
	/**
	 * 比較する際のホルダー
	 * @param rootHolder 上位のクラス
	 * @param tmpResult 現時点での値
	 * @param maxChildren 最大の持つべき子の数
	 * @param pattern 
	 */
	public CompareHolder(CompareHolder rootHolder,Cup tmpResult_A,Cup tmpResult_B,int position,int maxChildren){
		this.rootHolder = rootHolder;
		this.tmpResult_A = tmpResult_A;
		this.tmpResult_B = tmpResult_B;
		children = new CompareHolder[maxChildren];
		this.position = position;
	}
	
	public int getPostion(){
		return position;
	}
	
	public CompareHolder getRootHolder(){
		return rootHolder;
	}
	
	public Cup getTmpResult_A(){
		return tmpResult_A;
	}
	
	public Cup getTmpResult_B(){
		return tmpResult_B;
	}
	
	public boolean setChildren(int position,CompareHolder holder){
		if(position < 0 || position >= children.length)
			return false;
		else{
			children[position] = holder;
			return true;
		}
	}
	
	public CompareHolder getChildren(int position){
		if(position < 0 || position >= children.length)
			return null;
		else
			return children[position];
	}

}
