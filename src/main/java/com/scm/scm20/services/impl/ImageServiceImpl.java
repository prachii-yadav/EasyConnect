package com.scm.scm20.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.scm.scm20.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String uploadImage(MultipartFile contactImage) {

        // code to uploade image on server

        return "";
    }

}
