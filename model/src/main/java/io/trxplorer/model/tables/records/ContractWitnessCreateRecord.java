/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.records;


import io.trxplorer.model.tables.ContractWitnessCreate;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;
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
public class ContractWitnessCreateRecord extends UpdatableRecordImpl<ContractWitnessCreateRecord> implements Record5<UInteger, ULong, String, String, ULong> {

    private static final long serialVersionUID = -744481301;

    /**
     * Setter for <code>tmp.contract_witness_create.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>tmp.contract_witness_create.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>tmp.contract_witness_create.owner_id</code>.
     */
    public void setOwnerId(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>tmp.contract_witness_create.owner_id</code>.
     */
    public ULong getOwnerId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>tmp.contract_witness_create.owner_address</code>.
     */
    public void setOwnerAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tmp.contract_witness_create.owner_address</code>.
     */
    public String getOwnerAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tmp.contract_witness_create.url</code>.
     */
    public void setUrl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tmp.contract_witness_create.url</code>.
     */
    public String getUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tmp.contract_witness_create.transaction_id</code>.
     */
    public void setTransactionId(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>tmp.contract_witness_create.transaction_id</code>.
     */
    public ULong getTransactionId() {
        return (ULong) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<UInteger, ULong, String, String, ULong> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<UInteger, ULong, String, String, ULong> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return ContractWitnessCreate.CONTRACT_WITNESS_CREATE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return ContractWitnessCreate.CONTRACT_WITNESS_CREATE.OWNER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ContractWitnessCreate.CONTRACT_WITNESS_CREATE.OWNER_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ContractWitnessCreate.CONTRACT_WITNESS_CREATE.URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return ContractWitnessCreate.CONTRACT_WITNESS_CREATE.TRANSACTION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value2() {
        return getOwnerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getOwnerAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getTransactionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractWitnessCreateRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractWitnessCreateRecord value2(ULong value) {
        setOwnerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractWitnessCreateRecord value3(String value) {
        setOwnerAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractWitnessCreateRecord value4(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractWitnessCreateRecord value5(ULong value) {
        setTransactionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractWitnessCreateRecord values(UInteger value1, ULong value2, String value3, String value4, ULong value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ContractWitnessCreateRecord
     */
    public ContractWitnessCreateRecord() {
        super(ContractWitnessCreate.CONTRACT_WITNESS_CREATE);
    }

    /**
     * Create a detached, initialised ContractWitnessCreateRecord
     */
    public ContractWitnessCreateRecord(UInteger id, ULong ownerId, String ownerAddress, String url, ULong transactionId) {
        super(ContractWitnessCreate.CONTRACT_WITNESS_CREATE);

        set(0, id);
        set(1, ownerId);
        set(2, ownerAddress);
        set(3, url);
        set(4, transactionId);
    }
}
