package com.innobitsystems.neev.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.innobitsystems.neev.message.ResponseMessage;
import com.innobitsystems.neev.model.CsvUploadModel;
import com.innobitsystems.neev.service.*;
import com.innobitsystems.neev.exception.*;
import com.innobitsystems.neev.helper.CSVHelper;

@CrossOrigin
@RestController
@RequestMapping("/api/csv")
public class CSVController {

	@Autowired
	CSVService fileService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				fileService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@GetMapping("/csvall")
	public ResponseEntity<Object> getAllMessage() throws Exception {

		try {
			List<CsvUploadModel> str = fileService.getAllData();
			return new ResponseEntity<>(str, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/csvf/{district}/{block}/{gpName}/{cluster}")
	public ResponseEntity<Object> getbyDistrictNameandBlock(@PathVariable(value = "district") String district,@PathVariable(value = "block") String block,@PathVariable(value = "gpName") String gpName,@PathVariable(value = "cluster") String cluster) throws Exception {
	System.out.println("74");
		try {
			System.out.println(district+"  " + block +" " + " "+cluster);
			HashMap<String, Object> str = fileService.getAllDataAndBlock(district, block,gpName,cluster);
			return new ResponseEntity<>(str, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/csvDistrict/{district}")
	public ResponseEntity<Object> getByDistrict(@PathVariable(value = "district") String district) throws Exception {

		try {

			List<CsvUploadModel> str = fileService.getByDistrict(district);
			return new ResponseEntity<>(str, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/tutorials")
	public ResponseEntity<List<CsvUploadModel>> getAllTutorials() {
		try {
			List<CsvUploadModel> tutorials = fileService.getAllTutorials();

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> getFile() {
		String filename = "tutorials.csv";
		InputStreamResource file = new InputStreamResource(fileService.load());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/csv")).body(file);
	}

}
