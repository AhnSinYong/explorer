/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.records;


import io.trxplorer.model.tables.ContractVoteWitnessVote;

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
public class ContractVoteWitnessVoteRecord extends UpdatableRecordImpl<ContractVoteWitnessVoteRecord> implements Record5<ULong, ULong, String, ULong, ULong> {

    private static final long serialVersionUID = -577243882;

    /**
     * Setter for <code>tmp.contract_vote_witness_vote.id</code>.
     */
    public void setId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>tmp.contract_vote_witness_vote.id</code>.
     */
    public ULong getId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>tmp.contract_vote_witness_vote.owner_id</code>.
     */
    public void setOwnerId(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>tmp.contract_vote_witness_vote.owner_id</code>.
     */
    public ULong getOwnerId() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>tmp.contract_vote_witness_vote.owner_address</code>.
     */
    public void setOwnerAddress(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tmp.contract_vote_witness_vote.owner_address</code>.
     */
    public String getOwnerAddress() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tmp.contract_vote_witness_vote.vote_count</code>.
     */
    public void setVoteCount(ULong value) {
        set(3, value);
    }

    /**
     * Getter for <code>tmp.contract_vote_witness_vote.vote_count</code>.
     */
    public ULong getVoteCount() {
        return (ULong) get(3);
    }

    /**
     * Setter for <code>tmp.contract_vote_witness_vote.vote_witness_id</code>.
     */
    public void setVoteWitnessId(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>tmp.contract_vote_witness_vote.vote_witness_id</code>.
     */
    public ULong getVoteWitnessId() {
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
    public Row5<ULong, ULong, String, ULong, ULong> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<ULong, ULong, String, ULong, ULong> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE.OWNER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE.OWNER_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field4() {
        return ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE.VOTE_COUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field5() {
        return ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE.VOTE_WITNESS_ID;
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
    public ULong value4() {
        return getVoteCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value5() {
        return getVoteWitnessId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractVoteWitnessVoteRecord value1(ULong value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractVoteWitnessVoteRecord value2(ULong value) {
        setOwnerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractVoteWitnessVoteRecord value3(String value) {
        setOwnerAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractVoteWitnessVoteRecord value4(ULong value) {
        setVoteCount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractVoteWitnessVoteRecord value5(ULong value) {
        setVoteWitnessId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractVoteWitnessVoteRecord values(ULong value1, ULong value2, String value3, ULong value4, ULong value5) {
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
     * Create a detached ContractVoteWitnessVoteRecord
     */
    public ContractVoteWitnessVoteRecord() {
        super(ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE);
    }

    /**
     * Create a detached, initialised ContractVoteWitnessVoteRecord
     */
    public ContractVoteWitnessVoteRecord(ULong id, ULong ownerId, String ownerAddress, ULong voteCount, ULong voteWitnessId) {
        super(ContractVoteWitnessVote.CONTRACT_VOTE_WITNESS_VOTE);

        set(0, id);
        set(1, ownerId);
        set(2, ownerAddress);
        set(3, voteCount);
        set(4, voteWitnessId);
    }
}
