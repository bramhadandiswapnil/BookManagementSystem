package com.api.book.bookrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bookrestbook.helper.FileUploadHelper;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper h;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		try {
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		
		if(!file.getContentType().equals("image/png")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only png file type allowed");
			
			
			
		}
		
		 boolean b = h.uploadFile(file);
		 if(b) {
			 return ResponseEntity.ok("File is sucessfully upload..");
		 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somethimg went wrong..");
	}
}
