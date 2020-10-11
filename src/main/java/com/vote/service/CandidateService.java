package com.vote.service;

import java.util.List;

import com.vote.dto.CandidateVO;

public interface CandidateService {

	public int insert(CandidateVO candidateVO) throws Exception;

	public List<CandidateVO> selectAll() throws Exception;

	public CandidateVO selectOne(int num) throws Exception;

	public int delete(int num) throws Exception;
}
