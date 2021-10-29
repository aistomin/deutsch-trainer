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
public class Dropgeometrycolumn2 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.dropgeometrycolumn.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>public.dropgeometrycolumn.schema_name</code>.
     */
    public static final Parameter<String> SCHEMA_NAME = Internal.createParameter("schema_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.dropgeometrycolumn.table_name</code>.
     */
    public static final Parameter<String> TABLE_NAME = Internal.createParameter("table_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.dropgeometrycolumn.column_name</code>.
     */
    public static final Parameter<String> COLUMN_NAME = Internal.createParameter("column_name", SQLDataType.VARCHAR, false, false);

    /**
     * Create a new routine call instance
     */
    public Dropgeometrycolumn2() {
        super("dropgeometrycolumn", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(SCHEMA_NAME);
        addInParameter(TABLE_NAME);
        addInParameter(COLUMN_NAME);
        setOverloaded(true);
    }

    /**
     * Set the <code>schema_name</code> parameter IN value to the routine
     */
    public void setSchemaName(String value) {
        setValue(SCHEMA_NAME, value);
    }

    /**
     * Set the <code>schema_name</code> parameter to the function to be used
     * with a {@link org.jooq.Select} statement
     */
    public void setSchemaName(Field<String> field) {
        setField(SCHEMA_NAME, field);
    }

    /**
     * Set the <code>table_name</code> parameter IN value to the routine
     */
    public void setTableName(String value) {
        setValue(TABLE_NAME, value);
    }

    /**
     * Set the <code>table_name</code> parameter to the function to be used with
     * a {@link org.jooq.Select} statement
     */
    public void setTableName(Field<String> field) {
        setField(TABLE_NAME, field);
    }

    /**
     * Set the <code>column_name</code> parameter IN value to the routine
     */
    public void setColumnName(String value) {
        setValue(COLUMN_NAME, value);
    }

    /**
     * Set the <code>column_name</code> parameter to the function to be used
     * with a {@link org.jooq.Select} statement
     */
    public void setColumnName(Field<String> field) {
        setField(COLUMN_NAME, field);
    }
}
