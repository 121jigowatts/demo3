package com.heisy.demo3;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<InputItem> reader() {
        return new BatchItemReader();
    }

    @Bean
    public ItemProcessor<InputItem, OutputItem> processor() {
        return new BatchItemProcessor();
    }

    @Bean
    public ItemWriter<OutputItem> writer() {
        return new BatchItemWriter();
    }

    @Bean
    public Step step1(StepListener listener) {
        return this.stepBuilderFactory.get("step1").<InputItem, OutputItem>chunk(1).reader(reader())
                .processor(processor()).writer(writer()).listener(listener).build();
    }

    @Bean
    public Tasklet tasklet() {
        return new BatchTasklet();
    }

    @Bean
    public Step step2() {
        return this.stepBuilderFactory.get("step2").tasklet(tasklet()).build();
    }

    @Bean
    public Job runJob(JobListener listener, Step step1, Step step2) {
        return this.jobBuilderFactory.get("runJob").listener(listener).start(step1).next(step2).build();
    }
}