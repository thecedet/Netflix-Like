package fr.polytech.netflixbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.polytech.netflixbackend.dto.response.MessageDto;
import fr.polytech.netflixbackend.service.S3Service;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class S3Controller {
    
    private final S3Service s3Service;

    @PostMapping("/series/{id}/cover")
    public @ResponseBody MessageDto getCoverUrl(@PathVariable Integer id, @RequestParam(value = "extension", required = false) String extension) {
        return MessageDto.builder()
            .code("GET_COVER_URL")
            .message(s3Service.getPutCoverUrl(
                id,
                (extension == null ? ".png" : "."+extension)
            ))
            .build();
    }

    @GetMapping("/series/{id}/cover")
    public @ResponseBody MessageDto getCoverUrl(@PathVariable Integer id) {
        return MessageDto.builder()
            .code("GET_COVER_URL")
            .message(s3Service.getGetCoverUrl(id))
            .build();
    }

}
