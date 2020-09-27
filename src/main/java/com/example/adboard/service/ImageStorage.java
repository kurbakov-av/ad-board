package com.example.adboard.service;

import com.example.adboard.domain.image.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface ImageStorage {

    Image store(MultipartFile file);

    default Collection<Image> store(Iterable<MultipartFile> files) {
        return StreamSupport.stream(files.spliterator(), false)
                .map(this::store)
                .collect(Collectors.toList());
    }
}
