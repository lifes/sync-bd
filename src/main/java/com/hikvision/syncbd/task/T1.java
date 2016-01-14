package com.hikvision.syncbd.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import com.hikvision.syncbd.common.Config;
import com.hikvision.syncbd.service.SimpleService;

/**
 * @author chenhuaming
 * 2016-1-13
 * 
 */
public class T1 implements Runnable{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unused")
	private ApplicationContext ctx;
	private Config config;
	private SimpleService simpleService;

	public T1(ApplicationContext ctx) {
		this.ctx = ctx;
		this.config = ctx.getBean(Config.class);
		this.simpleService = ctx.getBean(SimpleService.class);
	}

	public void run() {
		logger.info("开始上传CrossingInfo数据");
		simpleService.uploadCrossingInfo(config);
	}
}
