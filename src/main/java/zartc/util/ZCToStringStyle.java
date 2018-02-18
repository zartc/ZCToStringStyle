/*
   Copyright 2014 Pascal Jacob

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package zartc.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A ToStringStyle that produce toString output displaying detailled information
 * about the data type in arrays and collections.
 * 
 * This ToStringStyle produce more detailled but more costly toString output. It
 * is very convenient to use while developing your application, but it is
 * recommended to switch to a more frugal ToStringStyle before moving the
 * application into production.
 *
 * @author Pascal JACOB
 * @inceptionDate 2014
 */
public class ZCToStringStyle extends ToStringStyle {
	private static final long serialVersionUID = 1L;

	public static final String SHORT_CLASSNAME = "short";
	public static final String LONG_CLASSNAME = "long";
	public static final String HASHCODE = "@";
	public static final String ARRAY_TYPE = "<>";

	/**
	 * Pre-intantiated toStringStyle that output no class name prefix, no hashcode
	 * and no array type. This produce the simplest ZCToStringStyle output.
	 */
	public static final ToStringStyle DEFAULT_STYLE = new ZCToStringStyle("");
	
	/**
	 * Pre-intantiated toStringStyle that output the system hashcode but not the
	 * class name nor array type.
	 */
	public static final ToStringStyle DEFAULT_WITH_HASH_STYLE = new ZCToStringStyle(HASHCODE);
	
	/**
	 * Pre-intantiated toStringStyle that output short class name prefix, the
	 * object's system hashcode but no array type.
	 */
	public static final ToStringStyle SHORT_WITH_HASH_STYLE = new ZCToStringStyle(SHORT_CLASSNAME + HASHCODE);
	
	/**
	 * Pre-intantiated toStringStyle that output long class name prefix, the
	 * object's system hashcode but no array type.
	 */
	public static final ToStringStyle LONG_WITH_HASH_STYLE = new ZCToStringStyle(LONG_CLASSNAME + HASHCODE);
	
	/**
	 * Pre-intantiated toStringStyle that output short class name prefix, the
	 * object's system hashcode and array type.
	 */
	public static final ToStringStyle SHORT_WITH_HASH_AND_ARRAYTYPE_STYLE = new ZCToStringStyle(
			SHORT_CLASSNAME + HASHCODE + ARRAY_TYPE);
	
	/**
	 * Pre-intantiated toStringStyle that output long class name prefix, the
	 * object's system hashcode and array type.
	 */
	public static final ToStringStyle LONG_WITH_HASH_AND_ARRAYTYPE_STYLE = new ZCToStringStyle(
			LONG_CLASSNAME + HASHCODE + ARRAY_TYPE);

	private static final String COLLECTION = "colln";
	private static final String QUEUE = "queue";
	private static final String ARRAY = "array";
	private static final String LIST = "list";
	private static final String SET = "set";
	private static final String MAP = "map";

	private static final String STRING_START = "\'";
	private static final String STRING_END = STRING_START;

	private static final String CONTENT_START = "{";
	private static final String CONTENT_END = "}";
	private static final String FIELD_SEP = "; ";

	private static final String ARRAY_START = "[";
	private static final String ARRAY_END = "]";
	private static final String ARRAY_SEP = ", ";

	private static final String COLLECTION_START = "( ";
	private static final String COLLECTION_END = " )";
	private static final String COLLECTION_SEP = " : ";

	private static final String KEY_VALUE_SEP = " -> ";

	/**
	 * The detail for array content.
	 */
	private boolean arrayTypeDetail = false;

	/**
	 * Variation of the default style are possible using the following special
	 * characters in the <code>options</code> parameter.
	 * <ul>
	 * <li>'long' keyword in the option string will set the style to output long
	 * classname prefix instead of the default short class name prefix.
	 * <li>a &nbsp;&nbsp;<b><code>@</code></b>&nbsp;&nbsp; character will set the
	 * style to output the object's system hash prefix - nice for debugging
	 * <li>'<>' will set the style to output the array type
	 * </ul>
	 *
	 * @param options
	 *            a string indicating which variations of the default style you
	 *            want.
	 */
	public ZCToStringStyle(String options) {
		super();

		setContentStart(CONTENT_START);
		setContentEnd(CONTENT_END);
		setArrayStart(ARRAY_START);
		setArrayEnd(ARRAY_END);
		setArraySeparator(ARRAY_SEP);
		setFieldSeparator(FIELD_SEP);

		setUseClassName(options.contains(SHORT_CLASSNAME) || options.contains(LONG_CLASSNAME));
		setUseShortClassName(!options.contains(LONG_CLASSNAME));

		setUseIdentityHashCode(options.contains(HASHCODE));
		setArrayContentDetail(true);
		arrayTypeDetail = options.contains(ARRAY_TYPE);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
		if (value instanceof String) {
			appendDetail(buffer, fieldName, (String) value);
		} else {
			super.appendDetail(buffer, fieldName, value);
		}
	}

	protected void appendDetail(StringBuffer buffer, String fieldName, String value) {
		buffer.append(STRING_START).append(value).append(STRING_END);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, boolean[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, char[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, double[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, float[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, long[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, short[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, Object[] array) {
		appendArrayPrefix(buffer, array);
		super.appendDetail(buffer, fieldName, array);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> collection) {
		buffer.append(getCollectionTypeString(collection));
		buffer.append(COLLECTION_START);

		Iterator<?> it = collection.iterator();

		if (it.hasNext()) {
			appendDetail(buffer, fieldName, it.next());

			while (it.hasNext()) {
				buffer.append(COLLECTION_SEP);
				appendDetail(buffer, fieldName, it.next());
			}
		}

		buffer.append(COLLECTION_END);
	}

	@Override
	protected void appendDetail(StringBuffer buffer, String fieldName, Map<?, ?> map) {
		buffer.append(MAP);
		buffer.append(COLLECTION_START);

		Iterator<?> it = map.entrySet().iterator();

		if (it.hasNext()) {
			appendDetail(buffer, fieldName, (Entry<?, ?>) it.next());

			while (it.hasNext()) {
				buffer.append(COLLECTION_SEP);
				appendDetail(buffer, fieldName, (Entry<?, ?>) it.next());
			}
		}

		buffer.append(COLLECTION_END);
	}

	protected void appendDetail(StringBuffer buffer, String fieldName, Map.Entry<?, ?> entry) {
		appendDetail(buffer, fieldName, entry.getKey());
		buffer.append(KEY_VALUE_SEP);
		appendDetail(buffer, fieldName, entry.getValue());
	}

	private String getCollectionTypeString(Collection<?> value) {
		if (value instanceof List) {
			return LIST;
		} else if (value instanceof Set) {
			return SET;
		} else if (value instanceof Queue) {
			return QUEUE;
		} else {
			return COLLECTION;
		}
	}

	@Override
	protected void reflectionAppendArrayDetail(StringBuffer buffer, String fieldName, Object array) {
		appendArrayPrefix(buffer, array);
		super.reflectionAppendArrayDetail(buffer, fieldName, array);
	}

	protected void appendArrayPrefix(StringBuffer buffer, Object array) {
		buffer.append(ARRAY);
		if (arrayTypeDetail)
			buffer.append(getSummaryObjectStartText()).append(getArrayType(array)).append(getSummaryObjectEndText());
	}

	private String getArrayType(Object array) {
		return super.getShortClassName(array.getClass().getComponentType());
	}
}
