package com.heisy.demo3;

import org.springframework.batch.item.ItemProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BatchItemProcessor implements ItemProcessor<InputItem, OutputItem> {

    @Override
    public OutputItem process(InputItem inputItem) throws Exception {
        log.debug("called process method");
        // ここでデータのバリデーションチェックをやる
        // 入力データを出力データへ変換する
        String data = inputItem.getData().toUpperCase();
        OutputItem outputItem = OutputItem.builder().data(data).build();
        log.debug("Input ({}), Output ({})", inputItem, outputItem);

        return outputItem;
    }
}