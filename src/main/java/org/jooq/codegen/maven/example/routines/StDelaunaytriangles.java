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
public class StDelaunaytriangles extends AbstractRoutine<Object> {

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
    public static final Parameter<Object> G1 = Internal.createParameter("g1", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * The parameter <code>public.st_delaunaytriangles.tolerance</code>.
     */
    public static final Parameter<Double> TOLERANCE = Internal.createParameter("tolerance", SQLDataType.DOUBLE.defaultValue(DSL.field("0.0", SQLDataType.DOUBLE)), true, false);

    /**
     * The parameter <code>public.st_delaunaytriangles.flags</code>.
     */
    public static final Parameter<Integer> FLAGS = Internal.createParameter("flags", SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), true, false);

    /**
     * Create a new routine call instance
     */
    public StDelaunaytriangles() {
        super("st_delaunaytriangles", Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""));

        setReturnParameter(RETURN_VALUE);
        addInParameter(G1);
        addInParameter(TOLERANCE);
        addInParameter(FLAGS);
    }

    /**
     * Set the <code>g1</code> parameter IN value to the routine
     */
    public void setG1(Object value) {
        setValue(G1, value);
    }

    /**
     * Set the <code>g1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setG1(Field<Object> field) {
        setField(G1, field);
    }

    /**
     * Set the <code>tolerance</code> parameter IN value to the routine
     */
    public void setTolerance(Double value) {
        setValue(TOLERANCE, value);
    }

    /**
     * Set the <code>tolerance</code> parameter to the function to be used with
     * a {@link org.jooq.Select} statement
     */
    public void setTolerance(Field<Double> field) {
        setField(TOLERANCE, field);
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
