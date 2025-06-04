package org.example.dao;

import com.google.protobuf.compiler.PluginProtos;
import org.example.entity.Product;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ProductDAO {

    private Session session;

    public ProductDAO(Session session) {
        this.session = session;
    }

    public Product save(Product product) {
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }

    public Product update(Product product) {
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        return product;
    }

    public Product delete(Product product) {
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        return product;
    }

    public Product get(int id) {
        return session.get(Product.class, id);
    }

    public List<Product> get() {
        return session.createQuery("select p from Product p",Product.class).getResultList();

    }
    public List<Product> get100() {
        return session.createQuery("select p from Product p where price < 100",Product.class).getResultList();
    }
    public List<Product> getDate(LocalDate start , LocalDate end) {
       TypedQuery<Product> query = session.createQuery("select p from Product p where puchaseDate BETWEEN :start AND :end",Product.class);
        query.setParameter("start", start);
       query.setParameter("end", end);
        return query.getResultList();
    }


    public List<Product> getrefWhenStock(int stockNeeded) {
        TypedQuery<Product> query = session.createQuery("select p from Product p where  stock < :stockNeeded",Product.class);
        query.setParameter("stockNeeded", stockNeeded);
        return query.getResultList();
    }

    public List<Product> getBrand(String brand) {
        TypedQuery<Product> query = session.createQuery("select p from Product p where  brand = :brand",Product.class);
        query.setParameter("brand", brand);
        return query.getResultList();

    }

    public  List<Product> DeleteBrand(String brand) {
        TypedQuery<Product> query = session.createQuery("delete from Product p where  brand = :brand",Product.class);
        query.setParameter("brand", brand);
        return query.getResultList();

    }


}
