package org.zicheng.stu.designpattern.strategy;

/**
 * 具体策略角色
 * Author: T.L. QIU
 * Date: 2020-11-11 10:00.
 */
public class StrategyB implements Strategy{
    @Override
    public void doAction() {
        System.out.println("由StrategyB实现了");
    }
}
