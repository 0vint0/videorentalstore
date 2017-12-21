package com.vsvet.example.videorentalstore;

import com.vsvet.example.videorentalstore.domain.Client;
import com.vsvet.example.videorentalstore.domain.Movie;
import com.vsvet.example.videorentalstore.domain.MoviePrice;
import com.vsvet.example.videorentalstore.domain.MovieType;
import com.vsvet.example.videorentalstore.repository.ClientRepository;
import com.vsvet.example.videorentalstore.repository.MoviePriceRepository;
import com.vsvet.example.videorentalstore.repository.MovieRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

@SpringBootApplication
@EnableAspectJAutoProxy
public class VideoRentalStoreApplication {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MoviePriceRepository moviePriceRepository;
    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(VideoRentalStoreApplication.class, args);
    }


    /**
     * Load default data into DB
     *
     * @return
     */
    @Bean
    public InitializingBean initializingBean() {
        return () -> {
            createDefaultClients();
            createDefaultPrices();
            createMovies();
        };

    }

    private void createDefaultClients() {
        Client client1 = new Client();
        client1.setEmail("test1@mail.com");
        client1.setBalance(BigDecimal.valueOf(100));
        client1.setPhoneNumber("0123456789");
        client1.setFirstName("FirstName1");
        client1.setLastName("LastName1");
        client1.setBonusPoints(0L);

        Client client2 = new Client();
        client2.setEmail("test2@mail.com");
        client2.setBalance(BigDecimal.valueOf(200));
        client2.setPhoneNumber("0123456789");
        client2.setFirstName("FirstName2");
        client2.setLastName("LastName2");
        client2.setBonusPoints(0L);

        clientRepository.save(Arrays.asList(client1, client2));
    }

    private void createMovies() {
        Movie matrix = new Movie();
        matrix.setMovieType(MovieType.NewRelease);
        matrix.setTitle("Matrix");
        matrix.setDescription("Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne)...");
        matrix.setDirector("Wachowski");
        matrix.setReleaseDate(LocalDateTime.of(1999, 03, 31, 0, 0).toInstant(ZoneOffset.UTC));
        matrix.setNumberOfCopies(5L);
        matrix.setNumberOfRentCopies(0L);

        Movie spiderMan = new Movie();
        spiderMan.setMovieType(MovieType.Regular);
        spiderMan.setTitle("Spider Man");
        spiderMan.setDescription("Spider-Man centers on student Peter Parker (Tobey Maguire) wh ...");
        spiderMan.setDirector("Sam Raimi");
        spiderMan.setReleaseDate(LocalDateTime.of(2002, 01, 30, 0, 0).toInstant(ZoneOffset.UTC));
        spiderMan.setNumberOfCopies(5L);
        spiderMan.setNumberOfRentCopies(0L);


        Movie xMen = new Movie();
        xMen.setMovieType(MovieType.Old);
        xMen.setTitle("X-Men");
        xMen.setDescription("The film introduces Wolverine and Rogue into the conflict between Professor Xavier's X-Men an....");
        xMen.setDirector("Bryan Jay Singer ...");
        xMen.setReleaseDate(LocalDateTime.of(2000, 01, 30, 0, 0).toInstant(ZoneOffset.UTC));
        xMen.setNumberOfCopies(5L);
        xMen.setNumberOfRentCopies(0L);

        movieRepository.save(Arrays.asList(matrix, xMen, spiderMan));
    }

    private void createDefaultPrices() {
        MoviePrice newReleaseMoviePrice = new MoviePrice();
        newReleaseMoviePrice.setMovieType(MovieType.NewRelease);
        newReleaseMoviePrice.setPrice(BigDecimal.valueOf(40));
        newReleaseMoviePrice.setStartPeriod(1);

        MoviePrice regularMoviePrice = new MoviePrice();
        regularMoviePrice.setMovieType(MovieType.Regular);
        regularMoviePrice.setPrice(BigDecimal.valueOf(30));
        regularMoviePrice.setStartPeriod(3);

        MoviePrice oldMoviePrice = new MoviePrice();
        oldMoviePrice.setMovieType(MovieType.Old);
        oldMoviePrice.setPrice(BigDecimal.valueOf(30));
        oldMoviePrice.setStartPeriod(3);

        moviePriceRepository.save(Arrays.asList(newReleaseMoviePrice, regularMoviePrice, oldMoviePrice));
    }
}
