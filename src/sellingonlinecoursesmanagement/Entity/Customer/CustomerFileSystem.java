    package sellingonlinecoursesmanagement.Entity.Person.Customer;

    import sellingonlinecoursesmanagement.Entity.Course.Course;
    import sellingonlinecoursesmanagement.Entity.Course.CourseList;

    import java.io.*;
    import java.util.List;
    public class CustomerFileSystem {
        private static final String FILE_PATH1 = "customer.txt";

        private CustomerList customerList;

        public CustomerFileSystem() {
            this.customerList = new CustomerList();
            loadCustomer();
        }

        public void loadCustomer() {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH1))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    String id = parts[0];
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String gender = parts[3];
                    String phoneNumber = parts[4];
                    String email = parts[5];


                    customerList.createCustomer(id, name, age, gender, phoneNumber, email);
                }
            } catch (IOException e) {
                System.out.println("Error loading customer from file: " + e.getMessage());
            }
        }

        private void saveCustomer() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH1))) {
                List<Customer> list = customerList.listAllCustomer();
                for(Customer customer : list) {
                    writer.write(customer.getId() + ":" + customer.getName() + ":"
                            + customer.getAge() + ":" + customer.getGender() + ":" + customer.getPhoneNumber()
                            + ":" + customer.getEmail());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error saving customer to file: " + e.getMessage());
            }
        }

        public CustomerList getAllCustomer() {
            return customerList;
        }


        public void addCustomer(String id, String name, int age, String gender, String phoneNumber, String email) {
            customerList.createCustomer(id, name, age, gender, phoneNumber, email);
            saveCustomer();
        }

        public void deleteCustomer(String id) {
            customerList.deleteCustomer(id);
            saveCustomer();
        }

        public void updateCustomer(String id, String name, int age, String gender, String phoneNumber, String email) {
            customerList.updateCustomer(id, name, age, gender, phoneNumber, email);
            saveCustomer();
        }
    }
