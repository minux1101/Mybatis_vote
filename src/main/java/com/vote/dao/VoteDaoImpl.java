package com.vote.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vote.dto.VoteVO;

@Repository
public class VoteDaoImpl implements VoteDao {

	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.vote.mapper.voteMapper";

	@Override
	public int insert(VoteVO voteVO) throws Exception {
		return sqlSession.insert(Namespace + ".insert", voteVO);
	}

	@Override
	public List<VoteVO> selectAll() throws Exception {
		return sqlSession.selectList(Namespace + ".selectAll");
	}

	@Override
	public List<VoteVO> selectCandidate(int cddnum) throws Exception {
		return sqlSession.selectList(Namespace + ".selectCandidate", cddnum);
	}

	@Override
	public int delete(int cddnum) throws Exception {
		return sqlSession.delete(Namespace + ".delete", cddnum);
	}

	@Override
	public int count() throws Exception {
		return sqlSession.selectOne(Namespace + ".getCount");
	}

	@Override
	public int countCandidate(int cddnum) throws Exception {
		return sqlSession.selectOne(Namespace + ".countCandidate", cddnum);
	}

	@Override
	public int countAge(VoteVO voteVO) throws Exception {
		return sqlSession.selectOne(Namespace + ".countAge", voteVO);
	}

}
