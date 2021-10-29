/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.maven.example.routines;


import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.codegen.maven.example.Public;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class _StLinecrossingdirection extends AbstractRoutine<Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public._st_linecrossingdirection.RETURN_VALUE</code>.
     */
    public static final Parameter<Integer> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.INTEGER, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> LINE1 = Internal.createParameter("line1", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> LINE2 = Internal.createParameter("line2", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * Create a new routine call instance
     */
    public _StLinecrossingdirection() {
        super("_st_linecrossingdirection", Public.PUBLIC, SQLDataType.INTEGER);

        setReturnParameter(RETURN_VALUE);
        addInParameter(LINE1);
        addInParameter(LINE2);
    }

    /**
     * Set the <code>line1</code> parameter IN value to the routine
     */
    public void setLine1(Object value) {
        setValue(LINE1, value);
    }

    /**
     * Set the <code>line1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setLine1(Field<Object> field) {
        setField(LINE1, field);
    }

    /**
     * Set the <code>line2</code> parameter IN value to the routine
     */
    public void setLine2(Object value) {
        setValue(LINE2, value);
    }

    /**
     * Set the <code>line2</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setLine2(Field<Object> field) {
        setField(LINE2, field);
    }
}
