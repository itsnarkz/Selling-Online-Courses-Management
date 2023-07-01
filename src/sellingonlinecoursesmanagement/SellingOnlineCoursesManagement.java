package sellingonlinecoursesmanagement;

import sellingonlinecoursesmanagement.App.App;

public class SellingOnlineCoursesManagement {
    public static void main(String[] args) {
        App app = new App();

        app.displayInfo();
        while(true) {
            app.displayMenu();
            int choice = app.getChoice(1, 3);

            switch(choice) {
                case 1: //Log in
                    int role = app.Login();
                    if(role == -1) break;

                    if(role == 1) app.runAdmin();
                    if(role == 2) app.runCustomer();
                    System.out.println();
                    break;
                case 2: //Sign up
                    app.Signup();
                    break;
                case 3: //Exit
                    System.out.println("Have a nice day! Thank you for shopping!");
                    System.exit(0);
            }
        }
    }
    
}
