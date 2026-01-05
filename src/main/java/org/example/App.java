package org.example;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Customer customer = new Customer(UUID.randomUUID().toString(),"Chadith Dissanayaka","Embilipitya",250000);
        CustomerDaoImpl.save(customer);
        System.out.println("Customer saved successfully");
    }
}
