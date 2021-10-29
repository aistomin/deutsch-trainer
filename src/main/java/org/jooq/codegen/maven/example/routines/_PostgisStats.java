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
public class _PostgisStats extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public._postgis_stats.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * @deprecated Unknown data type. Please define an explicit {@link
     * org.jooq.Binding} to specify how this type should be handled. Deprecation
     * can be turned off using {@literal <deprecationOnUnknownTypes/>} in your
     * code generator configuration.
     */
    @Deprecated
    public static final Parameter<Object> TBL = Internal.createParameter("tbl", org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"regclass\""), false, false);

    /**
     * The parameter <code>public._postgis_stats.att_name</code>.
     */
    public static final Parameter<String> ATT_NAME = Internal.createParameter("att_name", SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>public._postgis_stats._3</code>.
     */
    public static final Parameter<String> _3 = Internal.createParameter("_3", SQLDataType.CLOB.defaultValue(DSL.field("'2'::text", SQLDataType.CLOB)), true, true);

    /**
     * Create a new routine call instance
     */
    public _PostgisStats() {
        super("_postgis_stats", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(TBL);
        addInParameter(ATT_NAME);
        addInParameter(_3);
    }

    /**
     * Set the <code>tbl</code> parameter IN value to the routine
     */
    public void setTbl(Object value) {
        setValue(TBL, value);
    }

    /**
     * Set the <code>tbl</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setTbl(Field<Object> field) {
        setField(TBL, field);
    }

    /**
     * Set the <code>att_name</code> parameter IN value to the routine
     */
    public void setAttName(String value) {
        setValue(ATT_NAME, value);
    }

    /**
     * Set the <code>att_name</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setAttName(Field<String> field) {
        setField(ATT_NAME, field);
    }

    /**
     * Set the <code>_3</code> parameter IN value to the routine
     */
    public void set__3(String value) {
        setValue(_3, value);
    }

    /**
     * Set the <code>_3</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__3(Field<String> field) {
        setField(_3, field);
    }
}
