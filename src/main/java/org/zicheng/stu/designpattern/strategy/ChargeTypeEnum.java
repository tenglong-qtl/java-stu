package org.zicheng.stu.designpattern.strategy;

/**
 * Author: zicheng
 * Since: 2020-11-14 15:29
 * Description:
 */
public enum ChargeTypeEnum {
    E_BANK(1, "网银充值"),
    BUSI_ACCOUNT(2, "商业充值"),
    MOBILE(3, "手机充值")
    ;

    private Integer type;
    private String desc;

    ChargeTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
