package ru.ibisarnov.test.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

   /* private final StepBuilderFactory stepBuilderFactory;
    private final JobBuilderFactory jobBuilderFactory;

    @Autowired
    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Step parserStep() {
        return stepBuilderFactory.get(STEP1)
                .<Product, Product>chunk(10)
                //todo .reader()
                .build();
    }

    @Bean
    public Step dbWriterStep() {
        stepBuilderFactory.get(STEP2);
        //todo
        return null;
    }

    @Bean
    public Step resultsPrintoutStep() {
        stepBuilderFactory.get(STEP3);
        //todo
        return null;
    }

    @Bean
    public Job job(Step parserStep, Step dbWriterStep, Step resultsPrintoutStep) {
        return jobBuilderFactory.get(JOB_NAME)
                .incrementer(new RunIdIncrementer())
                .start(parserStep)
                .next(dbWriterStep)
                .next(resultsPrintoutStep)
                .build();
    }*/

}
