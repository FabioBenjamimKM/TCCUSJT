package com.usjt.tcc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagemService {

	public void SalvaImagem(MultipartFile file) throws IOException {
		File convFile = new File(
				"C:\\imagens\\icon.png");
		new File("C:\\imagens").mkdirs();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
	}
	
	public byte[] getImagem() throws IOException {
		try {
			File folder = new File("C:\\imagens\\icon.png");
			InputStream in = new FileInputStream(folder);
			return IOUtils.toByteArray(in);			
		} catch (Exception e) {
			return null;
		}
	}
}
