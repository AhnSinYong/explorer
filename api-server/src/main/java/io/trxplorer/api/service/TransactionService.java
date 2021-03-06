package io.trxplorer.api.service;

import static io.trxplorer.model.Tables.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.SelectConditionStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOrderByStep;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.types.ULong;

import com.google.inject.Inject;

import io.trxplorer.api.dto.common.ListResult;
import io.trxplorer.api.dto.transaction.TransactionCriteria;
import io.trxplorer.api.dto.transaction.TransactionDTO;
import io.trxplorer.api.utils.TransactionHelper;

public class TransactionService {

	private DSLContext dslContext;
	
	private final int TRON_START_YEAR = 2018;
	
	@Inject
	public TransactionService(DSLContext dslContext) {
		this.dslContext  = dslContext;
	}
	



	public TransactionDTO getTxByHash(String hash) {
		
		Field<String> fromField = DSL.when(CONTRACT_ACCOUNT_CREATE.OWNER_ADDRESS.isNotNull(), CONTRACT_ACCOUNT_CREATE.OWNER_ADDRESS)
		.when(CONTRACT_ACCOUNT_UPDATE.OWNER_ADDRESS.isNotNull(), CONTRACT_ACCOUNT_UPDATE.OWNER_ADDRESS)
		.when(CONTRACT_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), CONTRACT_ASSET_ISSUE.OWNER_ADDRESS)
		.when(CONTRACT_DEPLOY.OWNER_ADDRESS.isNotNull(), CONTRACT_DEPLOY.OWNER_ADDRESS)
		.when(CONTRACT_PARTICIPATE_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), CONTRACT_PARTICIPATE_ASSET_ISSUE.OWNER_ADDRESS)
		.when(CONTRACT_TRANSFER.OWNER_ADDRESS.isNotNull(), CONTRACT_TRANSFER.OWNER_ADDRESS)
		.when(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.isNotNull(), CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS)
		.when(CONTRACT_VOTE_ASSET.OWNER_ADDRESS.isNotNull(), CONTRACT_VOTE_ASSET.OWNER_ADDRESS)
		.when(CONTRACT_VOTE_WITNESS.OWNER_ADDRESS.isNotNull(), CONTRACT_VOTE_WITNESS.OWNER_ADDRESS)
		.when(CONTRACT_WITNESS_CREATE.OWNER_ADDRESS.isNotNull(), CONTRACT_WITNESS_CREATE.OWNER_ADDRESS)
		.when(CONTRACT_WITNESS_UPDATE.OWNER_ADDRESS.isNotNull(), CONTRACT_WITNESS_UPDATE.OWNER_ADDRESS)
		.as("from");
		
		Field<String> toField = DSL.when(CONTRACT_TRANSFER.TO_ADDRESS.isNotNull(), CONTRACT_TRANSFER.TO_ADDRESS)
		.when(CONTRACT_TRANSFER_ASSET.TO_ADDRESS.isNotNull(), CONTRACT_TRANSFER_ASSET.TO_ADDRESS)
		.as("to");		

		Field<ULong> amountField = DSL.when(CONTRACT_TRANSFER.AMOUNT.isNotNull(), CONTRACT_TRANSFER.AMOUNT)
		.when(CONTRACT_TRANSFER_ASSET.AMOUNT.isNotNull(), CONTRACT_TRANSFER_ASSET.AMOUNT)
		.as("amount");
		
		Field<String> typeField = DSL.when(CONTRACT_ACCOUNT_CREATE.OWNER_ADDRESS.isNotNull(), "ACCOUNT_CREATE")
		.when(CONTRACT_ACCOUNT_UPDATE.OWNER_ADDRESS.isNotNull(), "ACCOUNT_UPDATE")
		.when(CONTRACT_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), "ASSET_ISSUE")
		.when(CONTRACT_DEPLOY.OWNER_ADDRESS.isNotNull(), "DEPLOY")
		.when(CONTRACT_PARTICIPATE_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), "PARTICIPATE_ASSET_ISSUE")
		.when(CONTRACT_TRANSFER.OWNER_ADDRESS.isNotNull(), "TRANSFER")
		.when(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.isNotNull(), "TRANSFER_ASSET")
		.when(CONTRACT_VOTE_ASSET.OWNER_ADDRESS.isNotNull(), "VOTE_ASSET")
		.when(CONTRACT_VOTE_WITNESS.OWNER_ADDRESS.isNotNull(), "VOTE_WITNESS")
		.when(CONTRACT_WITNESS_CREATE.OWNER_ADDRESS.isNotNull(), "WITNESS_CREATE")
		.when(CONTRACT_WITNESS_UPDATE.OWNER_ADDRESS.isNotNull(), "WITNESS_UPDATE")
		.as("type");		
		
		Field<String> tokenField = DSL.when(CONTRACT_TRANSFER.OWNER_ADDRESS.isNotNull(), DSL.value("TRX"))
				.when(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.isNotNull(), CONTRACT_TRANSFER_ASSET.ASSET_NAME).as("token");
		
		TransactionDTO result = this.dslContext.select(fromField,toField,amountField,typeField,tokenField,BLOCK.NUM.as("blockNum"),TRANSACTION.TIMESTAMP,TRANSACTION.HASH)
		.from(TRANSACTION)
		.join(BLOCK).on(BLOCK.ID.eq(TRANSACTION.BLOCK_ID))
		.leftJoin(CONTRACT_ACCOUNT_CREATE).on(CONTRACT_ACCOUNT_CREATE.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_ACCOUNT_UPDATE).on(CONTRACT_ACCOUNT_UPDATE.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_ASSET_ISSUE).on(CONTRACT_ASSET_ISSUE.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_DEPLOY).on(CONTRACT_DEPLOY.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_PARTICIPATE_ASSET_ISSUE).on(CONTRACT_PARTICIPATE_ASSET_ISSUE.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_TRANSFER).on(CONTRACT_TRANSFER.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_TRANSFER_ASSET).on(CONTRACT_TRANSFER_ASSET.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_VOTE_ASSET).on(CONTRACT_VOTE_ASSET.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_VOTE_WITNESS).on(CONTRACT_VOTE_WITNESS.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_WITNESS_CREATE).on(CONTRACT_WITNESS_CREATE.TRANSACTION_ID.eq(TRANSACTION.ID))
		.leftJoin(CONTRACT_WITNESS_UPDATE).on(CONTRACT_WITNESS_UPDATE.TRANSACTION_ID.eq(TRANSACTION.ID))
		.where(TRANSACTION.HASH.eq(hash))
		.fetchOneInto(TransactionDTO.class);
		
	
		
		return result;
	}


	public ListResult<TransactionDTO, TransactionCriteria> listTransactions(TransactionCriteria criteria) {
		
		ArrayList<Condition> conditions = new ArrayList<>();
		
		//remove invalid transactions (wrong dates)
		//FIXME: remove if/when fixed in tron
		conditions.add(DSL.year(TRANSACTION.TIMESTAMP).gt(TRON_START_YEAR-1));
		conditions.add(DSL.year(TRANSACTION.TIMESTAMP).lt(DSL.year(DSL.currentDate()).plus(1)));
		
		Field<String> fromField = DSL.when(CONTRACT_ACCOUNT_CREATE.OWNER_ADDRESS.isNotNull(), CONTRACT_ACCOUNT_CREATE.OWNER_ADDRESS)
		.when(CONTRACT_ACCOUNT_UPDATE.OWNER_ADDRESS.isNotNull(), CONTRACT_ACCOUNT_UPDATE.OWNER_ADDRESS)
		.when(CONTRACT_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), CONTRACT_ASSET_ISSUE.OWNER_ADDRESS)
		.when(CONTRACT_DEPLOY.OWNER_ADDRESS.isNotNull(), CONTRACT_DEPLOY.OWNER_ADDRESS)
		.when(CONTRACT_PARTICIPATE_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), CONTRACT_PARTICIPATE_ASSET_ISSUE.OWNER_ADDRESS)
		.when(CONTRACT_TRANSFER.OWNER_ADDRESS.isNotNull(), CONTRACT_TRANSFER.OWNER_ADDRESS)
		.when(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.isNotNull(), CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS)
		.when(CONTRACT_VOTE_ASSET.OWNER_ADDRESS.isNotNull(), CONTRACT_VOTE_ASSET.OWNER_ADDRESS)
		.when(CONTRACT_VOTE_WITNESS.OWNER_ADDRESS.isNotNull(), CONTRACT_VOTE_WITNESS.OWNER_ADDRESS)
		.when(CONTRACT_WITNESS_CREATE.OWNER_ADDRESS.isNotNull(), CONTRACT_WITNESS_CREATE.OWNER_ADDRESS)
		.when(CONTRACT_WITNESS_UPDATE.OWNER_ADDRESS.isNotNull(), CONTRACT_WITNESS_UPDATE.OWNER_ADDRESS)
		.when(CONTRACT_FREEZE_BALANCE.OWNER_ADDRESS.isNotNull(), CONTRACT_FREEZE_BALANCE.OWNER_ADDRESS)
		.as("from");
		
		Field<String> toField = DSL.when(CONTRACT_TRANSFER.TO_ADDRESS.isNotNull(), CONTRACT_TRANSFER.TO_ADDRESS)
		.when(CONTRACT_TRANSFER_ASSET.TO_ADDRESS.isNotNull(), CONTRACT_TRANSFER_ASSET.TO_ADDRESS)
		.as("to");		

		Field<ULong> amountField = DSL.when(CONTRACT_TRANSFER.AMOUNT.isNotNull(), CONTRACT_TRANSFER.AMOUNT)
		.when(CONTRACT_TRANSFER_ASSET.AMOUNT.isNotNull(), CONTRACT_TRANSFER_ASSET.AMOUNT)
		.as("amount");
		
		Field<String> typeField = DSL.when(CONTRACT_ACCOUNT_CREATE.OWNER_ADDRESS.isNotNull(), "ACCOUNT_CREATE")
		.when(CONTRACT_ACCOUNT_UPDATE.OWNER_ADDRESS.isNotNull(), "ACCOUNT_UPDATE")
		.when(CONTRACT_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), "ASSET_ISSUE")
		.when(CONTRACT_DEPLOY.OWNER_ADDRESS.isNotNull(), "DEPLOY")
		.when(CONTRACT_PARTICIPATE_ASSET_ISSUE.OWNER_ADDRESS.isNotNull(), "PARTICIPATE_ASSET_ISSUE")
		.when(CONTRACT_TRANSFER.OWNER_ADDRESS.isNotNull(), "TRANSFER")
		.when(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.isNotNull(), "TRANSFER_ASSET")
		.when(CONTRACT_VOTE_ASSET.OWNER_ADDRESS.isNotNull(), "VOTE_ASSET")
		.when(CONTRACT_VOTE_WITNESS.OWNER_ADDRESS.isNotNull(), "VOTE_WITNESS")
		.when(CONTRACT_WITNESS_CREATE.OWNER_ADDRESS.isNotNull(), "WITNESS_CREATE")
		.when(CONTRACT_WITNESS_UPDATE.OWNER_ADDRESS.isNotNull(), "WITNESS_UPDATE")
		.when(CONTRACT_FREEZE_BALANCE.OWNER_ADDRESS.isNotNull(), "FREEZE")
		.as("type");		

		Field<String> tokenField = DSL.when(CONTRACT_TRANSFER.OWNER_ADDRESS.isNotNull(), DSL.value("TRX"))
				.when(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.isNotNull(), CONTRACT_TRANSFER_ASSET.ASSET_NAME).as("token");
		
		
		
		
		
		if (StringUtils.isNotBlank(criteria.getBlock())) {
			conditions.add(TRANSACTION.BLOCK_ID.in(DSL.select(BLOCK.ID).from(BLOCK).where(BLOCK.NUM.eq(ULong.valueOf(criteria.getBlock())))));
		}
		
		if (StringUtils.isNotBlank(criteria.getAddress())) {
			
			conditions.add(TRANSACTION.ID.in(
					DSL.select(CONTRACT_TRANSFER.TRANSACTION_ID)
					.from(CONTRACT_TRANSFER)
					.where(CONTRACT_TRANSFER.OWNER_ADDRESS.eq(criteria.getAddress())
							.or(CONTRACT_TRANSFER.TO_ADDRESS.eq(criteria.getAddress()))))
					.or(TRANSACTION.ID.in(DSL.select(CONTRACT_TRANSFER_ASSET.TRANSACTION_ID)
					.from(CONTRACT_TRANSFER_ASSET)
					.where(CONTRACT_TRANSFER_ASSET.OWNER_ADDRESS.eq(criteria.getAddress())
							.or(CONTRACT_TRANSFER_ASSET.TO_ADDRESS.eq(criteria.getAddress()))))))
					
					;

		}
		
		// We only want asset transfer
		if (StringUtils.isNotBlank(criteria.getAssetName())) {
			
			conditions.add(TRANSACTION.ID.in(DSL.select(CONTRACT_TRANSFER_ASSET.TRANSACTION_ID).from(CONTRACT_TRANSFER_ASSET).where(CONTRACT_TRANSFER_ASSET.ASSET_NAME.eq(criteria.getAssetName()))));
		}
	

		Table<?> tmpTable = DSL.select(TRANSACTION.ID,TRANSACTION.HASH,TRANSACTION.TIMESTAMP,TRANSACTION.BLOCK_ID).from(TRANSACTION).where(conditions).orderBy(TRANSACTION.TIMESTAMP.desc()).limit(criteria.getLimit()).offset(criteria.getOffSet()).asTable("tmp");
		


		SelectOnConditionStep<?> listQuery = this.dslContext.select(fromField,toField,amountField,typeField,BLOCK.NUM.as("blockNum"),tokenField,tmpTable.field(TRANSACTION.TIMESTAMP.getName()),tmpTable.field(TRANSACTION.HASH.getName()))
		.from(tmpTable)
		.join(BLOCK).on(BLOCK.ID.eq(tmpTable.field(TRANSACTION.BLOCK_ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_ACCOUNT_CREATE).on(CONTRACT_ACCOUNT_CREATE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_ACCOUNT_UPDATE).on(CONTRACT_ACCOUNT_UPDATE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_ASSET_ISSUE).on(CONTRACT_ASSET_ISSUE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_DEPLOY).on(CONTRACT_DEPLOY.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_PARTICIPATE_ASSET_ISSUE).on(CONTRACT_PARTICIPATE_ASSET_ISSUE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_TRANSFER).on(CONTRACT_TRANSFER.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_TRANSFER_ASSET).on(CONTRACT_TRANSFER_ASSET.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_VOTE_ASSET).on(CONTRACT_VOTE_ASSET.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_VOTE_WITNESS).on(CONTRACT_VOTE_WITNESS.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_WITNESS_CREATE).on(CONTRACT_WITNESS_CREATE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_WITNESS_UPDATE).on(CONTRACT_WITNESS_UPDATE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)))
		.leftJoin(CONTRACT_FREEZE_BALANCE).on(CONTRACT_FREEZE_BALANCE.TRANSACTION_ID.eq(tmpTable.field(TRANSACTION.ID.getName(),ULong.class)));
		
		
		SelectConditionStep<Record1<Integer>> countQuery = dslContext.select(DSL.count())
				.from(TRANSACTION)
				.join(BLOCK).on(BLOCK.ID.eq(TRANSACTION.BLOCK_ID))
				.where(conditions)
				;
		
		
		Integer totalCount = countQuery.fetchOneInto(Integer.class);
		
		List<TransactionDTO> items = listQuery.fetchInto(TransactionDTO.class);
		
		
		ListResult<TransactionDTO, TransactionCriteria> result = new ListResult<TransactionDTO, TransactionCriteria>(criteria, items, totalCount);
		
		return result;
	}
	

	

	

}
