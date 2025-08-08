package com.api.book.bookrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR="C:\\Users\\Vitthal Computers\\Documents\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\RestAPI\\src\\main\\resources\\static\\images";
	
	public boolean uploadFile(MultipartFile file) {
		
		boolean f = false;
		try {
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
