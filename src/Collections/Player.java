package Collections;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double salary;
    private double price;
    private boolean sellStatus;

    public Player() {
        this.sellStatus = false;
    }

    public Player(String name, String country, int age, double height, String club, String position, int number, double salary) {
        this.name = name;
        this.country = country;
        this.club = club;
        this.age = age;
        this.height = height;
        this.position = position;
        this.number = number;
        this.salary = salary;
        this.sellStatus = false;
    }


    //Getters and Setters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public double getSalary() {
        return salary;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(boolean sellStatus) {
        this.sellStatus = sellStatus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Display Information
    public void display() {
        System.out.println("Name: " + name + "\n" +
                "Country: " + country + "\n" +
                "Age in years: " + age + "\n" +
                "Height in meters: " + height + "\n" +
                "Club: " + club + "\n" +
                "Position: " + position + "\n" +
                "Number: " + number
        );
        System.out.printf("Weekly salary: %f $\n\n", salary);
    }

}