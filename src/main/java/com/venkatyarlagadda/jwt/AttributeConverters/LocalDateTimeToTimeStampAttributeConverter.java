package com.venkatyarlagadda.jwt.AttributeConverters;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

import com.venkatyarlagadda.jwt.utils.DateUtils;

public class LocalDateTimeToTimeStampAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		return localDateTime == null ? null : Timestamp.valueOf(DateUtils.toUtc(localDateTime));
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
		return timestamp == null ? null : DateUtils.toLocalZone(timestamp.toLocalDateTime());
	}
}