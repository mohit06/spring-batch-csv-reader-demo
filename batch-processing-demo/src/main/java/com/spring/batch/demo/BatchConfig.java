package com.spring.batch.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.LinkedList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    @Bean
    public CustomItemReader reader(){
        List<String> fruits = List.of("Mango", "Apple", "Banana", "Grapes", "Peach", "Pineapple", "Orange", "Watermelon", "musk melon");
        return new CustomItemReader(fruits);
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step1",jobRepository).<String, String>chunk(4, transactionManager).reader(reader())
                .writer(chunk -> {
                    System.out.println("Chunk Start");
                    System.out.println(chunk);
                    System.out.println("Chunk End");
                }).build();
    }

    @Bean
    public Job job1(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new JobBuilder("job1", jobRepository)
                .start(step1(jobRepository, transactionManager))
                .build();
    }

}
