package ma.ensaj.hotel.service;

import ma.ensaj.hotel.entity.Chambre;
import ma.ensaj.hotel.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    public Chambre createChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Optional<Chambre> updateChambre(Long id, Chambre chambre) {
        return chambreRepository.findById(id).map(existingChambre -> {
            existingChambre.setType(chambre.getType());
            existingChambre.setPrix(chambre.getPrix());
            existingChambre.setDisponible(chambre.getDisponible());
            return chambreRepository.save(existingChambre);
        });
    }

    public boolean deleteChambre(Long id) {
        if (chambreRepository.existsById(id)) {
            chambreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


