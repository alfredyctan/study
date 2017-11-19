package org.alf.study.service.impl;

import java.util.List;

import org.alf.study.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BootService implements Service {

	private static final Logger logger = LoggerFactory.getLogger(BootService.class);
	
	private List<Service> services;

	@Override
	public void init() {
		logger.info("initialize");
		for (Service service:services) {
			service.init();
		}
	}

	@Override
	public void start() {
		logger.info("start");
		for (Service service:services) {
			service.start();
		}
	}

	@Override
	public void stop() {
		logger.info("stop");
		for (Service service:services) {
			service.stop();
		}
	}

	@Override
	public void dispose() {
		logger.info("dispose");
		for (Service service:services) {
			service.dispose();
		}
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
