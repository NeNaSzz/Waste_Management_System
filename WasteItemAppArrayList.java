import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class WasteItemAppArrayList {

    // ni function utk masukkan dalam class lepastu masukkan dalam subclass masing ii
    public static WasteItem createWasteItem(String userID, String userName, String itemName, String category, double weight) {
        if (category.equalsIgnoreCase("Recyclable")) {
            return new RecyclableWasteItem(userID, userName, itemName, weight);
        } else if (category.equalsIgnoreCase("Organic")) {
            return new OrganicWasteItem(userID, userName, itemName, weight);
        } else {
            return new GeneralWasteItem(userID, userName, itemName, weight);
        }
    }

    // ni function untuk print row dengan column dia 
    public static void printTable(ArrayList<WasteItem> list) {
        System.out.printf("%-5s%-12s%-15s%-15s%-12s%-12s%-10s%n", //printf = formatted string , format specifier(%),left align(-),5(lebar dia),String(s) ,endline(
                "No.", "User ID", "User Name", "Item Name", "Category", "Weight(kg)", "Price(RM)");
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-5d%s%n", (i + 1), list.get(i).toString()); // ni ambik tostring tiap data dalam list
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    // ni function untuk print kalau 1 row je
    public static void printTable(WasteItem item) {
        ArrayList<WasteItem> single = new ArrayList<>();
        single.add(item);
        printTable(single);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        ArrayList<WasteItem> wasteList = new ArrayList<>(); // utk list semua
        DecimalFormat df = new DecimalFormat("0.00");
        WasteItem waste;
        int choice = 0;

        do {
            System.out.println("\n===== WASTE MANAGEMENT SYSTEM (ARRAYLIST) =====");
            System.out.println("1. Add New User ");
            System.out.println("2. Search User by UserID ");
            System.out.println("3. Update user by UserID ");
            System.out.println("4. Delete User by UserID ");
            System.out.println("5. Total Price Waste Item");
            System.out.println("6. View All / View by Category");
            System.out.println("7. Exit");
            System.out.println("================================================");
            System.out.print("\nEnter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                String userID;
                boolean idExists;
                do {
                    idExists = false;
                    System.out.print("\nEnter New UserID: ");
                    userID = input.nextLine();
                    //ni utk check data tu dah ada ke belum
                    for (int i = 0; i < wasteList.size(); i++) {
                        if (wasteList.get(i).getUserID().equalsIgnoreCase(userID)) {
                            System.out.println("ID already exists !!!");
                            idExists = true;
                            break;
                        }
                    }
                } while (idExists);

                System.out.print("Enter User Name: ");
                String userName = input.nextLine();

                System.out.print("Enter Item Name: ");
                String itemName = input.nextLine();

                String category;
                while (true) {
                    System.out.print("Enter Category (General/Recyclable/Organic): ");
                    category = input.nextLine();
                    if (category.equalsIgnoreCase("General") ||
                        category.equalsIgnoreCase("Recyclable") ||
                        category.equalsIgnoreCase("Organic")) {
                        break;
                    } else {
                        System.out.println("Category doesn't exist !!!");
                    }
                }

                System.out.print("Enter Item Weight (kg): ");
                double weight = input.nextDouble();
                input.nextLine();

                waste = createWasteItem(userID, userName, itemName, category, weight);
                wasteList.add(waste); 
                System.out.println("\nUser you just add : ");
                printTable(waste);
            }
            else if (choice == 2) {

                int found = -1;
                System.out.print("\nEnter UserID to search: ");
                String searchID = input.nextLine();

                for (int i = 0; i < wasteList.size(); i++) {
                    if (wasteList.get(i).getUserID().equalsIgnoreCase(searchID)) {
                        found = i;
                        printTable(wasteList.get(i));
                        break;
                    }
                }
                if (found == -1)
                    System.out.println("\nUserID is not found");
            }
            else if (choice == 3) {

                System.out.print("\nEnter UserID to make an update: ");
                String updateID = input.nextLine();
                int found1 = -1;

                for (int i = 0; i < wasteList.size(); i++) {
                    if (wasteList.get(i).getUserID().equalsIgnoreCase(updateID)) {
                        found1 = i;
                        System.out.println("\n===== Enter type of update you want to make to user=====");
                        System.out.println("1. Update Name");
                        System.out.println("2. Update Item Name");
                        System.out.println("3. Update Item Category");
                        System.out.println("4. Update Item Weight");
                        System.out.println("5. Update all");
                        int updatechoice = input.nextInt();
                        input.nextLine();

                        if (updatechoice == 1) {
                            System.out.print("Enter new User Name: ");
                            wasteList.get(i).setUserName(input.nextLine());
                        }
                        else if (updatechoice == 2) {
                            System.out.print("Enter new Item Name: ");
                            wasteList.get(i).setItemName(input.nextLine());
                        }
                        else if (updatechoice == 3) {
                            String Ncategory = "";
                            while (true) {
                                System.out.print("Enter New Category (General/Recyclable/Organic): ");
                                Ncategory = input.nextLine();
                                if (Ncategory.equalsIgnoreCase("General") ||
                                    Ncategory.equalsIgnoreCase("Recyclable") ||
                                    Ncategory.equalsIgnoreCase("Organic")) {
                                    break;
                                } else {
                                    System.out.println("Category doesn't exist !!!");
                                }
                            }
                        
                            WasteItem old = wasteList.get(i);
                            WasteItem updated = createWasteItem(old.getUserID(), old.getUserName(),
                                                                old.getItemName(), Ncategory, old.getWeight());
                            wasteList.set(i, updated);
                        }
                        else if (updatechoice == 4) {
                            System.out.print("Enter new Item Weight (kg): ");
                            wasteList.get(i).setWeight(input.nextDouble());
                            input.nextLine();
                        }
                        else if (updatechoice == 5) {
                            System.out.print("Enter new User Name: ");
                            wasteList.get(i).setUserName(input.nextLine());

                            System.out.print("Enter new Item Name: ");
                            wasteList.get(i).setItemName(input.nextLine());

                            System.out.print("Enter new Item Weight (kg): ");
                            wasteList.get(i).setWeight(input.nextDouble());
                            input.nextLine();
                        }
                        else {
                            System.out.println("Invalid choice. Returning to Main Menu.");
                            break;
                        }

                        System.out.println("\nItem you just updated : ");
                        printTable(wasteList.get(i));
                        break;
                    }
                }
                if (found1 == -1)
                    System.out.println("\nUser is not found");
            }
            else if (choice == 4) {

                System.out.print("\nEnter UserID to delete: ");
                String deleteID = input.nextLine();
                int found2 = -1;

                for (int i = 0; i < wasteList.size(); i++) {
                    if (wasteList.get(i).getUserID().equalsIgnoreCase(deleteID)) {
                        found2 = i;
                        wasteList.remove(i);
                        System.out.println("\nUser Record Deleted Successfully.");
                        break;
                    }
                }
                if (found2 == -1)
                    System.out.println("\nUser not found");
            }
            else if (choice == 5) {
                double totPriceG = 0, totPriceR = 0, totPriceO = 0, totPrice = 0;
                for (int i = 0; i < wasteList.size(); i++) {
                    waste = wasteList.get(i);
                    if (waste.getCategory().equalsIgnoreCase("General")) {
                        totPriceG += waste.determinePrice();
                    } else if (waste.getCategory().equalsIgnoreCase("Recyclable")) {
                        totPriceR += waste.determinePrice();
                    } else if (waste.getCategory().equalsIgnoreCase("Organic")) {
                        totPriceO += waste.determinePrice();
                    }
                }
                totPrice = totPriceG + totPriceR + totPriceO;

                System.out.println("\n========Summary Total Price========");
                System.out.println("Total Price (General)     : RM " + df.format(totPriceG));
                System.out.println("Total Price (Recyclable)  : RM " + df.format(totPriceR));
                System.out.println("Total Price (Organic)     : RM " + df.format(totPriceO));
                System.out.println("-------------------------------------");
                System.out.println("TOTAL PRICE               : RM " + df.format(totPrice));
                System.out.println("-------------------------------------");
            }
            else if (choice == 6) {
                if (wasteList.isEmpty()) {
                    System.out.println("\nNo records found.");
                } else {
                    System.out.println("\n===== VIEW RECORDS =====");
                    System.out.println("1. View All Categories");
                    System.out.println("2. View General Only");
                    System.out.println("3. View Recyclable Only");
                    System.out.println("4. View Organic Only");
                    System.out.print("Enter your choice: ");
                    int viewChoice = input.nextInt();
                    input.nextLine();

                    ArrayList<WasteItem> displayList = new ArrayList<>();
                    String header = "";

                    if (viewChoice == 1) {
                        displayList = wasteList;
                        header = "All Categories";
                    } else if (viewChoice == 2 || viewChoice == 3 || viewChoice == 4) {
                        String targetCategory;
                        if (viewChoice == 2) {
                            targetCategory = "General";
                        } else if (viewChoice == 3) {
                            targetCategory = "Recyclable";
                        } else {
                            targetCategory = "Organic";
                        }
                        for (int i = 0; i < wasteList.size(); i++) {
                            if (wasteList.get(i).getCategory().equalsIgnoreCase(targetCategory)) {
                                displayList.add(wasteList.get(i));
                            }
                        }
                        header = targetCategory.toUpperCase() + " Category";
                    } else {
                        System.out.println("Invalid choice. Returning to Main Menu.");
                    }

                    if (viewChoice >= 1 && viewChoice <= 4) {
                        if (displayList.isEmpty()) {
                            System.out.println("\nNo records found for this selection.");
                        } else {
                            System.out.println("\n========== " + header + " (" + displayList.size() + " record(s)) ==========");
                            printTable(displayList);
                        }
                    }
                }
            }
            else if (choice == 7) {
                System.out.println("\n==================================");
                System.out.println(" Thank you for using  waste management  system ");
                System.out.println("==================================");
            } else {
                System.out.println("Invalid Choice. Please try again.");
            }

        } while (choice != 7);
    }
}