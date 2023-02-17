package com.innobitsystems.neev.repo;

import com.innobitsystems.neev.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TutorialRepository extends JpaRepository<CsvUploadModel, Long> {
	
    public List<CsvUploadModel> findByDistrictName(String district);
    public List<CsvUploadModel> findByClusterName(String cluster);

    
    public List<CsvUploadModel> findByBlockAndDistrictName(String district,String d );
    
    
//    @Query("select c FROM CsvUploadModel c WHERE c.districtName= : d" )
//    public List<CsvUploadModel> getByDistrictAndBlock(@Param("d") String district,@Param("b")String block);
//
//    @Query(value = "SELECT * FROM CsvUploadModel ", nativeQuery = true)
//    public List<CsvUploadModel> findAllSortedByNameUsingNative();
    
    @Query("SELECT u FROM CsvUploadModel u WHERE u.clusterName= ?1")
    List<CsvUploadModel> findUserByStatus(String cluster,String gpName,String Block,String District);

//    @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//    User findUserByStatusAndName(Integer status, String name);

}
