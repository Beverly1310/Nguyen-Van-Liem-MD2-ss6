package ra.model;

import java.util.Scanner;

public class Singer {
    Scanner scanner = new Scanner(System.in);
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
    }

    ;

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        do {
            System.out.println("Mời nhập tên ca sĩ");
            this.singerName = scanner.nextLine();
            if (this.singerName.isBlank()) {
                System.out.println("Tên ca sĩ không được để trống");
            } else {
                break;
            }
            ;
        }
        while (true);
        do {
            System.out.println("Mời nhập tuổi của ca sĩ");
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age < 0) {
                System.out.println("Tuổi phải lớn hơn 0");
            } else {
                break;
            }
            ;
        }
        while (true);
        do {
            System.out.println("Mời nhập quốc tịch ca sĩ");
            this.nationality = scanner.nextLine();
            if (this.nationality.isBlank()) {
                System.out.println("Quốc tich ca sĩ không được để trống");
            } else {
                break;
            }
            ;
        }
        while (true);
        System.out.println("Mời nhập giới tính ca sĩ(true/false)");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        do {
            System.out.println("Mời nhập thể loại");
            this.genre = scanner.nextLine();
            if (this.genre.isBlank()) {
                System.out.println("Thể  không được để trống");
            } else {
                break;
            }
            ;
        }
        while (true);
    }

    public void displayData() {
        System.out.println("Mã ca sĩ: " + this.singerId +
                "\nHọ và tên: " + this.singerName +
                "\nTuổi: " + this.age +
                "\nQuốc tich: " + this.nationality +
                "\nGiới tính: " + this.gender +
                "\nThể loại: " + this.genre +
                "\n----------------------------------------");
    }

    public static Singer[] singerArr = new Singer[50];
}
