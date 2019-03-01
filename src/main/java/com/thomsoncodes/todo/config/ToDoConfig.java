package com.thomsoncodes.todo.config;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class ToDoConfig {
	
	@Bean
	public MessageConverter JacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = 
				new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("-class_");
		return converter;
	}
	
	@Bean
	public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
													 DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		                                      
		
		
		return null;		
	}

}
