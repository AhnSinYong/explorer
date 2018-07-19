/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.daos;


import io.trxplorer.model.tables.ContractVoteAssetVote;
import io.trxplorer.model.tables.records.ContractVoteAssetVoteRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
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
public class ContractVoteAssetVoteDao extends DAOImpl<ContractVoteAssetVoteRecord, io.trxplorer.model.tables.pojos.ContractVoteAssetVote, ULong> {

    /**
     * Create a new ContractVoteAssetVoteDao without any configuration
     */
    public ContractVoteAssetVoteDao() {
        super(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE, io.trxplorer.model.tables.pojos.ContractVoteAssetVote.class);
    }

    /**
     * Create a new ContractVoteAssetVoteDao with an attached configuration
     */
    public ContractVoteAssetVoteDao(Configuration configuration) {
        super(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE, io.trxplorer.model.tables.pojos.ContractVoteAssetVote.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ULong getId(io.trxplorer.model.tables.pojos.ContractVoteAssetVote object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractVoteAssetVote> fetchById(ULong... values) {
        return fetch(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public io.trxplorer.model.tables.pojos.ContractVoteAssetVote fetchOneById(ULong value) {
        return fetchOne(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE.ID, value);
    }

    /**
     * Fetch records that have <code>owner_id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractVoteAssetVote> fetchByOwnerId(ULong... values) {
        return fetch(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE.OWNER_ID, values);
    }

    /**
     * Fetch records that have <code>owner_address IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractVoteAssetVote> fetchByOwnerAddress(String... values) {
        return fetch(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE.OWNER_ADDRESS, values);
    }

    /**
     * Fetch records that have <code>vote_asset_id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractVoteAssetVote> fetchByVoteAssetId(ULong... values) {
        return fetch(ContractVoteAssetVote.CONTRACT_VOTE_ASSET_VOTE.VOTE_ASSET_ID, values);
    }
}