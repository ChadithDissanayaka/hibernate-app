package org.example;
import java.util.List;
import java.util.UUID;

public class App 
{
    public static void main( String[] args ) {
        // ================= CREATE =================
        Customer c1 = new Customer(
                UUID.randomUUID().toString(),
                "Chadith Dissanayaka",
                "Embilipitiya",
                250000
        );

        Customer c2 = new Customer(
                UUID.randomUUID().toString(),
                "Nimal Perera",
                "Colombo",
                180000
        );

        Customer c3 = new Customer(
                UUID.randomUUID().toString(),
                "Kamal Silva",
                "Galle",
                150000
        );

        CustomerDaoImpl.save(c1);
        CustomerDaoImpl.save(c2);
        CustomerDaoImpl.save(c3);

        System.out.println("✔ Customers saved");

        // ================= READ (Get All) =================
        List<Customer> customers = CustomerDaoImpl.getAll();
        System.out.println("\n--- All Customers ---");
        customers.forEach(System.out::println);

        // ================= READ (Find By ID) =================
        String searchId = c1.getId();
        Customer foundCustomer = CustomerDaoImpl.findById(searchId);
        System.out.println("\n--- Found Customer ---");
        System.out.println(foundCustomer);

        // ================= UPDATE =================
        foundCustomer.setSalary(300000);
        foundCustomer.setAddress("Matara");
        CustomerDaoImpl.update(foundCustomer);
        System.out.println("\n✔ Customer updated");

        // Verify update
        Customer updatedCustomer = CustomerDaoImpl.findById(searchId);
        System.out.println(updatedCustomer);

        // ================= DELETE =================
        CustomerDaoImpl.delete(c3.getId());
        System.out.println("\n✔ Customer deleted");

        // Verify delete
        System.out.println("\n--- Customers After Delete ---");
        CustomerDaoImpl.getAll().forEach(System.out::println);
    }
}
