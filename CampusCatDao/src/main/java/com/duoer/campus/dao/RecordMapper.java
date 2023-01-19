package com.duoer.campus.dao;

import com.duoer.campus.entity.AppearanceRecord;
import com.duoer.campus.entity.FeedingRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    @Select("select * from feeding_view order by record_id")
    @ResultMap("fRecordRM")
    List<FeedingRecord> selectAllFeedingRecords();

    @Select("select * from feeding_tmp_view order by record_id")
    @ResultMap("fRecordRM")
    List<FeedingRecord> selectAllFeedingRecordsTmp();

    @Select("select * from feeding_view where username = #{username} order by record_id")
    @ResultMap("fRecordRM")
    List<FeedingRecord> selectAllFeedingRecordsByUsername(String username);

    @Select("select * from feeding_view where record_id = #{id}")
    @ResultMap("fRecordRM")
    FeedingRecord selectFeedingRecordsById(int id);

    @Select("select * from feeding_tmp_view where record_id = #{id}")
    @ResultMap("fRecordRM")
    FeedingRecord selectFeedingRecordsByIdTmp(int id);

    @Select("select * from feeding_view where cat_id = #{id} order by record_id")
    @ResultMap("fRecordRM")
    List<FeedingRecord> selectFeedingRecordsByCatId(int id);

    @Insert("insert into feeding_record values " +
            "(null, #{catId}, #{username}, #{locationId}, #{recordTime}, #{remarks}, #{lastUpdate})")
    void insertFeedingRecord(FeedingRecord fr);

    @Insert("insert into feeding_record_tmp values " +
            "(null, #{catId}, #{username}, #{locationId}, #{recordTime}, #{remarks}, NOW(), #{formerId})")
    void insertFeedingRecordTmp(FeedingRecord fr);

    void deleteFeedingRecordsByIds(@Param("ids") int[] ids);

    void deleteFeedingRecordsByIdsTmp(@Param("ids") int[] ids);

    void updateFeedingRecord(FeedingRecord fr);


    @Select("select * from appearance_view order by record_id")
    @ResultMap("aRecordRM")
    List<AppearanceRecord> selectAllAppearanceRecords();

    @Select("select * from appearance_tmp_view order by record_id")
    @ResultMap("aRecordRM")
    List<AppearanceRecord> selectAllAppearanceRecordsTmp();

    @Select("select * from appearance_view where username = #{username} order by record_id")
    @ResultMap("aRecordRM")
    List<AppearanceRecord> selectAllAppearanceRecordsByUsername(String username);

    @Select("select * from appearance_view where record_id = #{id}")
    @ResultMap("aRecordRM")
    AppearanceRecord selectAppearanceRecordsById(int id);

    @Select("select * from appearance_tmp_view where record_id = #{id}")
    @ResultMap("aRecordRM")
    AppearanceRecord selectAppearanceRecordsByIdTmp(int id);

    @Select("select * from appearance_view where cat_id = #{id} order by record_id")
    @ResultMap("aRecordRM")
    List<AppearanceRecord> selectAppearanceRecordsByCatId(int id);

    @Insert("insert into appearance_record values " +
            "(null, #{catId}, #{username}, #{locationId}, #{recordTime}, #{lastUpdate})")
    void insertAppearanceRecord(AppearanceRecord ar);

    @Insert("insert into appearance_record_tmp values " +
            "(null, #{catId}, #{username}, #{locationId}, #{recordTime}, NOW(), #{formerId})")
    void insertAppearanceRecordTmp(AppearanceRecord ar);

    void deleteAppearanceRecordsByIds(@Param("ids") int[] ids);

    void deleteAppearanceRecordsByIdsTmp(@Param("ids") int[] ids);

    void updateAppearanceRecord(AppearanceRecord ar);
}
