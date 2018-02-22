package zartc.util;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ZCToStringBuilderTrial {
	public static class Person extends TrialClass.Person {
		public Person(String name, Date birthDate) {
			super(name, birthDate);
		}

		@Override
		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this);
			builder.append("name", name);
			builder.append("birthDate", birthDate);
			return builder.toString();
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(final String[] args) {
		ToStringBuilder.setDefaultStyle(ZCToStringStyle.SHORT_WITH_HASH_STYLE);

		TrialClass o = new TrialClass(new Person[] { 
				new Person("Alice", new Date(Date.parse("1964/4/6"))),
				new Person("Bob", new Date(Date.parse("1967/9/3 14:25"))) });

		ToStringBuilder builder = new ToStringBuilder(o);

		builder.append("boolValue", o.boolValue);

		builder.append("nonEmptyChar", o.nonEmptyChar);

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

		builder.append("stringCollection", o.stringCollection);
		builder.append("stringList", o.stringList);
		builder.append("stringSet", o.stringSet);

		builder.append("nullPersonArray", o.nullPersonArray);
		builder.append("emptyPersonArray", o.emptyPersonArray);
		builder.append("nonEmptyPersonArray", o.nonEmptyPersonArray);

		builder.append("objectCollection", o.objectCollection);
		builder.append("objectList", o.objectList);
		builder.append("objectSet", o.objectSet);
		builder.append("objectQueue", o.objectQueue);

		builder.append("emptyMap", o.emptyMap);
		builder.append("nonEmptyMap1", o.nonEmptyMap1);

		System.out.println(builder.toString());
	}
}

/* EOF */
