package com.eureka.client.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Bean("emailQueue")
	public Queue getEmailQueue(){
		return new Queue("emailQueue");
	}
	
	@Bean("messageQueue")
	public Queue getMessageQueue(){
		return new Queue("messageQueue");
	}
	
	@Bean
	public FanoutExchange getFanoutExchange(){
		return new FanoutExchange("fanoutExchange");
	}
	
	@Bean
	public Binding bindEmailQueueToFanoutExchange(@Qualifier("emailQueue") Queue emailQueue,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(emailQueue).to(fanoutExchange);
	}
	
	@Bean
	public Binding bindMessageQueueToFanoutExchange(@Qualifier("messageQueue") Queue messageQueue,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(messageQueue).to(fanoutExchange);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(){
		RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
			@Override
			public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
				String correlationId=message.getMessageProperties().getCorrelationId();
				System.out.printf(("消息：%s 发送失败, 应答码：%s 原因：%s 交换机: %s  路由键: %s"),correlationId, replyCode, replyText, exchange, routingKey);
			}
		});
		rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				if (ack){
					System.out.printf("消息发送到exchange成功,id: %s", correlationData.getId());
				}else{
					System.out.printf("消息发送到exchange失败,原因: %s", cause);
				}
			}
		});
		return rabbitTemplate;
	}

	
}
