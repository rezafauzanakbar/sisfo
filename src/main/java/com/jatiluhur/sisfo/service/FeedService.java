package com.jatiluhur.sisfo.service;
import com.jatiluhur.sisfo.handler.RequestCapture;
import com.jatiluhur.sisfo.handler.ResponseHandler;
import com.jatiluhur.sisfo.model.Feed;
import com.jatiluhur.sisfo.util.TransformDataPaging;
import com.jatiluhur.sisfo.repo.FeedRepo;
import com.jatiluhur.sisfo.core.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedService implements IService<Feed>{
    private FeedRepo feedRepo;
    private String[] strExceptionArr = new String[2];
    private TransformDataPaging transformDataPaging = new TransformDataPaging();
    private Map<String, Object> mapz = new HashMap<>();

    public FeedService(FeedRepo feedRepo) {
        strExceptionArr[0] = "FeedService";
        this.feedRepo = feedRepo;
    }

    @Override
    public ResponseEntity<Object> save(Feed feed, HttpServletRequest request) {
        if (feed == null) {
            return new ResponseHandler().generateResponse(
                    "Data tidak valid", HttpStatus.BAD_REQUEST,
                    null, "FE002000", request
            );
        }

        try {
            feedRepo.save(feed);
        } catch (Exception e) {
            strExceptionArr[1] = "save(Feed feed, HttpServletRequest request) --- LINE 59 \n"+ RequestCapture.allRequest(request);
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
    public ResponseEntity<Object> update(Long id, Feed feed, HttpServletRequest request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> saveBatch(List<Feed> lt, HttpServletRequest request) {
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
        List<Feed> listFeed;
        try{
            listFeed = feedRepo.findAll();
            if(listFeed.size()==0){
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
                listFeed,//object
                null,//errorCode diisi null ketika data berhasil disimpan
                request
        );
    }

    @Override
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request) {
        return null;
    }
}