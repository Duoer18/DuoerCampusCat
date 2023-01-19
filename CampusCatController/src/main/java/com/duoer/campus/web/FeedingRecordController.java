package com.duoer.campus.web;

import com.duoer.campus.entity.FeedingRecord;
import com.duoer.campus.entity.MyRecord;
import com.duoer.campus.service.RecordService;
import com.duoer.campus.web.format.ResponseCode;
import com.duoer.campus.web.format.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/feedings")
public class FeedingRecordController {
    @Autowired
    private RecordService recordService;

    /**
     * 获取所有记录
     *
     * @return 所有记录集合
     */
    @GetMapping
    public Result getAllRecords() {
        List<? extends MyRecord> records = recordService.getAllRecords("feeding");
        int code = records != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = records != null ? "" : "记录数据查询失败！";
        return new Result(code, records, msg);
    }

    /**
     * 获取某用户所有记录
     *
     * @return 所有记录集合
     */
    @GetMapping("/user")
    public Result getAllRecordsByUsername(HttpSession session) {
        String username = (String) session.getAttribute("username");
        List<? extends MyRecord> records = recordService.getAllRecordsByUsername(username, "feeding");
        int code = records != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = records != null ? "" : "记录数据查询失败！";
        return new Result(code, records, msg);
    }

    /**
     * 添加新投喂记录
     *
     * @param fr 前端传递记录对象
     * @return 状态码
     */
    @PostMapping
    public Result addRecord(@RequestBody FeedingRecord fr, HttpSession session) {
        fr.setUsername((String) session.getAttribute("username"));
        fr.setFormerId(-1);
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        isAdmin = isAdmin != null ? isAdmin : false;
        int status = isAdmin ? recordService.addRecord(fr) : recordService.addTempRecord(fr);
        int code = status == 1 ? ResponseCode.ADD_SUC.getCode() : ResponseCode.ADD_ERR.getCode();
        String msg = status == 1 ? "" : "添加记录失败！";
        return new Result(code, status, msg);
    }

    /**
     * 获取猫咪全部记录
     *
     * @param id 猫咪id
     * @return 所有记录集合
     */
    @GetMapping("/cat/{id}")
    public Result catRecords(@PathVariable int id) {
        List<? extends MyRecord> records = recordService.getCatOwnRecords(id, "feeding");
        int code = records != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = records != null ? "" : "记录数据查询失败！";
        return new Result(code, records, msg);
    }

    /**
     * 删除所选记录
     *
     * @param ids id数组
     * @return 状态码
     */
    @DeleteMapping
    public Result deleteRecord(@RequestBody int[] ids) {
        System.out.println(Arrays.toString(ids));
        int status = recordService.deleteRecord(ids, "feeding");
        int code = status == 1 ? ResponseCode.DEL_SUC.getCode() : ResponseCode.DEL_ERR.getCode();
        String msg = status == 1 ? "" : "删除记录失败！";
        return new Result(code, status, msg);
    }

    /**
     * 更新某记录
     *
     * @param fr 前端传递记录对象
     * @return 状态码
     */
    @PutMapping
    public Result updateRecord(@RequestBody FeedingRecord fr, HttpSession session) {
        fr.setUsername((String) session.getAttribute("username"));

        int status;
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        isAdmin = isAdmin != null ? isAdmin : false;
        if (isAdmin) {
            status = recordService.updateRecord(fr);
        } else {
            fr.setFormerId(fr.getRecordId());
            status = recordService.addTempRecord(fr);
        }

        int code = status == 1 ? ResponseCode.UPD_SUC.getCode() : ResponseCode.UPD_ERR.getCode();
        String msg = status == 1 ? "" : "更新记录失败！";
        return new Result(code, status, msg);
    }

    /**
     * 获取待修改记录的信息
     *
     * @param id 编号
     * @return 该记录对象
     */
    @GetMapping("/{id}")
    public Result PreUpdateRecord(@PathVariable int id) {
        MyRecord record = recordService.getRecordById(id, "feeding");
        int code = record != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = record != null ? "" : "记录数据查询失败！";
        return new Result(code, record, msg);
    }
}
