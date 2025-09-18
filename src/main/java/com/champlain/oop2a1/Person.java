package com.champlain.oop2a1;

import java.time.LocalDate;

/**
 * Represents a person with basic information and parking pass functionality.
 * This class stores a person's name, date of birth, email address, and tracks
 * whether they have purchased a parking pass.
 */
public class Person {
    /** The person's full name. */
    private final String name;

    /** The person's date of birth. */
    private final LocalDate dateOfBirth;

    /** The person's email address. */
    private final String emailAddress;

    /** Whether the person has purchased a parking pass. */
    private boolean hasParkingPass;

    /**
     * Constructs a new Person with the specified information.
     *
     * @param name The person's name (cannot be null or empty)
     * @param dateOfBirth The person's date of birth (cannot be null or in the future)
     * @param emailAddress The person's email address (cannot be null or empty, must contain @)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Person(String name, LocalDate dateOfBirth, String emailAddress) {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateEmailAddress(emailAddress);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.hasParkingPass = false; // Initially no parking pass
    }

    /**
     * Gets the person's name.
     *
     * @return The person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the person's date of birth.
     *
     * @return The person's date of birth
     */
    public LocalDate getDOB() {
        return dateOfBirth;
    }

    /**
     * Gets the person's email address.
     *
     * @return The person's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Checks if the person has purchased a parking pass.
     *
     * @return true if the person has a parking pass, false otherwise
     */
    public boolean isPurchasedParkingPass() {
        return hasParkingPass;
    }

    /**
     * Attempts to purchase a parking pass for this person.
     *
     * @return true if the purchase was successful, false if the person already had a pass
     */
    public boolean purchaseParkingPass() {
        if (hasParkingPass) {
            return false; // Already has a pass
        }
        hasParkingPass = true;
        return true; // Purchase successful
    }

    /**
     * Validates that the name is not null, empty, or contains only whitespace.
     *
     * @param name The name to validate
     * @throws IllegalArgumentException if the name is null, empty, or whitespace only
     */
    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or contain only whitespace");
        }
    }

    /**
     * Validates that the date of birth is not null and not in the future.
     *
     * @param dateOfBirth The date of birth to validate
     * @throws IllegalArgumentException if the date is null or in the future
     */
    private void validateDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
    }

    /**
     * Validates that the email address is not null, not empty, and contains an @ symbol.
     *
     * @param emailAddress The email address to validate
     * @throws IllegalArgumentException if the email is null, empty, or invalid format
     */
    private void validateEmailAddress(String emailAddress) {
        if (emailAddress == null) {
            throw new IllegalArgumentException("Email address cannot be null");
        }
        if (emailAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Email address cannot be empty or contain only whitespace");
        }
        if (!emailAddress.contains("@")) {
            throw new IllegalArgumentException("Email address must contain @ symbol");
        }
    }

    /**
     * Returns a string representation of this person.
     *
     * @return A string containing the person's name, date of birth, email, and parking pass status
     */
    @Override
    public String toString() {
        return String.format("Person{name='%s', dateOfBirth=%s, emailAddress='%s', hasParkingPass=%s}",
                name, dateOfBirth, emailAddress, hasParkingPass);
    }
}