package com.vsvet.example.videorentalstore.view;

import javax.persistence.Column;
import java.time.Instant;

public class MovieView {

    private Long id;

    private String title;

    private String description;

    private Long numberOfCopies;

    private Long numberOfRentCopies;

    private MovieTypeView movieType;

    private Instant releaseDate;

    private String director;

    private Instant createdDate;

    private Instant modifiedDate;

    private MoviePriceView price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getNumberOfRentCopies() {
        return numberOfRentCopies;
    }

    public void setNumberOfRentCopies(Long numberOfRentCopies) {
        this.numberOfRentCopies = numberOfRentCopies;
    }

    public MovieTypeView getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieTypeView movieType) {
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

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public MoviePriceView getPrice() {
        return price;
    }

    public void setPrice(MoviePriceView price) {
        this.price = price;
    }
}
