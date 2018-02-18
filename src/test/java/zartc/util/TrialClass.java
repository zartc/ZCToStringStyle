package zartc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public class TrialClass {
	public static class Person {
		public String name;
		public Date birthDate;

		public Person(String name, Date birthDate) {
			this.name = name;
			this.birthDate = birthDate;
		}
	}

	public boolean boolValue = true;
	
	public char nonEmptyChar = 'A';
	
	public String nullString = null;
	public String emptyString = "";
	public String nonEmptyString = "Hello";
	
	public String[] nullStringArray = null;
	public String[] emptyStringArray = { };
	public String[] nonEmptyStringArray = { "Alice", "", null, "Bob" };
	
	public short[] nullShortArray = null;
	public Short[] emptyShortArray = { };		// note: Big Short
	public short[] nonEmptyShortArray = { 3, 9, 67 };
	
	public long[] nullLongArray = null;
	public Long[] emptyLongArray = { };			// note: Big Long
	public long[] nonEmptyLongArray = { 3L, 9L, 1967L };
	
	public Person[] nullPersonArray = null;
	public Person[] emptyPersonArray = { };
	public Person[] nonEmptyPersonArray;
	
	public Collection<String> stringCollection = new Vector<String>(Arrays.asList(nonEmptyStringArray));
	public Collection<String> stringList = new ArrayList<String>(stringCollection);
	public Collection<String> stringSet = new HashSet<>(stringCollection);
	
	public Collection<Person> objectCollection;
	public Collection<Person> objectList;
	public Collection<Person> objectSet;
	public Collection<Person> objectQueue;
	
	public Map<String, Object> emptyMap = new HashMap<String, Object>();
	public Map<String, Object> nonEmptyMap1 = new HashMap<String, Object>();

	TrialClass(Person[] persons) {
		this.nonEmptyPersonArray = persons;
		this.objectCollection = new Vector<Person>(Arrays.asList(nonEmptyPersonArray));
		this.objectList = new ArrayList<Person>(objectCollection);
		this.objectSet = new HashSet<>(objectCollection);
		this.objectQueue = new LinkedBlockingQueue<>(objectCollection);
		
		this.nonEmptyMap1.put("firstPerson", nonEmptyPersonArray[0]);
		this.nonEmptyMap1.put("secondPerson", nonEmptyPersonArray[1]);
	}
}
