package com.trial.spring.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean//spring bunun için bir instance oluşturması için Bean anatasyonununu ekliyoruz.
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);// oluşturduğumuz instancenin eşleştirme stratejini belirliyoruz burda tam eşleştirme yapıyoruz yani DTO'daki fieldlere karşılık gelen etntitydeki alanlara birebir eşleştirme yapılacaktır.
        return modelMapper;
    }
}
