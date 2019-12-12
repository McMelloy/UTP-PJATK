package eu.glowacki.utp.assignment08.test;
import eu.glowacki.utp.assignment08.Assignment08Exception;
import eu.glowacki.utp.assignment08.Person;
import eu.glowacki.utp.assignment08.PersonDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonDatabaseTest {

	PersonDatabase orig;
	@Before
	public void fillDatabase(){
		try {
			Person p1 = new Person("Demetrius", "Baranovsky", new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-16"));
			Person p2 = new Person("William", "The Conqueror", new SimpleDateFormat("yyyy-MM-dd").parse("1999-01-20"));
			Person p3 = new Person("Napoleon", "Bonaparte", new SimpleDateFormat("yyyy-MM-dd").parse("1978-08-24"));
			Person p4 = new Person("Konstantin", "Kalinovsky", new SimpleDateFormat("yyyy-MM-dd").parse("1989-10-26"));
			List<Person> list = new ArrayList<>();
			list.add(p1);list.add(p2);list.add(p3);list.add(p4);
			orig = new PersonDatabase(list);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void serializeAndDeserialize() {

		PersonDatabase copy;

		try {
			orig.serialize(new DataOutputStream(new FileOutputStream(new File("PersonTest.txt"))));
			copy = PersonDatabase.deserialize(new DataInputStream(new FileInputStream(new File("PersonTest.txt"))));
			Assert.assertEquals(orig.getData().size(),copy.getData().size());
			Assert.assertEquals(orig.getData().get(0).get_surname(), orig.getData().get(0).get_surname());
		} catch (Assignment08Exception | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}