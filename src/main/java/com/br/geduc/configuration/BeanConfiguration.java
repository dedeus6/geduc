package com.br.geduc.configuration;

import com.br.geduc.mapper.EventMapper;
import com.br.geduc.mapper.UserMapper;
import com.br.geduc.repository.EventRepository;
import com.br.geduc.repository.UserRepository;
import com.br.geduc.service.EventService;
import com.br.geduc.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(
                userRepository,
                new UserMapper(new ModelMapper())
        );
    }

    @Bean
    public EventService eventService(EventRepository eventRepository) {
        return new EventService(
                eventRepository,
                new EventMapper(new ModelMapper())
        );
    }

    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }

}
