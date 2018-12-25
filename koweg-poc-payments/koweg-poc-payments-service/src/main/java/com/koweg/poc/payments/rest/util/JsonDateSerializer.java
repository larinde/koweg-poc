/**
 *
 */
package com.koweg.poc.payments.rest.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author larinde
 *
 */
public class JsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(final Date date, final JsonGenerator jgen, final SerializerProvider provider) throws IOException, JsonProcessingException {
		final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		jgen.writeString(dateFormat.format(date));
	}

}
