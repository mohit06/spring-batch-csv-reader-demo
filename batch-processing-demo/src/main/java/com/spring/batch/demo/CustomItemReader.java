package com.spring.batch.demo;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.List;

public class CustomItemReader implements ItemReader<String> {

    private Iterator<String> iterator;

    public CustomItemReader(List<String> list){
        iterator = list.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return iterator.hasNext() ? iterator.next() : null;
    }
}
