package com.rainyhon.task.job.v2.policy.entity;

import com.microcore.center.model.AlarmResult;
import lombok.Data;

/**
 * 告警策略结果
 *
 * @author leizhenyang
 * @date 2019.04.29
 */
@Data
public class AlarmPolicyResult {

    private boolean success = false;

    private AlarmResult result;

}
