package com.vsvet.example.videorentalstore.view;

import com.vsvet.example.videorentalstore.validator.ClientIdExist;
import com.vsvet.example.videorentalstore.validator.MovieIdsExist;
import com.vsvet.example.videorentalstore.validator.NotNull;
import com.vsvet.example.videorentalstore.validator.Positive;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

public class MovieRentalView {

    /**
     * To identify rental will use DB id
     * In real application there will be nice to have UUID or
     * sth else.
     */
    private Long id;

    @ClientIdExist
    private Long clientId;

    @MovieIdsExist
    private List<Long> movieIds;

    @NotNull(fieldName = "numberOfDays")
    @Positive(fieldName = "numberOfDays")
    private Integer numberOfDays;

    @ApiModelProperty(readOnly = true)
    private BigDecimal price;

    @ApiModelProperty(readOnly = true)
    private BigDecimal complimentPrice;

    public BigDecimal getComplimentPrice() {
        return complimentPrice;
    }

    public void setComplimentPrice(BigDecimal complimentPrice) {
        this.complimentPrice = complimentPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(List<Long> movieIds) {
        this.movieIds = movieIds;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "MovieRentalView{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", movieIds=" + movieIds +
                ", numberOfDays=" + numberOfDays +
                ", price=" + price +
                ", complimentPrice=" + complimentPrice +
                '}';
    }
}
