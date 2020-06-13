package com.mumapp.mumapp.music;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = Long.valueOf(0);

    private String styleName;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> characteristics;

    public Music(){}

    public Music(String styleName, String... characteristics) {
        super();
        this.styleName = styleName;
        this.characteristics = new ArrayList<>(Arrays.asList(characteristics));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public List<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<String> characteristics) {
        this.characteristics = characteristics;
    }
}
