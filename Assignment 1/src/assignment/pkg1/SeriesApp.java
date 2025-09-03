package assignment.pkg1;

import java.util.ArrayList;
import java.util.Scanner;

class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    public SeriesModel(String seriesId, String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    public String getSeriesId() { return seriesId; }
    public String getSeriesName() { return seriesName; }
    public int getSeriesAge() { return seriesAge; }
    public int getSeriesNumberOfEpisodes() { return seriesNumberOfEpisodes; }
    public void setSeriesName(String n) { this.seriesName = n; }
    public void setSeriesAge(int a) { this.seriesAge = a; }
    public void setSeriesNumberOfEpisodes(int e) { this.seriesNumberOfEpisodes = e; }

    public String toString() {
        return "SERIES ID: " + seriesId + "\n" +
               "SERIES NAME: " + seriesName + "\n" +
               "SERIES AGE RESTRICTION: " + seriesAge + "\n" +
               "NUMBER OF EPISODES: " + seriesNumberOfEpisodes;
    }
}

public class SeriesApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1 Capture\n2 Search\n3 Update\n4 Delete\n5 Report\n6 Exit");
            String c = sc.nextLine();
            if (c.equals("1")) capture();
            else if (c.equals("2")) search();
            else if (c.equals("3")) update();
            else if (c.equals("4")) delete();
            else if (c.equals("5")) report();
            else if (c.equals("6")) break;
        }
    }

    static void capture() {
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        int age;
        while (true) {
            System.out.print("Age (2-18): ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age >= 2 && age <= 18) break;
            } catch (Exception e) {}
            System.out.println("Invalid age");
        }
        System.out.print("Episodes: ");
        int ep = Integer.parseInt(sc.nextLine());
        seriesList.add(new SeriesModel(id, name, age, ep));
    }

    static void search() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Not found");
    }

    static void update() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.print("New name: ");
                s.setSeriesName(sc.nextLine());
                System.out.print("New age: ");
                s.setSeriesAge(Integer.parseInt(sc.nextLine()));
                System.out.print("New episodes: ");
                s.setSeriesNumberOfEpisodes(Integer.parseInt(sc.nextLine()));
                return;
            }
        }
        System.out.println("Not found");
    }

    static void delete() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                seriesList.remove(s);
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Not found");
    }

    static void report() {
        if (seriesList.isEmpty()) System.out.println("No series");
        else for (SeriesModel s : seriesList) System.out.println(s);
    }
}
