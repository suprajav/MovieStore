
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static sun.nio.cs.Surrogate.is;

class MovieStoreTest {

    private final MovieStore movieStore =new MovieStore();
    private final Movie harrypotter =new Movie("Harry Potter","Rowling");
    private final Movie starwars =new Movie("Star Wars", "Shwimmer");
    private final Movie charlie_and_chocolateFactory =new Movie("Charlie and ChocolateFactory", "Shwimmer");

    @BeforeEach
    public void setUp()
    {
        movieStore.add(harrypotter);
        movieStore.add(starwars);
        movieStore.add(charlie_and_chocolateFactory);
    }

    @DisplayName("Check if no movies find by partial Title")
    @Test
    public void NoResultsDisplayedWhenNoPartialName() {
        MovieStore movieStore = new MovieStore();
        List<String> results = movieStore.findByPartialTitle("Harry");
        //  movieStore.add(new Movie("Harry Potter", "Rowling"));
        assertEquals(results.size(),0);

    }

    @DisplayName("Display movies if partial name finds ")
    @Test
    public void DisplayMoviesWhenPartialNameFinds()
    {
        List<String> results ;
        results =   movieStore.findByPartialTitle("arry");
        List<String> expected = new ArrayList<>();
        expected.add("Harry Potter");
        assertIterableEquals(results,expected);
    }



    @DisplayName("Display movies if Director name finds ")
    @Test
    public void DisplayMoviesWhenExactDirectorNameFinds()
    {
        List<String> results ;
        results =   movieStore.findByDirector("Shwimmer");
        List<String> dirList = new ArrayList<>();

        dirList.add(starwars.getDirector());
        dirList.add(charlie_and_chocolateFactory.getDirector());
        assertEquals(results.size(),2);

        assertArrayEquals(results.toArray(),dirList.toArray());
    }

}