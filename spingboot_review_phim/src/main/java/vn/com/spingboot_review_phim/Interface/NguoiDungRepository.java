package vn.com.spingboot_review_phim.Interface;

import org.springframework.data.repository.CrudRepository;
import vn.com.spingboot_review_phim.Model.NguoiDung;

import java.util.List;

public interface NguoiDungRepository extends CrudRepository<NguoiDung, Integer> {
//    @Query("SELECT u FROM NguoiDungEntity u WHERE u.tenDangNhap LIKE :tuKhoa"
//            + " OR u.dienThoai LIKE :tuKhoa OR u.hoTen LIKE :tuKhoa OR u.vaiTro = :idVaiTro")
//    List<NguoiDungEntity> timKiemNguoiDung(@Param("tuKhoa") String tuKhoa, @Param("idVaiTro") Integer idVaiTro);

    List<NguoiDung> findByTenDangNhap(String tenDangNhap);
}
