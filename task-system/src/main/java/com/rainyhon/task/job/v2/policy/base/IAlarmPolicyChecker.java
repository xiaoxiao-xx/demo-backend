package com.rainyhon.task.job.v2.policy.base;

import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.task.job.v2.policy.entity.AlarmPolicyResult;
import com.rainyhon.task.job.v2.policy.entity.Record;

/**
 * 告警策略接口
 *
 * @author leizhenyang
 * @date 2019.04.29
 */
public interface IAlarmPolicyChecker {
    /**
     *
     * @param policy
     * @param face
     * @return
     */
    AlarmPolicyResult doCheck(AlarmPolicy policy, Record face);

}
