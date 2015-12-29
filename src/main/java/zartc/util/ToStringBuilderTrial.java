package zartc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class ToStringBuilderTrial {
	
	public boolean boolValue = true;
	
	public String nullString = null;
	public String emptyString = "";
	public String nonEmptyString = "Hello";
	
	public String[] nullStringArray = null;
	public String[] emptyStringArray = { };
	public String[] nonEmptyStringArray = { "Alice", "", "Bob" };
	
	public short[] nullShortArray = null;
	public Short[] emptyShortArray = { };
	public short[] nonEmptyShortArray = { 3, 9, 67 };
	
	public long[] nullLongArray = null;
	public Long[] emptyLongArray = { };
	public long[] nonEmptyLongArray = { 3L, 9L, 1967L };
	
	public Person[] nullPersonArray = null;
	public Person[] emptyPersonArray = { };
	@SuppressWarnings("deprecation")
	public Person[] nonEmptyPersonArray = { new Person("Alice", new Date(1967, 9, 3)),  new Person("Bob", new Date(1964, 4, 6)) };
	
	public Collection<String> stringCollection = new Vector<String>(Arrays.asList(nonEmptyStringArray));
	public List<String> stringList = new ArrayList<String>(stringCollection);
	public Set<String> stringSet = new HashSet<>(stringCollection);
	
	public Map<String, Object> emptyMap = new HashMap<String, Object>();
	public Map<String, Object> nonEmptyMap = new HashMap<String, Object>();
	
	
	public static class Person {
		public String name;
		public Date birthDate;
		public Person(String name, Date birthDate) {
			this.name = name;
			this.birthDate = birthDate;
		}
		@Override
		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
			builder.append("name", name);
			builder.append("birthDate", birthDate);
			return builder.toString();
		}
	}
	
	public static void main(final String[] args) {
		ToStringBuilderTrial o = new ToStringBuilderTrial();
		o.nonEmptyMap.put("key1", "value1");
		o.nonEmptyMap.put("key2", "value2");
		
		trialToStringBuilder(o, new SpringToStringStyle());
	}

	public static void trialToStringBuilder(ToStringBuilderTrial o, ToStringStyle tss) {
		ToStringBuilder builder = new ToStringBuilder(o, tss);
		
		builder.append("boolValue", o.boolValue);
		
		builder.append("nullString", o.nullString);
		builder.append("emptyString", o.emptyString);
		builder.append("nonEmptyString", o.nonEmptyString);
		
		builder.append("nullStringArray", o.nullStringArray);
		builder.append("emptyStringArray", o.emptyStringArray);
		builder.append("nonEmptyStringArray", o.nonEmptyStringArray);
		
		builder.append("nullShortArray", o.nullShortArray);
		builder.append("emptyShortArray", o.emptyShortArray);
		builder.append("nonEmptyShortArray", o.nonEmptyShortArray);
		
		builder.append("nullLongArray", o.nullLongArray);
		builder.append("emptyLongArray", o.emptyLongArray);
		builder.append("nonEmptyLongArray", o.nonEmptyLongArray);
		
		builder.append("nullPersonArray", o.nullPersonArray);
		builder.append("emptyPersonArray", o.emptyPersonArray);
		builder.append("nonEmptyPersonArray", o.nonEmptyPersonArray);
		
		builder.append("stringCollection", o.stringCollection);
		builder.append("stringList", o.stringList);
		builder.append("stringSet", o.stringSet);
		
		builder.append("emptyMap", o.emptyMap);
		builder.append("nonEmptyMap", o.nonEmptyMap);
		
		System.out.println(builder.toString());
	}
}

/* EOF */
