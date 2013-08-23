package com.abs104a.cuptest;

import java.util.ArrayList;
import java.util.LinkedList;

import com.abs104a.cuptest.data.CompareHolder;
import com.abs104a.cuptest.data.Cup;
import com.abs104a.cuptest.data.MapData;

public class Compare {

	//�ő�PATTERN��
	public final static int PATTERN = 3*2;
	
	public final static int A_FULL  = 0;
	public final static int A_EMPTY = 1;
	public final static int A_POUR  = 2;
	
	public final static int B_FULL  = 3;
	public final static int B_EMPTY = 4;
	public final static int B_POUR  = 5;
	
	public final static int DATA_A = 0;
	public final static int DATA_B = 1;
	
	
	public Cup[] doActions(int actions,Cup A,Cup B){
		Cup[] result = new Cup[2];
		switch(actions){
		case A_FULL:
			result[DATA_A] = A.full();
			result[DATA_B] = B;
			break;
		case A_EMPTY:
			result[DATA_A] = A.empty();
			result[DATA_B] = B;
			break;
		case A_POUR:
			result = A.pour(B);
			break;
			
		case B_FULL:
			result[DATA_A] = A;
			result[DATA_B] = B.full();
			break;
		case B_EMPTY:
			result[DATA_A] = A;
			result[DATA_B] = B.empty();
			break;
		case B_POUR:
			Cup[] tmp = B.pour(A);
			result[DATA_A] = tmp[Cup.CUP_OTHER];
			result[DATA_B] = tmp[Cup.CUP_MINE];
			break;
			
		}
		return result;
	}
	
	public String getStrings(int actions){

		switch(actions){
		case A_FULL:
			return "A_FULL";
		case A_EMPTY:
			return "A_EMPTY";
		case A_POUR:
			return "A_POUR";
			
		case B_FULL:
			return "B_FULL";
		case B_EMPTY:
			return "B_EMPTY";
		case B_POUR:
			return "B_POUR";
			
		}
		return "NONE";
	}
	
	/**
	 * ���C�����[�`��
	 * �T�����s��
	 * @param root
	 * @param capacity_A
	 * @param capacity_B
	 */
	public void search(final int capacity_A,final int capacity_B,final int goal){
		//���[�g�z���_�[�̍쐬
		final CompareHolder srootHolder = new CompareHolder(null, new Cup(capacity_A), new Cup(capacity_B),-1, PATTERN);
		//�T���p�̃L���[
		final LinkedList<CompareHolder> list = new LinkedList<CompareHolder>();
		//�}�؂�p�̉𓚃L���b�V��
		final ArrayList<MapData> cache = new ArrayList<MapData>();
		
		
		list.offer(srootHolder);
		//���݂̖؈ʒu�L���p
		CompareHolder tmpHolder = null;
		//���[�v����p�t���O
		boolean roopFlag = true;
		//���s��
		int count = 0;
		do{
			
			CompareHolder rootHolder = list.poll();
			for(int i = 0;i < PATTERN;i++){
				Cup[] tmp = doActions(i, rootHolder.getTmpResult_A(), rootHolder.getTmpResult_B());
				tmpHolder = new CompareHolder(rootHolder, tmp[DATA_A], tmp[DATA_B],i,PATTERN);
				rootHolder.setChildren(i, tmpHolder);
				count++;
				MapData data = new MapData(tmp[DATA_A].getNow(),tmp[DATA_B].getNow());
				//������s��
				if(tmp[DATA_A].getNow() == goal || tmp[DATA_B].getNow() == goal){
					System.out.println(i + ": A:"+tmp[DATA_A].getNow()+" ,B:"+tmp[DATA_B].getNow());
					roopFlag = false;
					break;
				}else if(!(data.getA_data() == 0 && data.getB_data() == 0)){
					if(cache.indexOf(data) == -1){
						list.offer(tmpHolder);
						cache.add(data);
					}
				}
			}
		}while(roopFlag && list.size() > 0);
		
		System.out.println("���s�񐔂�"+count+"��ł����D");
		
		if(!roopFlag){
			//���ʂ��o�Ă���ꍇ
			LinkedList<String> resultStrings = new LinkedList<String>();
			while(tmpHolder.getRootHolder() != null){
				resultStrings.push(getStrings(tmpHolder.getPostion()));
				tmpHolder = tmpHolder.getRootHolder();
			}
			while(resultStrings.size() > 0){
				System.out.println(resultStrings.pop());
			}
		}else{
			//���ʂ��łȂ��ꍇ
			System.out.println("���̎��s�͕s�\�ł�");
		}
		
	}
	
}
