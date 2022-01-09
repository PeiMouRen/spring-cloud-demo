package com.rhythm.service;

import com.rhythm.dao.StorageDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author peixi
 * @Date 2022/1/9
 * @Description
 */
@Service
public class StorageServiceImpl implements IStorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public int updateCount(Long productId, Integer count) {
        return storageDao.updateCount(productId, count);
    }
}
