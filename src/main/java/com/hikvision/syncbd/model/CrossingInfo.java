package com.hikvision.syncbd.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CrossingInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long crossing_id;
	private String altitude;
	private Long cascade_id;
	private Long control_unit_id;
	private String controlunit_indexcode;
	private Long crossing_mode;
	private Long crossing_type;
	private Long enable_relate;
	private Long front_type;
	private String crossing_index_code;
	private Long intercity;
	private Long internal_code;
	private String jccrossingindexcode;
	private Long lane_num;
	private String latitude;
	private String longitude;
	private String crossing_name;
	private String photo;
	private String related_camera_name;
	private String related_camera_path;
	private Timestamp updatetime;
	private Long crossing_server_id;

	public Long getCrossing_id() {
		return crossing_id;
	}

	public void setCrossing_id(Long crossing_id) {
		this.crossing_id = crossing_id;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public Long getCascade_id() {
		return cascade_id;
	}

	public void setCascade_id(Long cascade_id) {
		this.cascade_id = cascade_id;
	}

	public Long getControl_unit_id() {
		return control_unit_id;
	}

	public void setControl_unit_id(Long control_unit_id) {
		this.control_unit_id = control_unit_id;
	}

	public String getControlunit_indexcode() {
		return controlunit_indexcode;
	}

	public void setControlunit_indexcode(String controlunit_indexcode) {
		this.controlunit_indexcode = controlunit_indexcode;
	}

	public Long getCrossing_mode() {
		return crossing_mode;
	}

	public void setCrossing_mode(Long crossing_mode) {
		this.crossing_mode = crossing_mode;
	}

	public Long getCrossing_type() {
		return crossing_type;
	}

	public void setCrossing_type(Long crossing_type) {
		this.crossing_type = crossing_type;
	}

	public Long getEnable_relate() {
		return enable_relate;
	}

	public void setEnable_relate(Long enable_relate) {
		this.enable_relate = enable_relate;
	}

	public Long getFront_type() {
		return front_type;
	}

	public void setFront_type(Long front_type) {
		this.front_type = front_type;
	}

	public String getCrossing_index_code() {
		return crossing_index_code;
	}

	public void setCrossing_index_code(String crossing_index_code) {
		this.crossing_index_code = crossing_index_code;
	}

	public Long getIntercity() {
		return intercity;
	}

	public void setIntercity(Long intercity) {
		this.intercity = intercity;
	}

	public Long getInternal_code() {
		return internal_code;
	}

	public void setInternal_code(Long internal_code) {
		this.internal_code = internal_code;
	}

	public String getJccrossingindexcode() {
		return jccrossingindexcode;
	}

	public void setJccrossingindexcode(String jccrossingindexcode) {
		this.jccrossingindexcode = jccrossingindexcode;
	}

	public Long getLane_num() {
		return lane_num;
	}

	public void setLane_num(Long lane_num) {
		this.lane_num = lane_num;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCrossing_name() {
		return crossing_name;
	}

	public void setCrossing_name(String crossing_name) {
		this.crossing_name = crossing_name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getCrossing_server_id() {
		return crossing_server_id;
	}

	public void setCrossing_server_id(Long crossing_server_id) {
		this.crossing_server_id = crossing_server_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}