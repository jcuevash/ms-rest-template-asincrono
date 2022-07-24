package com.jcuevash.contacto.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.jcuevash.contacto.app.vo.ContactosVO;

public interface LlamadaServiceApp {
		public CompletableFuture<List<ContactosVO>> consumoServicio(ContactosVO contacto);
}
