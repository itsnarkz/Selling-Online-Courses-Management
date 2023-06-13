package sellingonlinecoursesmanagement;

import sellingonlinecoursesmanagement.App.App;

public class SellingOnlineCoursesManagement {
    public static void main(String[] args) {
        App app = new App();
        
        app.displayInfo();
        while(true) {
            app.displayMenu();
            int choice = app.getChoice();
        
            switch(choice) {
                case 1: //Log in
                    int role = app.Login();
                
                    if(role == 1) app.runAdmin();
                    if(role == 2) app.runManager();
                    if(role == 3) app.runEmployee();
                    if(role == 4) app.runCustomer();
                case 2: //Sign up
                    app.Signup();
                case 0: //Exit
                    System.exit(0);
            }
        }
        
    }
    
}
