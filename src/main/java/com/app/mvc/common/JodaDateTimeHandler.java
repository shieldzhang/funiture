package com.app.mvc.common;import org.apache.ibatis.type.BaseTypeHandler;import org.apache.ibatis.type.JdbcType;import org.apache.ibatis.type.MappedJdbcTypes;import org.joda.time.DateTime;import java.sql.CallableStatement;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.sql.Timestamp;/** * Created by jimin on 16/1/23. */@MappedJdbcTypes({JdbcType.TIMESTAMP})public class JodaDateTimeHandler extends BaseTypeHandler<DateTime>{    @Override    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DateTime dateTime, JdbcType jdbcType) throws SQLException {        if (dateTime != null){            preparedStatement.setObject(i, new Timestamp(dateTime.getMillis()));        }    }    @Override    public DateTime getNullableResult(ResultSet resultSet, String columnName) throws SQLException {        Timestamp timestamp = resultSet.getTimestamp(columnName);        if (timestamp == null) {            return null;        }        return  new DateTime(timestamp.getTime());    }    @Override    public DateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {        Timestamp timestamp = rs.getTimestamp(columnIndex);        if (timestamp == null) {            return null;        }        return  new DateTime(timestamp.getTime());    }    @Override    public DateTime getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {        Timestamp timestamp = callableStatement.getTimestamp(columnIndex);        if (timestamp == null) {            return null;        }        return new DateTime(timestamp.getTime());    }}