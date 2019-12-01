package com.demo.storage.service.impl;

import com.demo.druid.dao.BaseDao;
import com.demo.druid.service.BaseServiceImpl;
import com.demo.entity.Storage;
import com.demo.storage.dao.StorageDao;
import com.demo.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("storageService")
public class StorageServiceImpl extends BaseServiceImpl<Storage> implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    protected BaseDao<Storage> getDao() {
        return storageDao;
    }
}
