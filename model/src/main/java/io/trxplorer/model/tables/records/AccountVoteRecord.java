/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.records;


import io.trxplorer.model.tables.AccountVote;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class AccountVoteRecord extends UpdatableRecordImpl<AccountVoteRecord> implements Record5<ULong, String, ULong, ULong, ULong> {

    private static final long serialVersionUID = -2073561057;

    /**
     * Setter for <code>tmp.account_vote.id</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>tmp.account_vote.id</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>tmp.account_vote.vote_address</code>.
     */
    public void setVoteAddress(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tmp.account_vote.vote_address</code>.
     */
    public String getVoteAddress() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tmp.account_vote.vote_account_id</code>.
     */
    public void setVoteAccountId(ULong value) {
        set(2, value);
    }

    /**
     * Getter for <code>tmp.account_vote.vote_account_id</code>.
     */
    public ULong getVoteAccountId() {
        return (ULong) get(2);
    }

    /**
     * Setter for <code>tmp.account_vote.vote_count</code>.
     */
    public void setVoteCount(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>tmp.account_vote.vote_count</code>.
     */
    public ULong getVoteCount() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>tmp.account_vote.account_id</code>.
     */
    public void setAccountId(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>tmp.account_vote.account_id</code>.
     */
    public ULong getAccountId() {
        return (ULong) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<ULong, String, ULong, ULong, ULong> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<ULong, String, ULong, ULong, ULong> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return AccountVote.ACCOUNT_VOTE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return AccountVote.ACCOUNT_VOTE.VOTE_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field3() {
        return AccountVote.ACCOUNT_VOTE.VOTE_ACCOUNT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return AccountVote.ACCOUNT_VOTE.VOTE_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return AccountVote.ACCOUNT_VOTE.ACCOUNT_ID;
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
    public String value2() {
        return getVoteAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value3() {
        return getVoteAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value4() {
        return getVoteCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVoteRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVoteRecord value2(String value) {
        setVoteAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVoteRecord value3(ULong value) {
        setVoteAccountId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVoteRecord value4(ULong value) {
        setVoteCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVoteRecord value5(ULong value) {
        setAccountId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVoteRecord values(ULong value1, String value2, ULong value3, ULong value4, ULong value5) {
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
     * Create a detached AccountVoteRecord
     */
    public AccountVoteRecord() {
        super(AccountVote.ACCOUNT_VOTE);
    }

    /**
     * Create a detached, initialised AccountVoteRecord
     */
    public AccountVoteRecord(ULong id, String voteAddress, ULong voteAccountId, ULong voteCount, ULong accountId) {
        super(AccountVote.ACCOUNT_VOTE);

        set(0, id);
        set(1, voteAddress);
        set(2, voteAccountId);
        set(3, voteCount);
        set(4, accountId);
    }
}