package com.rainyhon.task.job.v2.policy;

import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.service.impl.AlarmPolicyService;
import com.rainyhon.task.job.v2.policy.base.IAlarmPolicyChecker;
import com.rainyhon.task.job.v2.policy.checker.StayTimeoutAlarmPolicyChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 告警策略管理者
 *
 * @author leizhenyang
 * @date 2019.04.29
 */
@Component
public class AlarmPolicyManager implements CommandLineRunner {

    public static final String DEFAULT = "DEFAULT";
    @Autowired
    private AlarmPolicyService policyService;

    /**
     * 策略验证器
     */
    private Map<String, IAlarmPolicyChecker> checker;

    private List<AlarmPolicy> policies;

    private Map<String, String> addressList;

    public List<AlarmPolicy> getPolicies() {
        return policies;
    }

    public Map<String, String> getAddressList() {
        return addressList;
    }

    @Override
    public void run(String... strings) throws Exception {
        // 加载已有的处理策略
        policies = (List<AlarmPolicy>) policyService.getAllEnableAlarmPolicy().getData();

        addressList = new HashMap<>();
        addressList.put("1", "入口");
        addressList.put("2", "入口");
        addressList.put("3", "工作区");
        addressList.put("4", "会议室");
        addressList.put("5", "总经理室");


        checker.put("DEFAULT", new StayTimeoutAlarmPolicyChecker(addressList));
    }

    public IAlarmPolicyChecker getChecker() {
        return checker.get(DEFAULT);
    }
}
