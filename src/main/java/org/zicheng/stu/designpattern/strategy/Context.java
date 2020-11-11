package org.zicheng.stu.designpattern.strategy;

/**
 * 封装角色
 * 持有抽象策略角色的引用
 * Author: T.L. QIU
 * Date: 2020-11-11 10:01.
 */
public class Context {
    /**
     * 抽象策略角色
     */
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doAction();
    }

    public static void main(String[] args) {
        Context context = new Context(new StrategyA());
        context.execute();

        Context context2 = new Context(new StrategyB());
        context2.execute();
    }
}
