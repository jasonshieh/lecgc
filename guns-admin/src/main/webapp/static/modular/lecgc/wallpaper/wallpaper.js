/**
 * 墙布管理管理初始化
 */
var Wallpaper = {
    id: "WallpaperTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Wallpaper.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '型号', field: 'typeNo', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'title', visible: true, align: 'center', valign: 'middle'},
            {title: '价格', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createtime', visible: true, align: 'center', valign: 'middle'},
            {title: '保留字段', field: 'version', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Wallpaper.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Wallpaper.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加墙布管理
 */
Wallpaper.openAddWallpaper = function () {
    var index = layer.open({
        type: 2,
        title: '添加墙布管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/wallpaper/wallpaper_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看墙布管理详情
 */
Wallpaper.openWallpaperDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '墙布管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/wallpaper/wallpaper_update/' + Wallpaper.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除墙布管理
 */
Wallpaper.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/wallpaper/delete", function (data) {
            Feng.success("删除成功!");
            Wallpaper.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("wallpaperId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询墙布管理列表
 */
Wallpaper.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Wallpaper.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Wallpaper.initColumn();
    var table = new BSTable(Wallpaper.id, "/wallpaper/list", defaultColunms);
    table.setPaginationType("client");
    Wallpaper.table = table.init();
});
