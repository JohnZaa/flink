package org.unit.flink.web.config;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FlinkBean {

    @Bean
    public StreamExecutionEnvironment flinkEnv() {
        // 不要初始化 Flink cluster 或 job
        return StreamExecutionEnvironment.createLocalEnvironment();
    }
}
