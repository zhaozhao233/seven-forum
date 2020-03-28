package com.seven.forum.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.UUID;
@Component
public class PictureUtils {
    private final String IMAGE_PATH = "D:/myProject/sevenForum/comment";

    public String upload(MultipartFile uploadFile) throws IOException {
        new File(IMAGE_PATH).mkdir();
        String path = IMAGE_PATH + "/" + UUID.randomUUID() + uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf("."));
        File file = new File(path);
        uploadFile.transferTo(file);
        return path;
    }

    public ResponseEntity<InputStreamResource> download(String filename) throws UnsupportedEncodingException, FileNotFoundException {
        File file = new File(filename);
        String mediaType = URLConnection.guessContentTypeFromName(filename);
        if (mediaType == null) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(mediaType));
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(filename, "utf-8"));
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<>(inputStreamResource, httpHeaders, HttpStatus.OK);
    }
}
