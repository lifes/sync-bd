package com.hikvision.syncbd.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("开始任务2");
		for (;;) {
			try {
				File[] imgs = FileUtil
						.getFilesOnDirectoryNotIncludeFolder(config
								.getDirectoryPath());
				List<Thread> list = new ArrayList<Thread>();
				List<File> all = Arrays.asList(imgs);
				int l = imgs.length;
				int flag = 10;// 线程数
				int g = (l - (l % flag)) / flag;				
				if (l > 0) {
					for (int i = 0; i < flag; i++) {
						if (i < flag - 1) {
							File[] ff = all.subList(i * g, g * (i + 1))
									.toArray(new File[0]);
							Thread t = new Thread(new T4(ctx, ff));
							t.start();
							list.add(t);
						}else{
							File[] ff = all.subList(i * g, l)
									.toArray(new File[0]);
							Thread t = new Thread(new T4(ctx, ff));
							t.start();
							list.add(t);
						}
					}
				}
				try {
					for (Thread t : list) {
						t.join();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					logger.error(e.getMessage());
				}
			} catch (Throwable e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}
}
