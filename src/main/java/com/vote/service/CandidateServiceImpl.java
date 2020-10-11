package com.vote.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.vote.dao.CandidateDao;
import com.vote.dto.CandidateVO;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Inject
	private CandidateDao dao;

	@Override
	public int insert(CandidateVO candidateVO) throws Exception {
		return dao.insert(candidateVO);
	}

	@Override
	public List<CandidateVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public CandidateVO selectOne(int num) throws Exception {
		return dao.selectOne(num);
	}

	@Override
	public int delete(int num) throws Exception {
		return dao.delete(num);
	}
}
