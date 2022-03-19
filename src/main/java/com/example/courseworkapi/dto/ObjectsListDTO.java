package com.example.courseworkapi.dto;

import com.example.courseworkapi.models.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectsListDTO implements Serializable {
    private Long id;
    private String type;
    private String name;
    private String picture;
    private String author;
    private float rating;

    public ObjectsListDTO(Objects obj) {
        this.id = obj.getId();
        this.type = obj.getType();
        this.name = obj.getName();
        this.picture = obj.getPicture();
        this.author = obj.getAuthor();
        this.rating = obj.getRating();
    }
}
