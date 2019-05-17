package com.rainyhon.task.job.v2.policy;

import com.rainyhon.common.constant.AreaDef;
import com.rainyhon.common.model.AlarmPolicy;
import com.rainyhon.common.service.AlarmPolicyService;
import com.rainyhon.task.job.v2.policy.base.IAlarmPolicyChecker;
import com.rainyhon.task.job.v2.policy.checker.StayTimeoutAlarmPolicyChecker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
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
@Slf4j
public class AlarmPolicyManager implements CommandLineRunner {

    private static final String DEFAULT = "DEFAULT";

    @Autowired
    private AlarmPolicyService policyService;

    /**
     * 策略验证器
     */
    private Map<String, IAlarmPolicyChecker> checker = new HashMap<>();

    private List<AlarmPolicy> policies;

    private Map<String, String> addressList = new HashMap<>();

    public List<AlarmPolicy> getPolicies() {
        return policies;
    }

    public Map<String, String> getAddressList() {
        return addressList;
    }

    private synchronized void refreshPolicy() {
        policies = policyService.getAllEnableAlarmPolicyReal();
    }

    @Override
    public void run(String... strings) throws Exception {
        // 加载已有的处理策略
        new Thread(() -> {
            try {
                refreshPolicy();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        addressList = new HashMap<>();
        addressList = AreaDef.areaMap;

        checker.put(DEFAULT, new StayTimeoutAlarmPolicyChecker(addressList));
    }

    public IAlarmPolicyChecker getChecker() {
        return checker.get(DEFAULT);
    }

    @Scheduled(fixedRate = 60000L)
    private void refreshPolicies() {
        refreshPolicy();
        // log.info("已经刷新告警策略");
    }

}
