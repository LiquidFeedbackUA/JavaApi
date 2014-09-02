package com.github.kindrat.liquidfeedback.api.persistence.types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.joda.time.Period;
import org.postgresql.util.PGInterval;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

public class Interval implements UserType {
    private static final int[] SQL_TYPES = {Types.OTHER};

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return Period.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return !(x == null || y == null) && x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names,
                              SessionImplementor sessionImplementor, Object owner)
            throws HibernateException, SQLException {
        String interval = rs.getString(names[0]);
        if (rs.wasNull() || interval == null) {
            return null;
        }
        PGInterval pgInterval = new PGInterval(interval);
        Date epoch = new Date(0l);
        pgInterval.add(epoch);
        return new Period(epoch.getTime());
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
                            SessionImplementor sessionImplementor) throws HibernateException,
            SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            st.setObject(index, getInterval((Period) value), Types.OTHER);
        }
    }

    private String getInterval(Period period) {
        return new PGInterval(
                period.getYears(),
                period.getMonths(),
                period.getDays(),
                period.getHours(),
                period.getMinutes(),
                period.getSeconds()
        ).getValue();
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

}