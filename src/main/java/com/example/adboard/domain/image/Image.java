package com.example.adboard.domain.image;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ImageProvider imageProvider;

    @Embedded
    private Location location = new Location();

    @Embedded
    private Sides sides = new Sides();

    @Enumerated(EnumType.STRING)
    private Format format;

    @Min(1)
    private long size;

    @Data
    @Embeddable
    public static class Location {

        @Column(nullable = false)
        private String uri;

        @Column(nullable = false)
        private String urn;
    }

    @Data
    @Embeddable
    public static class Sides {

        @Column(nullable = false)
        private Double width;

        @Column(nullable = false)
        private Double height;
    }

    @Getter
    public enum Format {
        JPG("FFD8FFDB"),
        JPEG("FFD8FFDB"),
        PNG("89504E470D0A1A0A");

        private final String signature;

        Format(String signature) {
            this.signature = signature;
        }
    }
}
