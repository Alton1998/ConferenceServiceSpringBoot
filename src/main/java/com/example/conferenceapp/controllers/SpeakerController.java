package com.example.conferenceapp.controllers;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.example.conferenceapp.models.Session;
import com.example.conferenceapp.models.Speaker;
import com.example.conferenceapp.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getAllSpeakers()
    {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeaker(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker createSpeaker(@RequestBody Speaker speaker)
    {
        return  speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void  deleteSpeaker(@PathVariable Long id)
    {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Long id,@RequestBody Speaker speaker)
    {
        Speaker existingSpeaker;
        existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
