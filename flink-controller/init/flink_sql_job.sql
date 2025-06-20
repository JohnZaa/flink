CREATE TABLE flink_sql_job (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    job_name VARCHAR(255),
    catalog_type VARCHAR(64),     -- 'mysql' | 'hive' | 'inmemory'
    catalog_config TEXT,          -- JSON 格式，存 JDBC、Hive 配置等
    execution_sql TEXT,           -- 多条 SQL（如 CREATE TABLE + INSERT INTO）
    parallelism INT,
    savepoint_path VARCHAR(1024),
    state_backend VARCHAR(128),
    status VARCHAR(32),           -- 'pending' | 'running' | 'failed' | 'success'
    create_time TIMESTAMP,
    update_time TIMESTAMP
);
