package com.koweg.poc.payments.rest.util;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonDateDeserializer extends JsonDeserializer<Date> {

	private static final String DATE_FORMAT = "dd-MM-yyyy";

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec codec = jp.getCodec();
		JsonNode node = codec.readTree(jp);
		String date =  node.get("date").asText();
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
		return DateTime.parse(date, formatter).toDate();
	}

}
