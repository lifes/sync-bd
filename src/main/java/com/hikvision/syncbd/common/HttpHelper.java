package com.hikvision.syncbd.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author chenhuaming 2016-1-8
 * 
 */
public class HttpHelper {
	public static String uploadImgSingleAndGetTheUrlBack(File img, Config config)
			throws ClientProtocolException, IOException, WrapperException {
		String accessUser = config.getAccessUser();
		String accessKey = config.getAccessKey();
		String storeName = config.getNoStructuredStoreName();
		String typeName = config.getNoStructuredTypeName();
		String uploadImgSingleUrl = config.getUploadImgSingleUrl();
		Map<String, String> params = new HashMap<String, String>();
		params.put("accessUser", accessUser);
		params.put("accessKey", accessKey);
		params.put("storeName", storeName);
		params.put("typeName", typeName);
		params.put("fileType", "IMAGE");
		String jsonString = new HttpRequest().sendPostWithFile(
				uploadImgSingleUrl, params, null, img);
		try {
			JSONObject json = JSON.parseObject(jsonString);
			if (json.getIntValue("statusCode") == 100) {
				return json.getString("message");
			} else {
				throw new WrapperException(
						"error:statusCode != 100, the return statusCode = "
								+ json.getIntValue("statusCode"));
			}
		} catch (Throwable e) {
			throw new WrapperException("Json parse error ~~!");
		}
	}

	public static boolean uploadRecordsByTable(String tableName,
			JSONArray records, Config config, Charset charset)
			throws ClientProtocolException, IOException, WrapperException {
		String accessUser = config.getAccessUser();
		String accessKey = config.getAccessKey();
		String storeName = config.getStructuredStoreName();
		String typeName = config.getNoStructuredStoreName()
				+ tableName.toUpperCase();
		String uploadRecordsUrl = config.getUploadRecordsUrl();
		Map<String, String> params = new HashMap<String, String>();
		params.put("accessUser", accessUser);
		params.put("accessKey", accessKey);
		params.put("storeName", storeName);
		params.put("typeName", typeName);
		params.put("records", JSONArray.toJSONString(records,
				SerializerFeature.WriteMapNullValue));
		if (charset == null) {
			charset = Charset.forName("UTF-8");
		}
		new HttpRequest().sendPostWithUrlEncodedFormEntity(uploadRecordsUrl,
				params, charset);
		return false;
	}
}
