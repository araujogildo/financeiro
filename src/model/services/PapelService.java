package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Papel;

public class PapelService {
	
	public List<Papel> findAll(){
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//mockar os dados (dados fake)
		List<Papel> list = new ArrayList<>();
		
		//sdf.format(new Date()).toString()
		list.add(new Papel(1, "PETR4", "Petrobras", "Petróleo", "28/08/2022" , 1));
		list.add(new Papel(2, "VALE3", "Vale", "Mineração", "28/08/2022", 1));
		list.add(new Papel(3, "SUZB3", "Suzano Papel e Celulose", "Celulose", "28/08/2022", 1));
		list.add(new Papel(4, "BBSA3", "Banco do Brasil", "Bancário", "28/08/2022", 1));
		list.add(new Papel(5, "AGRO3", "Via Agro", "Agronegócio", "28/08/2022", 1));
		return list;
		//
	}
}
