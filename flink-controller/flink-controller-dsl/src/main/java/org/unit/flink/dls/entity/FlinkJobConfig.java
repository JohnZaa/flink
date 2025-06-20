package org.unit.flink.dls.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Getter
@Setter
public class FlinkJobConfig {
    private String jobName;
    private String catalogType; // mysql / hive / etc.
    private Map<String, String> catalogConfig;
    private String executionSql;
    private int parallelism;
    private String jobManagerAddress;
    private int jobManagerPort;
}
