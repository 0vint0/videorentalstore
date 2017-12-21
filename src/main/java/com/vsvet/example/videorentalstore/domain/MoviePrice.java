package com.vsvet.example.videorentalstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Defines the price per movie type
 */
@Entity
@Table(name = "movie_prices")
public class MoviePrice extends AbstractEntity {

    @Id
    @Column(name = "movie_type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private MovieType movieType;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    /**
     * Represents the period in days included in price,
     * after period is exceed the calculation is done per day.
     */
    @Column(name = "start_period", nullable = false)
    private Integer startPeriod;

    public Integer getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Integer startPeriod) {
        this.startPeriod = startPeriod;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoviePrice)) return false;
        MoviePrice that = (MoviePrice) o;
        return getStartPeriod() == that.getStartPeriod() &&
                getMovieType() == that.getMovieType() &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieType(), getPrice(), getStartPeriod());
    }
}
