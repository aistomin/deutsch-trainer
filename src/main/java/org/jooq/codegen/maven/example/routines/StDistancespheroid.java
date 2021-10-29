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
public class StDistancespheroid extends AbstractRoutine<Double> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.st_distancespheroid.RETURN_VALUE</code>.
     */
    public static final Parameter<Double> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.DOUBLE, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOM1 = Internal.createParameter("geom1", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOM2 = Internal.createParameter("geom2", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> _3 = Internal.createParameter("_3", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"spheroid\""), false, true);

    /**
     * Create a new routine call instance
     */
    public StDistancespheroid() {
        super("st_distancespheroid", Public.PUBLIC, SQLDataType.DOUBLE);

        setReturnParameter(RETURN_VALUE);
        addInParameter(GEOM1);
        addInParameter(GEOM2);
        addInParameter(_3);
    }

    /**
     * Set the <code>geom1</code> parameter IN value to the routine
     */
    public void setGeom1(Object value) {
        setValue(GEOM1, value);
    }

    /**
     * Set the <code>geom1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setGeom1(Field<Object> field) {
        setField(GEOM1, field);
    }

    /**
     * Set the <code>geom2</code> parameter IN value to the routine
     */
    public void setGeom2(Object value) {
        setValue(GEOM2, value);
    }

    /**
     * Set the <code>geom2</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setGeom2(Field<Object> field) {
        setField(GEOM2, field);
    }

    /**
     * Set the <code>_3</code> parameter IN value to the routine
     */
    public void set__3(Object value) {
        setValue(_3, value);
    }

    /**
     * Set the <code>_3</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__3(Field<Object> field) {
        setField(_3, field);
    }
}
