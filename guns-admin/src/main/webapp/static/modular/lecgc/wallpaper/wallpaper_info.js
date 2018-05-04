/**
 * 初始化墙布管理详情对话框
 */
var WallpaperInfoDlg = {
    wallpaperInfoData : {}
};

/**
 * 清除数据
 */
WallpaperInfoDlg.clearData = function() {
    this.wallpaperInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WallpaperInfoDlg.set = function(key, val) {
    this.wallpaperInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
WallpaperInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
WallpaperInfoDlg.close = function() {
    parent.layer.close(window.parent.Wallpaper.layerIndex);
}

/**
 * 收集数据
 */
WallpaperInfoDlg.collectData = function() {
    this
    .set('id')
    .set('typeNo')
    .set('title')
    .set('price')
    .set('createtime')
    .set('version');
}

/**
 * 提交添加
 */
WallpaperInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wallpaper/add", function(data){
        Feng.success("添加成功!");
        window.parent.Wallpaper.table.refresh();
        WallpaperInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wallpaperInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
WallpaperInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/wallpaper/update", function(data){
        Feng.success("修改成功!");
        window.parent.Wallpaper.table.refresh();
        WallpaperInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.wallpaperInfoData);
    ajax.start();
}

$(function() {

});
