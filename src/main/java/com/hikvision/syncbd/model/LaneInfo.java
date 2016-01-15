package com.hikvision.syncbd.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class LaneInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long lane_id;
	private Long cascade_id;
	private Long crossingcameraid;
	private String direction_name;
	private Long direction_no;
	private Long enable_relate;
	private String lane_index_code;
	private Long directtype;
	private Long jclaneno;
	private Long lane_number;
	private Long lane_type;
	private String lane_name;
	private String related_camera_index_code;
	private String related_camera_name;
	private String related_camera_path;
	private Long speed_limit;
	private Long trigger_type;
	private Timestamp updatetime;
	private Long crossing_id;

	public Long getLane_id() {
		return lane_id;
	}

	public void setLane_id(Long lane_id) {
		this.lane_id = lane_id;
	}

	public Long getCascade_id() {
		return cascade_id;
	}

	public void setCascade_id(Long cascade_id) {
		this.cascade_id = cascade_id;
	}

	public Long getCrossingcameraid() {
		return crossingcameraid;
	}

	public void setCrossingcameraid(Long crossingcameraid) {
		this.crossingcameraid = crossingcameraid;
	}

	public String getDirection_name() {
		return direction_name;
	}

	public void setDirection_name(String direction_name) {
		this.direction_name = direction_name;
	}

	public Long getDirection_no() {
		return direction_no;
	}

	public void setDirection_no(Long direction_no) {
		this.direction_no = direction_no;
	}

	public Long getEnable_relate() {
		return enable_relate;
	}

	public void setEnable_relate(Long enable_relate) {
		this.enable_relate = enable_relate;
	}

	public String getLane_index_code() {
		return lane_index_code;
	}

	public void setLane_index_code(String lane_index_code) {
		this.lane_index_code = lane_index_code;
	}

	public Long getDirecttype() {
		return directtype;
	}

	public void setDirecttype(Long directtype) {
		this.directtype = directtype;
	}

	public Long getJclaneno() {
		return jclaneno;
	}

	public void setJclaneno(Long jclaneno) {
		this.jclaneno = jclaneno;
	}

	public Long getLane_number() {
		return lane_number;
	}

	public void setLane_number(Long lane_number) {
		this.lane_number = lane_number;
	}

	public Long getLane_type() {
		return lane_type;
	}

	public void setLane_type(Long lane_type) {
		this.lane_type = lane_type;
	}

	public String getLane_name() {
		return lane_name;
	}

	public void setLane_name(String lane_name) {
		this.lane_name = lane_name;
	}

	public String getRelated_camera_index_code() {
		return related_camera_index_code;
	}

	public void setRelated_camera_index_code(String related_camera_index_code) {
		this.related_camera_index_code = related_camera_index_code;
	}

	public String getRelated_camera_name() {
		return related_camera_name;
	}

	public void setRelated_camera_name(String related_camera_name) {
		this.related_camera_name = related_camera_name;
	}

	public String getRelated_camera_path() {
		return related_camera_path;
	}

	public void setRelated_camera_path(String related_camera_path) {
		this.related_camera_path = related_camera_path;
	}

	public Long getSpeed_limit() {
		return speed_limit;
	}

	public void setSpeed_limit(Long speed_limit) {
		this.speed_limit = speed_limit;
	}

	public Long getTrigger_type() {
		return trigger_type;
	}

	public void setTrigger_type(Long trigger_type) {
		this.trigger_type = trigger_type;
	}
	
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getCrossing_id() {
		return crossing_id;
	}

	public void setCrossing_id(Long crossing_id) {
		this.crossing_id = crossing_id;
	}

}