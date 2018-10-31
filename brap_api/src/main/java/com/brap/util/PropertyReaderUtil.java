/**
 * 
 */
package com.brap.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author prajwbhat
 *
 */
@Configuration
public class PropertyReaderUtil {

	@Value("${jenkins.adminUsername}")
	private String jenkinsUsername;
	@Value("${jenkins.adminPassword}")
	private String jenkinsPassword;
	@Value("${jenkins.Port}")
	private String jenkinsPort;

	public String getJenkinsUsername() {
		return jenkinsUsername;
	}

	public String getJenkinsPassword() {
		return jenkinsPassword;
	}

	public String getJenkinsPort() {
		return jenkinsPort;
	}

}
