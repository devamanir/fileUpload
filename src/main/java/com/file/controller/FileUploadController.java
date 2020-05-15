package com.file.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.entity.ContenTable;
import com.file.repository.FileUploadRepository;

@RestController
@RequestMapping("/upload/file")
public class FileUploadController {

	@Autowired
	private FileUploadRepository fileUploadRepository;

	@PostMapping(value = "/database")
	public String uploadToDatabase(@RequestParam String name, @RequestParam MultipartFile file)
			throws IOException {

		// Set the form data into entity
		ContenTable saveContent = new ContenTable();
		saveContent.setName(name);
		saveContent.setPhoto(file.getBytes());

		// Save the records into the database
		fileUploadRepository.save(saveContent);

		return "Records saved into database.";
	}

}
