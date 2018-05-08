package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Picture;
import com.stylefeng.guns.modular.system.service.IPictureService;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-05-08 10:12:31
 */
@Controller
@RequestMapping("/picture")
public class PictureController extends BaseController {

    private String PREFIX = "/system/picture/";

    @Autowired
    private IPictureService pictureService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "picture.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/picture_add")
    public String pictureAdd() {
        return PREFIX + "picture_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/picture_update/{pictureId}")
    public String pictureUpdate(@PathVariable Integer pictureId, Model model) {
        Picture picture = pictureService.selectById(pictureId);
        model.addAttribute("item",picture);
        LogObjectHolder.me().set(picture);
        return PREFIX + "picture_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return pictureService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Picture picture) {
        pictureService.insert(picture);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer pictureId) {
        pictureService.deleteById(pictureId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Picture picture) {
        pictureService.updateById(picture);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{pictureId}")
    @ResponseBody
    public Object detail(@PathVariable("pictureId") Integer pictureId) {
        return pictureService.selectById(pictureId);
    }
}
