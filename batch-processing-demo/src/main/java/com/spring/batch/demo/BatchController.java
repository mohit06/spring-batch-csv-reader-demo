package com.spring.batch.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("job1")
    private Job job;

    @Autowired
    @Qualifier("job2")
    private Job job2;

    @GetMapping("/job1/{param}")
    public void startJob1(@PathVariable("param") String param) throws Exception{
        JobParameters params = new JobParametersBuilder().addString("PARAM",param).toJobParameters();
        jobLauncher.run(job,params);
    }

    @GetMapping("/job2/{param}")
    public void startCsvJob(@PathVariable("param") String param) throws Exception{
        System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKK");
        JobParameters params = new JobParametersBuilder().addString("PARAM",param).toJobParameters();
        jobLauncher.run(job2,params);
    }
}
