package org.example;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_table")
public class Customer {
    @Id
    @Column(name = "customer_id", length = 80)
    private String id;

    @Column(name = "customer_name", length = 50)
    private String name;

    private String address;

    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Customer() {}

    public Customer(String id, String name, String address, double salary, Vehicle vehicle, List<Orders> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.vehicle = vehicle;
        this.orders = orders;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", vehicle=" + vehicle +
                '}';
    }
}
