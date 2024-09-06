package com.van.hexagonal.infrastructure.storage;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageProvider {
    public void init();

    public void createfolder(String name) ;

    public void saveFileOnFolder(MultipartFile file, String folderName);

    public Resource loadFileOnFolder(String filename, String folderName);

    public void save(MultipartFile file);

    public String  renameAndSave(MultipartFile file);

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

}
