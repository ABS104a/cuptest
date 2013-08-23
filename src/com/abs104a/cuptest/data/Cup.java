package com.abs104a.cuptest.data;

public class Cup {
	
	//���݂̃J�b�v�ɓ����Ă����
	private final int now;
	//���̃J�b�v�̍ő�e��
	final private int capacity;
	
	/**
	 * �C���X�^���X�����C�J�b�v�̍ő�e�ʂ����肷��
	 * @param capacity�@�J�b�v�̍ő�e��
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
	 * ���݂̓��e��Ԃ�
	 * @return
	 */
	public int getNow(){
		return now;
	}
	
	/**
	 * ���̃J�b�v�𖞃^���ɂ���
	 * @return ���݂̗e��
	 */
	public Cup full(){
		return new Cup(capacity,capacity);
	}
	
	/**
	 * �����̃J�b�v������ɂ���
	 * @return �[��
	 */
	public Cup empty(){
		return new Cup(0,capacity);
	}
	
	/**
	 * ���J�b�v�ւ̈ڂ��ւ����s��
	 * ����A������cupB�֓��e���ڂ��ւ���
	 * @param cup ����̃J�b�v
	 * @return �����̃J�b�v�̗e��
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
