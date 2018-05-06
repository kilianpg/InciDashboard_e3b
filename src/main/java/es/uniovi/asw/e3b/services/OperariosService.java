package es.uniovi.asw.e3b.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import es.uniovi.asw.e3b.entities.Operario;
import es.uniovi.asw.e3b.repositories.OperariosRepository;

@Service
public class OperariosService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private OperariosRepository operatorsRepository;

	public void addOperador(Operario operador) {
		operador.setPassword(bCryptPasswordEncoder.encode(operador.getPassword()));
		operatorsRepository.save(operador);
	}
	
	public Operario getOperarioByEmail(String email) {
		return operatorsRepository.findByEmail(email);		
	}

	public List<Operario> findAll() {
		return operatorsRepository.findAll();
	}


}