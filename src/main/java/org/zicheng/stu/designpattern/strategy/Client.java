package org.zicheng.stu.designpattern.strategy;

/**
 * Author: zicheng
 * Since: 2020-11-14 15:49
 * Description:
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        // 商户充值
        double charge1 = context.call(100.00, ChargeTypeEnum.BUSI_ACCOUNT.getType());
        System.out.println(charge1);
        // 网银充值
        double charge2 = context.call(100.00, ChargeTypeEnum.E_BANK.getType());
        System.out.println(charge2);
        // 手机充值
        double charge3 = context.call(100.00, ChargeTypeEnum.MOBILE.getType());
        System.out.println(charge3);

    }
}
