package co.usa.mintic.ciclo3.ciclo3.service;

import co.usa.mintic.ciclo3.ciclo3.model.Reservation;
import co.usa.mintic.ciclo3.ciclo3.repository.RsvtRepository;
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
   /**
    * Instancia clase RsvtRepository
    */
   private RsvtRepository reservationRepository; 
   
   /**
    * Creación lista Reservation
    * @return repositorio de la la clase reservacion
    */
   public List<Reservation> getAll(){
       return reservationRepository.getAll();
   }
   
   /**
    * Creación de la clase Optional
    * @param idRsv
    * @return idRsv
    */
   public Optional<Reservation> getReservation(int idRsv){
       return reservationRepository.getReservation(idRsv);
   }
   
   /**
    * Creación clase Reservation para grabar
    * @param reserva
    * @return reserva nuerva
    */
   public Reservation save(Reservation reserva){
       if(reserva.getIdReservation()==null){
           return reservationRepository.save(reserva);          
       }else{
           Optional<Reservation> raux=reservationRepository.getReservation(reserva.getIdReservation());
           if(!raux.isPresent()){
               return reservationRepository.save(reserva);
           }else{
               return reserva;
           }
       }
   }
   
   /**
    * Creación clase reservation para actualizar
    * @param reserva
    * @return reserva modificada
    */
    public Reservation update(Reservation reserva) {
        if (reserva.getIdReservation() != null) {
            Optional<Reservation> p = reservationRepository.getReservation(reserva.getIdReservation());
            if (p.isPresent()) {
                if (reserva.getStartDate()!= null) {
                    p.get().setStartDate(reserva.getStartDate());
                }
                if(reserva.getDevolutionDate()!=null){
                    p.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                return reservationRepository.save(p.get());
            }
        }
        return reserva;
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
