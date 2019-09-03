package com.zccs.assets_management.sendCode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 停车 请求数据 实体类对象
 * </p>
 *
 * @author gaoh
 * @version 1.0
 * @date 2019/9/3 20:08
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestParkEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer appId;// 用户id，不允许为空
    private String key;//验证码，参照安全性验证
    private Integer parkId;//  车场id，不允许为空
    private String plateNo;// 车牌号，全车牌
    private String orderNo;//  账单号，不允许为空
    private Integer amount;//   支付金额, 单位为分 ，不允许为空
    private Integer discount;//抵扣金额(第3方优惠活动免费的金额),**单位为分**，不允许为空
    private Integer ruleId;//充值规则ID 必填
    private Integer cardId;//  卡片id 必填

    private String startTime;// 开始时间(必填)   yyyy-MM-dd   HH:mm:ss
    private String endTime;//  结束时间(必填)   yyyy-MM-dd   HH:mm:ss
    private String pageIndex;//  第N页，N>0

    private String chargeFrom;//充值的开始时间 必填
    /**
     * 充值数量必填 针对接口9的充值规则ID
     * chargeCount = 3 表示充值   3 * 1（ruleAmount）个月，需要3* 500元（ruleFee）
     */
    private Integer chargeCount;
}
