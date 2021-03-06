package es.uniovi.asw.e3b.incidashboard_e3b.services;

import es.uniovi.asw.e3b.incidashboard_e3b.entities.Incidence;
import es.uniovi.asw.e3b.incidashboard_e3b.entities.Operario;
import es.uniovi.asw.e3b.incidashboard_e3b.repositories.IncidencesRepository;
import es.uniovi.asw.e3b.incidashboard_e3b.util.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenciasService {
	
	@Autowired
	IncidencesRepository incidencesRepository;
	
	public List<Incidence> getIncidenciasForOperario(Operario operario) {
		return incidencesRepository.getIncidenciasForOperario(operario);
	}
	
	public List<Incidence> getIncidenciasPeligrosasForOperario(Operario operario) {
		 List<Incidence> listaIncidencias = incidencesRepository.getIncidenciasForOperario(operario);
		 List<Incidence> list=new ArrayList<>();
		 for(Incidence i : listaIncidencias)
		 {
			 if(i.isPeligrosa())
				 list.add(i);
		 }
			 		 
		 
		 return list;
	}

	public Incidence findById(Long id) {
		return incidencesRepository.findOne(id);
	}
	
	public void addIncidencia(Incidence in){
		incidencesRepository.save(in);
	}


	
	@Transactional
	@Modifying
	public void cambiaEstadoIncidencia(Incidence inci,Estado es) {
		inci.setStatus(es);
	}

	public Incidence findOne(Long id) {
		return incidencesRepository.findOne(id);
	}

	@Transactional
	public void cambiaComentario(Incidence i, String comentario) {
		i.getComments().add(comentario);	
	}

}
