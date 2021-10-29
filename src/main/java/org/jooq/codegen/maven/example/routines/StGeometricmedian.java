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
public class StGeometricmedian extends AbstractRoutine<Object> {

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
    public static final Parameter<Object> G = Internal.createParameter("g", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""), false, false);

    /**
     * The parameter <code>public.st_geometricmedian.tolerance</code>.
     */
    public static final Parameter<Double> TOLERANCE = Internal.createParameter("tolerance", SQLDataType.DOUBLE.defaultValue(DSL.field("NULL::double precision", SQLDataType.DOUBLE)), true, false);

    /**
     * The parameter <code>public.st_geometricmedian.max_iter</code>.
     */
    public static final Parameter<Integer> MAX_ITER = Internal.createParameter("max_iter", SQLDataType.INTEGER.defaultValue(DSL.field("10000", SQLDataType.INTEGER)), true, false);

    /**
     * The parameter
     * <code>public.st_geometricmedian.fail_if_not_converged</code>.
     */
    public static final Parameter<Boolean> FAIL_IF_NOT_CONVERGED = Internal.createParameter("fail_if_not_converged", SQLDataType.BOOLEAN.defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), true, false);

    /**
     * Create a new routine call instance
     */
    public StGeometricmedian() {
        super("st_geometricmedian", Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""));

        setReturnParameter(RETURN_VALUE);
        addInParameter(G);
        addInParameter(TOLERANCE);
        addInParameter(MAX_ITER);
        addInParameter(FAIL_IF_NOT_CONVERGED);
    }

    /**
     * Set the <code>g</code> parameter IN value to the routine
     */
    public void setG(Object value) {
        setValue(G, value);
    }

    /**
     * Set the <code>g</code> parameter to the function to be used with a {@link
     * org.jooq.Select} statement
     */
    public void setG(Field<Object> field) {
        setField(G, field);
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
     * Set the <code>max_iter</code> parameter IN value to the routine
     */
    public void setMaxIter(Integer value) {
        setValue(MAX_ITER, value);
    }

    /**
     * Set the <code>max_iter</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setMaxIter(Field<Integer> field) {
        setField(MAX_ITER, field);
    }

    /**
     * Set the <code>fail_if_not_converged</code> parameter IN value to the
     * routine
     */
    public void setFailIfNotConverged(Boolean value) {
        setValue(FAIL_IF_NOT_CONVERGED, value);
    }

    /**
     * Set the <code>fail_if_not_converged</code> parameter to the function to
     * be used with a {@link org.jooq.Select} statement
     */
    public void setFailIfNotConverged(Field<Boolean> field) {
        setField(FAIL_IF_NOT_CONVERGED, field);
    }
}
