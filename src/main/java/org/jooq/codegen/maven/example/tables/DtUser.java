/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.maven.example.tables;


import java.util.Arrays;
import java.util.List;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.codegen.maven.example.Indexes;
import org.jooq.codegen.maven.example.Keys;
import org.jooq.codegen.maven.example.Public;
import org.jooq.codegen.maven.example.tables.records.DtUserRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DtUser extends TableImpl<DtUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.dt_user</code>
     */
    public static final DtUser DT_USER = new DtUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DtUserRecord> getRecordType() {
        return DtUserRecord.class;
    }

    /**
     * The column <code>public.dt_user.id</code>.
     */
    public final TableField<DtUserRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.dt_user.username</code>.
     */
    public final TableField<DtUserRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.dt_user.password</code>.
     */
    public final TableField<DtUserRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255), this, "");

    private DtUser(Name alias, Table<DtUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private DtUser(Name alias, Table<DtUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.dt_user</code> table reference
     */
    public DtUser(String alias) {
        this(DSL.name(alias), DT_USER);
    }

    /**
     * Create an aliased <code>public.dt_user</code> table reference
     */
    public DtUser(Name alias) {
        this(alias, DT_USER);
    }

    /**
     * Create a <code>public.dt_user</code> table reference
     */
    public DtUser() {
        this(DSL.name("dt_user"), null);
    }

    public <O extends Record> DtUser(Table<O> child, ForeignKey<O, DtUserRecord> key) {
        super(child, key, DT_USER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.DT_USER_ID_UINDEX, Indexes.DT_USER_USERNAME_UINDEX);
    }

    @Override
    public Identity<DtUserRecord, Long> getIdentity() {
        return (Identity<DtUserRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<DtUserRecord> getPrimaryKey() {
        return Keys.DT_USER_PK;
    }

    @Override
    public DtUser as(String alias) {
        return new DtUser(DSL.name(alias), this);
    }

    @Override
    public DtUser as(Name alias) {
        return new DtUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DtUser rename(String name) {
        return new DtUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DtUser rename(Name name) {
        return new DtUser(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}