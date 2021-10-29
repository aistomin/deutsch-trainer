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
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StGeohash2 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.st_geohash.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOG = Internal.createParameter("geog", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geography\""), false, false);

    /**
     * The parameter <code>public.st_geohash.maxchars</code>.
     */
    public static final Parameter<Integer> MAXCHARS = Internal.createParameter("maxchars", SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), true, false);

    /**
     * Create a new routine call instance
     */
    public StGeohash2() {
        super("st_geohash", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(GEOG);
        addInParameter(MAXCHARS);
        setOverloaded(true);
    }

    /**
     * Set the <code>geog</code> parameter IN value to the routine
     */
    public void setGeog(Object value) {
        setValue(GEOG, value);
    }

    /**
     * Set the <code>geog</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setGeog(Field<Object> field) {
        setField(GEOG, field);
    }

    /**
     * Set the <code>maxchars</code> parameter IN value to the routine
     */
    public void setMaxchars(Integer value) {
        setValue(MAXCHARS, value);
    }

    /**
     * Set the <code>maxchars</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setMaxchars(Field<Integer> field) {
        setField(MAXCHARS, field);
    }
}