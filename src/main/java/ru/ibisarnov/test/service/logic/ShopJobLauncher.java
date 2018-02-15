package ru.ibisarnov.test.service.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ShopJobLauncher {
    private static final Logger LOG = LoggerFactory.getLogger(ShopJobLauncher.class);

    private final JobLauncher jobLauncher;
    private final Job shopJob;

    @Autowired
    public ShopJobLauncher(@Qualifier("shopJob") Job shopJob, JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
        this.shopJob = shopJob;
    }

    @Scheduled(fixedRate = 60000)
    void launchXmlFileToDatabaseJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {
        LOG.info("Shop job has been started...");
        jobLauncher.run(shopJob, getExecutor());
        LOG.info("Shop job has been stopped.");
    }

    private JobParameters getExecutor() {
        Map<String, JobParameter> jobParameters = new HashMap<>();
        JobParameter timeParameter = new JobParameter(new Date());
        jobParameters.put("currentTime", timeParameter);
        return new JobParameters(jobParameters);
    }
}
