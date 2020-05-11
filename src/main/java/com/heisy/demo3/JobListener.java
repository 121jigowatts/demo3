package com.heisy.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobListener implements JobExecutionListener {

        private static final Logger log = LoggerFactory.getLogger(JobListener.class);

        @Override
        public void beforeJob(JobExecution jobExecution) {
                // Jobを実行する前に実行する処理を書く
        }

        @Override
        public void afterJob(JobExecution jobExecution) {
                // Jobを実行した後に実行する処理を書く
                if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                        log.info("!!! JOB FINISHED! Time to verify the results");
                }
        }
}