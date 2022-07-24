package com.jcuevash.contacto.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.jcuevash.contacto.app.vo.ContactosVO;

@Service
public class LlamadaServiceImpl implements LlamadaServiceApp {
	@Autowired
	RestTemplate templete;
	@Value("${ws.consume.url}")
	String url;
	
	@Override
	@Async
	public CompletableFuture<List<ContactosVO>> consumoServicio(ContactosVO contacto) {
		templete.postForLocation(url, contacto);
		ContactosVO[] response = templete.getForObject(url, ContactosVO[].class);
		return CompletableFuture.completedFuture(Arrays.asList(response));
	}

}
