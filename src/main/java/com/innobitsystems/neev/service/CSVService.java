package com.innobitsystems.neev.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.innobitsystems.neev.model.*;
import com.innobitsystems.neev.repo.*;
import com.innobitsystems.neev.exception.*;
import com.innobitsystems.neev.helper.CSVHelper;




@Service
public class CSVService {
  @Autowired
  TutorialRepository repository;

  public void save(MultipartFile file) {
    try {
    	System.out.println("jlkjlklklk isde save");
      List<CsvUploadModel> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      System.out.println(tutorials.size()+"jlsdkjkajsdkfjaskljfkjs");
      List<CsvUploadModel> f1 = repository.findAll();
      if(f1.size()!=0) {
    	  System.out.println("inside delete all ");
    	  repository.deleteAllInBatch();
      }
      for(int i=0;i<tutorials.size();i++) {
          CsvUploadModel c = new CsvUploadModel();

//    	  System.out.println(tutorials.get(i));
    	  c.setBlock(tutorials.get(i).getBlock());
    	  c.setClusterName(tutorials.get(i).getClusterName());
    	  c.setDistrictName(tutorials.get(i).getDistrictName());
    	  c.setGpName(tutorials.get(i).getGpName());
    	  c.setGpsCordinateOfpole(tutorials.get(i).getGpsCordinateOfpole());
    	  if(!tutorials.get(i).getLightimage().contains(",")) {
    	  c.setLightimage(tutorials.get(i).getLightimage());}
    	  else {
    		  String str = tutorials.get(i).getLightimage();
    		  System.out.println(str+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    		  String splStr[] = str.split(",");
    		  for(int k=0;k<splStr.length;k++) {
    			  c.setBlock(tutorials.get(i).getBlock());
    	    	  c.setClusterName(tutorials.get(i).getClusterName());
    	    	  c.setDistrictName(tutorials.get(i).getDistrictName());
    	    	  c.setGpName(tutorials.get(i).getGpName());
    	    	  c.setGpsCordinateOfpole(tutorials.get(i).getGpsCordinateOfpole());
    	    	  System.out.println(splStr[k]);
    	    	  c.setLightimage(splStr[k]);
    	          repository.save(c);
    	    	  
    			  
    		  }
    	  }
    	  c.setLandmark(tutorials.get(i).getLandmark());
          repository.save(c);
//System.out.println(i);
//System.out.println(tutorials.size());
      }
      System.out.println("iinside service 31");
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<CsvUploadModel> getAllData(){
	 List<CsvUploadModel> s = repository.findAll();
	 return s;
  } 
  public HashMap<String, Object> getAllDataAndBlock(String District,String Block,String gpName,String Cluster){
	  System.out.println(Cluster);
	 List<CsvUploadModel> s = repository.findByClusterName(Cluster);
     HashMap<String, Object> map = new HashMap<>();
     List<String > str = new ArrayList<>();
     for(int i=0;i<s.size();i++) {
    	str.add(s.get(i).getLightimage());
     }
     map.put("lighimage", str);
	 return map;
  } 
  
  public List<CsvUploadModel> getByDistrict(String district){
		 List<CsvUploadModel> s = repository.findByDistrictName(district);
		 return s;
	  } 
  
  
  public ByteArrayInputStream load() {
    List<CsvUploadModel> tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }

  public List<CsvUploadModel> getAllTutorials() {
    return repository.findAll();
  }
}
