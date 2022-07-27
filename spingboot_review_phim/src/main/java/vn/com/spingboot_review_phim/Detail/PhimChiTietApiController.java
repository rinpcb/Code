package vn.com.spingboot_review_phim.Detail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class PhimChiTietApiController {
    @Autowired
    PhimChiTietDao phimChiTietDao;


    @GetMapping("chitietphim/all")
    public ResponseEntity<List<PhimChiTietView>> getAll(){

        List<PhimChiTietView> lstPhimCT = phimChiTietDao.layDanhSach();

        return new  ResponseEntity<List<PhimChiTietView>>(lstPhimCT, HttpStatus.OK);
    }

}
