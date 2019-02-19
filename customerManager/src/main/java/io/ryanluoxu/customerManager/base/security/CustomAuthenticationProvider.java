package io.ryanluoxu.customerManager.base.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import io.ryanluoxu.customerManager.base.constant.AuthorityConstant;
import io.ryanluoxu.customerManager.base.constant.RoleConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.bean.entity.UserInfo;
import io.ryanluoxu.customerManager.bean.vo.UserInfoVO;
import io.ryanluoxu.customerManager.service.UserInfoService;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserInfoService userInfoService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/**
		 * encoding is not applicable
		 * 1. get user input
		 * 2. get system userInfo
		 * 3. verify
		 * 4. return authority (role) and other info
		 */
		String inputUserName = authentication.getName();
		String inputPassword = authentication.getCredentials().toString();
		List<UserInfo> userInfos = userInfoService.findByUserName(inputUserName);
		if (CollectionUtils.isEmpty(userInfos)) {
			throw new AuthenticationCredentialsNotFoundException(CommonError.INVALID_USERNAME_NOT_FOUND);
		}
		UserInfo userInfo = userInfos.get(0);
		if (userInfo.getPassword().equals(inputPassword)) {
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			if (userInfo.getRole().equals(RoleConstant.ADMIN)) {
				authorities.add(new SimpleGrantedAuthority(AuthorityConstant.ADMIN));
			} else if (userInfo.getRole().equals(RoleConstant.USER)) {
				authorities.add(new SimpleGrantedAuthority(AuthorityConstant.USER));
			}
			return new UsernamePasswordAuthenticationToken(convertToVO(userInfo), "", authorities);
		}
		return null;
	}

	private UserInfoVO convertToVO(UserInfo userInfo) {
		UserInfoVO userInfoVO = new UserInfoVO();
		userInfoVO.setRole(userInfo.getRole());
		userInfoVO.setUserInfoId(userInfo.getUserInfoId());
		userInfoVO.setUserName(userInfo.getUserName());
		return userInfoVO;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
