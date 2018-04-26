package com.pravin.tutorial.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @GetMapping("/")
    public String fileUploadForm(Model model) {
	return "fileUploadForm";
    }

    @PostMapping("/singleFileUpload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
	if (!file.getOriginalFilename().isEmpty()) {
	    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(
		    new File("/home/ppatil/Documents/singleFileUpload/", file.getOriginalFilename())));
	    bufferedOutputStream.write(file.getBytes());
	    bufferedOutputStream.flush();
	    bufferedOutputStream.close();
	    model.addAttribute("msg", "File uploaded successfully");
	} else {
	    model.addAttribute("msg", "Please select a valid file...");
	}
	return "fileUploadForm";
    }

    @PostMapping("/multipleFileUpload")
    public String multipleFileUpload(@RequestParam("file") MultipartFile[] files, Model model) throws IOException {

	for (MultipartFile file : files) {
	    if (!file.getOriginalFilename().isEmpty()) {
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(
			new File("/home/ppatil/Documents/multipleFileUpload/", file.getOriginalFilename())));
		bufferedOutputStream.write(file.getBytes());
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	    } else {
		model.addAttribute("msg", "Please select at least one file...");
		return "fileUploadForm";
	    }
	}
	model.addAttribute("msg", "Multiple Files uploaded successfully");
	return "fileUploadForm";
    }

}
