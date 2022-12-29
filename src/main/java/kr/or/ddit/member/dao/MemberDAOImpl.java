package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.memo.dao.MemoDAO;
import kr.or.ddit.mybatis.MybatisUtils;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemoVO;

public class MemberDAOImpl implements MemberDAO{
	
	private SqlSessionFactory sqlSessionFactory = MybatisUtils.getSessionFactory();
	
	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.insertMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		try(
			SqlSession sqlSession =  sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class); //계속 생성해주므로 전역으로 만들 필요성이 있음, 그것이 mybatis scanner
			return mapperProxy.selectMemberList();
		}
		
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession =  sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class); //계속 생성해주므로 전역으로 만들 필요성이 있음, 그것이 mybatis scanner
			return mapperProxy.selectMember(memId);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.updateMember(member);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int rowcnt = mapperProxy.deleteMember(memId);
			sqlSession.commit();
			return rowcnt;
		}
	}

}
