package com.yedam.app.mybatis.mapper;

import java.util.List;

import com.yedam.app.mybatis.service.EmpVO;

//Mapper : 실제 SQL문을 수행하는 객체
//테이블 1개 -> Mapper 1개
public interface EmpMapper {
	//로직이 어떻게 도는지 알아야함 = EmpDAO 참고
	//전체조회 -> 조회의 기본은 List 타입임
	public List<EmpVO> selectAll(); //PreparenStatement (디폴트로 사용)
	//단건조회
	public EmpVO selectInfo(EmpVO emp); //컬럼 정보를 기준으로 getter/setter를 땡기기 때문에 클래스로 받음 => 결과에 제한을 건거임
	//등록
	public int insertInfo(EmpVO emp); //정수를 리턴 받기 때문에 int로 사용=>몇 건이 등록되었습니다.
	//수정
	public int updateInfo(EmpVO emp); //여러 개의 데이터를 넘길 때는 객체로 넘기길
	//삭제
	public int deleteInfo(int empId);
}
