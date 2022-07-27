package vn.com.stanford.je1121.model;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * Hàm tạo đối tượng quản lý kết nối trong Hibernate
     * @return
     */
    private static SessionFactory buildSessionFactory()
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        return cfg.buildSessionFactory();
    }

    /**
     * Hàm trả về đối tượng quản lý kết nối với db trong Hibernate
     * @return
     */
    public static  SessionFactory getSessionFactory()
    {
        if (sessionFactory == null)
        {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
