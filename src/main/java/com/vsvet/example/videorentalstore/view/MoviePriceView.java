package com.vsvet.example.videorentalstore.view;

import java.math.BigDecimal;
import java.time.Instant;

public class MoviePriceView {

    private MovieTypeView movieType;

    private BigDecimal price;

    private Integer startPeriod;

    private Instant createdDate;

    private Instant modifiedDate;

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

    public MovieTypeView getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieTypeView movieType) {
        this.movieType = movieType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Integer startPeriod) {
        this.startPeriod = startPeriod;
    }
}
