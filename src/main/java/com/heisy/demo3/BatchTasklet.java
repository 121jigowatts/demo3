package com.heisy.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class BatchTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(BatchTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // ここで好きなの処理をやる
        log.info("called execute method");
        return RepeatStatus.FINISHED;
    }
}