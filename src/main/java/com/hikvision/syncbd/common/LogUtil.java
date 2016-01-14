package com.hikvision.syncbd.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenhuaming
 * 2016-1-11
 * 
 */
public class LogUtil  {
        private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);
        public static void error(String msg){
        	logger.error(msg);
        }
}
