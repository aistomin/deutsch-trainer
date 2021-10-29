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
 * @deprecated Unknown data type. Please define an explicit {@link
 * org.jooq.Binding} to specify how this type should be handled. Deprecation can
 * be turned off using {@literal <deprecationOnUnknownTypes/>} in your code
 * generator configuration.
 */
@Deprecated
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StGeneratepoints2 extends AbstractRoutine<Object> {

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
    public static final Parameter<Object> AREA = Internal.createParameter("area", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * The parameter <code>public.st_generatepoints.npoints</code>.
     */
    public static final Parameter<Integer> NPOINTS = Internal.createParameter("npoints", SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>public.st_generatepoints.seed</code>.
     */
    public static final Parameter<Integer> SEED = Internal.createParameter("seed", SQLDataType.INTEGER, false, false);

    /**
     * Create a new routine call instance
     */
    public StGeneratepoints2() {
        super("st_generatepoints", Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""));

        setReturnParameter(RETURN_VALUE);
        addInParameter(AREA);
        addInParameter(NPOINTS);
        addInParameter(SEED);
        setOverloaded(true);
    }

    /**
     * Set the <code>area</code> parameter IN value to the routine
     */
    public void setArea(Object value) {
        setValue(AREA, value);
    }

    /**
     * Set the <code>area</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setArea(Field<Object> field) {
        setField(AREA, field);
    }

    /**
     * Set the <code>npoints</code> parameter IN value to the routine
     */
    public void setNpoints(Integer value) {
        setValue(NPOINTS, value);
    }

    /**
     * Set the <code>npoints</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setNpoints(Field<Integer> field) {
        setField(NPOINTS, field);
    }

    /**
     * Set the <code>seed</code> parameter IN value to the routine
     */
    public void setSeed(Integer value) {
        setValue(SEED, value);
    }

    /**
     * Set the <code>seed</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setSeed(Field<Integer> field) {
        setField(SEED, field);
    }
}
