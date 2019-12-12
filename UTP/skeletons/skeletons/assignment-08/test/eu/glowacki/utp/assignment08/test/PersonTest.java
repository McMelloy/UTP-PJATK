package eu.glowacki.utp.assignment08.test;

import eu.glowacki.utp.assignment08.Assignment08Exception;
import eu.glowacki.utp.assignment08.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonTest {

	@Test
	public void serializeAndDeserialize() {
		Person orig;
		Person copy;

		try {
			orig = new Person("Demetrius", "Baranovsky", new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-16"));
			orig.serialize(new DataOutputStream(new FileOutputStream(new File("PersonTest.txt"))));
			copy = Person.deserialize(new DataInputStream(new FileInputStream(new File("PersonTest.txt"))));
			Assert.assertEquals(orig.get_surname(), copy.get_surname());
			Assert.assertEquals(orig.get_birthDate(), copy.get_birthDate());
		} catch (Assignment08Exception | FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
	}
}