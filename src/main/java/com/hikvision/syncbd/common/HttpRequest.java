package com.hikvision.syncbd.common;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author chenhuaming 2016-1-8
 * 
 */
public class HttpRequest {

	// send post with urlEncodeFormEntity. (Charset charset = Consts.UTF_8)
	public String sendPostWithUrlEncodedFormEntity(String url,
			Map<String, String> params, Charset charset)
			throws ClientProtocolException, IOException, WrapperException {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			List<NameValuePair> nvps = mapToListNvp(params);
			HttpEntity entity = new UrlEncodedFormEntity(nvps, charset);
			post.setEntity(entity);
			response = client.execute(post);
			int code = response.getStatusLine().getStatusCode();
			HttpEntity resEntity = response.getEntity();
			String s = EntityUtils.toString(resEntity);
			if (200 == code) {
				return s;
			} else {
				throw new WrapperException(
						"server response a bad status code(!=200)");
			}
		} finally {
			if (null != response) {
				response.close();
			}
			if (null != client)
				client.close();
		}
	}

	public String sendPostWithFile(String url, Map<String, String> params,
			Charset charset, File... files) throws ClientProtocolException,
			IOException, WrapperException {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			List<NameValuePair> nvps = mapToListNvp(params);
			nvps.toString();
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			if (charset == null) {
				charset = Charset.forName("UTF-8");
			}
			builder.setCharset(charset);

			// builder.addTextBody("name", "wtf");
			for (NameValuePair nvp : mapToListNvp(params)) {
				builder.addBinaryBody(nvp.getName(),
						nvp.getValue().getBytes(charset));
			}

			for (File file : files) {
				builder.addBinaryBody("file", fileToByteArray(file),
						ContentType.DEFAULT_BINARY, file.getName());
			}
			HttpEntity entity = builder.build();
			post.setEntity(entity);
			response = client.execute(post);
			int code = response.getStatusLine().getStatusCode();
			HttpEntity resEntity = response.getEntity();
			String s = EntityUtils.toString(resEntity);
			if (200 == code) {
				return s;
			} else {
				throw new WrapperException(
						"server response a bad status code(!=200)");
			}
		} finally {
			if (null != response) {
				response.close();
			}
			if (null != client)
				client.close();
		}

	}

	private static List<NameValuePair> mapToListNvp(Map<String, String> map) {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			NameValuePair nvp = new BasicNameValuePair(entry.getKey(),
					entry.getValue());
			nvps.add(nvp);
		}
		return nvps;
	}

	private static byte[] fileToByteArray(File file) throws IOException {
		if (!file.exists()) {
			throw new WrapperRuntimeException(file.getName()
					+ "file can't be found Exception");
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream(
				(int) file.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			throw e;
		} finally {
			if (null != in) {
				in.close();
			}
			bos.close();
		}
	}
}
