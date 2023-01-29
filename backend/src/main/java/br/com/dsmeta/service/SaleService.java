package br.com.dsmeta.service;

import br.com.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
   @Autowired
   private SaleRepository saleRepository;


}
