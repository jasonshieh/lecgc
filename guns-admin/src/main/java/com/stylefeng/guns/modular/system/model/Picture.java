package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author stylefeng123
 * @since 2018-05-08
 */
public class Picture extends Model<Picture> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * wallpaper id
     */
    @TableField("wallpaper_id")
    private Integer wallpaperId;
    /**
     * 缩略图url
     */
    @TableField("small_pic_url")
    private String smallPicUrl;
    /**
     * 图url
     */
    @TableField("big_pic_url")
    private String bigPicUrl;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 保留字段
     */
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWallpaperId() {
        return wallpaperId;
    }

    public void setWallpaperId(Integer wallpaperId) {
        this.wallpaperId = wallpaperId;
    }

    public String getSmallPicUrl() {
        return smallPicUrl;
    }

    public void setSmallPicUrl(String smallPicUrl) {
        this.smallPicUrl = smallPicUrl;
    }

    public String getBigPicUrl() {
        return bigPicUrl;
    }

    public void setBigPicUrl(String bigPicUrl) {
        this.bigPicUrl = bigPicUrl;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Picture{" +
        "id=" + id +
        ", wallpaperId=" + wallpaperId +
        ", smallPicUrl=" + smallPicUrl +
        ", bigPicUrl=" + bigPicUrl +
        ", createtime=" + createtime +
        ", version=" + version +
        "}";
    }
}
