package com.heisy.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class StepListener implements StepExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(StepListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        // Stepを実行する前に実行する処理を書く
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        // Stepを実行した後に実行する処理を書く
        log.info("Summary : " + stepExecution.getSummary());
        log.info("commit count : " + stepExecution.getCommitCount());
        log.info("skip count : " + stepExecution.getSkipCount());
        log.info("write count : " + stepExecution.getWriteCount());
        log.info("read count : " + stepExecution.getReadCount());
        if (stepExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! STEP FINISHED! Time to verify the results");
            return ExitStatus.COMPLETED;
        }
        return ExitStatus.FAILED;
    }
}