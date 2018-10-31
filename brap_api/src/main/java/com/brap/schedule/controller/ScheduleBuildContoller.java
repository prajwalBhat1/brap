package com.brap.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brap.schedule.service.SchedulerService;

@RestController
@RequestMapping("/brap/api")
public class ScheduleBuildContoller {

	private SchedulerService schedulerService;

	@Autowired
	public ScheduleBuildContoller(SchedulerService schedulerService) {
		this.schedulerService = schedulerService;
	}

	@ResponseBody
	@RequestMapping(value = "/build", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public String triggerBuild(@RequestParam("jobName") String jobName) {
		schedulerService.buildJob(jobName);
		return "build triggered";
	}
}
