/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.maven.example.routines;


import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.codegen.maven.example.Public;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * @deprecated Unknown data type. Please define an explicit {@link
 * org.jooq.Binding} to specify how this type should be handled. Deprecation can
 * be turned off using {@literal <deprecationOnUnknownTypes/>} in your code
 * generator configuration.
 */
@Deprecated
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StCurvetoline extends AbstractRoutine<Object> {

    private static final long serialVersionUID = 1L;

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOM = Internal.createParameter("geom", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * The parameter <code>public.st_curvetoline.tol</code>.
     */
    public static final Parameter<Double> TOL = Internal.createParameter("tol", SQLDataType.DOUBLE.defaultValue(DSL.field("32", SQLDataType.DOUBLE)), true, false);

    /**
     * The parameter <code>public.st_curvetoline.toltype</code>.
     */
    public static final Parameter<Integer> TOLTYPE = Internal.createParameter("toltype", SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), true, false);

    /**
     * The parameter <code>public.st_curvetoline.flags</code>.
     */
    public static final Parameter<Integer> FLAGS = Internal.createParameter("flags", SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), true, false);

    /**
     * Create a new routine call instance
     */
    public StCurvetoline() {
        super("st_curvetoline", Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""));

        setReturnParameter(RETURN_VALUE);
        addInParameter(GEOM);
        addInParameter(TOL);
        addInParameter(TOLTYPE);
        addInParameter(FLAGS);
    }

    /**
     * Set the <code>geom</code> parameter IN value to the routine
     */
    public void setGeom(Object value) {
        setValue(GEOM, value);
    }

    /**
     * Set the <code>geom</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setGeom(Field<Object> field) {
        setField(GEOM, field);
    }

    /**
     * Set the <code>tol</code> parameter IN value to the routine
     */
    public void setTol(Double value) {
        setValue(TOL, value);
    }

    /**
     * Set the <code>tol</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setTol(Field<Double> field) {
        setField(TOL, field);
    }

    /**
     * Set the <code>toltype</code> parameter IN value to the routine
     */
    public void setToltype(Integer value) {
        setValue(TOLTYPE, value);
    }

    /**
     * Set the <code>toltype</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setToltype(Field<Integer> field) {
        setField(TOLTYPE, field);
    }

    /**
     * Set the <code>flags</code> parameter IN value to the routine
     */
    public void setFlags(Integer value) {
        setValue(FLAGS, value);
    }

    /**
     * Set the <code>flags</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setFlags(Field<Integer> field) {
        setField(FLAGS, field);
    }
}
