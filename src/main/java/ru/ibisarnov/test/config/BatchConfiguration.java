package ru.ibisarnov.test.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ibisarnov.test.domain.dto.element.ShopDto;
import ru.ibisarnov.test.domain.entity.Product;

import static ru.ibisarnov.test.config.ConfigConstants.BatchConstants.*;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private final JobBuilderFactory jobBuilderFactory;
    private final ItemReader<ShopDto> productReader;
    private final ItemWriter<ShopDto> productWriter;

    @Autowired
    public BatchConfiguration(@Qualifier("productReader") ItemReader<ShopDto> productReader,
                              @Qualifier("productWriter") ItemWriter<ShopDto> productWriter,
                              JobBuilderFactory jobBuilderFactory,
                              StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.jobBuilderFactory = jobBuilderFactory;
        this.productReader = productReader;
        this.productWriter = productWriter;
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
    }

}
