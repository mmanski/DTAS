package com.rasgrass.config;

import javax.inject.Inject;
import org.junit.Before;
import org.springframework.security.web.FilterChainProxy;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public abstract class WebSecurityConfigurationAware extends WebAppConfigurationAware {

	@Inject
	private FilterChainProxy springSecurityFilterChain;

	@Before
	public void before() {
		this.mockMvc = webAppContextSetup(this.wac)
				.addFilters(this.springSecurityFilterChain).build();
	}
}
