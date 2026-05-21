package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.rest.service.Post;

@SpringBootTest
public class BuildrPatternTest {
	@Test
	void first() {
		Post post = new Post.Builder()
							.userId(1)
							.title("Firet Post")
							.body("Hello")
							.build();
		System.out.println(post);
	}
}
