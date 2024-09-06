package com.van.hexagonal.infrastructure.storage;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MinioFileStorageProviderAdapter implements FileStorageProvider {

    Logger log = LoggerFactory.getLogger(MinioFileStorageProviderAdapter.class);


    @Override
    public void init() {

    }

    @Override
    public void createfolder(String name) {

    }

    @Override
    public void saveFileOnFolder(MultipartFile file, String folderName) {

    }

    @Override
    public Resource loadFileOnFolder(String filename, String folderName) {

        return null;
    }

    @Override
    public void save(MultipartFile file) {

    }

    @Override
    public String renameAndSave(MultipartFile file) {
        return null;
    }

    @Override
    public Resource load(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }
}
