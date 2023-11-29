package fr.polytech.netflixbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.polytech.netflixbackend.entity.SerieEntity;
import fr.polytech.netflixbackend.exception.ResourceNotFoundException;
import fr.polytech.netflixbackend.repository.SerieRepository;

@ExtendWith(MockitoExtension.class)
public class SerieServiceTest {
    
    @Mock
    private SerieRepository serieRepository;

    @InjectMocks
    private SerieService serieService;

    @Test
    public void shouldReturnASerieEntity() {
        SerieEntity serie = SerieEntity.builder().id(3).build();
        when(serieRepository.findById(any())).thenReturn(Optional.of(serie));

        SerieEntity result = this.serieService.getSerie(3);

        assertEquals(serie, result);
    }

    @Test
    public void shouldReturnAErrorIfIdDoesExists() {
        when(serieRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            this.serieService.getSerie(30);
        });
    }

}
