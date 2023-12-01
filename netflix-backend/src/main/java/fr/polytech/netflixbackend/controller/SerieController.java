package fr.polytech.netflixbackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.netflixbackend.dto.request.SerieDtoCreate;
import fr.polytech.netflixbackend.dto.request.SerieDtoUpdate;
import fr.polytech.netflixbackend.dto.response.MessageDto;
import fr.polytech.netflixbackend.dto.response.SerieDto;
import fr.polytech.netflixbackend.service.SerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SerieController {
    
    private final SerieService serieService;

    @GetMapping("/series")
    public @ResponseBody List<SerieDto> getSeries() {
        return serieService.getSeries().stream().map(
            serie -> SerieDto.convertEntitytoDto(serie)
        ).toList();
    }

    @GetMapping("/series/{id}")
    public @ResponseBody SerieDto getSerie(@PathVariable Integer id) {
        return SerieDto.convertEntitytoDto(serieService.getSerie(id));
    }

    @PostMapping("/series")
    public @ResponseBody SerieDto addSerie(@Valid @RequestBody SerieDtoCreate serieDtoCreate) {
        return SerieDto.convertEntitytoDto(serieService.addSerie(serieDtoCreate));
    }

    @PutMapping("/series/{id}")
    public @ResponseBody SerieDto editSerie(@PathVariable Integer id, @Valid @RequestBody SerieDtoUpdate serieDtoUpdate) {
        return SerieDto.convertEntitytoDto(serieService.editSerie(id, serieDtoUpdate));
    }

    @DeleteMapping("/series/{id}")
    public @ResponseBody MessageDto deleteSerie(@PathVariable Integer id) {
        return MessageDto.builder()
            .code("OK_DELETE")
            .message(this.serieService.deleteSerie(id))
            .build();
    }

}
