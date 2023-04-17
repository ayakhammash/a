import java.util.Scanner;
import java.util.ArrayList;

class Customer {
    private String name;
    private String phone;
    private String address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Product {
    private String name;
    private String picture;
    private String description;
    private boolean specialTreatmentRequired;

    public Product(String name, String picture, String description, boolean specialTreatmentRequired) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.specialTreatmentRequired = specialTreatmentRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSpecialTreatmentRequired() {
        return specialTreatmentRequired;
    }

    public void setSpecialTreatmentRequired(boolean specialTreatmentRequired) {
        this.specialTreatmentRequired = specialTreatmentRequired;
    }
}

public class DeleteFeature {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();


        customers.add(new Customer());
        customers.add(new Customer());
        products.add(new Product());
        products.add(new Product());


        System.out.println("Which feature do you want to delete? (1) Customer, (2) Product");
        int featureChoice = scanner.nextInt();
        scanner.nextLine();

        if (featureChoice == 1) {
            System.out.println("Which customer do you want to delete? (Enter the customer's name)");
            String customerName = scanner.nextLine();


            for (Customer customer : customers) {
                if (customer.getName().equals(customerName)) {
                    customers.remove(customer);
                    System.out.println("Customer is deleted.");
                    break;
                }
            }
        } else if (featureChoice == 2) {
            System.out.println("Which product do you want to delete? (Enter the product's name)");
            String productName = scanner.nextLine();


            for (Product product : products) {
                if (product.getName().equals(productName)) {
                    products.remove(product);
                    System.out.println("Product is deleted.");
                    break;
                }
            }
        } else
