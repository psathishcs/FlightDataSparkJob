package org.flightdata;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

/**
 * 
 * @author SathishParthasarathy
 * @date Nov-12-2018,7:36:23 AM
 * 
 */
public class FlightDataApplication {
	public static void main(String[] args) {
		String  fileName ="/user/psathishcs/datasets/RITA/2007.csv";
		processData(fileName);
	}
	
	private static void processData(String fileName) {
		System.out.println("fileName : " + fileName);
		SparkSession spark =  SparkSession
				.builder()
				.appName("FlightDataJob")
				.config("spark.master", "local")
				.config("hive.metastore.uris", "thrift://skylark.datalake:9083")
				.enableHiveSupport()
				.getOrCreate();
		Dataset  inputFile =  spark.read().option("header", "true").csv("hdfs://skylark.datalake:9000/"+fileName);
		inputFile.show();
		System.out.println("inputFile.count() : " + inputFile.count()); 
		inputFile.write().mode(SaveMode.Overwrite).saveAsTable("flight.flight_data");
	}
}
