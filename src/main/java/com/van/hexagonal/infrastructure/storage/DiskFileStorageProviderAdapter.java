package com.van.hexagonal.infrastructure.storage;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public class DiskFileStorageProviderAdapter implements FileStorageProvider {

    /*@Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Value("${minio.endpoint}")
    private String url;

    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey,secretKey)
                .build();
    }*/



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
