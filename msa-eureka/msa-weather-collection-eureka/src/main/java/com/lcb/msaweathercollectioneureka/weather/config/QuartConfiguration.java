package com.lcb.msaweathercollectioneureka.weather.config;


import com.lcb.msaweathercollectioneureka.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartConfiguration {

    private static final int TIME = 1800;

    //Jobdetail 定义特定的job
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
    }

    //Trigger 触发设定
    @Bean
    public Trigger weatherDataSynvTrigger() {
        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSynvTrigger").withSchedule(schedBuilder).build();
    }
}
