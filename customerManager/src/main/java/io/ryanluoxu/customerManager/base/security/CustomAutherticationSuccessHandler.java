package io.ryanluoxu.customerManager.base.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import io.ryanluoxu.customerManager.base.constant.RoleConstant;

public class CustomAutherticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		
		String targetUrl = getTargetUrl(authentication);
		
		if (response.isCommitted()) {
			// Response has already been committed. Unable to redirect
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
		clearAuthenticationAttributes(request);
	}

	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	private String getTargetUrl(Authentication authentication) {
		/*
		 * Role is either ADMIN or USER
		 */
		Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			if (grantedAuthority.getAuthority().equals(RoleConstant.ADMIN)) {
				return "/pages/admin/admin.html";
			} else if (grantedAuthority.getAuthority().equals(RoleConstant.USER)) {
				return "/user";
			}
		}
		return null;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	

}
