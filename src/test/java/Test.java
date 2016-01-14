import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 * @author chenhuaming
 * 2016-1-13
 * 
 */
public class Test {
	public static void main(String args[]){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<10; i++){
			list.add(i);
		}
		List<Integer> sub = list.subList(0, 3);
		System.out.println(JSON.toJSONString(sub));
	}
}
