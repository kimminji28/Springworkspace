package com.yedam.app.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.yedam.app.mybatis.service.EmpVO;

import lombok.RequiredArgsConstructor;

//Mapper의 구현 객체 => Mybatis가 자동으로 생성 가능
@Repository
@RequiredArgsConstructor //생성자 주입 방식(private final SqlSessionFactory factory;) 필드 작성
public class EmpMapperImpl implements EmpMapper{
	//DAO 객체
	private final SqlSessionFactory factory;
	
	@Override
	public List<EmpVO> selectAll() {
		SqlSession session = factory.openSession(true); //factory를 통해 세션 받아오기
		List<EmpVO> list = session.selectList("com.yedam.app.mybatis.mapper.EmpMapper.selectAll");
		session.close(); //자원(커넥션) 해제
		return list;
	}

	@Override
	public EmpVO selectInfo(EmpVO emp) {
		//try-with-resources : 자동으로 자원을 닫아줌
		//try (SqlSession session = factory.openSession()) : 진행이 되든, 예외가 발생하든 커넥션 자원을 자동으로 해제해줌
		try (SqlSession session = factory.openSession(true)){
			EmpVO find = session.selectOne("com.yedam.app.mybatis.mapper.EmpMapper.selectInfo", emp);
			return find;
		}
	}

	@Override
	public int insertInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)){
			int result = session.insert("com.yedam.app.mybatis.mapper.EmpMapper.insertInfo", emp);
			return result;
		}
	}

	@Override
	public int updateInfo(EmpVO emp) {
		try (SqlSession session = factory.openSession(true)){
			int result = session.update("com.yedam.app.mybatis.mapper.EmpMapper.updateInfo", emp);
			return result;
		}
	}

	@Override
	public int deleteInfo(int empId) {
		try (SqlSession session = factory.openSession(true)){
			int result = session.delete("com.yedam.app.mybatis.mapper.EmpMapper.deleteInfo", empId);
			return result;
		}
	}
	
}
