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

import fr.polytech.netflixbackend.dto.request.ActeurDtoCreate;
import fr.polytech.netflixbackend.dto.request.ActeurDtoUpdate;
import fr.polytech.netflixbackend.dto.response.ActeurDto;
import fr.polytech.netflixbackend.dto.response.MessageDto;
import fr.polytech.netflixbackend.service.ActeurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ActeurController {
    
    private final ActeurService acteurService;

    @GetMapping("/acteurs")
    public @ResponseBody List<ActeurDto> getActeurs() {
        return acteurService.getActeurs().stream().map(
            acteur -> ActeurDto.convertEntitytoDto(acteur)
        ).toList();
    }

    @GetMapping("/acteurs/{id}")
    public @ResponseBody ActeurDto getActeur(@PathVariable Integer id) {
        return ActeurDto.convertEntitytoDto(acteurService.getActeur(id));
    }

    @PostMapping("/acteurs")
    public @ResponseBody ActeurDto addActeur(@Valid @RequestBody ActeurDtoCreate acteurDtoCreate) {
        return ActeurDto.convertEntitytoDto(acteurService.addActeur(acteurDtoCreate));
    }

    @PutMapping("/acteurs/{id}")
    public @ResponseBody ActeurDto editActeur(@PathVariable Integer id, @Valid @RequestBody ActeurDtoUpdate acteurDtoUpdate) {
        return ActeurDto.convertEntitytoDto(acteurService.editActeur(id, acteurDtoUpdate));
    }

    @DeleteMapping("/acteurs/{id}")
    public @ResponseBody MessageDto deleteActeur(@PathVariable Integer id) {
        return MessageDto.builder()
            .code("OK_DELETE")
            .message(this.acteurService.deleteActeur(id))
            .build();
    }

}
