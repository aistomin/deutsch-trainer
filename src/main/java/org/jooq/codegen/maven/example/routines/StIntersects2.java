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
public class StIntersects2 extends AbstractRoutine<Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.st_intersects.RETURN_VALUE</code>.
     */
    public static final Parameter<Boolean> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.BOOLEAN, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOG1 = Internal.createParameter("geog1", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geography\""), false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOG2 = Internal.createParameter("geog2", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geography\""), false, false);

    /**
     * Create a new routine call instance
     */
    public StIntersects2() {
        super("st_intersects", Public.PUBLIC, SQLDataType.BOOLEAN);

        setReturnParameter(RETURN_VALUE);
        addInParameter(GEOG1);
        addInParameter(GEOG2);
        setOverloaded(true);
    }

    /**
     * Set the <code>geog1</code> parameter IN value to the routine
     */
    public void setGeog1(Object value) {
        setValue(GEOG1, value);
    }

    /**
     * Set the <code>geog1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setGeog1(Field<Object> field) {
        setField(GEOG1, field);
    }

    /**
     * Set the <code>geog2</code> parameter IN value to the routine
     */
    public void setGeog2(Object value) {
        setValue(GEOG2, value);
    }

    /**
     * Set the <code>geog2</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setGeog2(Field<Object> field) {
        setField(GEOG2, field);
    }
}
