package com.innobitsystems.neev.repo;

import com.innobitsystems.neev.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorialRepository extends JpaRepository<CsvUploadModel, Long> {
	
    public List<CsvUploadModel> findByDistrictName(String district);
    
//    public List<CsvUploadModel> findByDistrictAnd(String district);


}
