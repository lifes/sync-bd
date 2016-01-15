package com.hikvision.syncbd.task;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.hikvision.syncbd.common.Config;
import com.hikvision.syncbd.service.SimpleService;

/**
 * @author chenhuaming 2016-1-15
 * 
 */
public class T4 implements Runnable {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unused")
	private ApplicationContext ctx;
	private Config config;
	private SimpleService simpleService;
	private File[] imgs;

	public T4(ApplicationContext ctx,File[] imgs) {
		this.ctx = ctx;
		this.config = ctx.getBean(Config.class);
		this.simpleService = ctx.getBean(SimpleService.class);
		this.imgs = imgs;
	}

	public void run() {
		try {
			for (File img : imgs) {
				simpleService.uploadOne(img, config);
			}
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
	}
}
