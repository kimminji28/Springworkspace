package com.yedam.app.securify.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.securify.mapper.UserMapper;
import com.yedam.app.securify.service.UserVO;

import lombok.RequiredArgsConstructor;

@Service //시큐리티가 가지고있는 인터페이스를 기반으로 구현클래스 강제로 생성
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService{
	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//username을 이용해서 인증 => DB 활용
		UserVO userVO = userMapper.getUserInfo(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return null; // DB에 아이디 없으면 널 값 반환됨
	}

}
