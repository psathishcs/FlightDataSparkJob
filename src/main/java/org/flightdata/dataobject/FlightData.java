package org.flightdata.dataobject;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author SathishParthasarathy
 * @date Nov-12-2018,7:36:06 AM
 */
@Getter @Setter
public class FlightData {
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer day_of_week;
	private Integer dep_time;
	private Integer crs_dep_time;
	private Integer arr_time;
	private Integer crs_arr_time;
	private String unique_carrier;
	private Integer flight_num;
	private String tail_num;
	private Integer actual_elapsed_time;
	private Integer crs_elapsed_time;
	private Integer air_time;
	private Integer arr_delay;
	private Integer dep_delay;
	private String origin;
	private String dest;
	private Integer distance;
	private Integer taxi_in;
	private Integer taxi_out;
	private Integer cancelled;
	private String cancellation_code;
	private Integer diverted;
	private String carrier_delay;
	private String weather_delay;
	private String nas_delay;
	private String security_delay;
	private String late_aircraft_delay;

	
}
