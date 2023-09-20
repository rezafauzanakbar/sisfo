package com.jatiluhur.sisfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jatiluhur.sisfo.core.IService;

import com.jatiluhur.sisfo.handler.ResponseHandler;
import com.jatiluhur.sisfo.model.Imunisasi;
import com.jatiluhur.sisfo.repo.ImunisasiRepo;


@Service
@Transactional
public class ImunisasiService implements IService<Imunisasi>{
    private ImunisasiRepo imunisasiRepo;
    
    @Autowired
    public ImunisasiService(ImunisasiRepo imunisasiRepo) {
        
        this.imunisasiRepo = imunisasiRepo;
      
    }

    @Override
    public ResponseEntity<Object> save(Imunisasi imunisasi, HttpServletRequest request) {
        if(imunisasi==null)
        {
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid",//message
                    HttpStatus.BAD_REQUEST,//httpstatus
                    null,//object
                    "FV002001",//errorCode Fail Validation modul-code 001 sequence 001 range 001 - 010
                    request
            );
        }
        try{
            imunisasiRepo.save(imunisasi); 
 
         }catch (Exception e)
         {
             return new ResponseHandler().generateResponse(
                     "Data Gagal Disimpan",//message
                     HttpStatus.INTERNAL_SERVER_ERROR,//httpstatus
                     null,//object
                     "FE002001",//errorCode Fail Error modul-code 001 sequence 001 range 001 - 010
                     request
             );
         }
 
         return new ResponseHandler().generateResponse(
                 "Data Berhasil Disimpan",//message
                 HttpStatus.CREATED,//httpstatus created
                 null,//object
                 null,//errorCode diisi null ketika data berhasil disimpan
                 request
         );
     }


@Override
    public ResponseEntity<Object> update(Long id, Imunisasi imunisasi, HttpServletRequest request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> saveBatch(List<Imunisasi> lt, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByPage(Integer page, Integer size, String columFirst, String valueFirst, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAllByPage(Integer page, Integer size, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        List<Imunisasi> listImunisasi;
         listImunisasi = imunisasiRepo.findAll();
       

        return new ResponseHandler().generateResponse(
                "Data Ditemukan",//message
                HttpStatus.OK,//httpstatus OK
                listImunisasi,//object
                null,//errorCode diisi null ketika data berhasil disimpan
                request
        );
      
    }

    @Override
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }



}