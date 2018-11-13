package org.flightdata;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * 
 * @author SathishParthasarathy
 * @date Nov-12-2018,7:36:23 AM
 * 
 */
public class FlightDataApplication {
	public static void main(String[] args) {
		if (args.length == 0) {
			if (args.length == 0) {
				System.out.println("No files provided");
				System.exit(0);
			}
			processData(args[0]);
		}
	}
	private static void processData(String fileName) {
		System.out.println("fileName : " + fileName);
		SparkSession spark =  SparkSession
				.builder()
				.appName("FlightDataJob")
				.config("spark.master", "local")
				.config("hive.metastore.uris", "thrift://localhost:9083")
				.enableHiveSupport()
				.getOrCreate();
		Dataset  inputFile =  spark.read().csv("hdfs://localhost:9000/"+fileName);
		inputFile.show();
		System.out.println("inputFile.count() : " + inputFile.count()); 
	}
}
