package vn.com.stanford.je1121.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

@Service("sachDao")
public class SachImpl implements SachDao {

    @Override
    public List<Sach> layDanhSach() {
        List<Sach> lstSach = new ArrayList<Sach>();

        //kết nối đến db qua Hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //khởi tạo 1 transaction
        Transaction tx  =session.beginTransaction();

        TypedQuery<Sach> query = session.createQuery("from Sach", Sach.class);

        //lấy danh sách
        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }

    @Override
    public Sach layChiTietTheoMa(Object maSach) {
        //khai báo 1 đối tượng
        Sach objSach = null;
        //kết nối đên db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //lấy đối tượng theo mã
        objSach = (Sach)session.get(Sach.class, "" + maSach);
        tx.commit();

        return objSach;
    }

    @Override
    public boolean themMoi(Sach objSach) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //thực hiện thêm mới thông tin
        session.save(objSach);
        tx.commit();

        return false;
    }

    @Override
    public boolean capNhat(Sach objSach) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //thực hiện cập nhật thông tin
        session.update(objSach);
        tx.commit();
        return false;
    }

    @Override
    public boolean xoa(Object maSach) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //lấy thông tin cần xóa
        Sach objSach = (Sach) session.get(Sach.class, ""+ maSach);
        if (objSach !=null)
        {
            //thực hiện xóa
            session.delete(objSach);
            tx.commit();
            return true;
        }
        return false;
    }

    @Override
    public List<Sach> laySachTheoChuDe(String maChuDe)
    {
        // Khai báo 1 danh sách
        List<Sach> lstSach = new ArrayList();

        //kết nối đến db qua Hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //khởi tạo 1 transaction
        Transaction tx  =session.beginTransaction();

        TypedQuery<Sach> query = session.createNativeQuery("select * from Sachs where MaChuDe = :name", Sach.class);
        query.setParameter("name", maChuDe);
        //lấy danh sách
        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }
    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maChuDe) {
        // Khai báo 1 danh sách
        List<Sach> lstSach = new ArrayList();

        //Kết nối đến db qua hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //Khởi tạo 1 transaction
        Transaction tx = session.beginTransaction();

        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from Sach where 1=1";

        if(!tuKhoa.isEmpty())
        {
            strSQL += " AND (MaSach like '%" + tuKhoa + "%' OR TenSach like '%" +
                    tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%')";
        }

        if(!maChuDe.isEmpty())
        {
            strSQL += " AND MaChuDe = '" + maChuDe + "'";
        }

        TypedQuery<Sach> query = session.createNativeQuery(strSQL,
                Sach.class);

        //Lấy danh sách
        lstSach = query.getResultList();

        tx.commit();

        return lstSach;
    }
}
