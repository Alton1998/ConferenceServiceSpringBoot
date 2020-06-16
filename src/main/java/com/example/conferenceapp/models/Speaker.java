package com.example.conferenceapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Speaker {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long speaker_id;

    private String speaker_name;

    private String speaker_title;

    private String speaker_company;

    private String speaker_bio;

    @ManyToMany(mappedBy = "speakers")
    private List <Session> sessions;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    public Speaker() {
    }

    public String getSpeaker_name() {
        return speaker_name;
    }

    public void setSpeaker_name(String speaker_name) {
        this.speaker_name = speaker_name;
    }

    public String getSpeaker_title() {
        return speaker_title;
    }

    public void setSpeaker_title(String speaker_title) {
        this.speaker_title = speaker_title;
    }

    public String getSpeaker_company() {
        return speaker_company;
    }

    public void setSpeaker_company(String speaker_company) {
        this.speaker_company = speaker_company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }
}
