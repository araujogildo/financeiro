package model.services;

import java.util.ArrayList;
import java.util.List;
import model.entities.Papel;

public class PapelService {
	
	public List<Papel> findAll(){
		
		//mockar os dados (dados fake)
		List<Papel> list = new ArrayList<>();
		
		list.add(new Papel(1, "PETR4", "Petrobras", "Petróleo"));
		list.add(new Papel(2, "VALE3", "Vale", "Mineração"));
		list.add(new Papel(3, "SUZB3", "Suzano Papel e Celulose", "Celulose"));
		list.add(new Papel(4, "BBSA3", "Banco do Brasil", "Bancário"));
		list.add(new Papel(5, "AGRO3", "Via Agro", "Agronegócio"));
		return list;
		//
	}
}
