package vn.com.stanford.je1121.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service("chuDeDao")
public class ChuDeImpl implements ChuDeDao {
    @Override
    public List<ChuDe> layDanhSach()
    {
        //khai báo 1 danh sách
        List<ChuDe> lstCD = new ArrayList<ChuDe>();

        //kết nối đến db qua Hibernate
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        //khởi tạo 1 transaction
        Transaction tx  =session.beginTransaction();

        TypedQuery<ChuDe> query = session.createQuery("from ChuDe", ChuDe.class);

        //lấy danh sách
        lstCD = query.getResultList();

        tx.commit();

        return lstCD;
    }

    @Override
    public ChuDe layChiTietTheoMa(Object id) {
       //khai báo 1 đối tượng
        ChuDe objCD = null;
        //kết nối đên db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //lấy đối tượng theo mã
        objCD = (ChuDe)session.get(ChuDe.class, "" + id);
        tx.commit();
        return objCD;
    }

    @Override
    public boolean themMoi(ChuDe objCD) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //thực hiện thêm mới thông tin
        session.save(objCD);
        tx.commit();
        return false;
    }


    @Override
    public boolean capNhat(ChuDe objCD) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //thực hiện cập nhật thông tin
        session.update(objCD);
        tx.commit();
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        //kết nối đến db
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //lấy thông tin cần xóa
        ChuDe objCD = (ChuDe) session.get(ChuDe.class, ""+ id);
        if (objCD !=null)
        {
            //thực hiện xóa
            session.delete(objCD);
            tx.commit();
            return true;
        }
        return false;
    }
}
