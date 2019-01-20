package com.piterskikh.jpa.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MonetaryAmountUserType implements CompositeUserType, DynamicParameterizedType {

    private Currency onvertTo;

    @Override
    public void setParameterValues(Properties properties) {

    }

    @Override
    public String[] getPropertyNames() {
        return new String[0];
    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[0];
    }

    @Override
    public Object getPropertyValue(Object o, int i) throws HibernateException {
        return null;
    }

    @Override
    public void setPropertyValue(Object o, int i, Object o1) throws HibernateException {

    }

    @Override
    public Class returnedClass() {
        return MonetaryAmount.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y || !(x == null || y == null) && x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {

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
    public Serializable disassemble(Object value, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return value.toString();
    }

    @Override
    public Object assemble(Serializable cashed, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws HibernateException {
        return MonetaryAmount.fromString((String)cashed);
    }

    @Override
    public Object replace(Object original, Object target, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws HibernateException {
        return original;
    }


}
