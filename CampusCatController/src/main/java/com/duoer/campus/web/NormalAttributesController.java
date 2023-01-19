package com.duoer.campus.web;

import com.duoer.campus.entity.CatCharacter;
import com.duoer.campus.entity.Category;
import com.duoer.campus.entity.Color;
import com.duoer.campus.entity.Location;
import com.duoer.campus.service.NormalAttributesService;
import com.duoer.campus.web.format.ResponseCode;
import com.duoer.campus.web.format.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NormalAttributesController {
    @Autowired
    private NormalAttributesService normalAttributesService;

    /**
     * 获取全部品种
     *
     * @return 全部品种集合
     */
    @GetMapping("/categories")
    public Result getAllCategories() {
        List<Category> categories = normalAttributesService.getAllCategories();
        int code = categories != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = categories != null ? "" : "数据获取失败！";
        return new Result(code, categories, msg);
    }

    /**
     * 获取全部颜色
     *
     * @return 全部颜色集合
     */
    @GetMapping("/colors")
    public Result getAllColors() {
        List<Color> colors = normalAttributesService.getAllColors();
        int code = colors != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = colors != null ? "" : "数据获取失败！";
        return new Result(code, colors, msg);
    }

    /**
     * 获取全部性格
     *
     * @return 全部性格集合
     */
    @GetMapping("/characters")
    public Result getAllCharacters() {
        List<CatCharacter> characters = normalAttributesService.getAllCharacters();
        int code = characters != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = characters != null ? "" : "数据获取失败！";
        return new Result(code, characters, msg);
    }

    /**
     * 获取全部位置
     *
     * @return 全部位置集合
     */
    @GetMapping("/locations")
    public Result getAllLocations() {
        List<Location> locations = normalAttributesService.getAllLocations();
        int code = locations != null ? ResponseCode.GET_SUC.getCode() : ResponseCode.GET_ERR.getCode();
        String msg = locations != null ? "" : "数据获取失败！";
        return new Result(code, locations, msg);
    }
}
