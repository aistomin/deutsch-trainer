/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.maven.example.tables;


import java.util.Arrays;
import java.util.List;
import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.codegen.maven.example.Keys;
import org.jooq.codegen.maven.example.Public;
import org.jooq.codegen.maven.example.tables.records.SpatialRefSysRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SpatialRefSys extends TableImpl<SpatialRefSysRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.spatial_ref_sys</code>
     */
    public static final SpatialRefSys SPATIAL_REF_SYS = new SpatialRefSys();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SpatialRefSysRecord> getRecordType() {
        return SpatialRefSysRecord.class;
    }

    /**
     * The column <code>public.spatial_ref_sys.srid</code>.
     */
    public final TableField<SpatialRefSysRecord, Integer> SRID = createField(DSL.name("srid"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.spatial_ref_sys.auth_name</code>.
     */
    public final TableField<SpatialRefSysRecord, String> AUTH_NAME = createField(DSL.name("auth_name"), SQLDataType.VARCHAR(256), this, "");

    /**
     * The column <code>public.spatial_ref_sys.auth_srid</code>.
     */
    public final TableField<SpatialRefSysRecord, Integer> AUTH_SRID = createField(DSL.name("auth_srid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.spatial_ref_sys.srtext</code>.
     */
    public final TableField<SpatialRefSysRecord, String> SRTEXT = createField(DSL.name("srtext"), SQLDataType.VARCHAR(2048), this, "");

    /**
     * The column <code>public.spatial_ref_sys.proj4text</code>.
     */
    public final TableField<SpatialRefSysRecord, String> PROJ4TEXT = createField(DSL.name("proj4text"), SQLDataType.VARCHAR(2048), this, "");

    private SpatialRefSys(Name alias, Table<SpatialRefSysRecord> aliased) {
        this(alias, aliased, null);
    }

    private SpatialRefSys(Name alias, Table<SpatialRefSysRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.spatial_ref_sys</code> table reference
     */
    public SpatialRefSys(String alias) {
        this(DSL.name(alias), SPATIAL_REF_SYS);
    }

    /**
     * Create an aliased <code>public.spatial_ref_sys</code> table reference
     */
    public SpatialRefSys(Name alias) {
        this(alias, SPATIAL_REF_SYS);
    }

    /**
     * Create a <code>public.spatial_ref_sys</code> table reference
     */
    public SpatialRefSys() {
        this(DSL.name("spatial_ref_sys"), null);
    }

    public <O extends Record> SpatialRefSys(Table<O> child, ForeignKey<O, SpatialRefSysRecord> key) {
        super(child, key, SPATIAL_REF_SYS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<SpatialRefSysRecord> getPrimaryKey() {
        return Keys.SPATIAL_REF_SYS_PKEY;
    }

    @Override
    public List<Check<SpatialRefSysRecord>> getChecks() {
        return Arrays.asList(
            Internal.createCheck(this, DSL.name("spatial_ref_sys_srid_check"), "(((srid > 0) AND (srid <= 998999)))", true)
        );
    }

    @Override
    public SpatialRefSys as(String alias) {
        return new SpatialRefSys(DSL.name(alias), this);
    }

    @Override
    public SpatialRefSys as(Name alias) {
        return new SpatialRefSys(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SpatialRefSys rename(String name) {
        return new SpatialRefSys(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SpatialRefSys rename(Name name) {
        return new SpatialRefSys(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
