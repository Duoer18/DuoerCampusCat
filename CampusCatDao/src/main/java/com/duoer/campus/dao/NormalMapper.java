package com.duoer.campus.dao;

import com.duoer.campus.entity.CatCharacter;
import com.duoer.campus.entity.Category;
import com.duoer.campus.entity.Color;
import com.duoer.campus.entity.Location;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NormalMapper {
    @Select("select * from color order by color_id")
    @ResultMap("colorRM")
    List<Color> selectAllColors();

    @Select("select * from category order by category_id")
    @ResultMap("categoryRM")
    List<Category> selectAllCategories();

    @Select("select * from cat_character order by character_id")
    @ResultMap("characterRM")
    List<CatCharacter> selectAllCharacters();

    @Select("select * from location order by location_id")
    @ResultMap("locationRM")
    List<Location> selectAllLocations();
}
