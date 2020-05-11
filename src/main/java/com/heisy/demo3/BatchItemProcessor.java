package com.heisy.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class BatchItemProcessor implements ItemProcessor<InputItem, OutputItem> {

    private static final Logger log = LoggerFactory.getLogger(BatchItemProcessor.class);

    @Override
    public OutputItem process(InputItem inputItem) throws Exception {
        log.info("called process method");
        // ここでデータのバリデーションチェックをやる
        // 入力データを出力データへ変換する
        OutputItem outputItem = new OutputItem(inputItem.getData().toUpperCase());
        log.info("Input (" + inputItem + "), Output (" + outputItem + ")");
        return outputItem;
    }
}