package com.springboot.ipl.app.batchConfig;

import javax.sql.DataSource;

import com.springboot.ipl.app.util.MyItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.springboot.ipl.app.dto.MatchData;
import com.springboot.ipl.app.entity.Match;
import org.springframework.transaction.annotation.Transactional;


@Configuration
@Transactional
public class BatchConfig {

    private Logger log = LoggerFactory.getLogger(BatchConfig.class);

    private String[] FIELD_NAMES = {
            "season",
            "id",
            "name",
            "shortName",
            "description",
            "home_team",
            "away_team",
            "toss_won",
            "decision",
            "first_inning_score",
            "second_inning_score",
            "winner",
            "result",
            "start_date",
            "end_date",
            "venue_id",
            "venue_name",
            "home_captain",
            "away_captain",
            "pom",
            "points",
            "super_over",
            "home_overs",
            "home_runs",
            "home_wickets",
            "home_boundaries",
            "away_overs",
            "away_runs",
            "away_wickets",
            "away_boundaries",
            "highlights",
            "home_key_batsman",
            "home_key_bowler",
            "home_playx1",
            "away_playx1",
            "away_key_batsman",
            "away_key_bowler",
            "match_days",
            "umpire1",
            "umpire2",
            "tv_umpire",
            "referee",
            "reserve_umpire"
    };

//    @Bean
//    public FlatFileItemReader<MatchData> reader() throws Exception {
//        FlatFileItemReader<MatchData> reader = new FlatFileItemReader<>();
//        reader.setName("matchDataItemReader");
//        reader.setResource(new ClassPathResource("Cricket_data.csv"));
//        reader.setLinesToSkip(1);
//        reader.setLineMapper(lineMapper());

//        MatchData item = new MatchData();

//        log.info("checking the item -> : {}", item.getSeason());
//        reader.open(new ExecutionContext()); // Open the reader
//
//        MatchData item;
//        while ((item = (MatchData) reader.read()) != null) {
//            // Print the data
//            System.out.println("Read item: " + item);
//            log.info("Read item: {}", item);
//
//            // You can also access individual fields and print them
////            System.out.println("Season: " + item.getSeason());
////            System.out.println("Team1: " + item.getDecision());
//            log.info("Season: {}", item.getSeason());
//            log.info("Season: {}", item.getDecision());
//            // ... and so on
//
//            // If you want to pause between each item, you can use Thread.sleep()
//            // Thread.sleep(1000); // Pause for 1 second
//
//            // If you want to process the item further, you can do so here
//            // Match processedItem = processor.process(item);
//            // ...
//        }

//        return reader;
//    }

//    @Bean
//    public LineMapper<MatchData> lineMapper() {
//        DefaultLineMapper<MatchData> lineMapper = new DefaultLineMapper<>();
//
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames(FIELD_NAMES);
//
//        BeanWrapperFieldSetMapper<MatchData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(MatchData.class);
//
//        lineMapper.setLineTokenizer(lineTokenizer);
//        lineMapper.setFieldSetMapper(fieldSetMapper);
//
//        return lineMapper;
//    }

    @Bean
    public FlatFileItemReader<MatchData> reader() {
        return new FlatFileItemReaderBuilder<MatchData>()
                .name("matchItemReader")
                .resource(new ClassPathResource("Cricket_data.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchData>() {{
                    setTargetType(MatchData.class);
                }})
                .build();
    }


    @Bean
    public MatchDataProcessor processor() {
        return new MatchDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO matches (id, season, team1, team2, team_one_short_name, team_two_short_name, "
                        + "description, toss_winner, decision, first_inning_score, second_inning_score, "
                        + "match_winner, result, start_date, end_date, venue_name, home_captain, super_over, "
                        + "home_overs, home_runs, home_wickets, home_boundaries, highlights, home_key_batsman, "
                        + "home_key_bowler, home_playx1, match_days, umpire1, umpire2, tv_umpire, "
                        + "referee, reserve_umpire) "
                        + "VALUES "
                        + "(:id,:season,:team1,:team2,:teamOneShortName,:teamTwoShortName,:description, "
                        + ":tossWinner,:decision,:firstInningScore,:secondInningScore,:matchWinner, "
                        + ":result,:startDate,:endDate,:venueName,:homeCaptain,:superOver,:homeOvers, "
                        + ":homeRuns,:homeWickets,:homeBoundaries,:highlights,:homeKeyBatsman, "
                        + ":homeKeyBowler,:homePlayx1,:matchDays,:umpire1,:umpire2,:tvUmpire, "
                        + ":referee,:reserveUmpire)")
                .dataSource(dataSource)
                .build();
    }

//    @Bean
//    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
//        JdbcBatchItemWriter<Match> writer = new JdbcBatchItemWriter<>();
//        writer.setDataSource(dataSource);
//        writer.setSql("INSERT INTO people (id, first_name, last_name) VALUES (:id,:firstName,:lastName)");
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
//
//        return writer;
//    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
            JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
        PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Match> writer) throws Exception {
      return new StepBuilder("step1", jobRepository)
        .<MatchData, Match> chunk(10, transactionManager)
        .reader(reader())
        .processor(processor())
        .writer(writer)
        .build();
    }
}


