package com.heisy.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BatchItemReader implements ItemReader<InputItem> {

    private static final Logger log = LoggerFactory.getLogger(BatchItemReader.class);

    private static int count = 0;

    @Override
    public InputItem read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        log.info("called read method");
        // 本当はここでデータをDBやファイルを読み取る
        if (count++ > 1) {
            return null; // データを読み終わったら、nullを返却すること
        }
        // 読み取ったデータを入力データクラスへ詰めて、返却
        return new InputItem("data");
    }
}