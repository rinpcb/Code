package vn.com.stanford.je1121.model;


import java.util.List;
import java.util.Set;

public class HibernateTest {
    public static void main(String arg[])
    {
//        ChuDeDao chuDeDao = new ChuDeImpl();
//        //lấy chủ đề có Mã TH
//        ChuDe objCD = chuDeDao.layChiTietTheoMa("TH");
//        //lấy tất cả danh sách có chủ đề tin học
//        Set <Sach> lstSachByCD = objCD.getSachs();M
//        System.out.println("Danh sách thông tin sách ");
//        for (Sach objSach : lstSachByCD)
//        {
//            System.out.println(objSach.getMaSach()+ "\t" + objSach.getTenSach()+ "\t"+ objSach.getChuDe().getMaChuDe());
//        }
        NguoiDungDao nguoiDungDao = new NguoiDungImpl();

        List<NguoiDung> lstNguoiDung = nguoiDungDao.layDanhSach();

        System.out.println("Danh sách thông tin người dùng");

        for(NguoiDung objUser : lstNguoiDung)
        {
            System.out.println(objUser.getId() + "\t" + objUser.getTenDangNhap() + "\t" + objUser.getHoTen());
        }
    }
}
