package com.heisy.demo3;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class BatchItemWriter implements ItemWriter<OutputItem> {

    private static final Logger log = LoggerFactory.getLogger(BatchItemWriter.class);

    @Override
    public void write(List<? extends OutputItem> items) throws Exception {
        log.info("called write method");
        // 本当はここでデータをDBやファイルへ出力する
        log.info("Output ({})", items);
    }
}