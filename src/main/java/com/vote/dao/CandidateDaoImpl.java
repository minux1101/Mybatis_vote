package com.vote.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vote.dto.CandidateVO;

@Repository
public class CandidateDaoImpl implements CandidateDao {

	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.vote.mapper.candidateMapper";

	@Override
	public int insert(CandidateVO candidateVO) throws Exception {
		return sqlSession.insert(Namespace + ".insert", candidateVO);
	}

	@Override
	public List<CandidateVO> selectAll() throws Exception {
		return sqlSession.selectList(Namespace + ".select");
	}

	@Override
	public CandidateVO selectOne(int num) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectOne", num);
	}

	@Override
	public int delete(int num) throws Exception {
		return sqlSession.delete(Namespace + ".delete", num);
	}
}
