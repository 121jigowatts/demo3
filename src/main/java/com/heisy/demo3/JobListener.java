package com.heisy.demo3;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobListener implements JobExecutionListener {

        @Override
        public void beforeJob(JobExecution jobExecution) {
                // Jobを実行する前に実行する処理を書く
        }

        @Override
        public void afterJob(JobExecution jobExecution) {
                // Jobを実行した後に実行する処理を書く
                if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                        log.debug("!!! JOB FINISHED! Time to verify the results");
                }
        }
}