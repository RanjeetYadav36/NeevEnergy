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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.innobitsystems.neev.model.CsvUploadModel;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

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

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
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
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("userid"),
              csvRecord.get("uploadedtime"),
              csvRecord.get("districtName"),
              csvRecord.get("blockName"),
              csvRecord.get("gpName"),
              csvRecord.get("clusterName"),
              csvRecord.get("wardNumber"),
              csvRecord.get("gpsCordinateOfpole"),
              csvRecord.get("poleNumber"),
              csvRecord.get("lightInWattage"),
              csvRecord.get("lightimage"),
              csvRecord.get("reconductoringStartPoleNo"),
              csvRecord.get("reconductoringEndPoleNo"),
              csvRecord.get("spanLength"),
              csvRecord.get("landmark")
              


            );

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
