package com.yedam.app.securify.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Spring Security에서 사용할 실질적인 VO
@RequiredArgsConstructor
@Getter //Data, toString 어노테이션 사용안함 / 생성자 어노테이션도 안함
public class LoginVO implements UserDetails{
	private final UserVO userVO;
	//보안이라 가져온 정보를 변경할 일이 없으니 setter는 필요없음

	@Override
	public Collection<? extends GrantedAuthority>
								getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		for (String auth : userVO.getRoleList()) {
			auths.add(new SimpleGrantedAuthority(auth));
			}
		return auths;
	}

	@Override
	public String getPassword() {
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.getLoginId();
	}
}
