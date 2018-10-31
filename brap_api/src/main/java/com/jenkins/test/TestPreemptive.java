package com.jenkins.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.DatatypeConverter;

/**
 * Simple class to launch a jenkins build on run@Cloud platform, should also
 * work on every jenkins instance (not tested)
 *
 */
public class TestPreemptive {

	public static void main(String[] args) {

		try {
			URL url = new URL("http://localhost:8080/job/Protractor-Automation/build"); // Jenkins URL localhost:8080, job named 'test'
			String user = "admin"; // username
			String pass = "7ac5d60319dbd3ae8f8f5b3b96c8a10e"; // password or API token
			String authStr = user + ":" + pass;
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
