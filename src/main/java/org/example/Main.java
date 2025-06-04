package org.example;

import org.example.dao.ProductDAO;
import org.example.entity.Product;
import org.example.util.SessionFactorySingleton;
import org.hibernate.Session;

import javax.management.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO(SessionFactorySingleton.getSession());

        Product product = Product.builder().brand("apple").reference("iphone").puchaseDate(LocalDate.now()).price(999.99).stock(12).build();
        Product product1 = Product.builder().brand("Microsoft").reference("nokia").puchaseDate(LocalDate.now()).price(999.99).stock(2).build();
        Product product2= Product.builder().brand("Samsung").reference("S31").puchaseDate(LocalDate.now()).price(999.99).stock(15).build();
        Product product3 = Product.builder().brand("Xbox").reference("serie X").puchaseDate(LocalDate.now()).price(999.99).stock(9).build();
        Product product4 = Product.builder().brand("Sony").reference("ps5").puchaseDate(LocalDate.now()).price(999.99).stock(3).build();
        productDAO.save(product);
        productDAO.save(product1);
        productDAO.save(product2);
        productDAO.save(product3);
        productDAO.save(product4);

//        System.out.println("tout les products");
//        System.out.println(productDAO.get());
//
//        System.out.println("product 2");
//        productDAO.get(2);
//        System.out.println(productDAO.get(2));
//
//        System.out.println("suppression du product id - 3");
//        productDAO.delete(productDAO.get(3));
//
//        System.out.println(productDAO.get());
//
//        System.out.println("modif product id - 1");
//
//
//        productDAO.get(1).setBrand("New brand");
//
//        productDAO.update(productDAO.get(1));
//        System.out.println(productDAO.get(1));

        Product product5 = Product.builder().brand("logitech").reference("Lg1230").puchaseDate(LocalDate.of(2020,5,1)).price(49).stock(2).build();
        Product product6 = Product.builder().brand("phillips").reference("p12536").puchaseDate(LocalDate.of(2010, 6 ,9)).price(99).stock(4).build();

        productDAO.save(product5);
        productDAO.save(product6);
        System.out.println("tout les products");
        System.out.println(productDAO.get());


        System.out.println("tout les products a - de 100€");
        System.out.println(productDAO.get100());

       // System.out.println("tout les products entre now et 2010");
        //System.out.println(productDAO.getDate());

// p1 Q1
//        System.out.println("choix des dates entre les quelles trouver les articles");

        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Entrez la date de début (YYYY-MM-DD) : ");
//        String startDateStr = scanner.nextLine();
//
//        System.out.print("Entrez la date de fin (YYYY-MM-DD) : ");
//        String endDateStr = scanner.nextLine();
//        LocalDate startDate = LocalDate.parse(startDateStr);
//        LocalDate endDate = LocalDate.parse(endDateStr);
//
//        System.out.println(productDAO.getDate(startDate,endDate));

        // p2 q2

//System.out.println("trouver les produits dont le stock est inférieur à X ");
//int stock = scanner.nextInt();
//        System.out.println(productDAO.getrefWhenStock(stock));
//        List<Product> products = productDAO.getrefWhenStock(stock);
//        for (Product p : products) {
//            System.out.println("Produit ID : " + p.getId() +
//                    ", Référence : " + p.getReference());
//        }

        // p2 Q1
//        System.out.println("\n trouver les produits dont la marque est ##### ");
//        System.out.println("Entrez la marque : ");
//        String brand = scanner.nextLine();
//        //System.out.println(productDAO.getBrand(brand));
//        List<Product> products1 = productDAO.getBrand(brand);
//            for (Product p : products1) {
//                System.out.println("Produit ID : " + p.getId() +
//                        ", Référence : " + p.getReference() +
//                        ", Stock : " + p.getStock());
//            }


// p2 q2 -- pas réussi
double totalPrice;
int nbePduit;

        System.out.println("connaitre le prix moyen de tout les produits");
        List<Product> productsAll = productDAO.get();
        for (Product p : productsAll) {


        }


        // p2 q3

        System.out.println("\n trouver les produits d'une marque choisie ");
            System.out.println("Entrez la marque : ");
            String brand1 = scanner.nextLine();
            List<Product> products2 = productDAO.getBrand(brand1);
        System.out.println(products2);


        // p2 Q4
        System.out.println("\n supprimer les produits d'une marque choisie ");
        System.out.println("Entrez la marque : ");
        String brand2 = scanner.nextLine();
        productDAO.DeleteBrand(brand2);





    }



}