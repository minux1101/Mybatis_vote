package com.vote.dao;

import java.util.List;

import com.vote.dto.VoteVO;

public interface VoteDao {

	public int insert(VoteVO voteVO) throws Exception;

	public List<VoteVO> selectAll() throws Exception;

	public List<VoteVO> selectCandidate(int cddnum) throws Exception;

	public int delete(int cddnum) throws Exception;

	public int count() throws Exception;

	public int countCandidate(int cddnum) throws Exception;

	public int countAge(VoteVO voteVO) throws Exception;

}
