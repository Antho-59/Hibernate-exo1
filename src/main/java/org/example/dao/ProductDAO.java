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
    public List<Product> getDate() {
       TypedQuery<Product> query = session.createQuery("select p from Product p where puchaseDate BETWEEN :start AND :end",Product.class);
        query.setParameter("start", LocalDate.of(2010, 1, 1));
       query.setParameter("end", LocalDate.of(2025, 1, 1));
        return query.getResultList();
    }

}
