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
public class Updategeometrysrid3 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.updategeometrysrid.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>public.updategeometrysrid._1</code>.
     */
    public static final Parameter<String> _1 = Internal.createParameter("_1", SQLDataType.VARCHAR, false, true);

    /**
     * The parameter <code>public.updategeometrysrid._2</code>.
     */
    public static final Parameter<String> _2 = Internal.createParameter("_2", SQLDataType.VARCHAR, false, true);

    /**
     * The parameter <code>public.updategeometrysrid._3</code>.
     */
    public static final Parameter<Integer> _3 = Internal.createParameter("_3", SQLDataType.INTEGER, false, true);

    /**
     * Create a new routine call instance
     */
    public Updategeometrysrid3() {
        super("updategeometrysrid", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(_1);
        addInParameter(_2);
        addInParameter(_3);
        setOverloaded(true);
    }

    /**
     * Set the <code>_1</code> parameter IN value to the routine
     */
    public void set__1(String value) {
        setValue(_1, value);
    }

    /**
     * Set the <code>_1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__1(Field<String> field) {
        setField(_1, field);
    }

    /**
     * Set the <code>_2</code> parameter IN value to the routine
     */
    public void set__2(String value) {
        setValue(_2, value);
    }

    /**
     * Set the <code>_2</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__2(Field<String> field) {
        setField(_2, field);
    }

    /**
     * Set the <code>_3</code> parameter IN value to the routine
     */
    public void set__3(Integer value) {
        setValue(_3, value);
    }

    /**
     * Set the <code>_3</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__3(Field<Integer> field) {
        setField(_3, field);
    }
}
