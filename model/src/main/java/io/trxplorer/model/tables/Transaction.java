/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables;


import io.trxplorer.model.Keys;
import io.trxplorer.model.Tmp;
import io.trxplorer.model.tables.records.TransactionRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Transaction extends TableImpl<TransactionRecord> {

    private static final long serialVersionUID = 1034334417;

    /**
     * The reference instance of <code>tmp.transaction</code>
     */
    public static final Transaction TRANSACTION = new Transaction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TransactionRecord> getRecordType() {
        return TransactionRecord.class;
    }

    /**
     * The column <code>tmp.transaction.id</code>.
     */
    public final TableField<TransactionRecord, ULong> ID = createField("id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>tmp.transaction.hash</code>.
     */
    public final TableField<TransactionRecord, String> HASH = createField("hash", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

    /**
     * The column <code>tmp.transaction.timestamp</code>.
     */
    public final TableField<TransactionRecord, Timestamp> TIMESTAMP = createField("timestamp", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>tmp.transaction.expiration</code>.
     */
    public final TableField<TransactionRecord, Timestamp> EXPIRATION = createField("expiration", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>tmp.transaction.confirmed</code>.
     */
    public final TableField<TransactionRecord, Byte> CONFIRMED = createField("confirmed", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>tmp.transaction.block_id</code>.
     */
    public final TableField<TransactionRecord, ULong> BLOCK_ID = createField("block_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>tmp.transaction</code> table reference
     */
    public Transaction() {
        this("transaction", null);
    }

    /**
     * Create an aliased <code>tmp.transaction</code> table reference
     */
    public Transaction(String alias) {
        this(alias, TRANSACTION);
    }

    private Transaction(String alias, Table<TransactionRecord> aliased) {
        this(alias, aliased, null);
    }

    private Transaction(String alias, Table<TransactionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Tmp.TMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TransactionRecord, ULong> getIdentity() {
        return Keys.IDENTITY_TRANSACTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TransactionRecord> getPrimaryKey() {
        return Keys.KEY_TRANSACTION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TransactionRecord>> getKeys() {
        return Arrays.<UniqueKey<TransactionRecord>>asList(Keys.KEY_TRANSACTION_PRIMARY, Keys.KEY_TRANSACTION_HASH_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TransactionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TransactionRecord, ?>>asList(Keys.FK_TRANSACTION_BLOCK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transaction as(String alias) {
        return new Transaction(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Transaction rename(String name) {
        return new Transaction(name, null);
    }
}