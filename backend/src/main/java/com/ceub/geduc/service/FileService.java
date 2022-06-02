package com.ceub.geduc.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	@Value("${geduc.files.path}")
	private String sourcePath;
	
	@Value("${geduc.files.path.videos}")
	private String videosPath;
	
	public void saveFileOnSystem(Set<MultipartFile> files) {
		for (MultipartFile file : files) {
			saveFile(this.videosPath, file);
		}
	}
	
	private void saveFile(String path, MultipartFile file) {
		Path diretoryPath = Paths.get(this.sourcePath, path);
		Path archivePath = diretoryPath.resolve(file.getOriginalFilename());
		try {
			Files.createDirectories(diretoryPath);
			file.transferTo(archivePath.toFile());			
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}
	}

}
