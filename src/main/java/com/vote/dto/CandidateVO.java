package com.vote.dto;

public class CandidateVO {
	private int num; /* 후보자 번호 */
	private String name; /* 후보자 이름 */

	public int getNum() { /* 후보자 번호 getter */
		return num;
	}

	public void setNum(int num) { /* 후보자 번호 setter */
		this.num = num;
	}

	public String getName() { /* 후보자 이름 getter */
		return name;
	}

	public void setName(String name) { /* 후보자 이름 setter */
		this.name = name;
	}

}
