package com.inventoryControl.service;

import com.google.cloud.storage.*;
import com.inventoryControl.controllers.seller.models.DocumentFileModel;
import com.inventoryControl.domain.enums.FileType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GoogleStorageAppService {

    private Bucket bucket;
    private final static String BUCKET_NAME = "inventory-control-bucket";

    public GoogleStorageAppService(Storage storage) {
        bucket = storage.get(BUCKET_NAME, Storage.BucketGetOption.fields(Storage.BucketField.values()));
        if (bucket == null)
            bucket = storage.create(BucketInfo.of(BUCKET_NAME));
    }

    public DocumentFileModel save(MultipartFile file, FileType fileType) throws IOException {
        byte[] bytes = file.getBytes();

        var fileName = fileType.toString() +
                "_" + System.currentTimeMillis() +
                "." + FilenameUtils.getExtension(file.getOriginalFilename());

        Blob blob = bucket.create(fileName,
                bytes,
                Bucket.BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ)
        );

        return new DocumentFileModel(fileName, blob.getMediaLink());
    }

}
