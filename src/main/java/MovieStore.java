import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class MovieStore {

    List<Movie> moviesList = new ArrayList<Movie>();
    public List<String> findByPartialTitle(String partialTitle) {

         List<String> result = new ArrayList<>();
       // Implementing Stream() for iterating through movieList,and checking partialTitle.
         result = moviesList.stream().filter(movie -> movie.getTitle().toUpperCase().contains(partialTitle.toUpperCase())).
                 map(movie-> movie.getTitle()).collect(Collectors.toList());
//        for (Movie movie : moviesList)
//        {
//
//            if(movie.getTitle().toUpperCase().contains(partialTitle.toUpperCase()))
//            {
//                result.add(movie);
//            }
//        }
       return result;

}

    public void add(Movie movie) {
        moviesList.add(movie);
    }

    public List<String> findByDirector(String director) {

        List<String> result = new ArrayList<>();

        result = moviesList.stream().filter(movie -> movie.getDirector().equals(director)).map(movie -> movie.getDirector()).collect(Collectors.toList());

//        for (Movie movie : moviesList)
//        {
//
//            if(movie.getDirector().equals(director))
//            {
//                result.add(movie);
//            }
//        }
        return result;
    }
}
