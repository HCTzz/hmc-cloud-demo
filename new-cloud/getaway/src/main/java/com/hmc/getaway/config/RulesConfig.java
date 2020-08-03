package com.hmc.getaway.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HHF
 * @Description
 * @create 2020-07-02 上午 10:05
 */
@Configuration
public class RulesConfig {

    @PostConstruct
    public void initRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("consumer-a");
        // set limit qps to 20
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
