package com.duoer.campus.service.impl;

import com.duoer.campus.dao.RecordMapper;
import com.duoer.campus.entity.AppearanceRecord;
import com.duoer.campus.entity.FeedingRecord;
import com.duoer.campus.entity.MyRecord;
import com.duoer.campus.service.RecordService;
import com.duoer.campus.utils.RecordLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<? extends MyRecord> getAllRecords(String type) {
        if (type.equals("feeding")) {
            return recordMapper.selectAllFeedingRecords();
        } else if (type.equals("appearance")) {
            return recordMapper.selectAllAppearanceRecords();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<? extends MyRecord> getAllRecordsByUsername(String username, String type) {
        if (type.equals("feeding")) {
            return recordMapper.selectAllFeedingRecordsByUsername(username);
        } else if (type.equals("appearance")) {
            return recordMapper.selectAllAppearanceRecordsByUsername(username);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<? extends MyRecord> getAllTempRecords(String type) {
        if (type.equals("feeding")) {
            return recordMapper.selectAllFeedingRecordsTmp();
        } else if (type.equals("appearance")) {
            return recordMapper.selectAllAppearanceRecordsTmp();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public MyRecord getRecordById(int id, String type) {
        if (type.equals("feeding")) {
            return recordMapper.selectFeedingRecordsById(id);
        } else if (type.equals("appearance")) {
            return recordMapper.selectAppearanceRecordsById(id);
        } else {
            return new FeedingRecord();
        }
    }

    @Override
    public MyRecord getTempRecordById(int id, String type) {
        if (type.equals("feeding")) {
            return recordMapper.selectFeedingRecordsByIdTmp(id);
        } else if (type.equals("appearance")) {
            return recordMapper.selectAppearanceRecordsByIdTmp(id);
        } else {
            return new FeedingRecord();
        }
    }

    @Override
    public List<? extends MyRecord> getCatOwnRecords(int id, String type) {
        if (type.equals("feeding")) {
            return recordMapper.selectFeedingRecordsByCatId(id);
        } else if (type.equals("appearance")) {
            return recordMapper.selectAppearanceRecordsByCatId(id);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public int addRecord(MyRecord r) {
        int insertStatus = 1;
        if (r instanceof FeedingRecord) {
            recordMapper.insertFeedingRecord((FeedingRecord) r);
        } else if (r instanceof AppearanceRecord) {
            recordMapper.insertAppearanceRecord((AppearanceRecord) r);
        } else {
            insertStatus = 0;
        }
        return insertStatus;
    }

    @Override
    public int addTempRecord(MyRecord r) {
        int insertStatus = 1;
        if (r instanceof FeedingRecord) {
            recordMapper.insertFeedingRecordTmp((FeedingRecord) r);
        } else if (r instanceof AppearanceRecord) {
            recordMapper.insertAppearanceRecordTmp((AppearanceRecord) r);
        } else {
            insertStatus = 0;
        }
        return insertStatus;
    }

    @Override
    public int addRecordCheckPass(int id, String type) {
        if (!type.equals("feeding") && !type.equals("appearance")) {
            return 0;
        }

        int status;
        synchronized (type.equals("feeding") ? RecordLock.getFeedingLock(id) : RecordLock.getAppearanceLock(id)) {
            MyRecord r = getTempRecordById(id, type);
            if (r != null) {
                deleteTempRecord(new int[]{id}, type);
                if (r.getFormerId() == -1) {
                    status = addRecord(r);
                } else {
                    r.setRecordId(r.getFormerId());
                    status = updateRecord(r);
                }
            } else {
                status = 0;
            }
        }

        return status;
    }

    @Override
    public int updateRecord(MyRecord r) {
        int updateStatus = 1;
        if (r instanceof FeedingRecord) {
            recordMapper.updateFeedingRecord((FeedingRecord) r);
        } else if (r instanceof AppearanceRecord) {
            recordMapper.updateAppearanceRecord((AppearanceRecord) r);
        } else {
            updateStatus = 0;
        }
        return updateStatus;
    }

    @Override
    public int deleteRecord(int[] ids, String type) {
        int deleteStatus = 1;
        if (type.equals("feeding")) {
            recordMapper.deleteFeedingRecordsByIds(ids);
        } else if (type.equals("appearance")) {
            recordMapper.deleteAppearanceRecordsByIds(ids);
        } else {
            deleteStatus = 0;
        }
        return deleteStatus;
    }

    @Override
    public int deleteTempRecord(int[] ids, String type) {
        int deleteStatus = 1;
        if (type.equals("feeding")) {
            recordMapper.deleteFeedingRecordsByIdsTmp(ids);
        } else if (type.equals("appearance")) {
            recordMapper.deleteAppearanceRecordsByIdsTmp(ids);
        } else {
            deleteStatus = 0;
        }
        return deleteStatus;
    }
}
