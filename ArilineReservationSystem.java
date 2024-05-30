/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arilinereservationsystem;
import java.util.Scanner;
/**
 *
 * @author Shoaib Ahmed Bullo <your.name at your.org>
 */

public class ArilineReservationSystem {

    public static void main(String[] args) {
        boolean[] seats = new boolean[10];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu and get user input
            System.out.println("Please type 1 for First Class");
            System.out.println("Please type 2 for Economy");
            int choice = scanner.nextInt();

            // Check seat availability and assign seat
            boolean seatAssigned = false;
            if (choice == 1) {
                seatAssigned = assignSeat(seats, 0, 4);
            } else if (choice == 2) {
                seatAssigned = assignSeat(seats, 5, 9);
            }

            // Handle full sections
            if (!seatAssigned) {
                if (choice == 1) {
                    System.out.println("First Class is full. Would you like to be placed in Economy? (yes/no)");
                } else {
                    System.out.println("Economy is full. Would you like to be placed in First Class? (yes/no)");
                }
                String response = scanner.next();
                if (response.equalsIgnoreCase("yes")) {
                    seatAssigned = (choice == 1) ? assignSeat(seats, 5, 9) : assignSeat(seats, 0, 4);
                }
            }
            if (!seatAssigned) {
                System.out.println("Next flight leaves in 3 hours.");
            }

            // Repeat process or exit
            System.out.println("Do you want to book another seat? (yes/no)");
            String continueBooking = scanner.next();
            if (continueBooking.equalsIgnoreCase("no")) {
                break;
            }
        }
        scanner.close();
    }

    public static boolean assignSeat(boolean[] seats, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                displayBoardingPass(i);
                return true;
            }
        }
        return false;
    }

    public static void displayBoardingPass(int seatNumber) {
        String section = (seatNumber < 5) ? "First Class" : "Economy";
        System.out.println("Boarding Pass: Seat Number " + (seatNumber + 1) + " in " + section);
    }
}
