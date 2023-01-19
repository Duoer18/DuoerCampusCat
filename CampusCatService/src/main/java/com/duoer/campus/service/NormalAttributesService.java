package com.duoer.campus.service;

import com.duoer.campus.entity.CatCharacter;
import com.duoer.campus.entity.Category;
import com.duoer.campus.entity.Color;
import com.duoer.campus.entity.Location;

import java.util.List;

public interface NormalAttributesService {
    /**
     * 获取全部品种
     *
     * @return 全部品种集合
     */
    List<Category> getAllCategories();

    /**
     * 获取全部颜色
     *
     * @return 全部颜色集合
     */
    List<Color> getAllColors();

    /**
     * 获取全部性格
     *
     * @return 全部性格集合
     */
    List<CatCharacter> getAllCharacters();

    /**
     * 获取全部位置
     *
     * @return 全部位置集合
     */
    List<Location> getAllLocations();
}
