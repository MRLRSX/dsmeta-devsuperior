package br.com.dsmeta.dsmeta.resource;

import br.com.dsmeta.dsmeta.entities.Sale;
import br.com.dsmeta.dsmeta.service.SaleService;
import br.com.dsmeta.dsmeta.service.SmsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleResource {

    @Autowired
    private SaleService service;
    @Autowired
    private SmsServices smsService;

    @GetMapping
    public ResponseEntity<Page<Sale>> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @PageableDefault(size = 12) Pageable pageable) {

        Page<Sale> lista = service.findSales(minDate, maxDate, pageable);
        return ResponseEntity.ok().body(lista);
    }


    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
