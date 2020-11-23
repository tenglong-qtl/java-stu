package org.zicheng.stu.designpattern.strategy;

/**
 * 识别要使用的算策略，调用工厂类去创建并调用
 * Author: zicheng
 * Since: 2020-11-14 15:44
 * Description:
 */
public class Context {
    private IStrategy strategy;

    public Double call(Double charge, Integer integer) {
        strategy = StrategyFactory.getInstance().crate(integer);
        return strategy.call(charge,integer);
    }
}
