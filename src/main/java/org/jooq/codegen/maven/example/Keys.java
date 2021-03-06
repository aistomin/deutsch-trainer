/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.maven.example;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.codegen.maven.example.tables.DtUser;
import org.jooq.codegen.maven.example.tables.SpatialRefSys;
import org.jooq.codegen.maven.example.tables.records.DtUserRecord;
import org.jooq.codegen.maven.example.tables.records.SpatialRefSysRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DtUserRecord> DT_USER_PK = Internal.createUniqueKey(DtUser.DT_USER, DSL.name("dt_user_pk"), new TableField[] { DtUser.DT_USER.ID }, true);
    public static final UniqueKey<SpatialRefSysRecord> SPATIAL_REF_SYS_PKEY = Internal.createUniqueKey(SpatialRefSys.SPATIAL_REF_SYS, DSL.name("spatial_ref_sys_pkey"), new TableField[] { SpatialRefSys.SPATIAL_REF_SYS.SRID }, true);
}
