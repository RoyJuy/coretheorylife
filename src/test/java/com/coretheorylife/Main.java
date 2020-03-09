package com.coretheorylife;

import com.coretheorylife.common.utils.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date from  = null;
        try {
            from = dateFormat.parse("2019-12-16");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> list = DateUtils.getTimes(new Date(), new Date());
        System.out.println();
    }
}
