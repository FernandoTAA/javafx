package br.com.javafx.labspring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.javafx.labspring.dto.PersonDTO;

@Service
public class ListServiceImpl implements ListService{

	@Override
	public List<PersonDTO> getPeople() {
		List<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("Ana Carvalho Pereira", "336.867.864-78", LocalDate.of(1991, 1, 1)));
		list.add(new PersonDTO("Fernando Teixeira Alves de Araujo", "459.226.786-98", LocalDate.of(1988, 5, 3)));
		list.add(new PersonDTO("João Aguinaldo Mendes", "331.416.625-76", LocalDate.of(1981, 3, 15)));
		list.add(new PersonDTO("José de Alcantara", "801.813.572-08", LocalDate.of(1987, 3, 11)));
		list.add(new PersonDTO("Maria Jose Pereira", "746.866.846-92", LocalDate.of(1995, 9, 24)));
		list.add(new PersonDTO("Pedro Henrique de Souza", "501.888.436-39", LocalDate.of(1950, 1, 9)));
		list.add(new PersonDTO("Paula da Silva", "696.251.272-40", LocalDate.of(2000, 7, 4)));
		list.add(new PersonDTO("Ronaldo de Oliveira Filho", "518.498.532-82", LocalDate.of(1970, 9, 13)));
		return list;
	}

}
