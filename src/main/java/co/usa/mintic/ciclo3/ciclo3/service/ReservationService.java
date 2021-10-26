/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Reservation;
import co.usa.mintic.ciclo3.ciclo3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Angelica Alzate
 */

@Service
public class ReservationService {
    
   @Autowired
   private ReservationRepository reservationRepository; 
   
   public List<Reservation> getAll(){
       return reservationRepository.getAll();
   }
   
   public Optional<Reservation> getReservation(int idRsv){
       return reservationRepository.getReservation(idRsv);
   }
   
   public Reservation save(Reservation r){
       if(r.getIdReservation()==null){
           return reservationRepository.save(r);          
       }else{
           Optional<Reservation> raux=reservationRepository.getReservation(r.getIdReservation());
           if(!raux.isPresent()){
               return reservationRepository.save(r);
           }else{
               return r;
           }
       }
   }
   
    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> p = reservationRepository.getReservation(r.getIdReservation());
            if (p.isPresent()) {
                if (r.getStartDate()!= null) {
                    p.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    p.get().setDevolutionDate(r.getDevolutionDate());
                }
                return reservationRepository.save(p.get());
            }
        }
        return r;
    }   
    public boolean deleteReservation(int id){
        Optional<Reservation> r=getReservation(id);
        if(r.isPresent()){
            reservationRepository.delete(r.get());
            return true;
    }
    return false;
    }
}
