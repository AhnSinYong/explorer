package io.trxplorer.syncnode.job;

import org.jooby.quartz.Scheduled;
import org.quartz.DisallowConcurrentExecution;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.trxplorer.syncnode.service.NodeSyncService;

@Singleton
@DisallowConcurrentExecution
public class NodeSyncJob {
	
	private NodeSyncService nodeSyncService;

	@Inject
	public NodeSyncJob(NodeSyncService nodeSyncService) {
		this.nodeSyncService = nodeSyncService;
	}
	
	@Scheduled("1m")
	public void synNodes(){
		
		this.nodeSyncService.syncNodes();
		
		
	}
	
	@Scheduled("5m")
	public void updateNodeLocalization() throws UnirestException {
		
		this.nodeSyncService.updateNodesLocalizationData();
		
	}
	
	
}
