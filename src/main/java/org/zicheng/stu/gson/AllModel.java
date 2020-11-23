package org.zicheng.stu.gson;

import java.util.Map;

/**
 * Author: T.L. QIU
 * Date: 2020-11-23 15:18.
 */
public class AllModel {

    private Map<String,Model> masks;
    private Map<String,Model> stickers;

    public AllModel(Map<String, Model> masks, Map<String, Model> stickers) {
        this.masks = masks;
        this.stickers = stickers;
    }

    public Map<String, Model> getMasks() {
        return masks;
    }

    public void setMasks(Map<String, Model> masks) {
        this.masks = masks;
    }

    public Map<String, Model> getStickers() {
        return stickers;
    }

    public void setStickers(Map<String, Model> stickers) {
        this.stickers = stickers;
    }

    @Override
    public String toString() {
        return "AllModel{" +
                "masks=" + masks +
                ", stickers=" + stickers +
                '}';
    }
}
