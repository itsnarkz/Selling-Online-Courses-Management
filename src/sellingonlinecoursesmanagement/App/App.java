package sellingonlinecoursesmanagement.App;

public class App {
    private AdminService adminService;
    private ManagerService managerService;
    private EmployeeService employeeService;
    private CustomerService customerService;

    public App() {
        this.adminService = new AdminService();
        this.managerService = new ManagerService();
        this.employeeService = new EmployeeService();
        this.customerService = new CustomerService();
    }

    public void displayInfo() {

    }

    public void displayMenu() {

    }

    public int getChoice() { //must have validation

    }

    public int Login() {
        return 1;
    }

    public void Signup() {

    }

    public void runAdmin() {
        admin.displayMenu();
    }

    public void runManager() {

    }

    public void runEmployee() {

    }

    public void runCustomer() {

    }
}
