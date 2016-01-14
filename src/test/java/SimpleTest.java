import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hikvision.syncbd.common.Config;
import com.hikvision.syncbd.common.FileUtil;
import com.hikvision.syncbd.common.HttpHelper;
import com.hikvision.syncbd.common.HttpRequest;
import com.hikvision.syncbd.common.WrapperException;
import com.hikvision.syncbd.mapper.SimpleMapper;

/**
 * @author chenhuaming 2016-1-8
 * 
 */
public class SimpleTest {
	
	

	// @Test
	public void testSendPost() throws ClientProtocolException, IOException,
			WrapperException {
		for (int i = 0; i < 100; i++) {
			new HttpRequest().sendPostWithUrlEncodedFormEntity("http://www.apple.com/",
					new HashMap<String, String>(), Consts.UTF_8);
		}
	}

	//@Test
	public void testSendPost2() throws ClientProtocolException, IOException,
			WrapperException {
		System.out.println("中文");
		new HttpRequest().sendPostWithFile("http://www.baidu.com",
				new HashMap<String, String>(), Charset.forName("UTF-8"),
				new File("protocal.txt"));

	}

	// @Test
	public void testFileToByteArray() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		for (int i = 0; i < 100; i++) {
			Method method = HttpRequest.class.getDeclaredMethod(
					"fileToByteArray", File.class);
			method.setAccessible(true);
			method.invoke(HttpRequest.class, new File("protocal.txt"));
		}
	}

	//@Test
	public void testFileUtil() {
		File[] files = FileUtil
				.getFilesOnDirectoryNotIncludeFolder("C:/Users/chenhuaming/Desktop/testImage");
		for (File f : files) {
			System.out.println(f.getName());
		}
	}
	//@Test
	public void testHttpHelper() throws ClientProtocolException, IOException, WrapperException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		Config config = ctx.getBean(Config.class);
		File img = new File("C:/Users/chenhuaming/Desktop/testImage/test001.png");
		System.out.println(HttpHelper.uploadImgSingleAndGetTheUrlBack(img, config));
	}
	@Test
	public void test11(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		SimpleMapper simpleMapper = ctx.getBean(SimpleMapper.class);
		System.out.println(simpleMapper.getTotalNumber("BMS_CROSSING_INFO"));
	}
}
