package com.theodorou.argy.photosclone.web;


import com.theodorou.argy.photosclone.model.Photo;
import com.theodorou.argy.photosclone.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {


    private final PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }


    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/photos")
    public Iterable <Photo> get(){
        return photosService.get;

    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photosService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id){
        photosService.remove(id);
    }

    @PostMapping("/photos/{id}")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photosService.save(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        return photo;

    }
}
