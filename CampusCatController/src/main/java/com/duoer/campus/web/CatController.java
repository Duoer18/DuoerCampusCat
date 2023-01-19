package com.duoer.campus.web;

import com.duoer.campus.entity.Cat;
import com.duoer.campus.service.CatService;
import com.duoer.campus.web.format.ResponseCode;
import com.duoer.campus.web.format.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    @Autowired
    private CatService catService;

    /**
     * 添加新猫咪
     *
     * @param c 前端传递猫咪对象
     * @return 状态码
     */
    @PostMapping
    public Result addCat(@RequestBody Cat c, HttpSession session) {
        // 若为管理员则直接完成添加，否则添加到临时表待审核
        c.setUsername((String) session.getAttribute("username"));
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        isAdmin = isAdmin != null ? isAdmin : false;
        int status = catService.addCat(c, !isAdmin);
        int code = status == 1 ? ResponseCode.ADD_SUC.getCode() : ResponseCode.ADD_ERR.getCode();
        String msg = status == 1 ? "" : "添加猫咪失败！";
        return new Result(code, status, msg);
    }

    /**
     * 获取所有猫咪
     *
     * @return 所有猫咪集合
     */
    @GetMapping
    public Result getAllCats() {
        List<Cat> cats = catService.getAllCats(false);
        int code = cats != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = cats != null ? "" : "猫咪数据查询失败！";
        return new Result(code, cats, msg);
    }

    /**
     * 按id获取猫咪信息
     *
     * @param id 编号
     * @return 猫咪对象
     */
    @GetMapping("/{id}")
    public Result getCatById(@PathVariable int id) {
        Cat cat = catService.getCatById(id, false);
        int code = cat != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = cat != null ? "" : "猫咪数据查询失败！";
        return new Result(code, cat, msg);
    }
}
