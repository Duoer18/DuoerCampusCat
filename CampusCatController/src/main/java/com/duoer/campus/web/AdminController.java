package com.duoer.campus.web;

import com.duoer.campus.entity.Cat;
import com.duoer.campus.entity.MyRecord;
import com.duoer.campus.service.CatService;
import com.duoer.campus.service.RecordService;
import com.duoer.campus.web.format.ResponseCode;
import com.duoer.campus.web.format.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private CatService catService;

    /**
     * 获取所有待审核猫咪信息
     *
     * @return 所有猫咪集合
     */
    @GetMapping("/cats")
    public Result getAllTempCats() {
        List<Cat> cats = catService.getAllCats(true);
        int code = cats != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = cats != null ? "" : "猫咪数据查询失败！";
        return new Result(code, cats, msg);
    }

    /**
     * 猫咪添加申请通过
     *
     * @param id 临时表id
     * @return 状态码
     */
    @GetMapping("/cats/{id}")
    public Result addCatCheckPass(@PathVariable int id) {
        int status = catService.addCatFromTemp(id);
        int code = status == 1 ? ResponseCode.ADD_SUC.getCode() : ResponseCode.ADD_ERR.getCode();
        String msg = status == 1 ? "" : "添加猫咪失败！";
        return new Result(code, status, msg);
    }

    /**
     * 直接删除猫咪
     *
     * @param id 编号
     * @return 状态码
     */
    @DeleteMapping("/cats/{id}")
    public Result deleteCat(@PathVariable int id) {
        int status = catService.deleteCatById(id, false);
        int code = status == 1 ? ResponseCode.DEL_SUC.getCode() : ResponseCode.DEL_ERR.getCode();
        String msg = status == 1 ? "" : "删除猫咪失败！";
        return new Result(code, status, msg);
    }

    /**
     * 驳回添加猫咪申请
     *
     * @param id 临时表id
     * @return 状态码
     */
    @DeleteMapping("/cats/tmp/{id}")
    public Result addCatCheckReject(@PathVariable int id) {
        int status = catService.deleteCatById(id, true);
        int code = status == 1 ? ResponseCode.DEL_SUC.getCode() : ResponseCode.DEL_ERR.getCode();
        String msg = status == 1 ? "" : "删除猫咪失败！";
        return new Result(code, status, msg);
    }

    /**
     * 修改猫咪信息
     *
     * @param c 前端传递猫咪对象
     * @return 状态码
     */
    @PutMapping("/cats")
    public Result updateCat(@RequestBody Cat c) {
        int status = catService.updateCat(c);
        int code = status == 1 ? ResponseCode.UPD_SUC.getCode() : ResponseCode.UPD_ERR.getCode();
        String msg = status == 1 ? "" : "修改猫咪失败！";
        return new Result(code, status, msg);
    }

    /**
     * 获取所有待审核记录
     * @param type 类型
     * @return 所有记录集合
     */
    @GetMapping("/records/{type}")
    public Result getAllTempRecords(@PathVariable String type) {
        List<? extends MyRecord> records = recordService.getAllTempRecords(type);
        int code = records != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = records != null ? "" : "记录数据查询失败！";
        return new Result(code, records, msg);
    }

    /**
     * 通过记录请求申请
     * @param id 临时表id
     * @param type 类型
     * @return 状态码
     */
    @GetMapping("/records/{type}/{id}")
    public Result addRecordCheckPass(@PathVariable int id, @PathVariable String type) {
        int status = recordService.addRecordCheckPass(id, type);
        int code = status == 1 ? ResponseCode.ADD_SUC.getCode() : ResponseCode.ADD_ERR.getCode();
        String msg = status == 1 ? "" : "添加记录失败！";
        return new Result(code, status, msg);
    }

    /**
     * 驳回记录请求申请
     * @param id 临时表id
     * @param type 类型
     * @return 状态码
     */
    @DeleteMapping("/records/{type}/{id}")
    public Result addRecordCheckReject(@PathVariable int id, @PathVariable String type) {
        int status = recordService.deleteTempRecord(new int[]{id}, type);
        int code = status == 1 ? ResponseCode.DEL_SUC.getCode() : ResponseCode.DEL_ERR.getCode();
        String msg = status == 1 ? "" : "删除记录失败！";
        return new Result(code, status, msg);
    }
}
