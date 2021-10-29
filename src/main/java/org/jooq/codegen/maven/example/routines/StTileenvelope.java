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
public class StTileenvelope extends AbstractRoutine<Object> {

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
     * The parameter <code>public.st_tileenvelope.zoom</code>.
     */
    public static final Parameter<Integer> ZOOM = Internal.createParameter("zoom", SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>public.st_tileenvelope.x</code>.
     */
    public static final Parameter<Integer> X = Internal.createParameter("x", SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>public.st_tileenvelope.y</code>.
     */
    public static final Parameter<Integer> Y = Internal.createParameter("y", SQLDataType.INTEGER, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> BOUNDS = Internal.createParameter("bounds", org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\"").defaultValue(DSL.field("'0102000020110F00000200000052107C45F81B73C152107C45F81B73C152107C45F81B734152107C45F81B7341'::geometry", SQLDataType.OTHER)), true, false);

    /**
     * Create a new routine call instance
     */
    public StTileenvelope() {
        super("st_tileenvelope", Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("\"public\".\"geometry\""));

        setReturnParameter(RETURN_VALUE);
        addInParameter(ZOOM);
        addInParameter(X);
        addInParameter(Y);
        addInParameter(BOUNDS);
    }

    /**
     * Set the <code>zoom</code> parameter IN value to the routine
     */
    public void setZoom(Integer value) {
        setValue(ZOOM, value);
    }

    /**
     * Set the <code>zoom</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setZoom(Field<Integer> field) {
        setField(ZOOM, field);
    }

    /**
     * Set the <code>x</code> parameter IN value to the routine
     */
    public void setX(Integer value) {
        setValue(X, value);
    }

    /**
     * Set the <code>x</code> parameter to the function to be used with a {@link
     * org.jooq.Select} statement
     */
    public void setX(Field<Integer> field) {
        setField(X, field);
    }

    /**
     * Set the <code>y</code> parameter IN value to the routine
     */
    public void setY(Integer value) {
        setValue(Y, value);
    }

    /**
     * Set the <code>y</code> parameter to the function to be used with a {@link
     * org.jooq.Select} statement
     */
    public void setY(Field<Integer> field) {
        setField(Y, field);
    }

    /**
     * Set the <code>bounds</code> parameter IN value to the routine
     */
    public void setBounds(Object value) {
        setValue(BOUNDS, value);
    }

    /**
     * Set the <code>bounds</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setBounds(Field<Object> field) {
        setField(BOUNDS, field);
    }
}