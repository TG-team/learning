package jp.co.technica.imple.make_clazz.compare;

import java.util.Date;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        equalsCheck();

        toStringCheck();

        hashCodeCheck();

        cloneCheck();
    }

    private static void equalsCheck() {
        System.out.println("===equalsCheck===");
        long date = new Date().getTime();

        Photo photo1_1 = new Photo();
        photo1_1.setPath("C:\\");
        photo1_1.setDate(date);
        photo1_1.setName("Photo1");
        photo1_1.setSize(1000);
        Photo photo1_2 = new Photo();
        photo1_2.setPath("C:\\");
        photo1_2.setDate(date);
        photo1_2.setName("Photo1");
        photo1_2.setSize(1000);

        Movie movie1_1 = new Movie();
        movie1_1.setPath("C:\\");
        movie1_1.setDate(date);
        movie1_1.setName("Movie1");
        movie1_1.setSize(1000);
        Movie movie1_2 = new Movie();
        movie1_2.setPath("C:\\");
        movie1_2.setDate(date);
        movie1_2.setName("Movie1");
        movie1_2.setSize(1000);

        System.out.println("photo1_1 == photo1_2 : "
                + photo1_1.equals(photo1_2));
        System.out.println("movie1_1 == movie1_2 : "
                + movie1_1.equals(movie1_2));
    }

    private static void toStringCheck() {
        System.out.println("===toStringCheck===");
        long date = new Date().getTime();

        Photo photo = new Photo();
        photo.setPath("C:\\");
        photo.setDate(date);
        photo.setName("Photo");
        photo.setSize(1000);

        Movie movie = new Movie();
        movie.setPath("C:\\");
        movie.setDate(date);
        movie.setName("Movie");
        movie.setSize(1000);

        System.out.println(photo.toString());
        System.out.println(movie.toString());
    }

    private static void hashCodeCheck() {
        System.out.println("===hashCodeCheck===");
        HashMap<Photo, Integer> photos = new HashMap<Photo, Integer>();
        HashMap<Movie, Integer> movies = new HashMap<Movie, Integer>();

        long now = System.currentTimeMillis();
        Photo photo = null;
        for (int i = 0; i < 20000; i++) {
            photo = new Photo();
            photo.setSize(i);

            photos.put(photo, i);
        }
        System.out.println("Photo#put time : "
                + (System.currentTimeMillis() - now));

        now = System.currentTimeMillis();
        Movie movie = null;
        for (int i = 0; i < 20000; i++) {
            movie = new Movie();
            movie.setSize(i);

            movies.put(movie, i);
        }
        System.out.println("Movie#put time : "
                + (System.currentTimeMillis() - now));
    }

    private static void cloneCheck() {
        System.out.println("===cloneCheck===");
        Photo photo1 = new Photo();
        photo1.setDate(new Date().getTime());
        photo1.setName("Photo");
        photo1.setPath("C:\\");
        photo1.setSize(1000);
        Photo photo2 = photo1.clone();

        System.out.println("equals : " + photo1.equals(photo2));
        System.out.println("== : " + (photo1 == photo2));
        photo2.setSize(1234);
        System.out.println(photo1 + " : " + photo2);
    }
}
