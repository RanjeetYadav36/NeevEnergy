package com.innobitsystems.neev.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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
      List<CsvUploadModel> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<CsvUploadModel> getAllData(){
	 List<CsvUploadModel> s = repository.findAll();
	 return s;
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
