package com.heisy.demo3;

import java.util.ArrayList;
import java.util.List;

import com.heisy.demo3.domain.model.Person;
import com.heisy.demo3.service.PersonService;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BatchItemReader implements ItemReader<InputItem> {

    @Autowired
    private PersonService personService;

    private List<Person> people = new ArrayList<>();
    private int index = 0;

    @Override
    public InputItem read() throws Exception {
        log.debug("called read method");

        if (people.isEmpty()) {
            this.people = personService.selectAll();
            this.index = 0;
        }

        if (index == people.size()) {
            return null;
        }

        Person p = people.get(index);
        InputItem inputItem = InputItem.builder().data(p.toString()).build();
        index++;

        // 読み取ったデータを入力データクラスへ詰めて、返却
        return inputItem;
    }
}