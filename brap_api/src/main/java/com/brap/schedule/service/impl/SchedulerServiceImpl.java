package com.brap.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brap.schedule.client.JenkinsRestClient;
import com.brap.schedule.service.SchedulerService;
@Component
public class SchedulerServiceImpl implements SchedulerService {

	private JenkinsRestClient jenkinsClient;

	@Autowired
	public SchedulerServiceImpl(JenkinsRestClient client) {
		this.jenkinsClient = client;
	}

	@Override
	public void buildJob(String jobName) {
		jenkinsClient.buildJob(jobName);
	}

}
