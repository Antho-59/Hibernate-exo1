package org.example.dao;

import org.example.entity.Product;
import org.hibernate.Session;

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
        return session.createQuery("select p from Product p where puchaseDate BETWEEN :start AND :end",Product.class).getResultList();
        LocalDate start = LocalDate.of(2019 , 1 , 1);
        LocalDate end = LocalDate.now();
    }

}
