package wit.project.player;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private int id;
    private String name;
    private String lastname;
    private String initials;
    @Transient
    private int age;
    private LocalDate dob;
    private double height;
    private int number;
    private String country;
    private String club;
    private String position;
    private String foot;
    private int trophies;
    private int matches;
    private int goals;
    private int assists;
    private int yellowcards;
    private int redcards;

    public Player() {
    }

    public Player(int id,
                  String name,
                  String lastname,
                  String initials,
                  LocalDate dob,
                  double height,
                  int number,
                  String country,
                  String club,
                  String position,
                  String foot,
                  int trophies,
                  int matches,
                  int goals,
                  int assists,
                  int yellowcards,
                  int redcards) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.initials = initials;
        this.dob = dob;
        this.height = height;
        this.number = number;
        this.country = country;
        this.club = club;
        this.position = position;
        this.foot = foot;
        this.trophies = trophies;
        this.matches = matches;
        this.goals = goals;
        this.assists = assists;
        this.yellowcards = yellowcards;
        this.redcards = redcards;
    }

    public Player(String name,
                  String lastname,
                  String initials,
                  LocalDate dob,
                  double height,
                  int number,
                  String country,
                  String club,
                  String position,
                  String foot,
                  int trophies,
                  int matches,
                  int goals,
                  int assists,
                  int yellowcards,
                  int redcards) {
        this.name = name;
        this.lastname = lastname;
        this.initials = initials;
        this.dob = dob;
        this.height = height;
        this.number = number;
        this.country = country;
        this.club = club;
        this.position = position;
        this.foot = foot;
        this.trophies = trophies;
        this.matches = matches;
        this.goals = goals;
        this.assists = assists;
        this.yellowcards = yellowcards;
        this.redcards = redcards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.trophies = matches;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowcards() {
        return yellowcards;
    }

    public void setYellowcards(int yellowcards) {
        this.yellowcards = yellowcards;
    }

    public int getRedcards() {
        return redcards;
    }

    public void setRedcards(int redcards) {
        this.redcards = redcards;
    }

    @Override
    public String toString() {
        return "Player { " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", initials = '" + initials + '\'' +
                ", age = " + age +
                ", dob = " + dob +
                ", height = " + height +
                ", number = " + number +
                ", country = '" + country + '\'' +
                ", club = '" + club + '\'' +
                ", position = '" + position + '\'' +
                ", foot = '" + foot + '\'' +
                ", trophies = " + trophies +
                ", matches = " + matches +
                ", goals = " + goals +
                ", assists = " + assists +
                ", yellowcards = " + yellowcards +
                ", redcards = " + redcards +
                '}';
    }
}
