/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Client;
import co.usa.mintic.ciclo3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angélica Alzate
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client t){
        if(t.getIdClient()== null){
            return clientRepository.save(t);
            
        }else{
            Optional<Client> taux=clientRepository.getClient(t.getIdClient());
            if(!taux.isPresent()){
                return clientRepository.save(t);                             
            }else{
                return t;
            }
        }
    }
}
