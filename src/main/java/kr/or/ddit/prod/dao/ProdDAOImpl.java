package kr.or.ddit.prod.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.MybatisUtils;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements ProdDAO {
	//마이바티스와 의존 관계
	private SqlSessionFactory sqlSessionFactory = MybatisUtils.getSessionFactory();
	
	@Override
	public ProdVO selectProd(String prodId) {
		try(
			SqlSession sqlSession =  sqlSessionFactory.openSession();
		){
			ProdDAO mapperProxy = sqlSession.getMapper(ProdDAO.class); 
			return mapperProxy.selectProd(prodId);
		}
	}

}
