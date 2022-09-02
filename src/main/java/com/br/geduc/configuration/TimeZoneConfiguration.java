package com.br.geduc.configuration;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

@Configuration
public class TimeZoneConfiguration {

    private static final String DEFAULT_TIMEZONE = "America/Sao_Paulo";

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(DEFAULT_TIMEZONE));
        System.out.println(LocalDateTime.now(ZoneId.systemDefault()));
    }

}
