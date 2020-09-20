package com.usjt.tcc.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.usjt.tcc.service.ImagemService;

@RestController
@RequestMapping("/config/imagem")
public class ImagemController {
	
	@Autowired
	ImagemService _service;

	@PostMapping
	public void SalvaImagem(@RequestParam MultipartFile file) throws IOException, TransformerException {
		_service.SalvaImagem(file);
	}

	@GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImagem() throws IOException {
		return _service.getImagem();
	}

}
