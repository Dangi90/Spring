package com.ch10.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String tokenPrefix = "Bearer ";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        // 요청 주소에서 마지막 문자열 추출
        String uri = request.getRequestURI();
        int i = uri.lastIndexOf("/");
        String path = uri.substring(i + 1);

        log.info("here1 - " + path);

        // 토큰 추출
        String header = request.getHeader(AUTHORIZATION_HEADER);
        log.info("here2 - " + header);

        String token = null;
        if (header != null && header.startsWith(tokenPrefix)) {
            token = header.substring(tokenPrefix.length());
        }
        log.info("here3 - " + token);

        // 토큰 검사
        if (token != null) {
            try {
                jwtProvider.validateToken(token);

                // 토큰이 유효하면 시큐리티 인증 처리
                Authentication authentication = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.info("here4 - " + authentication);

            } catch (Exception e) {
                log.error("JWT validation failed: " + e.getMessage(), e);  // 로그에 오류 기록
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);    // 상태 코드 설정
                response.getWriter().write("Invalid JWT token: " + e.getMessage());  // 오류 메시지 반환
                return;  // 예외 발생 시 필터 체인을 중단
            }
        }

        log.info("here6 - " + token);
        filterChain.doFilter(request, response);
    }

}
