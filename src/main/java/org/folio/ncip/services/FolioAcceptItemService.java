package org.folio.ncip.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.extensiblecatalog.ncip.v2.service.*;
import org.folio.ncip.Constants;
import org.folio.ncip.FolioNcipException;
import org.folio.ncip.FolioRemoteServiceManager;
import io.vertx.core.json.JsonObject;

public class FolioAcceptItemService extends FolioNcipService implements AcceptItemService {
	
	 private static final Logger logger = Logger.getLogger(FolioAcceptItemService.class);

	 @Override
	 public AcceptItemResponseData performService(AcceptItemInitiationData initData,
			 ServiceContext serviceContext,
             RemoteServiceManager serviceManager) {

		 	AcceptItemResponseData responseData = new AcceptItemResponseData();
		 
			ItemId itemId = initData.getItemId();
			UserId userId = initData.getUserId();
			String pickupLocation = initData.getPickupLocation().getValue();
			logger.info("accept item: " + itemId);
			
	        try {
	        	validateUserId(userId);
	        	validateItemId(itemId);
	        	validatePickupLocation(pickupLocation);
	        }
	        catch(Exception exception) {
	        	logger.error("Failed validating userid, itemid or pickup location." + exception.getLocalizedMessage());
	        	if (responseData.getProblems() == null) responseData.setProblems(new ArrayList<>());
	        	Problem p = new Problem(new ProblemType(Constants.ACCEPT_ITEM_PROBLEM),Constants.ACCEPT_ITEM_INPUT_PROBLEM,exception.getMessage(),exception.getMessage());
	        	responseData.getProblems().add(p);
	        	return responseData;
	        } 

	        // ATTEMPT TO DETERMINE AGENCY ID
	        // INITIATION HEADER IS NOT REQUIRED
	        String requesterAgencyId;
	        try {
	        	requesterAgencyId = initData.getInitiationHeader().getFromAgencyId().getAgencyId().getValue();
	        	if (requesterAgencyId == null || requesterAgencyId.equalsIgnoreCase("")) throw new Exception("Requester agency ID is missing");
	        }
	        catch(Exception e) {
	        	// Cannot get requester agency id from init header - try request id element
	        	try {
	        		requesterAgencyId = initData.getRequestId().getAgencyId().getValue();
	        		if (requesterAgencyId == null || requesterAgencyId.trim().equalsIgnoreCase(""))
	        			throw new Exception("From Agency ID Missing");
	        	}
	        	catch(Exception except) {
	        		logger.error("Could not determine agency id from initiation header or request id element.");
	        		if (responseData.getProblems() == null) responseData.setProblems(new ArrayList<>());
	            	Problem p = new Problem(new ProblemType(Constants.ACCEPT_ITEM_PROBLEM),Constants.AGENCY_ID,Constants.FROM_AGENCY_MISSING ,e.getMessage());
	            	responseData.getProblems().add(p);
	            	return responseData;
	        	}
	        }
	        
	        ItemIdentifierType itemIdentifierType = new ItemIdentifierType(Constants.SCHEME, Constants.ITEM_BARCODE);
	        RequestIdentifierType requestIdentifierType = new RequestIdentifierType(Constants.SCHEME,Constants.REQUEST_ID);
	        
	        itemId.setAgencyId(new AgencyId(requesterAgencyId));
	        itemId.setItemIdentifierType(itemIdentifierType);
	        RequestId ncipRequestId = new RequestId();
	        ncipRequestId.setAgencyId(new AgencyId(requesterAgencyId));
	        ncipRequestId.setRequestIdentifierType(requestIdentifierType);
				  UserId optionalUserId = new UserId();
	           
	        try {
	        	// THE SERVICE MANAGER CALLS THE OKAPI APIs
	        	JsonObject acceptItemResponseDetails = ((FolioRemoteServiceManager)serviceManager).acceptItem(initData,userId,requesterAgencyId.toLowerCase());
	        	String assignedRequestId = acceptItemResponseDetails.getString("id");
						String requesterId = acceptItemResponseDetails.getString("requesterId");
	        	responseData.setItemId(itemId);
	        	ncipRequestId.setRequestIdentifierValue(assignedRequestId);
	        	responseData.setRequestId(ncipRequestId);
						optionalUserId.setUserIdentifierValue(requesterId);
	        }
	        catch(Exception e) {
	        	if (responseData.getProblems() == null) responseData.setProblems(new ArrayList<>());
	        	Problem p = new Problem(new ProblemType(Constants.ACCEPT_ITEM_PROBLEM),Constants.UNKNOWN_DATA_ELEMENT,Constants.ACCEPT_ITEM_PROBLEM ,e.getMessage());
	        	responseData.getProblems().add(p);
	        	return responseData;
	        }

				  optionalUserId.setUserIdentifierType(new UserIdentifierType(Constants.SCHEME,"uuid"));
				  UserOptionalFields userOptionalFields = new UserOptionalFields();
				  userOptionalFields.setUserIds(List.of(optionalUserId));

		    return responseData;
	 }
	 
	 private void validatePickupLocation(String pickupLocation) throws FolioNcipException {
		  if (pickupLocation == null || pickupLocation.trim().equalsIgnoreCase("")) {
        throw new FolioNcipException(Constants.PICKUP_LOCATION_MISSING);
		  }
	 }
}
