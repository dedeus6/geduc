package com.br.geduc.service;

import com.azure.storage.blob.BlobClientBuilder;
import com.br.geduc.document.FileDocument;
import com.br.geduc.document.StorageFileDocument;
import com.br.geduc.dto.response.StorageResponseDTO;
import com.br.geduc.exceptions.BusinessException;
import com.br.geduc.repository.StorageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.br.geduc.constants.Errors.AZURE_ERROR;
import static java.lang.String.format;

import static com.br.geduc.constants.Errors.FILE_LIST_IS_EMPTY;

@Service
@AllArgsConstructor
@Slf4j
public class StorageService {

    private StorageRepository storageRepository;

    private BlobClientBuilder blobClient;

    public StorageResponseDTO uploadFiles(List<MultipartFile> files) {
        if (files.isEmpty())
            throw new BusinessException(FILE_LIST_IS_EMPTY);

        var document = storageRepository.save(StorageFileDocument.builder().build());
        asyncUploadFiles(files, document);
        return StorageResponseDTO.builder()
                .filesId(document.getId())
                .build();
    }

    @Async
    private void asyncUploadFiles(List<MultipartFile> files, StorageFileDocument document) {
        files.forEach(file -> {
            FileDocument fileDocument = saveFileOnAzure(file);
            document.getFiles().add(fileDocument);
        });

        document.setFinalUploadDate(LocalDateTime.now());
        storageRepository.save(document);
    }

    private FileDocument saveFileOnAzure(MultipartFile file) {
        try {
            var fileDocument = FileDocument.builder()
                    .azureId(UUID.randomUUID().toString())
                    .originalName(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .build();


            blobClient.blobName(fileDocument.getAzureId())
                    .buildClient()
                    .upload(file.getInputStream(), file.getSize());
            return fileDocument;
        } catch (IOException e) {
            log.error(format(AZURE_ERROR, file.getOriginalFilename(), e.getMessage()));
        }
        return null;
    }


}
