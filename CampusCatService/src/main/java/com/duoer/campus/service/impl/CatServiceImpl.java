package com.duoer.campus.service.impl;

import com.duoer.campus.dao.CatMapper;
import com.duoer.campus.entity.Cat;
import com.duoer.campus.service.CatService;
import com.duoer.campus.utils.CatLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatMapper catMapper;

    @Override
    public List<Cat> getAllCats(boolean isTmp) {
        return isTmp ? catMapper.selectAllCatsTmp() : catMapper.selectAllCats();
    }

    @Override
    public Cat getCatById(int id, boolean isTmp) {
        return isTmp ? catMapper.selectCatByIdTmp(id) : catMapper.selectCatById(id);
    }

    @Override
    public List<Cat> catRandomSearch(Cat c) {
        return catMapper.randomSelect(c);
    }

    @Override
    public int addCatFromTemp(int id) {
        int insertStatus = 1;
        synchronized (CatLock.get(id)) {
            Cat c = catMapper.selectCatByIdTmp(id);
            if (c != null) {
                catMapper.deleteCatByIdTmp(id);
                catMapper.insertCat(c);
            } else {
                insertStatus = 0;
            }
        }
        return insertStatus;
    }

    @Override
    public int addCat(Cat c, boolean isTmp) {
        int insertStatus = 1;
        if (isTmp) {
            catMapper.insertCatTmp(c);
        } else {
            catMapper.insertCat(c);
        }
        return insertStatus;
    }

    @Override
    public int deleteCatById(int id, boolean isTmp) {
        int deleteStatus = 1;
        if (isTmp) {
            catMapper.deleteCatByIdTmp(id);
        } else {
            catMapper.deleteCatById(id);
        }
        return deleteStatus;
    }

    @Override
    public int updateCat(Cat c) {
        int updateStatus = 1;
        catMapper.updateCat(c);
        return updateStatus;
    }
}
