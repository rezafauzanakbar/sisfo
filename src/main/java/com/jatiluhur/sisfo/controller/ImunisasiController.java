package com.jatiluhur.sisfo.controller;

import javax.servlet.http.HttpServletRequest;
import com.jatiluhur.sisfo.model.Imunisasi;
import com.jatiluhur.sisfo.service.ImunisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/imunisasi")
public class ImunisasiController {
    private ImunisasiService imunisasiService;
   
    

    @Autowired
    public ImunisasiController(ImunisasiService imunisasiService) {
        this.imunisasiService = imunisasiService;
    }
 @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Imunisasi imunisasi,HttpServletRequest request)
    {
      
         return imunisasiService.save(imunisasi,request);
    }
     @GetMapping("/findall")
    public ResponseEntity<Object> findAll(HttpServletRequest request)
    {
        return imunisasiService.findAll(request);
    }
    
}