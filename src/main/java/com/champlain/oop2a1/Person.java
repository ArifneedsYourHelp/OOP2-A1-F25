package com.champlain.oop2a1;

import java.time.LocalDate;
    public class Person {

        private String name;


        private LocalDate dateOfBirth;


        private String emailAddress;


        private boolean hasParkingPass;


        public Person(String name, LocalDate dateOfBirth, String emailAddress) {
            validateName(name);
            validateDateOfBirth(dateOfBirth);
            validateEmailAddress(emailAddress);

            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.emailAddress = emailAddress;
            this.hasParkingPass = false;
        }


        public String getName() {
            return name;
        }


        public LocalDate getDOB() {
            return dateOfBirth;
        }


        public String getEmailAddress() {
            return emailAddress;
        }


        public boolean isPurchasedParkingPass() {
            return hasParkingPass;
        }


        public boolean purchaseParkingPass() {
            if (hasParkingPass) {
                return false; // Already has a pass
            }
            hasParkingPass = true;
            return true; // Purchase successful
        }


        private void validateName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
        }


        private void validateDateOfBirth(LocalDate dateOfBirth) {
            if (dateOfBirth == null) {
                throw new IllegalArgumentException("Date of birth cannot be null");
            }
            if (dateOfBirth.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }
        }


        private void validateEmailAddress(String emailAddress) {
            if (emailAddress == null || emailAddress.trim().isEmpty()) {
                throw new IllegalArgumentException("Email address cannot be null or empty");
            }
            if (!emailAddress.contains("@")) {
                throw new IllegalArgumentException("Email address must contain @ symbol");
            }
        }


        @Override
        public String toString() {
            return String.format("Person{name='%s', dateOfBirth=%s, emailAddress='%s', hasParkingPass=%s}",
                    name, dateOfBirth, emailAddress, hasParkingPass);
        }
    }
