package com.jatiluhur.sisfo.service;
import com.jatiluhur.sisfo.handler.RequestCapture;
import com.jatiluhur.sisfo.handler.ResponseHandler;
import com.jatiluhur.sisfo.model.Kip;
import com.jatiluhur.sisfo.util.TransformDataPaging;
import com.jatiluhur.sisfo.repo.KipRepo;
import com.jatiluhur.sisfo.core.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KipService implements IService<Kip>{
    private KipRepo kipRepo;
    private String[] strExceptionArr = new String[2];
    private TransformDataPaging transformDataPaging = new TransformDataPaging();
    private Map<String, Object> mapz = new HashMap<>();

    public KipService(KipRepo kipRepo) {
        strExceptionArr[0] = "KipService";
        this.kipRepo = kipRepo;
    }

    @Override
    public ResponseEntity<Object> save(Kip kip, HttpServletRequest request) {
        if (kip == null) {
            return new ResponseHandler().generateResponse(
                    "Data tidak valid", HttpStatus.BAD_REQUEST,
                    null, "FE002000", request
            );
        }

        try {
            kipRepo.save(kip);
        } catch (Exception e) {
            strExceptionArr[1] = "save(Kip kip, HttpServletRequest request) --- LINE 59 \n"+ RequestCapture.allRequest(request);
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
    public ResponseEntity<Object> update(Long id, Kip kip, HttpServletRequest request) throws Exception {
            return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

//    @Override
//    public ResponseEntity<Object> deleteByNik(String nik, HttpServletRequest request){
//        Optional<Kip> barangTrans =  kipRepo.findByNik(nik);
//
//        if(barangTrans.isEmpty())
//        {
//            return new ResponseHandler().generateResponse(
//                    "Data tidak Valid",//message
//                    HttpStatus.BAD_REQUEST,//httpstatus
//                    null,//object
//                    "FV002021",//errorCode Fail Validation modul-code 001 sequence 001 range 021 - 030
//                    request
//            );
//        }
//
//        try{
//            kipRepo.deleteByNik(nik, request);
//        }catch (Exception e)
//        {
//            return new ResponseHandler().generateResponse(
//                    "Data Gagal Dihapus",//message
//                    HttpStatus.INTERNAL_SERVER_ERROR,//httpstatus
//                    null,//object
//                    "FE002021",//errorCode Fail Error modul-code 001 sequence 001 range 021 - 030
//                    request
//            );
//        }
//        return new ResponseHandler().generateResponse(
//                "Data Berhasil Dihapus",//message
//                HttpStatus.CREATED,//httpstatus seharusnya no content 204 (permintaan berhasil tapi tidak ada content untuk dikirim dalam response)
//                null,//object
//                null,//errorCode diisi null ketika data berhasil disimpan
//                request
//        );
//    }

    @Override
    public ResponseEntity<Object> saveBatch(List<Kip> lt, HttpServletRequest request) {
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
        List<Kip> listKip;
        try{
            listKip = kipRepo.findAll();
            if(listKip.size()==0){
                return new ResponseHandler().generateResponse(
                        "Data tidak Ditemukan",//message
                        HttpStatus.NOT_FOUND,//httpstatus
                        null,//object
                        "FV002002",//errorCode Fail Validation modul-code 001 sequence 001 range 071 - 080
                        request
                );
            }
        } catch (Exception e){
            strExceptionArr[1] = "findAll(HttpServletRequest request) --- LINE 382 \n" + RequestCapture.allRequest(request);
            return new ResponseHandler().generateResponse(
                    "Data tidak Valid",//message
                    HttpStatus.INTERNAL_SERVER_ERROR,//httpstatus
                    null,//object
                    "FE002002",//errorCode Fail Validation modul-code 001 sequence 001 range 071 - 080
                    request
            );
        }

        return new ResponseHandler().generateResponse(
                "Data Ditemukan",//message
                HttpStatus.OK,//httpstatus OK
                listKip,//object
                null,//errorCode diisi null ketika data berhasil disimpan
                request
        );
    }

    @Override
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }
}