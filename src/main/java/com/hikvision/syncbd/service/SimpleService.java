package com.hikvision.syncbd.service;

import java.io.File;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;
import com.hikvision.syncbd.common.Config;
import com.hikvision.syncbd.common.FileUtil;
import com.hikvision.syncbd.common.HttpHelper;
import com.hikvision.syncbd.mapper.SimpleMapper;
import com.hikvision.syncbd.model.CrossingInfo;
import com.hikvision.syncbd.model.LaneInfo;
import com.hikvision.syncbd.model.VehiclePass;
import com.hikvision.syncbd.model.VehicleViolation;

/**
 * @author chenhuaming 2016-1-11
 * 
 */
@Service
public class SimpleService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SimpleMapper simpleMapper;

	public void uploadCrossingInfo(Config config) {			
		List<CrossingInfo> all = simpleMapper.getAllCrossingInfo();
		logger.info("共查到"+all.size()+"条CI数据");
		int base = 0;
		for(;;){
			int total = simpleMapper.getTotalNumber("BMS_CROSSING_INFO");
			if(total>base){
				logger.info("新增"+(total-base)+"条CI数据");
				all = simpleMapper.getAllCrossingInfo();
				List<CrossingInfo> xz = all.subList(base, total);
				upload(xz,"BMS_CROSSING_INFO",config);
			}
			base = total;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
	public void uploadLaneInfo(Config config) {		
		List<LaneInfo> all = simpleMapper.getAllLaneInfo();
		logger.info("共查到"+all.size()+"条LI数据");
		int base = 0;
		for(;;){
			int total = simpleMapper.getTotalNumber("BMS_LANE_INFO");
			if(total>base){
				logger.info("新增"+(total-base)+"条LI数据");
				all = simpleMapper.getAllLaneInfo();
				List<LaneInfo> xz = all.subList(base, total);
				upload(xz,"BMS_LANE_INFO",config);
			}
			base = total;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
	}

	private <T> void upload(List<T> all, String tableName, Config config){
		int u = 0;
		while (u < all.size()) {
			JSONArray records = new JSONArray();
			for (int i = 0; i < 50; i++) {
				if (i < 50 && u<all.size()) {
					records.add(all.get(u));
				} else {
					break;
				}
				u++;
			}
			try {
				if (records.size() > 0) {
					HttpHelper.uploadRecordsByTable(tableName,
							records, config, null);

					logger.info("Success:上传" + records.size() + "条数据成功");
				}
			} catch (Throwable e) {
				logger.error("Error:上传" + records.size() + "条数据失败");
			}
		}	
	}
	public void uploadOne(File img, Config config) {
		logger.info("===============uploadOne begin");
		String url = null;
		try {
			url = HttpHelper.uploadImgSingleAndGetTheUrlBack(img, config);
			logger.info("Success:图片上传成功1");
		} catch (Throwable e) {
			logger.error("Error:上传图片失败1");
		}
		if (url != null) {
			String imgName = img.getName();
			String[] args = imgName.split("A");
			String index = args[0];
			String flag = args[1];
			// 更新CrossingPass
			logger.info("1B---");
			if (flag.contains("1B")) {
				VehiclePass vehiclePass = null;
				try {
					simpleMapper.updateVehiclePass(url, index);
					vehiclePass = simpleMapper.getVehiclePassByIndex(index);
					logger.info("Success:更新本地数据库成功2");
				} catch (Throwable e) {
					logger.error("Error:更新本地数据库失败2");
				}
				if (vehiclePass != null) {
					JSONArray records = new JSONArray();
					records.add(vehiclePass);
					try {
						HttpHelper.uploadRecordsByTable("BMS_VEHICLE_PASS",
								records, config, null);
						logger.info("Success:上传一条数据到云端成功3");
					} catch (Throwable e) {
						logger.error("Error:上传一条数据到云端失败3");
					}
				}
			}
			logger.info("2B---");
			if (flag.contains("2B")) {
				VehicleViolation vehicleViolation = null;
				try {
					simpleMapper.updateVehicleViolation(url, index);
					vehicleViolation = simpleMapper
							.getVehicleViolationByIndex(index);
					logger.info("Success:更新本地数据库成功2");
				} catch (Throwable e) {
					logger.error("Error:更新本地数据库失败2");
				}
				if (vehicleViolation != null) {
					JSONArray records = new JSONArray();
					records.add(vehicleViolation);
					try {
						HttpHelper.uploadRecordsByTable(
								"BMS_VEHICLE_VIOLATION", records, config, null);
						logger.info("Success:上传一条数据到云端成功3");
						FileUtil.del(img);
					} catch (Throwable e) {
						logger.error("Error:上传一条数据到云端失败3");
					}
				}
			}
		}
		logger.info("===============uploadOne end");
	}
}
