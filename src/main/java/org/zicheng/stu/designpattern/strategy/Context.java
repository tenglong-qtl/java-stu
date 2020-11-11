package org.zicheng.stu.designpattern.strategy;

/**
 * Author: T.L. QIU
 * Date: 2020-11-11 10:01.
 */
public class Context {
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
