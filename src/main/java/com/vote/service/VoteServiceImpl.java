package com.vote.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.vote.dao.VoteDao;
import com.vote.dto.VoteVO;

@Service
public class VoteServiceImpl implements VoteService {

	@Inject
	private VoteDao dao;

	@Override
	public int insert(VoteVO voteVO) throws Exception {
		return dao.insert(voteVO);
	}

	@Override
	public List<VoteVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	@Override
	public List<VoteVO> selectCandidate(int cddnum) throws Exception {
		return dao.selectCandidate(cddnum);
	}

	@Override
	public int delete(int cddnum) throws Exception {
		return dao.delete(cddnum);
	}

	@Override
	public int count() throws Exception {
		return dao.count();
	}

	@Override
	public int countCandidate(int cddnum) throws Exception {
		return dao.countCandidate(cddnum);
	}

	@Override
	public List<Integer> countAge(int cddnum) throws Exception {
		List<Integer> countCandidateAge = new ArrayList<Integer>();
		VoteVO vote = new VoteVO();
		for (int i = 1; i < 10; i++) {
			vote.setCddnum(cddnum);
			vote.setAge(i * 10);
			countCandidateAge.add(dao.countAge(vote));
		}
		return countCandidateAge;
	}
}
