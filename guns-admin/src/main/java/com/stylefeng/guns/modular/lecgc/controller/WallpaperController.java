package com.stylefeng.guns.modular.lecgc.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Wallpaper;
import com.stylefeng.guns.modular.lecgc.service.IWallpaperService;

/**
 * 墙布管理控制器
 *
 * @author fengshuonan
 * @Date 2018-05-03 23:50:36
 */
@Controller
@RequestMapping("/wallpaper")
public class WallpaperController extends BaseController {

    private String PREFIX = "/lecgc/wallpaper/";

    @Autowired
    private IWallpaperService wallpaperService;

    /**
     * 跳转到墙布管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "wallpaper.html";
    }

    /**
     * 跳转到添加墙布管理
     */
    @RequestMapping("/wallpaper_add")
    public String wallpaperAdd() {
        return PREFIX + "wallpaper_add.html";
    }

    /**
     * 跳转到修改墙布管理
     */
    @RequestMapping("/wallpaper_update/{wallpaperId}")
    public String wallpaperUpdate(@PathVariable Integer wallpaperId, Model model) {
        Wallpaper wallpaper = wallpaperService.selectById(wallpaperId);
        model.addAttribute("item",wallpaper);
        LogObjectHolder.me().set(wallpaper);
        return PREFIX + "wallpaper_edit.html";
    }

    /**
     * 获取墙布管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return wallpaperService.selectList(null);
    }

    /**
     * 新增墙布管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Wallpaper wallpaper) {
        wallpaperService.insert(wallpaper);
        return SUCCESS_TIP;
    }

    /**
     * 删除墙布管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer wallpaperId) {
        wallpaperService.deleteById(wallpaperId);
        return SUCCESS_TIP;
    }

    /**
     * 修改墙布管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Wallpaper wallpaper) {
        wallpaperService.updateById(wallpaper);
        return SUCCESS_TIP;
    }

    /**
     * 墙布管理详情
     */
    @RequestMapping(value = "/detail/{wallpaperId}")
    @ResponseBody
    public Object detail(@PathVariable("wallpaperId") Integer wallpaperId) {
        return wallpaperService.selectById(wallpaperId);
    }
}
