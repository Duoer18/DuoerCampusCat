package com.duoer.campus.dao;

import com.duoer.campus.entity.Cat;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CatMapper {
    @Select("select * from catinfoview order by cat_id")
    @ResultMap("catRM")
    List<Cat> selectAllCats();

    @Select("select * from cattmpinfoview order by cat_id")
    @ResultMap("catRM")
    List<Cat> selectAllCatsTmp();

    List<Cat> randomSelect(Cat c);

    @Select("select * from catinfoview where cat_id = #{id}")
    @ResultMap("catRM")
    Cat selectCatById(int id);

    @Select("select * from cattmpinfoview where cat_id = #{id}")
    @ResultMap("catRM")
    Cat selectCatByIdTmp(int id);

    @Select("select * from cat where cat_name = #{name}")
    @ResultMap("catRM")
    Cat selectCatByName(String name);

    @Insert("insert into cat_tmp values (null, #{catName}, " +
            "#{categoryId}, #{colorId}, #{characterId}, #{locationId}, 0, #{username})")
    void insertCatTmp(Cat c);

    @Insert("insert into cat values (null, #{catName}, " +
            "#{categoryId}, #{colorId}, #{characterId}, #{locationId}, 0)")
    void insertCat(Cat c);

    @Delete("delete from cat where cat_id = #{id}")
    void deleteCatById(int id);

    @Delete("delete from cat_tmp where cat_id = #{id}")
    void deleteCatByIdTmp(int id);

    void updateCat(Cat c);
}
