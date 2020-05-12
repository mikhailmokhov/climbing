package com.mokhov.climbing.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "yelpBusinesses")
public class YelpBusiness {
    @Id
    private String id;
    private String name;
    @SerializedName("image_url")
    private String yelpImageUrl;
    @SerializedName("url")
    private String yelpUrl;
    @SerializedName("review_count")
    private Integer yelpReviewCount;
    @SerializedName("rating")
    private Double yelpRating;
    private YelpCoordinates coordinates;
    private YelpLocation location;
    private double distance;
    private boolean hidden;
    private String internalGymId;
    @Transient
    private boolean homeGym;

    @Indexed(name = "created", expireAfterSeconds = 86400) //document is automatically deleted after 24hrs
    private Date created;
}
