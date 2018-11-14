package org.flightdata;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

public class FlightDataWithPartitionApplication {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No files provided");
			System.exit(0);
		}
		processData(args[0]);
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
		inputFile.write().mode(SaveMode.Overwrite).saveAsTable("flight.flight_data_partion_by_month");
	}
}
