package de.schauderhaft.degraph.demo.person.domain;

import java.util.List;

public interface PersonRepository {
	public void saveOrUpdate(List<Person> persons);
}
