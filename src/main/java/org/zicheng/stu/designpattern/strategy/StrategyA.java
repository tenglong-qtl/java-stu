package org.zicheng.stu.designpattern.strategy;

/**
 * 具体策略角色
 * Author: T.L. QIU
 * Date: 2020-11-11 9:59.
 */
public class StrategyA implements Strategy {
    @Override
    public void doAction() {
        System.out.println("由StrategyA实现了");
    }
}
