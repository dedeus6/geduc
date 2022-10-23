package com.br.geduc.rest;

import com.br.geduc.dto.response.StorageResponseDTO;
import com.br.geduc.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/storage")
public class StorageController {

    private final StorageService service;

    @PostMapping(consumes = MULTIPART_FORM_DATA)
    @ResponseStatus(CREATED)
    public StorageResponseDTO upload(@RequestParam List<MultipartFile> files) {
        return service.uploadFiles(files);
    }

    @PutMapping(value = "/{filesId}", consumes = MULTIPART_FORM_DATA)
    @ResponseStatus(CREATED)
    public StorageResponseDTO update(@PathVariable String filesId, @RequestParam List<MultipartFile> files) {
        return service.updateFiles(filesId, files);
    }

    @GetMapping("/{filesId}")
    @ResponseStatus(OK)
    public StorageResponseDTO getById(@PathVariable String filesId) {
        return service.getEventFiles(filesId);
    }

    @DeleteMapping("/{filesId}")
    @ResponseStatus(OK)
    public void deleteFiles(@PathVariable String filesId, @RequestParam(required = false) String azureId) {
        service.deleteFiles(filesId, azureId);
    }

}
