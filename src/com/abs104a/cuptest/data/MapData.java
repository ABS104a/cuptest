package com.abs104a.cuptest.data;

public class MapData {

	private final int a_data;
	private final int b_data;
	
	public MapData(int a_data,int b_data){
		this.a_data = a_data;
		this.b_data = b_data;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MapData){
			return ((MapData)obj).a_data == a_data && ((MapData)obj).b_data == b_data;
		}else
			return false;
	}
	
	public int getA_data(){
		return a_data;
	}
	
	public int getB_data(){
		return b_data;
	}

}
