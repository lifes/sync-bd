package com.hikvision.syncbd.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class VehicleViolation implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long vehicle_violation_id;
	private Long alarm_action;
	private Long vehicle_logo;
	private Long veh_color_depth;
	private Long crossing_id;
	private Long image_server_id;
	private Long lane_id;
	private Timestamp alarm_time;
	private String pic_abbreviate;
	private String pic_plate;
	private String pic_vehicle_1;
	private String pic_vehicle_2;
	private String pic_vehicle_3;
	private String pic_vehicle_4;
	private Long plate_color;
	private String plate_info;
	private Long plate_type;
	private Timestamp update_time;
	private Long vehicle_audit;
	private Long vehicle_color;
	private Long vehicle_id;
	private String vehicle_index;
	private Long vehicle_model;
	private Long vehicle_speed;
	private Long vehicle_state;
	private Long vehicle_sublogo;
	private Long vehicle_sunvisor;
	private Long vehicle_type;

	public Long getVehicle_violation_id() {
		return vehicle_violation_id;
	}

	public void setVehicle_violation_id(Long vehicle_violation_id) {
		this.vehicle_violation_id = vehicle_violation_id;
	}

	public Long getAlarm_action() {
		return alarm_action;
	}

	public void setAlarm_action(Long alarm_action) {
		this.alarm_action = alarm_action;
	}

	public Long getVehicle_logo() {
		return vehicle_logo;
	}

	public void setVehicle_logo(Long vehicle_logo) {
		this.vehicle_logo = vehicle_logo;
	}

	public Long getVeh_color_depth() {
		return veh_color_depth;
	}

	public void setVeh_color_depth(Long veh_color_depth) {
		this.veh_color_depth = veh_color_depth;
	}

	public Long getCrossing_id() {
		return crossing_id;
	}

	public void setCrossing_id(Long crossing_id) {
		this.crossing_id = crossing_id;
	}

	public Long getImage_server_id() {
		return image_server_id;
	}

	public void setImage_server_id(Long image_server_id) {
		this.image_server_id = image_server_id;
	}

	public Long getLane_id() {
		return lane_id;
	}

	public void setLane_id(Long lane_id) {
		this.lane_id = lane_id;
	}

	public Timestamp getAlarm_time() {
		return alarm_time;
	}

	public void setAlarm_time(Timestamp alarm_time) {
		this.alarm_time = alarm_time;
	}

	public String getPic_abbreviate() {
		return pic_abbreviate;
	}

	public void setPic_abbreviate(String pic_abbreviate) {
		this.pic_abbreviate = pic_abbreviate;
	}

	public String getPic_plate() {
		return pic_plate;
	}

	public void setPic_plate(String pic_plate) {
		this.pic_plate = pic_plate;
	}

	public String getPic_vehicle_1() {
		return pic_vehicle_1;
	}

	public void setPic_vehicle_1(String pic_vehicle_1) {
		this.pic_vehicle_1 = pic_vehicle_1;
	}

	public String getPic_vehicle_2() {
		return pic_vehicle_2;
	}

	public void setPic_vehicle_2(String pic_vehicle_2) {
		this.pic_vehicle_2 = pic_vehicle_2;
	}

	public String getPic_vehicle_3() {
		return pic_vehicle_3;
	}

	public void setPic_vehicle_3(String pic_vehicle_3) {
		this.pic_vehicle_3 = pic_vehicle_3;
	}

	public String getPic_vehicle_4() {
		return pic_vehicle_4;
	}

	public void setPic_vehicle_4(String pic_vehicle_4) {
		this.pic_vehicle_4 = pic_vehicle_4;
	}

	public Long getPlate_color() {
		return plate_color;
	}

	public void setPlate_color(Long plate_color) {
		this.plate_color = plate_color;
	}

	public String getPlate_info() {
		return plate_info;
	}

	public void setPlate_info(String plate_info) {
		this.plate_info = plate_info;
	}

	public Long getPlate_type() {
		return plate_type;
	}

	public void setPlate_type(Long plate_type) {
		this.plate_type = plate_type;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public Long getVehicle_audit() {
		return vehicle_audit;
	}

	public void setVehicle_audit(Long vehicle_audit) {
		this.vehicle_audit = vehicle_audit;
	}

	public Long getVehicle_color() {
		return vehicle_color;
	}

	public void setVehicle_color(Long vehicle_color) {
		this.vehicle_color = vehicle_color;
	}

	public Long getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_index() {
		return vehicle_index;
	}

	public void setVehicle_index(String vehicle_index) {
		this.vehicle_index = vehicle_index;
	}

	public Long getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(Long vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	public Long getVehicle_speed() {
		return vehicle_speed;
	}

	public void setVehicle_speed(Long vehicle_speed) {
		this.vehicle_speed = vehicle_speed;
	}

	public Long getVehicle_state() {
		return vehicle_state;
	}

	public void setVehicle_state(Long vehicle_state) {
		this.vehicle_state = vehicle_state;
	}

	public Long getVehicle_sublogo() {
		return vehicle_sublogo;
	}

	public void setVehicle_sublogo(Long vehicle_sublogo) {
		this.vehicle_sublogo = vehicle_sublogo;
	}

	public Long getVehicle_sunvisor() {
		return vehicle_sunvisor;
	}

	public void setVehicle_sunvisor(Long vehicle_sunvisor) {
		this.vehicle_sunvisor = vehicle_sunvisor;
	}

	public Long getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(Long vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}