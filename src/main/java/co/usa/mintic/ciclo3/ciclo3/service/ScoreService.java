/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Score;
import co.usa.mintic.ciclo3.ciclo3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angélica Alzate
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int idScore) {
        return scoreRepository.getScore(idScore);
    }

    public Score save(Score s) {
        if (s.getIdScore() == null) {
            return scoreRepository.save(s);
        } else {
            Optional<Score> saux = scoreRepository.getScore(s.getIdScore());
            if (!saux.isPresent()) {
                return scoreRepository.save(s);
            } else {
                return s;
            }
        }

    }
    
}
