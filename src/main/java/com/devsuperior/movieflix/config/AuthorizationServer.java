package com.devsuperior.movieflix.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.devsuperior.movieflix.components.JwtTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	
	@Value("${jwt.duration}")
	private Integer jwtDuration;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private JwtAccessTokenConverter accessToken;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired
	private JwtTokenEnhancer tokenEnhancer;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		//credencias
		.withClient(clientId)
		.secret(encoder.encode(clientSecret))
		.scopes("read", "write")
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(jwtDuration)
		.refreshTokenValiditySeconds(jwtDuration);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain chain = new TokenEnhancerChain();
		//adicionando que além do token padrão mais as informações adicionais
		chain.setTokenEnhancers(Arrays.asList(accessToken, tokenEnhancer));
		
		endpoints.accessTokenConverter(accessToken)
		.tokenStore(tokenStore).authenticationManager(authManager)
		.tokenEnhancer(chain)
		.userDetailsService(userDetailService);
	}

	
	
}
