package com.vote.dto;

public class VoteVO {
	private int cddnum; /* 후보자 번호 */
	private int age; /* 투표한 연령대 */

	public int getCddnum() { /* 후보자 번호의 getter */
		return cddnum;
	}

	public void setCddnum(int cddnum) { /* 후보자 번호의 setter */
		this.cddnum = cddnum;
	}

	public int getAge() { /* 투표한 연령대의 getter */
		return age;
	}

	public void setAge(int age) { /* 투표한 연령대의 setter */
		this.age = age;
	}

}
