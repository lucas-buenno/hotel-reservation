package Application;

import entities2.Reservation;
import exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-In date (dd/mm/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-Out date (dd/mm/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-In date (dd/mm/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-Out date (dd/mm/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf);

            reservation.updatedData(checkIn, checkOut);
            System.out.println();

            System.out.println("Update reservation:");
            System.out.println(reservation);
        }

        catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        catch (InputMismatchException e) {
            System.out.println("The room number is invalid. Please, type again.");
        }

        catch (RuntimeException e) {
            System.out.println("The action cannot be performed at this time. Please try again later.");
        }





    }

}
