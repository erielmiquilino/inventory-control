package com.inventoryControl.repository.folder;

import com.inventoryControl.domain.folder.Folder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FolderRepository extends MongoRepository<Folder, String>, ICustomFolderRepository {
}
