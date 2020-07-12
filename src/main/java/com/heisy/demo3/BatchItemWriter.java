package com.heisy.demo3;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BatchItemWriter implements ItemWriter<OutputItem> {

    @Override
    public void write(List<? extends OutputItem> items) throws Exception {
        log.debug("called write method");
        // 本当はここでデータをDBやファイルへ出力する
        log.debug("Output ({})", items);
    }
}