package com.es.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsConfig {
	@Value("${es.host}")
	private String host;
	@Value("${es.port}")
	private int port;
	
	@SuppressWarnings("resource")
	@Bean(name="client")
	public TransportClient getTransportClient(){
		TransportClient client=null;
		try {
			client = new PreBuiltTransportClient(Settings.EMPTY)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("获取es连接失败......");
		}
		return client;
	}
	
}
