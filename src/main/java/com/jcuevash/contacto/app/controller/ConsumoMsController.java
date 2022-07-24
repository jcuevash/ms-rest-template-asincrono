package com.jcuevash.contacto.app.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jcuevash.contacto.app.service.LlamadaServiceApp;
import com.jcuevash.contacto.app.vo.ContactosVO;

@RestController
@RequestMapping("/jcuevash/consumo")
public class ConsumoMsController {

	@Autowired
	private LlamadaServiceApp serviceApp;
	
	
	@GetMapping(value = "/addContacto/{nombre}/{edad}/{email}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ContactosVO> addNuevoContacto(
			@PathVariable(name = "nombre")String nombre,@PathVariable(name = "edad")Integer edad,@PathVariable(name = "email")String email
			) throws URISyntaxException{
		
			ContactosVO vo = new ContactosVO();
			
			vo.setNombre(nombre);
			vo.setEdad(edad);
			vo.setEmail(email);
			
			CompletableFuture<List<ContactosVO>> listaVo = serviceApp.consumoServicio(vo);
			
			for (int i=0;i<50;i++) {
				System.out.println("esperando "+1+" ...");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				return listaVo.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	

	

}
