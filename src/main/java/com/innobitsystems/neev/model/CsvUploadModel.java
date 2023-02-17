package com.innobitsystems.neev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "csvUpload")
public class CsvUploadModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = true)
    private Long id;
	
	 @Column(name = "userid")
	  private String userid;

	
	public String getUserid() {
		return userid;
	}

	public CsvUploadModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CsvUploadModel(Long id, String userid, String uploadedtime, String districtName, String block, String gpName,
			String clusterName, String wardNumber, String gpsCordinateOfpole, String poleNumber, String lightInWattage,
			String lightimage, String reconductoringStartPoleNo, String reconductoringEndPoleNo, String spanLength,
			String landmark) {
		this.id = id;
		this.userid = userid;
		this.uploadedtime = uploadedtime;
		this.districtName = districtName;
		this.block = block;
		this.gpName = gpName;
		this.clusterName = clusterName;
		this.wardNumber = wardNumber;
		this.gpsCordinateOfpole = gpsCordinateOfpole;
		this.poleNumber = poleNumber;
		this.lightInWattage = lightInWattage;
		this.lightimage = lightimage;
		this.reconductoringStartPoleNo = reconductoringStartPoleNo;
		this.reconductoringEndPoleNo = reconductoringEndPoleNo;
		this.spanLength = spanLength;
		this.landmark = landmark;
	}

	@Override
	public String toString() {
		return "CsvUploadModel [id=" + id + ", userid=" + userid + ", uploadedtime=" + uploadedtime + ", districtName="
				+ districtName + ", block=" + block + ", gpName=" + gpName + ", clusterName=" + clusterName
				+ ", wardNumber=" + wardNumber + ", gpsCordinateOfpole=" + gpsCordinateOfpole + ", poleNumber="
				+ poleNumber + ", lightInWattage=" + lightInWattage + ", lightimage=" + lightimage
				+ ", reconductoringStartPoleNo=" + reconductoringStartPoleNo + ", reconductoringEndPoleNo="
				+ reconductoringEndPoleNo + ", spanLength=" + spanLength + ", landmark=" + landmark + "]";
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getReconductoringEndPoleNo() {
		return reconductoringEndPoleNo;
	}

	public void setReconductoringEndPoleNo(String reconductoringEndPoleNo) {
		this.reconductoringEndPoleNo = reconductoringEndPoleNo;
	}

	public String getSpanLength() {
		return spanLength;
	}

	public void setSpanLength(String spanLength) {
		this.spanLength = spanLength;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUploadedtime() {
		return uploadedtime;
	}

	public void setUploadedtime(String uploadedtime) {
		this.uploadedtime = uploadedtime;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getBlockName() {
		return block;
	}

	public void setBlockName(String blockName) {
		this.block = blockName;
	}

	public String getGpName() {
		return gpName;
	}

	public void setGpName(String gpName) {
		this.gpName = gpName;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	public String getGpsCordinateOfpole() {
		return gpsCordinateOfpole;
	}

	public void setGpsCordinateOfpole(String gpsCordinateOfpole) {
		this.gpsCordinateOfpole = gpsCordinateOfpole;
	}

	public String getPoleNumber() {
		return poleNumber;
	}

	public void setPoleNumber(String poleNumber) {
		this.poleNumber = poleNumber;
	}

	public String getLightInWattage() {
		return lightInWattage;
	}

	public void setLightInWattage(String lightInWattage) {
		this.lightInWattage = lightInWattage;
	}

	public String getLightimage() {
		return lightimage;
	}

	public void setLightimage(String lightimage) {
		this.lightimage = lightimage;
	}

	public String getReconductoringStartPoleNo() {
		return reconductoringStartPoleNo;
	}

	public void setReconductoringStartPoleNo(String reconductoringStartPoleNo) {
		this.reconductoringStartPoleNo = reconductoringStartPoleNo;
	}

	@Column(name = "uploaded_time")
	  private String uploadedtime;

  @Column(name = "district_name")
  private String districtName;
  

  
  @Column(name = "block_name")
  private String block;
  
  @Column(name = "gp_name")
  private String gpName;

  @Column(name = "cluster_name")
  private String clusterName;
  
  @Column(name = "ward_number")
  private String wardNumber;
  
  @Column(name = "gps_coordinates_of_each_poles")
  private String gpsCordinateOfpole;
  
  @Column(name = "pole_no")
  private String poleNumber;
  
  @Column(name = "light_in_wattage")
  private String lightInWattage;
  
  
  @Column(name = "light_image")
  private String lightimage;
  
  @Column(name = "reconductoring_start_pole_no")
  private String reconductoringStartPoleNo;
  
  
  @Column(name = "reconductoring_end_pole_no")
  private String reconductoringEndPoleNo;
  
  @Column(name = "span_length")
  private String spanLength;
  
  @Column(name = "landmark")
  private String landmark;
  
  
  
  
  public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


}