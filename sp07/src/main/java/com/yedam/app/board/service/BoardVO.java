package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //VO파일에서는 기본 생성자 무조건 필요한데 데이터 어노테이션에는 없음
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class BoardVO {
	private Integer bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private Date updatedate;
	private String image;
}