package org.unit.flink.dls.service;

import lombok.RequiredArgsConstructor;

import org.unit.flink.dls.entity.FlinkJobConfig;

import org.springframework.stereotype.Service;

import org.apache.flink.api.common.JobID;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.catalog.Catalog;
import org.apache.flink.table.catalog.exceptions.CatalogException;


import java.util.Map;

@Service
@RequiredArgsConstructor
public class FlinkJobSubmitService {

    public TableEnvironment createTableEnv(FlinkJobConfig jobConfig) {
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inStreamingMode()
                .build();

        TableEnvironment tableEnv = TableEnvironment.create(settings);

        tableEnv.getConfig().getConfiguration()
                .setString("parallelism.default", String.valueOf(jobConfig.getParallelism()));

        if ("mysql".equalsIgnoreCase(jobConfig.getCatalogType())) {
            Map<String, String> props = jobConfig.getCatalogConfig();
//            Catalog catalog = new JdbcCatalog(
//                    props.get("catalogName"),
//                    props.get("defaultDatabase"),
//                    props.get("username"),
//                    props.get("password"),
//                    props.get("baseUrl")
//            );
            try {
//                tableEnv.registerCatalog("my_catalog", catalog);
                tableEnv.useCatalog("my_catalog");
            } catch (CatalogException e) {
                throw new RuntimeException("Catalog registration failed", e);
            }
        }
        return tableEnv;
    }

    public JobID submitJobGraphToRemoteCluster(FlinkJobConfig jobConfig) throws Exception {
        // 1. 创建 TableEnvironment
        TableEnvironment tableEnv = createTableEnv(jobConfig);

        // 2. 执行 SQL 语句
        for (String sql : jobConfig.getExecutionSql().split(";")) {
            if (!sql.trim().isEmpty()) {
                tableEnv.executeSql(sql);
            }
        }

        // 3. 编译为 Pipeline（JobGraph 的前身）
//        Pipeline pipeline = tableEnv.compilePlan();
//
//        // 4. 准备 Flink Configuration
//        Configuration config = new Configuration();
//        config.setString(RestOptions.ADDRESS, jobConfig.getJobManagerAddress());
//        config.setInteger(RestOptions.PORT, jobConfig.getJobManagerPort());

        // 5. 创建并使用 RestClusterClient 提交 Pipeline
//        try (RestClusterClient<String> client = new RestClusterClient<>(config, "standalone-cluster")) {
//            CompletableFuture<JobID> jobIdFuture = client.submitJob(pipeline);
//            return jobIdFuture.get(); // 阻塞获取 JobID
//        }
        return null;
    }
}

