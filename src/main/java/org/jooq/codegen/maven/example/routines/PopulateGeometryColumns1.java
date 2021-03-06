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
public class PopulateGeometryColumns1 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.populate_geometry_columns.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>public.populate_geometry_columns.use_typmod</code>.
     */
    public static final Parameter<Boolean> USE_TYPMOD = Internal.createParameter("use_typmod", SQLDataType.BOOLEAN.defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), true, false);

    /**
     * Create a new routine call instance
     */
    public PopulateGeometryColumns1() {
        super("populate_geometry_columns", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(USE_TYPMOD);
        setOverloaded(true);
    }

    /**
     * Set the <code>use_typmod</code> parameter IN value to the routine
     */
    public void setUseTypmod(Boolean value) {
        setValue(USE_TYPMOD, value);
    }

    /**
     * Set the <code>use_typmod</code> parameter to the function to be used with
     * a {@link org.jooq.Select} statement
     */
    public void setUseTypmod(Field<Boolean> field) {
        setField(USE_TYPMOD, field);
    }
}
