package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Objects;
import java.util.Scanner;

import static ra.model.Singer.singerArr;
import static ra.model.Song.songArr;

public class MusicManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************" +
                    "\n1. Quản lý ca sĩ " +
                    "\n2. Quản lý bài hát " +
                    "\n3. Tìm kiếm bài hát " +
                    "\n4. Thoát " +
                    "\nMời nhập việc cần làm:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                //Quản lý ca sĩ
                case 1:
                    int choice1;
                    do {
                        System.out.println("**********************SINGER-MANAGEMENT*************************" +
                                "\n1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới " +
                                "\n2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ" +
                                "\n3.Thay đổi thông tin ca sĩ theo mã id" +
                                "\n4.Xóa ca sĩ theo mã id " +
                                "\n5.Thoát" +
                                "\nMời nhập việc cần làm: ");
                        choice1 = Integer.parseInt(scanner.nextLine());
                        switch (choice1) {
                            case 1:
                                createSinger();
                                break;
                            case 2:
                                displaySinger();
                                break;
                            case 3:
                                changeInfoSinger();
                                break;
                            case 4:
                                deleteSinger();
                                break;
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    }
                    while (choice1 != 5);
                    break;
                case 2:
                    int choice2;
                    do {
                        System.out.println("**********************SONG-MANAGEMENT*************************" +
                                "\n1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới " +
                                "\n2.Hiển thị danh sách tất cả bài hát đã lưu trữ" +
                                "\n3.Thay đổi thông tin bài hát theo mã id" +
                                "\n4.Xóa bài hát theo mã id" +
                                "\n5.Thoát" +
                                "\nMời nhập việc cần làm");
                        choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
                            case 1:
                                createSong();
                                break;
                            case 2:
                                displaySong();
                                break;
                            case 3:
                                changeInfoSong();
                                break;
                            case 4:
                                deleteSong();
                                break;
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    }
                    while (choice2 != 5);
                    break;
                case 3:
                    int choice3;
                    do {
                        System.out.println("*********************SEARCH-MANAGEMENT************************" +
                                "\n1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại ." +
                                "\n2.Tìm kiếm ca sĩ theo tên hoặc thể loại " +
                                "\n3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần " +
                                "\n4.Hiển thị 10 bài hát được đăng mới nhất " +
                                "\n5.Thoát" +
                                "\nMời nhập việc cần làm");
                        choice3 = Integer.parseInt(scanner.nextLine());
                        switch (choice3) {
                            case 1:
                                searchSong();
                                break;
                            case 2:
                                searchSinger();
                                break;
                            case 3:
                                songDecreasd();
                                break;
                            case 4:
                                displayNewestSong();
                                break;
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    }
                    while (choice3 != 5);
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice != 4);
    }

    static int lengthSinger = 0;

    //Thêm ca sĩ
    public static void createSinger() {
        System.out.println("Nhập vào số lượng ca sĩ muốn thêm:");
        int id = 0;

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            singerArr[lengthSinger] = new Singer();
            singerArr[i].setSingerId(id + 1);
            singerArr[lengthSinger].inputData();
            lengthSinger++;
            id++;
        }
    }

    //Hiển thị danh sách ca sĩ đã luu trữ
    public static void displaySinger() {
        for (int i = 0; i < lengthSinger; i++) {
            singerArr[i].displayData();
        }
    }

    //Thay đổi thông tin ca sĩ theo Id
    public static void changeInfoSinger() {
        int index = -1;
        System.out.println("Nhập ID ca sĩ cần sửa: ");
        int changeId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lengthSinger; i++) {
            if (singerArr[i].getSingerId() == changeId) {
                index = i;
                break;
            }
        }
        if (index != 1) {
            singerArr[index].inputData();
        }
    }

    //xóa ca sĩ theo Id
    public static void deleteSinger() {
        int index = -1;
        boolean check = false;
        System.out.println("Nhập vào Id ca sĩ cần xóa");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lengthSinger; i++) {
            if (singerArr[i].getSingerId() == deleteId) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < lengthSinger; i++) {
            if (Objects.equals(songArr[i].getSinger().getSingerName(), singerArr[index].getSingerName())) {
                System.out.println("Ca sĩ đã có bài hát, không thể xóa");
                check = true;
            }
        }
        if (index != -1 && !check) {
            for (int i = index; i < lengthSinger - 1; i++) {
                singerArr[i] = singerArr[i + 1];
            }
            singerArr[lengthSinger - 1] = null;
            lengthSinger--;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static int lengthSong = 0;

    //Thêm bài hát
    public static void createSong() {
        System.out.println("Nhập vào số lượng bài muốn thêm:");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            songArr[lengthSong] = new Song();
            songArr[lengthSong].songInputData();
            lengthSong++;
        }
    }

    //Hiển thị danh sách bài hát đã luu trữ
    public static void displaySong() {
        for (int i = 0; i < lengthSong; i++) {
            songArr[i].songDisplayData();
        }
    }

    //Thay đổi thông tin bài hát theo Id
    public static void changeInfoSong() {
        int index = -1;
        System.out.println("Nhập ID bài hát cần sửa: ");
        String changeId = scanner.nextLine();
        for (int i = 0; i < lengthSong; i++) {
            if (songArr[i].getSongId().equals(changeId)) {
                index = i;
                break;
            }
        }
        if (index != 1) {
            songArr[index].songInputData();
        }
    }

    //xóa bài hát theo Id
    public static void deleteSong() {
        int index = -1;
        boolean check = false;
        System.out.println("Nhập vào Id bài hát cần xóa");
        String deleteId = scanner.nextLine();
        for (int i = 0; i < lengthSong; i++) {
            if (songArr[i].getSongId() == deleteId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < lengthSong - 1; i++) {
                songArr[i] = songArr[i + 1];
            }
            songArr[lengthSong - 1] = null;
            lengthSong--;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại
    public static void searchSong() {
        System.out.println("Nhập tên ca sĩ hoặc mô tả của bài hát cần tìm");// Không thể tìm theo thể loại do đề bài không cho class Song trường category nên tìm theo mô tả
        String findSong = scanner.nextLine();
        for (int i = 0; i < lengthSong; i++) {
            if (songArr[i].getSinger().getSingerName().equals(findSong) || songArr[i].getDescriptions().contains(findSong)) {
                songArr[i].songDisplayData();
            }
        }
    }

    //Tìm kiếm ca sĩ theo tên hoặc thể loại
    public static void searchSinger() {
        System.out.println("Nhập tên ca sĩ hoặc thể loại của ca sĩ tìm");
        String findSinger = scanner.nextLine();
        for (int i = 0; i < lengthSinger; i++) {
            if (singerArr[i].getSingerName().equals(findSinger) || singerArr[i].getGenre().equals(findSinger)) {
                singerArr[i].displayData();
            }
        }
    }

    //Hiển thị danh sách bài hát theo thứ tự tăng dần
    public static void songDecreasd() {
        for (int i = lengthSong - 1; i >= 0; i--) {
            for (int j = i + 1; j < lengthSong; j++) {
                if (songArr[i].getSongName().compareTo(songArr[j].getSongName()) > 0) {
                    Song tg = songArr[i];
                    songArr[i] = songArr[j];
                    songArr[j] = tg;
                }
            }
            songArr[i].songDisplayData();
        }
    }

    //Hiển thị 10 bài hát được đăng mới nhất
    public static void displayNewestSong() {
        if (lengthSong <= 10) {
            for (int i = 0; i < lengthSong; i++) {
                songArr[i].songDisplayData();
            }
        } else {
            Song[] clone = songArr.clone();
            for (int i = lengthSong - 1; i >= 0; i--) {
                for (int j = i + 1; j < lengthSong; j++) {
                    if (clone[i].getCreatedDate().getTime() < clone[j].getCreatedDate().getTime()) {
                        Song tg = clone[i];
                        clone[i] = clone[j];
                        clone[j] = tg;
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                clone[i].songDisplayData();
            }
        }
    }
}
