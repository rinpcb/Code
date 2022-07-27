package vn.com.spingboot_review_phim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.spingboot_review_phim.Interface.PhimDienVienDao;
import vn.com.spingboot_review_phim.Interface.PhimDienVienRepository;
import vn.com.spingboot_review_phim.Model.PhimDienVien;
import vn.com.spingboot_review_phim.Model.PhimDienVienViewModel;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service("phimDienVienDao")
public class PhimDienVienImpl implements PhimDienVienDao {
    @Autowired
    PhimDienVienRepository phimDienVienRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<PhimDienVienViewModel> getAll() {
        List<PhimDienVienViewModel> lstPhimDienVienView = new ArrayList<>();
        Query query = entityManager
                .createQuery("SELECT p.id,p.vaiDien, pe.tenPhim, dv.hoTen FROM PhimDienVien p "
                        +" INNER JOIN Phim pe ON p.phimId = pe.id"
                        +" INNER JOIN DienVien dv ON p.dienVienId = dv.id");

        List<Object[]> lstObject = query.getResultList();
        for (Object[] r : lstObject) {
            PhimDienVienViewModel objPhimDV = new PhimDienVienViewModel();

            objPhimDV.setId(Integer.parseInt("" + r[0]));
            objPhimDV.setVaiDien("" + r[1]);
            objPhimDV.setTenPhim("" + r[2]);
            objPhimDV.setTenDienVien(""+r[3]);
            lstPhimDienVienView.add(objPhimDV);
        }
        return lstPhimDienVienView;
    }

    @Override
    public List<PhimDienVien> layDanhSach() {
        return (List<PhimDienVien>)phimDienVienRepository.findAll();
    }

    @Override
    public PhimDienVien layChiTietTheoMa(Object id) {
        PhimDienVien objPhimDienVien = null;
        try {
            objPhimDienVien = phimDienVienRepository.findById(Integer.parseInt("" + id)).get();
        } catch (Exception ex) {
            System.out.println("Lỗi không lấy phim diễn viên có id: " + ex.getMessage());
        }
        return objPhimDienVien;
    }

    @Override
    public boolean themMoi(PhimDienVien obj) {
        PhimDienVien objPhimDienVien = phimDienVienRepository.save(obj);
        if (objPhimDienVien != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean capNhat(PhimDienVien obj) {
        PhimDienVien objPhimDienVien = phimDienVienRepository.findById(obj.getId()).get();
        if (objPhimDienVien != null)
        {
            objPhimDienVien.setVaiDien(obj.getVaiDien());
            objPhimDienVien.setPhimId(obj.getPhimId());
            objPhimDienVien.setDienVienId(obj.getDienVienId());

            phimDienVienRepository.save(objPhimDienVien);
            return true;
        }
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        PhimDienVien objPhimDienVien = layChiTietTheoMa(id);

        if (objPhimDienVien != null) {
            phimDienVienRepository.delete(objPhimDienVien);
            return true;
        }
        return false;
    }

    @Override
    public List<PhimDienVien> layPhimDienVienTheoPhimId(Integer phimId) {
        return phimDienVienRepository.layPhimDienVienTheoPhimId(phimId);
    }
}
