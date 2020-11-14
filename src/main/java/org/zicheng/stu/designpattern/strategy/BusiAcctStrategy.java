package org.zicheng.stu.designpattern.strategy;

/**
 * 业务充值
 * Author: zicheng
 * Since: 2020-11-14 15:31
 * Description:
 */
public class BusiAcctStrategy implements IStrategy {
    @Override
    public double call(Double charge, Integer type) {
        return charge * 0.9;
    }
}
