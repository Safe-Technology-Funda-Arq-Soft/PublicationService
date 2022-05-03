package com.api.safectech.publicationservice.tag.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("commentMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TagMapper tagMapper() { return new TagMapper();}
}
