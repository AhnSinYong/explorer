/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.daos;


import io.trxplorer.model.tables.ContractTransferAsset;
import io.trxplorer.model.tables.records.ContractTransferAssetRecord;

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
public class ContractTransferAssetDao extends DAOImpl<ContractTransferAssetRecord, io.trxplorer.model.tables.pojos.ContractTransferAsset, ULong> {

    /**
     * Create a new ContractTransferAssetDao without any configuration
     */
    public ContractTransferAssetDao() {
        super(ContractTransferAsset.CONTRACT_TRANSFER_ASSET, io.trxplorer.model.tables.pojos.ContractTransferAsset.class);
    }

    /**
     * Create a new ContractTransferAssetDao with an attached configuration
     */
    public ContractTransferAssetDao(Configuration configuration) {
        super(ContractTransferAsset.CONTRACT_TRANSFER_ASSET, io.trxplorer.model.tables.pojos.ContractTransferAsset.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ULong getId(io.trxplorer.model.tables.pojos.ContractTransferAsset object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchById(ULong... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public io.trxplorer.model.tables.pojos.ContractTransferAsset fetchOneById(ULong value) {
        return fetchOne(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.ID, value);
    }

    /**
     * Fetch records that have <code>asset_name IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByAssetName(String... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.ASSET_NAME, values);
    }

    /**
     * Fetch records that have <code>owner_id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByOwnerId(ULong... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.OWNER_ID, values);
    }

    /**
     * Fetch records that have <code>to_id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByToId(ULong... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.TO_ID, values);
    }

    /**
     * Fetch records that have <code>owner_address IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByOwnerAddress(String... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS, values);
    }

    /**
     * Fetch records that have <code>to_address IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByToAddress(String... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.TO_ADDRESS, values);
    }

    /**
     * Fetch records that have <code>amount IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByAmount(ULong... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.AMOUNT, values);
    }

    /**
     * Fetch records that have <code>transaction_id IN (values)</code>
     */
    public List<io.trxplorer.model.tables.pojos.ContractTransferAsset> fetchByTransactionId(ULong... values) {
        return fetch(ContractTransferAsset.CONTRACT_TRANSFER_ASSET.TRANSACTION_ID, values);
    }
}
