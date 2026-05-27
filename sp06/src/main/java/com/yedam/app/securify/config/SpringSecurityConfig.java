package com.yedam.app.securify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.yedam.app.securify.mapper.UserMapper;
import com.yedam.app.securify.service.impl.CustomerUserDetailsService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity //Security 설정
//Security가 세션을 건드림
public class SpringSecurityConfig {
	@Bean //비밀번호 암호화 : 단방향
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//인증 및 인가 : HttpSecurity로 설정
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http //Security각 적용될 URI
			.authorizeHttpRequests(authrize
				-> authrize
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/", "/all", "/info").permitAll()
				.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
			)			
		    .formLogin(formlogin
		    	-> formlogin //loginProcessingUrl, loginPage도 활용 가능
		    	.usernameParameter("id")
		    	.defaultSuccessUrl("/all")) //인증성공하면 메인 페이지로 이동   
		    .logout(logout
		    	-> logout
		    	.logoutSuccessUrl("/all")
		    	.invalidateHttpSession(true)
		    	.deleteCookies("JSESSIONID")
		    );
		
		// CSRF protection 비활성화
		//http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
	//자바스크립트에서 파일 열리게 보안 설정
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web
						.ignoring()
						.requestMatchers("/images/**", "/js/**", "/css/**");
	}	
	
	@Bean
	UserDetailsService customerUserDetailsService(UserMapper usermapper) {
		return new CustomerUserDetailsService(usermapper);
	}
	
	//인메모리 죽임
	/*@Bean //메모리상 인증정보 등록 => 테스트 전용 방식
	InMemoryUserDetailsManager inmemoryUserDetailaSevice() {
		UserDetails user = User.builder()
							   .username("user1")
							   .password(passwordEncoder().encode("1234")) //
							   .roles("USER") //ROLE_USER(이게 자동으로 붙음) 롤을 정의할 때 ROLE_로 시작하겠다.
							   .build();
		
		UserDetails admin = User.builder()
							    .username("admin1")
							    .password(passwordEncoder().encode("1234"))
							    .authorities("ROLE_ADMIN") //롤을 정의할 때 ROLE_를 제외하겠다.
							    .build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	*/
	
}
