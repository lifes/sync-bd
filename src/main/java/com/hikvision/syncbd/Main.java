package com.hikvision.syncbd;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hikvision.syncbd.common.WrapperException;
import com.hikvision.syncbd.task.T1;
import com.hikvision.syncbd.task.T2;
import com.hikvision.syncbd.task.T3;

/**
 * @author chenhuaming 2016-1-11
 * 
 */
public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String args[]) throws ClientProtocolException,
			IOException, WrapperException, InterruptedException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		
		logger.info("初始化成功----\n----\n----\n----\n----\n");
		Thread t1 = new Thread(new T1(ctx));
		Thread t2 = new Thread(new T2(ctx));
		Thread t3 = new Thread(new T3(ctx));
		//t1.start();
		//t2.start();
		t3.start();
		while (!t1.isAlive()) {
			Thread.sleep(1000);
		}
		while (!t2.isAlive()) {
			Thread.sleep(1000);
		}
		while (!t3.isAlive()) {
			Thread.sleep(1000);
		}
		Thread[] ts = new Thread[3];
		ts[0] = t1;
		ts[1] = t2;
		ts[2] = t3;

		boolean isRuning = true;
		while (isRuning) {
			Thread.sleep(5000);
			for (int i = 0; i < ts.length; i++) {
				if (ts[i].isAlive()) {
					isRuning = true;
					break;
				}
				isRuning = false;
			}
		}
		logger.info("系统非正常退出");//unreachable
		System.exit(0);
	}
}
