package com.innobitsystems.neev.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.innobitsystems.neev.model.CsvUploadModel;


public class CSVHelper {
  public static String TYPE = "text/csv";

  static String[] HEADERs = { "id", "userid", "uploaded_time", "district_name","block_name","gp_name","cluster_name","ward_number","gps_coordinates_of_each_poles","pole_no" ,"light_in_wattage","light_image","reconductoring_start_pole_no","reconductoring_end_pole_no","span_length","landmark"};

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<CsvUploadModel> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<CsvUploadModel> tutorials = new ArrayList<CsvUploadModel>();
      List<CSVRecord> cs = new ArrayList<CSVRecord>();
//      for(int i=0;i<cs.size();i++) {
//    	  syso
//      }

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
   
      for (CSVRecord csvRecord : csvRecords) {
  		System.out.println(              csvRecord.get("block_name")+"klllllllllllllllllllllllllll");

        CsvUploadModel tutorial = new CsvUploadModel(
        	
//        		this.id = id;
//        		this.userid = userid;
//        		this.uploadedtime = uploadedtime;
//        		this.districtName = districtName;
//        		this.block = block;
//        		this.gpName = gpName;
//        		this.clusterName = clusterName;
//        		this.wardNumber = wardNumber;
//        		this.gpsCordinateOfpole = gpsCordinateOfpole;
//        		this.poleNumber = poleNumber;
//        		this.lightInWattage = lightInWattage;
//        		this.lightimage = lightimage;
//        		this.reconductoringStartPoleNo = reconductoringStartPoleNo;
//        		this.reconductoringEndPoleNo = reconductoringEndPoleNo;
//        		this.spanLength = spanLength;
//        		this.landmark = landmark;
        		
//              Long.parseLong(csvRecord.get("id")),
              csvRecord.get("userid"),
              csvRecord.get("uploaded_time"),
              csvRecord.get("district_name"),
              csvRecord.get("block_name"),
              csvRecord.get("gp_name"),
              csvRecord.get("cluster_name"),
              csvRecord.get("ward_number"),
              csvRecord.get("gps_coordinates_of_each_poles"),
              csvRecord.get("pole_no"),
              csvRecord.get("light_in_wattage"),
              csvRecord.get("light_image"),
              csvRecord.get("reconductoring_start_pole_no"),
              csvRecord.get("reconductoring_end_pole_no"),
              csvRecord.get("span_length"),
              csvRecord.get("landmark")
              


            );
System.out.println(tutorial);
        tutorials.add(tutorial);
      }

      return tutorials;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream tutorialsToCSV(List<CsvUploadModel> tutorials) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (CsvUploadModel tutorial : tutorials) {
        List<Object> data = Arrays.asList(
              String.valueOf(tutorial.getId()),
              tutorial.getBlockName(),
              tutorial.getClusterName(),
              tutorial.getDistrictName(),
              tutorial.getGpName(),
              tutorial.getGpsCordinateOfpole(),
              tutorial.getId(),
              tutorial.getLightimage(),
              tutorial.getLightInWattage(),
              tutorial.getPoleNumber(),
             tutorial.getReconductoringStartPoleNo(),
             tutorial.getUploadedtime(),
             tutorial.getUserid(),
             tutorial.getWardNumber()    
            
              
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }

}
