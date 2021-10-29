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
public class StArea2 extends AbstractRoutine<Double> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.st_area.RETURN_VALUE</code>.
     */
    public static final Parameter<Double> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.DOUBLE, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> GEOG = Internal.createParameter("geog", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geography\""), false, false);

    /**
     * The parameter <code>public.st_area.use_spheroid</code>.
     */
    public static final Parameter<Boolean> USE_SPHEROID = Internal.createParameter("use_spheroid", SQLDataType.BOOLEAN.defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), true, false);

    /**
     * Create a new routine call instance
     */
    public StArea2() {
        super("st_area", Public.PUBLIC, SQLDataType.DOUBLE);

        setReturnParameter(RETURN_VALUE);
        addInParameter(GEOG);
        addInParameter(USE_SPHEROID);
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
     * Set the <code>use_spheroid</code> parameter IN value to the routine
     */
    public void setUseSpheroid(Boolean value) {
        setValue(USE_SPHEROID, value);
    }

    /**
     * Set the <code>use_spheroid</code> parameter to the function to be used
     * with a {@link org.jooq.Select} statement
     */
    public void setUseSpheroid(Field<Boolean> field) {
        setField(USE_SPHEROID, field);
    }
}