package com.jatiluhur.sisfo.repo;

import com.jatiluhur.sisfo.model.Kip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface KipRepo extends JpaRepository<Kip, Long>{
    public Page<Kip> findByNikContains(Pageable p, String val);
//    public Optional<Kip> findByNik(String nik);
//    public Optional<Kip> deleteByNik(String nik);

}
