package es.uniovi.asw.e3b.incidashboard_e3b.services;

import org.springframework.stereotype.Service;

@Service
public class RolesService {
	private String[] roles = {"ROLE_OPERADOR","ROLE_ADMIN"};
	
	public String[] getRoles() {
		return roles;
	}
}
