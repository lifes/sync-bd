package com.hikvision.syncbd.common;

import java.io.File;
import java.util.Properties;
import org.springframework.stereotype.Component;

/**
 * @author chenhuaming 2016-1-11
 * 
 */
@Component
public class Config {

	private String accessUser;
	private String accessKey;

	private String structuredStoreName;
	private String structuredTypeName;

	private String noStructuredStoreName;
	private String noStructuredTypeName;

	private String directoryPath;
	private String uploadRecordsUrl;
	private String uploadImgSingleUrl;
	private String uploadImgBulkUrl;

	public Config() {
		init();
	}

	private void init() {
		Properties ps = ConfigReader.in("config.properties");
		this.accessUser = ps.getProperty("accessUser");
		this.accessKey = ps.getProperty("accessKey");

		this.structuredStoreName = ps.getProperty("structured.storeName");
		this.structuredTypeName = ps.getProperty("structured.typeName");

		this.noStructuredStoreName = ps.getProperty("nostructured.storeName");
		this.noStructuredTypeName = ps.getProperty("nostructured.typeName");

		this.directoryPath = ps.getProperty("directoryPath");
		this.uploadRecordsUrl = ps.getProperty("uploadRecordsUrl");
		this.uploadImgSingleUrl = ps.getProperty("uploadImgSingleUrl");
		this.uploadImgBulkUrl = ps.getProperty("uploadImgBulkUrl");

		if (accessUser == null || accessKey == null
				|| structuredStoreName == null || structuredTypeName == null
				|| noStructuredStoreName == null
				|| noStructuredTypeName == null || directoryPath == null
				|| uploadRecordsUrl == null || uploadImgSingleUrl == null
				|| uploadImgBulkUrl == null) {
			throw new WrapperRuntimeException(
					"config error, please see the file of config.properties");
		}
		File file = new File(directoryPath);
		if (!file.exists()) {
			throw new WrapperRuntimeException("folder not found==="
					+ directoryPath);
		} else {
			if (!file.isDirectory()) {
				throw new WrapperRuntimeException("not a folder==="
						+ directoryPath);
			}
		}
	}

	public String getAccessUser() {
		return accessUser;
	}

	public void setAccessUser(String accessUser) {
		this.accessUser = accessUser;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getStructuredStoreName() {
		return structuredStoreName;
	}

	public void setStructuredStoreName(String structuredStoreName) {
		this.structuredStoreName = structuredStoreName;
	}

	public String getStructuredTypeName() {
		return structuredTypeName;
	}

	public void setStructuredTypeName(String structuredTypeName) {
		this.structuredTypeName = structuredTypeName;
	}

	public String getNoStructuredStoreName() {
		return noStructuredStoreName;
	}

	public void setNoStructuredStoreName(String noStructuredStoreName) {
		this.noStructuredStoreName = noStructuredStoreName;
	}

	public String getNoStructuredTypeName() {
		return noStructuredTypeName;
	}

	public void setNoStructuredTypeName(String noStructuredTypeName) {
		this.noStructuredTypeName = noStructuredTypeName;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	public String getUploadRecordsUrl() {
		return uploadRecordsUrl;
	}

	public void setUploadRecordsUrl(String uploadRecordsUrl) {
		this.uploadRecordsUrl = uploadRecordsUrl;
	}

	public String getUploadImgSingleUrl() {
		return uploadImgSingleUrl;
	}

	public void setUploadImgSingleUrl(String uploadImgSingleUrl) {
		this.uploadImgSingleUrl = uploadImgSingleUrl;
	}

	public String getUploadImgBulkUrl() {
		return uploadImgBulkUrl;
	}

	public void setUploadImgBulkUrl(String uploadImgBulkUrl) {
		this.uploadImgBulkUrl = uploadImgBulkUrl;
	}

	

}
