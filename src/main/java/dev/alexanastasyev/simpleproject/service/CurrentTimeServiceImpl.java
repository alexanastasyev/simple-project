package dev.alexanastasyev.simpleproject.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CurrentTimeServiceImpl implements CurrentTimeService {

    private static final String DATE_FORMAT_PATTERN = "dd MMMM yyyy HH:mm:ss";

    @Override
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override
    public String getCurrentTimeFormatted() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(new Date());
    }

}
