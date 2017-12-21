package com.vsvet.example.videorentalstore.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

/**
 * This table will contain whole movies inventory.
 */
@Entity
@Table(name = "movies")
public class Movie extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "number_of_copies", nullable = false)
    private Long numberOfCopies;

    @Column(name = "number_of_rent_copies", nullable = false)
    private Long numberOfRentCopies;

    @Column(name = "movie_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @Column(name = "release_date", nullable = false)
    private Instant releaseDate;

    @Column(name = "director", nullable = false)
    private String director;

    @ManyToOne
    @JoinColumn(name = "movie_type", insertable = false, updatable = false)
    private MoviePrice moviePrice;

    //..This table can be extended to include here: stars, rating, review etc  ..//


    public Long getNumberOfRentCopies() {
        return numberOfRentCopies;
    }

    public void setNumberOfRentCopies(Long numberOfRentCopies) {
        this.numberOfRentCopies = numberOfRentCopies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoviePrice getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(MoviePrice moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getDescription(), movie.getDescription()) &&
                Objects.equals(getNumberOfCopies(), movie.getNumberOfCopies()) &&
                Objects.equals(getNumberOfRentCopies(), movie.getNumberOfRentCopies()) &&
                getMovieType() == movie.getMovieType() &&
                Objects.equals(getReleaseDate(), movie.getReleaseDate()) &&
                Objects.equals(getDirector(), movie.getDirector()) &&
                Objects.equals(getMoviePrice(), movie.getMoviePrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getNumberOfCopies(), getNumberOfRentCopies(), getMovieType(), getReleaseDate(), getDirector(), getMoviePrice());
    }
}
