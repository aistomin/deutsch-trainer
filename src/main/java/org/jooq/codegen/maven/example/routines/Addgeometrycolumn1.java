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
public class Addgeometrycolumn1 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.addgeometrycolumn.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.catalog_name</code>.
     */
    public static final Parameter<String> CATALOG_NAME = Internal.createParameter("catalog_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.schema_name</code>.
     */
    public static final Parameter<String> SCHEMA_NAME = Internal.createParameter("schema_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.table_name</code>.
     */
    public static final Parameter<String> TABLE_NAME = Internal.createParameter("table_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.column_name</code>.
     */
    public static final Parameter<String> COLUMN_NAME = Internal.createParameter("column_name", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.new_srid_in</code>.
     */
    public static final Parameter<Integer> NEW_SRID_IN = Internal.createParameter("new_srid_in", SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.new_type</code>.
     */
    public static final Parameter<String> NEW_TYPE = Internal.createParameter("new_type", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.new_dim</code>.
     */
    public static final Parameter<Integer> NEW_DIM = Internal.createParameter("new_dim", SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>public.addgeometrycolumn.use_typmod</code>.
     */
    public static final Parameter<Boolean> USE_TYPMOD = Internal.createParameter("use_typmod", SQLDataType.BOOLEAN.defaultValue(DSL.field("true", SQLDataType.BOOLEAN)), true, false);

    /**
     * Create a new routine call instance
     */
    public Addgeometrycolumn1() {
        super("addgeometrycolumn", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(CATALOG_NAME);
        addInParameter(SCHEMA_NAME);
        addInParameter(TABLE_NAME);
        addInParameter(COLUMN_NAME);
        addInParameter(NEW_SRID_IN);
        addInParameter(NEW_TYPE);
        addInParameter(NEW_DIM);
        addInParameter(USE_TYPMOD);
        setOverloaded(true);
    }

    /**
     * Set the <code>catalog_name</code> parameter IN value to the routine
     */
    public void setCatalogName(String value) {
        setValue(CATALOG_NAME, value);
    }

    /**
     * Set the <code>catalog_name</code> parameter to the function to be used
     * with a {@link org.jooq.Select} statement
     */
    public void setCatalogName(Field<String> field) {
        setField(CATALOG_NAME, field);
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

    /**
     * Set the <code>new_srid_in</code> parameter IN value to the routine
     */
    public void setNewSridIn(Integer value) {
        setValue(NEW_SRID_IN, value);
    }

    /**
     * Set the <code>new_srid_in</code> parameter to the function to be used
     * with a {@link org.jooq.Select} statement
     */
    public void setNewSridIn(Field<Integer> field) {
        setField(NEW_SRID_IN, field);
    }

    /**
     * Set the <code>new_type</code> parameter IN value to the routine
     */
    public void setNewType(String value) {
        setValue(NEW_TYPE, value);
    }

    /**
     * Set the <code>new_type</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setNewType(Field<String> field) {
        setField(NEW_TYPE, field);
    }

    /**
     * Set the <code>new_dim</code> parameter IN value to the routine
     */
    public void setNewDim(Integer value) {
        setValue(NEW_DIM, value);
    }

    /**
     * Set the <code>new_dim</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void setNewDim(Field<Integer> field) {
        setField(NEW_DIM, field);
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
