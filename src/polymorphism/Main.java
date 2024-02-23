package polymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Polymorphism.Movie theMovie = new Polymorphism.Adventure("Star Wars");
//        theMovie.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("Enter type (A for Polymorphism.Adventure, C for Polymorphism.Comedy, S for Polymorphism.ScienceFiction, or Q to quit): ");
            String type = s.nextLine();
            if(type.contains("Qq")){
                break;
            }
            System.out.println("Enter movie title");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type,title);
            movie.watchMovie();
        }
    }
}
