package com.demo.storage.dao;

import com.demo.druid.dao.BaseDao;
import com.demo.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageDao extends BaseDao<Storage> {
}
