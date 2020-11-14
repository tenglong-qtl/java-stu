package org.zicheng.stu.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 负责根据不同类型创建策略,工厂类的职责是单一的，
 * 只负责创建
 * Author: zicheng
 * Since: 2020-11-14 15:33
 * Description:
 */
public class StrategyFactory {
    private static StrategyFactory factory = new StrategyFactory();
    private static Map<Integer, IStrategy> strategyMap = new HashMap<>();

    /**
     * 类加载的时候就会加载静态代码块
     * 属性 --> 静态代码块 --> 构造函数
     */
    static {
        strategyMap.put(ChargeTypeEnum.BUSI_ACCOUNT.getType(), new BusiAcctStrategy());
        strategyMap.put(ChargeTypeEnum.E_BANK.getType(), new EBankStrategy());
        strategyMap.put(ChargeTypeEnum.MOBILE.getType(), new MobileStrategy());
    }

    private StrategyFactory() {

    }

    public IStrategy crate(Integer type) {
        return strategyMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return factory;
    }


}
