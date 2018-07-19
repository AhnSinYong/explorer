/*
 * This file is generated by jOOQ.
*/
package io.trxplorer.model.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

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
public class ContractWitnessCreate implements Serializable {

    private static final long serialVersionUID = 58775410;

    private UInteger id;
    private ULong    ownerId;
    private String   ownerAddress;
    private String   url;
    private ULong    transactionId;

    public ContractWitnessCreate() {}

    public ContractWitnessCreate(ContractWitnessCreate value) {
        this.id = value.id;
        this.ownerId = value.ownerId;
        this.ownerAddress = value.ownerAddress;
        this.url = value.url;
        this.transactionId = value.transactionId;
    }

    public ContractWitnessCreate(
        UInteger id,
        ULong    ownerId,
        String   ownerAddress,
        String   url,
        ULong    transactionId
    ) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownerAddress = ownerAddress;
        this.url = url;
        this.transactionId = transactionId;
    }

    public UInteger getId() {
        return this.id;
    }

    public void setId(UInteger id) {
        this.id = id;
    }

    public ULong getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(ULong ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerAddress() {
        return this.ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ULong getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(ULong transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ContractWitnessCreate (");

        sb.append(id);
        sb.append(", ").append(ownerId);
        sb.append(", ").append(ownerAddress);
        sb.append(", ").append(url);
        sb.append(", ").append(transactionId);

        sb.append(")");
        return sb.toString();
    }
}
