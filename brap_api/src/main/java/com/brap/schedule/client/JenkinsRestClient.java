package com.brap.schedule.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brap.util.PropertyReaderUtil;

@Component
public class JenkinsRestClient {

	private PropertyReaderUtil propUtil;

	@Autowired
	public JenkinsRestClient(PropertyReaderUtil propUtil) {
		this.propUtil = propUtil;
	}

	public void buildJob(String jobName) {
		try {
			//TO-DO : Use URLBuilder.  Add dependancy
			StringBuilder builder = new StringBuilder();
			builder.append("http://localhost:8080/job/").append(jobName).append("/build");
			URL url = new URL(builder.toString()); // Jenkins URL localhost:8080,
			String authStr = propUtil.getJenkinsUsername() + ":" + propUtil.getJenkinsPassword();
			String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			InputStream content = connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
