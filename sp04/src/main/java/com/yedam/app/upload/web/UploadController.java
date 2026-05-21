package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UploadController {
	//파일의 업로드 경로
	@Value("${file.upload.path}")
	private String uploadPath;
	
	//페이지
	@GetMapping("formUpload")
	public void formUploadPage() {};
	
	//처리
	@PostMapping("uploadForm")
	public String formUploadFile(@RequestPart("file") MultipartFile images) {
		log.info(uploadPath);
		log.info(images.getContentType()); //파일의 종류 및 확장자
		log.info(images.getOriginalFilename()); //파일이름
		log.info(String.valueOf(images.getSize())); //크기
		
		String fileName = images.getOriginalFilename();
		String saveName = uploadPath + File.separator + fileName;
		
		log.debug("saveName : " + saveName);
		
		//실제 경로로 인식하는 객체(클래스)
		Path savePath = Paths.get(saveName);
		
		try {
			images.transferTo(savePath);
		} catch (IllegalStateException e) {//경로에 대한 정보가 잘못되면 이거
			e.printStackTrace();
		} catch (IOException e) {//파일 읽고, 쓸때 잘못되면 이거
			e.printStackTrace();
		}
		
		return "redirect:formUpload";
	}
	
	@PostMapping("/uploadAjax")
	@ResponseBody
	public List<String> uploadFile(@RequestPart MultipartFile[] uploads){
		List<String> imageList = new ArrayList();
		for(MultipartFile file : uploads) {
			if(!file.getContentType().startsWith("image")) {
			log.error("this file is not image");
			return null;
			}
			//실제 파일명
			String fileName = file.getOriginalFilename();
			//식별자
			String uuid = UUID.randomUUID().toString(); //uuid로 중복 방지 (고유식별자 붙임)
			//업로드할 파일명
			String uploadName = uuid + "_" + fileName;
			//업로드 경로와 결합해서 실제 저장될 경로가 만들어짐
			String saveName = uploadPath + File.separator + uploadName;
			
			Path savePath = Paths.get(saveName);
			
			try {
				file.transferTo(savePath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//DB에 해당 경로 저장
			//1) 실제 서버에 업로드한 경로
			//2) 사용자가 업로드할 때 사용한 파일명
			imageList.add(uploadName);
		}
		return imageList;
	}
}
