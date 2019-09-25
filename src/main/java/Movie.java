public class Movie {


    private  String title;
    private String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

//    public String title() {
//        return  title;
//    }

    public String getTitle() {
        return title;
    }
    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return title;

    }
}
