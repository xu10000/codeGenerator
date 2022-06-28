package com.xzt.ts.entity.gbw;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 投保单信息
 * </p>
 *
 * @author xzt
 * @since 2022-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "o_id", type = IdType.AUTO)
    private Long oId;

    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 订单类型
     */
    @TableField("order_type")
    private String orderType;

    /**
     * 项目id
     */
    @TableField("project_id")
    private Long projectId;

    @TableField("project_name")
    private String projectName;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Long goodsId;

    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 业务模式online:线上 offline线下
     */
    @TableField("bus_code")
    private String busCode;

    @TableField("insure_code")
    private String insureCode;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 项目所在省
     */
    @TableField("province_name")
    private String provinceName;

    /**
     * 省级代码
     */
    @TableField("province_code")
    private String provinceCode;

    /**
     * 项目所在市
     */
    @TableField("city_name")
    private String cityName;

    /**
     * 市代码
     */
    @TableField("city_code")
    private String cityCode;

    /**
     * 项目所在区
     */
    @TableField("area_name")
    private String areaName;

    /**
     * 区代码
     */
    @TableField("area_code")
    private String areaCode;

    /**
     * 订单来源
     */
    @TableField("order_source")
    private String orderSource;

    /**
     * 订单金额
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;

    /**
     * 保额
     */
    @TableField("insurance_amount")
    private BigDecimal insuranceAmount;

    /**
     * 保险费率
     */
    @TableField("fee")
    private BigDecimal fee;

    /**
     * 费率区间起
     */
    @TableField("fee_start")
    private BigDecimal feeStart;

    /**
     * 费率区间止
     */
    @TableField("fee_end")
    private BigDecimal feeEnd;

    /**
     * 保险期限起
     */
    @TableField("limit_start")
    private Date limitStart;

    /**
     * 保险期限止
     */
    @TableField("limit_end")
    private Date limitEnd;

    /**
     * 保险天数
     */
    @TableField("insure_days")
    private Integer insureDays;

    /**
     * 主承保机构id
     */
    @TableField("main_org_id")
    private Long mainOrgId;

    /**
     * 主承保机构名称
     */
    @TableField("main_org_name")
    private String mainOrgName;

    /**
     * 工作流ID
     */
    @TableField("wf_id")
    private Long wfId;

    /**
     * 补录标识
     */
    @TableField("input_flag")
    private String inputFlag;

    /**
     * 驳回标识
     */
    @TableField("reject_flag")
    private String rejectFlag;

    /**
     * 资料审核标识	json
     */
    @TableField("doc_flag")
    private String docFlag;

    /**
     * 信息审核标识	json proFlag/custFlag/riskFlag 0:通过 1未通过
     */
    @TableField("info_flag")
    private String infoFlag;

    /**
     * 当前节点
     */
    @TableField("cur_node_name")
    private String curNodeName;

    /**
     * 当前节点编码
     */
    @TableField("cur_node_code")
    private String curNodeCode;

    /**
     * 上一节点名称
     */
    @TableField("pre_node_name")
    private String preNodeName;

    /**
     * 上一节点编码
     */
    @TableField("pre_node_code")
    private String preNodeCode;

    /**
     * 投保步骤
     */
    @TableField("step")
    private Integer step;

    /**
     * 支付方式
     */
    @TableField("pay_type")
    private String payType;

    /**
     * 保单url
     */
    @TableField("policy_url")
    private String policyUrl;

    /**
     * 保函url
     */
    @TableField("guarantee_url")
    private String guaranteeUrl;

    /**
     * 支付url
     */
    @TableField("pay_url")
    private String payUrl;

    /**
     * 保单号
     */
    @TableField("policy_no")
    private String policyNo;

    /**
     * 投保单号
     */
    @TableField("apply_no")
    private String applyNo;

    /**
     * 投保单号
     */
    @TableField("apply_flag")
    private String applyFlag;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 经纪人名称
     */
    @TableField("broker_name")
    private String brokerName;

    /**
     * 经纪人电话
     */
    @TableField("broker_phone_no")
    private String brokerPhoneNo;

    /**
     * 当前操作人
     */
    @TableField("op_name")
    private String opName;

    /**
     * 当前操作人id
     */
    @TableField("op_id")
    private String opId;

    /**
     * 其他承保机构	            
     */
    @TableField("json_other_org")
    private String jsonOtherOrg;

    /**
     * 项目信息快照
     */
    @TableField("pro_info_json")
    private String proInfoJson;

    /**
     * 状态	            0 草稿	            1 已提交	            2 已完成	            3 取消
     */
    @TableField("status")
    private String status;

    /**
     * 创建日期
     */
    @TableField("create_date")
    private Date createDate;

    /**
     * 最后修改日期
     */
    @TableField("modify_date")
    private Date modifyDate;

    @TableField("tender_date")
    private Date tenderDate;

    @TableField("is_delete")
    private String isDelete;

    /**
     * 人工审核提交标识 0 否 1是
     */
    @TableField("rg_check")
    private String rgCheck;

    /**
     * oss保单url
     */
    @TableField("local_policy")
    private String localPolicy;

    /**
     * oss保函url
     */
    @TableField("local_guarantee")
    private String localGuarantee;

    /**
     * 批次编号
     */
    @TableField("batch_no")
    private String batchNo;

    /**
     * 退保状态	0:未退保	1:退保申请	2:退保审核	3.退保成功	4:退保失败
     */
    @TableField("surrender_status")
    private String surrenderStatus;

    /**
     * 出函时间
     */
    @TableField("policy_date")
    private Date policyDate;

    /**
     * 反担保措施编码
     */
    @TableField("counter_guarantee")
    private String counterGuarantee;

    /**
     * 投保人类型
     */
    @TableField("policy_holder_type")
    private String policyHolderType;

    /**
     * 关联订单ID
     */
    @TableField("link_id")
    private Long linkId;

    /**
     * 关联订单编号
     */
    @TableField("link_no")
    private String linkNo;

    /**
     * 关联类型，1:主订单，0:副订单
     */
    @TableField("link_type")
    private String linkType;

    /**
     * 关联订单上一订单编号
     */
    @TableField("pre_order_no")
    private String preOrderNo;

    /**
     * 投保人信用证代码
     */
    @TableField("tb_code")
    private String tbCode;

    /**
     * 投保人名称
     */
    @TableField("tb_name")
    private String tbName;

    /**
     * 被保人信用证代码
     */
    @TableField("bb_code")
    private String bbCode;

    /**
     * 被保人名称
     */
    @TableField("bb_name")
    private String bbName;

    /**
     * 特别约定
     */
    @TableField("special_clause")
    private String specialClause;

    /**
     * 推送时间
     */
    @TableField("push_time")
    private Date pushTime;

    /**
     * 推送状态：0.未处理 1.成功 2.处理中 3.失败
     */
    @TableField("push_status")
    private Boolean pushStatus;


}
