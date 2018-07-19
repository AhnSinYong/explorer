/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.records;


import io.trxplorer.model.tables.Witness;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;
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
public class WitnessRecord extends UpdatableRecordImpl<WitnessRecord> implements Record10<ULong, ULong, String, ULong, ULong, ULong, Long, Byte, ULong, String> {

    private static final long serialVersionUID = 982449005;

    /**
     * Setter for <code>tmp.witness.id</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>tmp.witness.id</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>tmp.witness.vote_count</code>.
     */
    public void setVoteCount(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>tmp.witness.vote_count</code>.
     */
    public ULong getVoteCount() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>tmp.witness.url</code>.
     */
    public void setUrl(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tmp.witness.url</code>.
     */
    public String getUrl() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tmp.witness.total_produced</code>.
     */
    public void setTotalProduced(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>tmp.witness.total_produced</code>.
     */
    public ULong getTotalProduced() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>tmp.witness.total_missed</code>.
     */
    public void setTotalMissed(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>tmp.witness.total_missed</code>.
     */
    public ULong getTotalMissed() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>tmp.witness.latest_block_num</code>.
     */
    public void setLatestBlockNum(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>tmp.witness.latest_block_num</code>.
     */
    public ULong getLatestBlockNum() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>tmp.witness.latest_slot_num</code>.
     */
    public void setLatestSlotNum(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>tmp.witness.latest_slot_num</code>.
     */
    public Long getLatestSlotNum() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>tmp.witness.isJobs</code>.
     */
    public void setIsjobs(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>tmp.witness.isJobs</code>.
     */
    public Byte getIsjobs() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>tmp.witness.account_id</code>.
     */
    public void setAccountId(ULong value) {
        set(8, value);
    }

    /**
     * Getter for <code>tmp.witness.account_id</code>.
     */
    public ULong getAccountId() {
        return (ULong) get(8);
    }

    /**
     * Setter for <code>tmp.witness.address</code>.
     */
    public void setAddress(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>tmp.witness.address</code>.
     */
    public String getAddress() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<ULong, ULong, String, ULong, ULong, ULong, Long, Byte, ULong, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<ULong, ULong, String, ULong, ULong, ULong, Long, Byte, ULong, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return Witness.WITNESS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return Witness.WITNESS.VOTE_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Witness.WITNESS.URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return Witness.WITNESS.TOTAL_PRODUCED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return Witness.WITNESS.TOTAL_MISSED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field6() {
        return Witness.WITNESS.LATEST_BLOCK_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return Witness.WITNESS.LATEST_SLOT_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Witness.WITNESS.ISJOBS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field9() {
        return Witness.WITNESS.ACCOUNT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Witness.WITNESS.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value2() {
        return getVoteCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getTotalProduced();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getTotalMissed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value6() {
        return getLatestBlockNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getLatestSlotNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getIsjobs();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value9() {
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value2(ULong value) {
        setVoteCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value3(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value4(ULong value) {
        setTotalProduced(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value5(ULong value) {
        setTotalMissed(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value6(ULong value) {
        setLatestBlockNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value7(Long value) {
        setLatestSlotNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value8(Byte value) {
        setIsjobs(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value9(ULong value) {
        setAccountId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord value10(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WitnessRecord values(ULong value1, ULong value2, String value3, ULong value4, ULong value5, ULong value6, Long value7, Byte value8, ULong value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WitnessRecord
     */
    public WitnessRecord() {
        super(Witness.WITNESS);
    }

    /**
     * Create a detached, initialised WitnessRecord
     */
    public WitnessRecord(ULong id, ULong voteCount, String url, ULong totalProduced, ULong totalMissed, ULong latestBlockNum, Long latestSlotNum, Byte isjobs, ULong accountId, String address) {
        super(Witness.WITNESS);

        set(0, id);
        set(1, voteCount);
        set(2, url);
        set(3, totalProduced);
        set(4, totalMissed);
        set(5, latestBlockNum);
        set(6, latestSlotNum);
        set(7, isjobs);
        set(8, accountId);
        set(9, address);
    }
}
