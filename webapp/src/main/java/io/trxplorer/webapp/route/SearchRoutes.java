package io.trxplorer.webapp.route;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jooby.Request;
import org.jooby.Response;
import org.jooby.Results;
import org.jooby.View;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import io.trxplorer.webapp.WebAppConfig;
import io.trxplorer.webapp.dto.search.SearchResultDTO;
import io.trxplorer.webapp.service.SearchService;

@Singleton
public class SearchRoutes {
	
	private SearchService searchService;
	private WebAppConfig config;

	@Inject
	public SearchRoutes(WebAppConfig config,SearchService searchService) {
		this.searchService = searchService;
		this.config = config;
	}
	
	@POST
	@GET
	@Path(TRXPlorerRoutePaths.Front.SEARCH)
	public void search(Request req,Response res) throws Throwable {
		
		String query = req.param("q").value(null);
		String queryType = req.param("type").value(null);
		
		//TODO: autoguest queryType based on regex when not specified
		
		View view = Results.html("search");
		
		if (StringUtils.isNotBlank(queryType) && StringUtils.isNotBlank(query)) {
			
			SearchResultDTO searchResult = new SearchResultDTO();
			searchResult.setQuery(query);
			
			
			if (queryType.equals("tx")) {
				
				searchResult.setSearchType("Transaction");
				
				if (this.searchService.txHashExists(query)) {
					
					searchResult.setUrl(this.config.getBaseUrl()+TRXPlorerRoutePaths.Front.TRANSACTION_DETAIL.replace(":txid", query));
					
				}
				
			}else if (queryType.equals("token")) {
				
				searchResult.setSearchType("Token");
				
				if (this.searchService.tokenByNameExists(query)) {
					
					searchResult.setUrl(this.config.getBaseUrl()+TRXPlorerRoutePaths.Front.ASSET_DETAIL.replace(":assetName", query));
					
				}
				
			}else if (queryType.equals("address")) {
				
				searchResult.setSearchType("Address");
				
				if (this.searchService.accountByAddressExists(query)) {
					
					searchResult.setUrl(this.config.getBaseUrl()+TRXPlorerRoutePaths.Front.ACCOUNT_DETAIL.replace(":address", query));
					
				}
				
			}else if (queryType.equals("block")) {
				
				searchResult.setSearchType("Block");
				
				String blockNum = this.searchService.getBlockNumByHash(query);
				
				if (StringUtils.isNotBlank(blockNum)) {
					
					searchResult.setUrl(this.config.getBaseUrl()+TRXPlorerRoutePaths.Front.BLOCK_DETAIL.replace(":num", blockNum));
					
				}
			}else if (queryType.equals("rep")) {
				
				searchResult.setSearchType("Representative");
				
				String address = this.searchService.getWitnessAddressByUrl(query);
				
				if (StringUtils.isNotBlank(address)) {
					
					searchResult.setUrl(this.config.getBaseUrl()+TRXPlorerRoutePaths.Front.ACCOUNT_DETAIL.replace(":address", address));
					
				}
			}
				
			view.put("result",searchResult);
			
		}
		
		
		
		view.put("q",query);
		
		
		res.send(view);
	
	}
	
	@GET
	@Path(TRXPlorerRoutePaths.Front.SEARCH_TOKEN)
	public void redirSETokenResult(Request req,Response res) throws Throwable{ 
		
		String id = req.param("id").value(null);

		if (id==null) {
			res.redirect("/search");
			return;
		}

		id = id.split("_")[1];
		
		if (!NumberUtils.isNumber(id)) {
			res.redirect("/search");
			return;
		}
		
		//FIXME:SHOULD BE ASSET NAME, BUT REPLACE BY ID UNTIL FIXED BY TRON

		res.redirect(TRXPlorerRoutePaths.Front.ASSET_DETAIL.replace(":assetName", id));
	}
	
	@GET
	@Path(TRXPlorerRoutePaths.Front.SEARCH_WITNESS)
	public void redirSEWitnessResult(Request req,Response res) throws Throwable{ 
		
		String id = req.param("id").value(null);

		if (id==null) {
			res.redirect("/search");
			return;
		}

		id = id.split("_")[1];
		
		if (!NumberUtils.isNumber(id)) {
			res.redirect("/search");
			return;
		}
		

		String address = this.searchService.getWitnessAddressById(Long.valueOf(id));
			
		res.redirect(TRXPlorerRoutePaths.Front.ACCOUNT_DETAIL.replace(":address", address));
	}

}
