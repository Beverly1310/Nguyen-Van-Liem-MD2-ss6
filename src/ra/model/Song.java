package ra.model;

import java.util.Date;
import java.util.Scanner;

import static ra.model.Singer.singerArr;

public class Song {
    Scanner scanner = new Scanner(System.in);
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = new Date();
        this.songStatus = songStatus;
    }

    public Song() {
        this.createdDate = new Date();
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }


    public void songInputData() {
        do {
            System.out.println("Mời nhập mã bài hát");
            this.songId = scanner.nextLine();
            boolean check1 = false;
            boolean check2 = false;
            boolean check3 = false;
            if (this.songId.length() != 4) {
                System.out.println("Phải đủ 4 ký tự");
                check1 = true;
            }
            if (!this.songId.startsWith("S")) {
                System.out.println("Phải bắt đầu bằng ký tự S");
                check2 = true;
            }
            for (int i = 0; i < songArr.length; i++) {
                if (this.songId.equals(songArr[i].getSongId())) {
                    System.out.println("Bài hát đã tồn tài, mời nhập lại");
                    check3 = true;
                    break;
                }
            }
            if (!check1 && !check2 && !check3) {
                break;
            }
        }
        while (true);
        do {
            System.out.println("Mời nhập tên bài hát");
            this.songName = scanner.nextLine();
            if (this.songName.isBlank()) {
                System.out.println("Tên bài hát không được để trống: ");
            } else {
                break;
            }
        }
        while (true);
        System.out.println("Mời nhập mô tả bài hát");
        this.descriptions = scanner.nextLine();
        System.out.println("Mời nhập ca sĩ");
        for (int i = 0; i < singerArr.length; i++) {
            if (singerArr[i] != null)
                System.out.println(singerArr[i].getSingerName());
        }
        String name = scanner.nextLine();
        for (int i = 0; i < singerArr.length; i++) {
            if (name.equals(singerArr[i].getSingerName())) {
                this.singer = singerArr[i];
                break;
            } else {
                System.out.println("Ca sĩ không tồn tại");
            }
        }
        do {
            System.out.println("Mời nhập người sáng tác");
            this.songWriter = scanner.nextLine();
            if (this.songWriter.isBlank()) {
                System.out.println("Người sáng tác không được để trống: ");
            } else {
                break;
            }
        }
        while (true);
        System.out.println("Mời nhập trạng thái(true/false):");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void songDisplayData() {
        System.out.println("Mã bài hát: " + this.songId +
                "\nTên bài hát: " + this.songName +
                "\nMô tả: " + this.descriptions +
                "\nCa sĩ trình bày: " + this.singer.getSingerName() +
                "\nNgười sáng tác: " + this.songWriter +
                "\nNgày tạo: " + this.createdDate +
                "\nTrạng thái: " + (this.songStatus ? "Hoạt động" : "Không hoạt động"));
    }

    public static Song[] songArr = new Song[50];
}
