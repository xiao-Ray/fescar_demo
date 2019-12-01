package com.demo.druid.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.druid.dao.BaseDao;
import com.demo.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T extends BaseEntity> extends ServiceImpl<BaseDao<T>, T> implements BaseService<T> {

    protected abstract BaseDao<T> getDao();

    @Override
    public int singleInsert(T entity) {
        return this.getDao().singleInsert(entity);
    }

    @Override
    public int singleUpdate(T entity) {
        return this.getDao().singleUpdate(entity);
    }

    @Override
    public T getSingleById(long id) {
        return this.getDao().getSingleById(id);
    }

    @Override
    public int deleteById(long id) {
        return this.getDao().deleteById(id);
    }

    @Override
    public Page<T> listPage(IPage<T> page, Map map) {
        return this.getDao().listPage(page,map);
    }

    @Override
    public List<T> listBy(Map map) {
        return this.getDao().listBy(map);
    }

    @Override
    public long invalidById(long id) {
        return this.getDao().invalidById(id);
    }
}
