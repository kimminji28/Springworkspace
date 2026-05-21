package com.yedam.app.rest.service;

import lombok.Getter;
import lombok.ToString;

@Getter                                                            //0번
@ToString                                                          //0번
public class Post {
	private Integer userId;
	private Integer id;
	private String title;
	private String body;
	
	//모든 필드를 값으로 가지는 생성자가 1개 필요함                           2번
	public Post(Integer userId, Integer id, String title, String body) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public static class Builder {//외부에서 호출하기 쉽게 static (전역) 붙이기
		//빌더 패턴 : 생성자
		//사이가 밀접해서 중첩클래스 사용, 클래스 안에 클래스                  1번
		//중첩클래스라 getter, setter 안씀 -> 지꺼 아니고 넘의 꺼라
		private Integer userId;
		private Integer id;
		private String title;
		private String body;
		
		public Builder userId(int userId) {
			this.userId = userId;
			return this;
		}
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder body(String body) {
			this.body = body;
			return this;
		}
		
		//최종적으로 포스트 클래스 생성해서 전달함                             3번
		public Post build() {
			return new Post(userId, id, title, body);
		}
		
	}
}
