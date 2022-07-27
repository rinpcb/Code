package vn.com.stanford.je1121.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service ("nguoiDungDao")
public class NguoiDungImpl  implements NguoiDungDao{
    @Override
    public List<NguoiDung> layDanhSach() {
        //Khao bao 1 danh sach
        List<NguoiDung> lstNguoiDung = new ArrayList< NguoiDung>();


        // kết nối vơi db

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction tx = session.beginTransaction();

        TypedQuery<NguoiDung> query = session.createQuery("from NguoiDung", NguoiDung.class);

        //Lấy danh sách

        lstNguoiDung = query.getResultList();

        tx.commit();

        return lstNguoiDung;
    }

    @Override
    public NguoiDung layChiTietTheoMa(Object tenDangNhap) {
        //khai báo 1 đối tượng
        NguoiDung objND = null;
        //kết nối đên db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //lấy đối tượng theo mã
        objND = (NguoiDung) session.get(NguoiDung.class, "" + tenDangNhap);
        tx.commit();

        return objND;
    }

    @Override
    public boolean themMoi(NguoiDung objND) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //thực hiện thêm mới thông tin
        session.save(objND);
        tx.commit();
        return false;
    }

    @Override
    public boolean capNhat(NguoiDung objND) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //thực hiện thêm mới thông tin
        session.update(objND);
        tx.commit();
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        return false;
    }

    @Override
    public NguoiDung layNguoiDungTheoTaiKhoan(String tenDN) {
        //khai bao 1 danh sach
        List<NguoiDung> lstNguoiDung = new ArrayList<NguoiDung>();

        //ket noi den db qua hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //Khởi tạo 1 transaction
        Transaction tx = session.beginTransaction();

        TypedQuery<NguoiDung> query = session.createQuery("from NguoiDung " +
                "where tenDangNhap = :name", NguoiDung.class);
        query.setParameter("name", tenDN);
        //lay danh sach
        lstNguoiDung = query.getResultList();

        tx.commit();

        if (lstNguoiDung != null && lstNguoiDung.size() > 0) {
            return lstNguoiDung.get(0);
        }
        return null;
    }
}
