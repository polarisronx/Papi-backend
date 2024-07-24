package com.polaris.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 接口调用任务
 * @TableName invoke_task
 */
@TableName(value ="invoke_task")
@Data
public class InvokeTask implements Serializable {
    /**
     * 任务ID
     */
    @TableId(value = "task_id")
    private Long taskId;

    /**
     * 调用的接口ID
     */
    @TableField(value = "interface_id")
    private Long interfaceId;

    /**
     * 调用的用户的ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 运行状态
     */
    @TableField(value = "process_status")
    private String processStatus;

    /**
     * 输入参数
     */
    @TableField(value = "input_params")
    private String inputParams;

    /**
     * 输出结果
     */
    @TableField(value = "output_res")
    private String outputRes;

    /**
     * 输入数据
     */
    @TableField(value = "input_data")
    private String inputData;

    /**
     * 结果类型
     */
    @TableField(value = "res_type")
    private String resType;
    /**
     * 运行时信息
     */
    @TableField(value = "running_msg")
    private String runningMsg;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InvokeTask other = (InvokeTask) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
                && (this.getInterfaceId() == null ? other.getInterfaceId() == null : this.getInterfaceId().equals(other.getInterfaceId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getProcessStatus() == null ? other.getProcessStatus() == null : this.getProcessStatus().equals(other.getProcessStatus()))
                && (this.getInputParams() == null ? other.getInputParams() == null : this.getInputParams().equals(other.getInputParams()))
                && (this.getOutputRes() == null ? other.getOutputRes() == null : this.getOutputRes().equals(other.getOutputRes()))
                && (this.getInputData() == null ? other.getInputData() == null : this.getInputData().equals(other.getInputData()))
                && (this.getResType() == null ? other.getResType() == null : this.getResType().equals(other.getResType()))
                && (this.getRunningMsg() == null ? other.getRunningMsg() == null : this.getRunningMsg().equals(other.getRunningMsg()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getInterfaceId() == null) ? 0 : getInterfaceId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProcessStatus() == null) ? 0 : getProcessStatus().hashCode());
        result = prime * result + ((getInputParams() == null) ? 0 : getInputParams().hashCode());
        result = prime * result + ((getOutputRes() == null) ? 0 : getOutputRes().hashCode());
        result = prime * result + ((getInputData() == null) ? 0 : getInputData().hashCode());
        result = prime * result + ((getResType() == null) ? 0 : getResType().hashCode());
        result = prime * result + ((getRunningMsg() == null) ? 0 : getRunningMsg().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", interfaceId=").append(interfaceId);
        sb.append(", userId=").append(userId);
        sb.append(", processStatus=").append(processStatus);
        sb.append(", inputParams=").append(inputParams);
        sb.append(", outputRes=").append(outputRes);
        sb.append(", inputData=").append(inputData);
        sb.append(", resType=").append(resType);
        sb.append(", runningMsg=").append(runningMsg);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}