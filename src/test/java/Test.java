import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.hikvision.syncbd.model.CrossingInfo;
import com.hikvision.syncbd.model.LaneInfo;
import com.hikvision.syncbd.model.VehiclePass;
import com.hikvision.syncbd.model.VehicleViolation;


/**
 * @author chenhuaming
 * 2016-1-13
 * 
 */
public class Test {
	public static void main(String args[]){
		CrossingInfo t1 =	new CrossingInfo();
		Timestamp time = new Timestamp(new Date().getTime());
		t1.setUpdatetime(time);
		LaneInfo t2 = new LaneInfo();
		t2.setUpdatetime(time);
		VehiclePass  t3 = new VehiclePass();
		t3.setUpdate_time(time);
		t3.setPass_time(time);
		VehicleViolation t4 = new VehicleViolation();
		t4.setAlarm_time(time);
		t4.setUpdate_time(time);
		System.out.println(JSON.toJSONString(t1));
		System.out.println(JSON.toJSONString(t2));
		System.out.println(JSON.toJSONString(t3));
		System.out.println(JSON.toJSONString(t4));
	}
}