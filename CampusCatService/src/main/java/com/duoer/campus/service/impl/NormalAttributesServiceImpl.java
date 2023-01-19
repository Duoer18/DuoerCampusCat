package com.duoer.campus.service.impl;

import com.duoer.campus.dao.NormalMapper;
import com.duoer.campus.entity.CatCharacter;
import com.duoer.campus.entity.Category;
import com.duoer.campus.entity.Color;
import com.duoer.campus.entity.Location;
import com.duoer.campus.service.NormalAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalAttributesServiceImpl implements NormalAttributesService {
    @Autowired
    private NormalMapper normalMapper;

    @Override
    public List<Category> getAllCategories() {
        return normalMapper.selectAllCategories();
    }

    @Override
    public List<Color> getAllColors() {
        return normalMapper.selectAllColors();
    }

    @Override
    public List<CatCharacter> getAllCharacters() {
        return normalMapper.selectAllCharacters();
    }

    @Override
    public List<Location> getAllLocations() {
        return normalMapper.selectAllLocations();
    }
}
