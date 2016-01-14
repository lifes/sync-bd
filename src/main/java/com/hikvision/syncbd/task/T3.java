package com.hikvision.syncbd.task;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import com.hikvision.syncbd.common.Config;
import com.hikvision.syncbd.common.FileUtil;
import com.hikvision.syncbd.service.SimpleService;

/**
 * @author chenhuaming 2016-1-13
 * 
 */
public class T3 implements Runnable {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unused")
	private ApplicationContext ctx;
	private Config config;
	private SimpleService simpleService;

	public T3(ApplicationContext ctx) {
		this.ctx = ctx;
		this.config = ctx.getBean(Config.class);
		this.simpleService = ctx.getBean(SimpleService.class);
	}

	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("开始任务2");
		for (;;) {
			try {
				File[] imgs = FileUtil
						.getFilesOnDirectoryNotIncludeFolder(config
								.getDirectoryPath());
				for (File img : imgs) {
					simpleService.uploadOne(img, config);
				}
			} catch (Throwable e) {
				logger.error("unmarked error");
			}
		}
	}
}
