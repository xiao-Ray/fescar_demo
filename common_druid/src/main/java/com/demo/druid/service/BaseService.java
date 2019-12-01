package com.demo.druid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> extends IService<T> {


    /**
     * 单个插入
     * @param entity
     * @return
     */
    int singleInsert(T entity);

    /**
     * 单个更新
     * @param entity
     * @return
     */
    int singleUpdate(T entity);

    /**
     * 根据ID查找记录.
     *
     * @param id
     * @return entity
     */
    T getSingleById(long id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(long id);

    /**
     * 分页查询 .
     *
     * @param page
     *            分页参数.
     * @param map
     *            业务条件查询参数.
     * @return
     */
    Page<T> listPage(IPage<T> page, @Param("cm") Map map);

    /**
     * 根据条件查询 listBy
     *
     * @param map
     * @return 返回集合
     */
    List<T> listBy(@Param("cm") Map map);

    /**
     * 根据ID将记录置为删除或无效状态.
     *
     * @param id
     *            .
     * @return.
     */
    long invalidById(long id);
}
