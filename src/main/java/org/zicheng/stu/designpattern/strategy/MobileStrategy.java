package org.zicheng.stu.designpattern.strategy;

/**
 * Author: zicheng
 * Since: 2020-11-14 15:32
 * Description:
 */
public class MobileStrategy implements IStrategy {
    @Override
    public double call(Double charge, Integer type) {
        return charge * 0.88;
    }
}
