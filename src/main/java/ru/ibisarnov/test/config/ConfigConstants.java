package ru.ibisarnov.test.config;

final class ConfigConstants {
    private ConfigConstants() {
    }

    static final class BatchConstants {
        private BatchConstants() {
        }

        //Batch Configuration
        static final String JOB_NAME = "job";
        static final String STEP1 = "parserStep";
        static final String STEP2 = "dbWriterStep";
        static final String STEP3 = "resultsPrintoutStep";

        //Xml Job Configuration
        static final String YML_PATH_PROPERTY = "yml.path";
        static final String PRODUCT_ROOT = "offer";
    }
}
