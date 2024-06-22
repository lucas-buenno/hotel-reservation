package entities;

import exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private static Double dailyValue = 150.00;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now)) {
            throw new DomainException("The check-in date must be later than the current date.");
        }
        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("The check-out date must be later than the check-in date.");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public Double dailyValue() {
        return dailyValue * duration();
    }

    public void updatedData(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now)) {
            throw new DomainException("The check-in date must be later than the current date.");
        }
        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("The check-out date must be later than the check-in date.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String toString(){
        return "Reservation: Room " + roomNumber
                + ", check-In: " + dtf.format(checkIn)
                + ", check-Out: " + dtf.format(checkOut)
                + ", " + duration() + " nights, "
                + "reservation amount: $ " + String.format("%.2f", dailyValue());
    }
}
