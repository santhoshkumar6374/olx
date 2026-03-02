package com.bustrack.bustrack.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String busNumber;
    private double latitude;
    private double longitude;
    private double eta;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusnumber() {
        return busNumber;
    }

    public void setBusnumber(String busnumber) {
        this.busNumber = busnumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getEta() {
        return eta;
    }

    public void setEta(double eta) {
        this.eta = eta;
    }


   @OneToMany(mappedBy = "bus")
    private List<User> users;


}
