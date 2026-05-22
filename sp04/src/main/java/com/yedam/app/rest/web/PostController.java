package com.yedam.app.rest.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.yedam.app.rest.service.Post;

@RestController //임시서버에 있는 데이터를 통신을 이용해서 데이터 땡김
public class PostController {
	// WebClient : Spring에서 제공하는 HTTP 통신 객체.
	// WebClient : stream api를 기반으로 진행함
	private WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/");

	@GetMapping("selectList")
	public Map<String, Object> selectList() {
		Map<String, Object> map = new HashMap<>();
		
		List<Post> list = webClient.get()
				 .uri("/posts")
				 .retrieve() //실제 요청과 응답 처리
				 .bodyToFlux(Post.class) //다건조회(일종의 스트림을 열여서 데이터가 흘러오면 단건에 대해선 post 클래스를 기반으로 처리)
				 //Body를 스트림으로 전환한다는 뜻
				 //bodyToFlux(전체조회)/bodyToMono(건별조회) : 스트림을 열어서 처리하는 메소드
				 .collectList() //최종적으로 받을 컬렉션 선택 -> List로 변환
				 .block(); //닫기 (동기식 처리)
		map.put("다건처리결과", list);
		return map;
	}
	
	@GetMapping("selectOne")
	public Map<String, Object> selectOne(){
		Map<String, Object> map = new HashMap<>();
		
		Post post = webClient.get() 
							 .uri("/posts/3")
							 .retrieve() //실제 요청과 응답 처리
							 .bodyToMono(Post.class) //Mono : Body를 스트림으로 처리, 최대 1개만 처리함 => 그래서 묶어서 처리할 이유가 없어서 컬렉션 필요없음
							  //exeChangeMono : 다용도로 쓰고싶으면 이거 사용
							 .block(); //닫기 (동기식 처리)
		map.put("단건처리", post);
		return map;
	}
	
	@GetMapping("insertOne")
	public Map<String, Object> insertOne() {
		Map<String, Object> map = new HashMap<>();
		
		Post newPost = new Post.Builder()
							   .userId(1)
							   .title("New Post")
							   .body("New Content")
							   .build();
		Post post = webClient.post()
							 .uri("/posts")
							 .contentType(MediaType.APPLICATION_JSON)
							 .bodyValue(newPost) //내가 전송하고싶은 데이터 넣으면 됨
							 .retrieve() //실제 요청과 응답 처리
							 .bodyToMono(Post.class)
							 .block(); //닫기 (동기식 처리)
		map.put("등록", post);
		return map;
	}
	
}