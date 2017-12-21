package com.vsvet.example.videorentalstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an action of renting a movie by client.
 * Will use createdDate  - as rent date
 */
@Entity
@Table(name = "movie_rentals")
public class MovieRental extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Number of renting days (planned).
     */
    @Column(name = "original_period", nullable = false)
    private Integer originalPeriod;

    /**
     * Number of renting days (real).
     */
    @Column(name = "actual_period")
    private Integer actualPeriod;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MovieRentalStatus status;

    /**
     * The price on renting date.
     */
    @Column(name = "orginal_price", nullable = false)
    private BigDecimal originalPrice;

    /**
     * The price on returning date.
     */
    @Column(name = "actual_price")
    private BigDecimal actualPrice;

    /**
     * Date when client returned movies.
     */
    @Column(name = "returned_date")
    private Instant returnedDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_rental_movies",
            joinColumns = @JoinColumn(name = "movie_rental_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false, nullable = false)
    private Client client;

    @Column(name="client_id",nullable = false)
    private Long clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Integer getOriginalPeriod() {
        return originalPeriod;
    }

    public void setOriginalPeriod(Integer originalPeriod) {
        this.originalPeriod = originalPeriod;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public MovieRentalStatus getStatus() {
        return status;
    }

    public void setStatus(MovieRentalStatus status) {
        this.status = status;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Instant getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Instant returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Integer getActualPeriod() {
        return actualPeriod;
    }

    public void setActualPeriod(Integer actualPeriod) {
        this.actualPeriod = actualPeriod;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieRental)) return false;
        MovieRental that = (MovieRental) o;
        return Objects.equals(getOriginalPeriod(), that.getOriginalPeriod()) &&
                Objects.equals(getActualPeriod(), that.getActualPeriod()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getOriginalPrice(), that.getOriginalPrice()) &&
                Objects.equals(getActualPrice(), that.getActualPrice()) &&
                Objects.equals(getReturnedDate(), that.getReturnedDate()) &&
                Objects.equals(getClientId(), that.getClientId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOriginalPeriod(), getActualPeriod(), getStatus(), getOriginalPrice(), getActualPrice(), getReturnedDate(), getClientId());
    }
}
