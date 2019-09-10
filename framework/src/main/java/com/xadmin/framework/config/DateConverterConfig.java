package com.xadmin.framework.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class DateConverterConfig implements Converter<String, Date> {

    private static final List<String> formarts = new ArrayList<>(4);

    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }

    @Override
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }
        try {
            if(source.matches("^\\d{4}-\\d{1,2}$")){
                return new SimpleDateFormat(formarts.get(0)).parse(source);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                return new SimpleDateFormat(formarts.get(1)).parse(source);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                return new SimpleDateFormat(formarts.get(2)).parse(source);
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                return new SimpleDateFormat(formarts.get(3)).parse(source);
            }else {
                throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
