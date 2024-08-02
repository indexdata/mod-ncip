package org.folio.ncip;

public class Constants {
	public static final String BLOCKED = "BLOCKED";
	public static final String OK = "OK";
	public static final String AUTH_UID = "Username";
	public static final String AUTH_BARCODE = "Barcode Id";
	public static final String ACTIVE = "ACTIVE";
	public static final String VALUE_KEY = "value";
	public static final String CODE_KEY = "code";
	public static final String UNABLE_TO_INIT_TOOLKIT = "Unable to initialize the default toolkit properties.";
	public static final String BORROWING_BLOCK = "borrowing";
	public static final String REQUEST_BLOCK = "requests";
	public static final String AUTOMATED_REQUEST_BLOCK = "blockRequests";
	public static final String AUTOMATED_BORROWING_BLOCK = "blockBorrowing";
	public static final String ACCEPT_ITEM_PROBLEM = "Problem performing AcceptItem";
	public static final String ACCEPT_ITEM_INPUT_PROBLEM = "Problem occurred validating input (user id, item id or pickup location)";
	public static final String LOOKUP_USER_VALIDATION_PROBLEM = "Problem occurred validating user id";
	public static final String GENERAL_ERROR = "General Error";
	public static final String LOOKUP_USER_FAILED = "Lookup User Failed";
	public static final String UNABLE_TO_PROCESS_RESPONSE = "Unable to process response: ";
	public static final String USERID = "Userid";
	public static final String USER_NOT_FOUND = "Did not find a user with that id";
	public static final String PERSONAL = "personal";
	public static final String PREFERRED_FIRST_NAME = "preferredFirstName";
	public static final String CAMPUS = "CAMPUS";
	public static final String OTHER = "OTH";
	public static final String USER_PROBLEM_ELEMENT = "AuthenticationInput or UserId";
	public static final String CHECK_OUT_PROBLEM = "Problem performing checkout";
	public static final String CHECK_OUT_INPUT_PROBLEM = "Problem occurred validating input (user id or item id)";
	public static final String UNKNOWN_DATA_ELEMENT = "--";
	public static final String CHECK_IN_PROBLEM = "Problem performing check in";
	public static final String FATAL_ERROR_OCCURED = "An error occurred processing this request.  Unable to construct a proper NCIP response with problem element";
	public static final String USER_ID_MISSING = "User id missing";
	public static final String USER_ID_IS_INVALID  = "User id is invalid";
	public static final String ITEM_ID_IS_MISSING = "Item id missing";
	public static final String  ITEM_ID_IS_INVALID = "Item id is invalid";
	public static final String PICKUP_LOCATION_MISSING = "Pickup location is missing";
	public static final String REQUEST_ID_MISSING = "Request ID Missing";
	public static final String FROM_AGENCY_MISSING = "Could not determine FromAgency";
	public static final String COULD_NOT_DETERMINE_USER = "User id missing from request or user id provided in authentication input does not exist";
	public static final String REQUEST_ITEM_PROBLEM = "Problem performing RequestItem";
	public static final String REQUEST_ITEM_INPUT_PROBLEM = "Problem occurred validating input (user id or item id)";
	public static final String REQUEST_ITEM_MISSING_PROBLEM = "Problem occurred while fetching item";
	public static final String CANCEL_REQUEST_ITEM_PROBLEM = "Problem performing CancelRequestItem";
	public static final String DELETE_ITEM_PROBLEM = "Problem performing DeleteItem";
	public static final String CREATE_USER_FISCAL_TRANSACTION_PROBLEM = "Problem performing CreateUserFiscalTransaction";
	
	//MISC
	public static final String NCIP_TOOLKIT_PROPS = "ncip_toolkit_props";
	public static final String APP_XML = "application/xml";
	public static final String SYS_PORT = "port";
	public static final String DEFAULT_PORT = "8081";
	public static final String INIT_PROP_FILE = "init-values.properties";
	public static final String TOOLKIT_PROP_FILE = "toolkit.properties";
	public static final String NCIP_PROP_FILE = "ncip.properties";
	public static final String X_OKAPI_TENANT = "x-okapi-tenant";
	public static final String X_OKAPI_TOKEN = "X-Okapi-Token";
	public static final String X_OKAPI_URL = "X-Okapi-Url";
	public static final String ACCEPT_TEXT = "Accept";
	public static final String CONTENT_TYPE_TEXT = "Content-Type";
	public static final String CONTENT_JSON_AND_PLAIN = "application/json,text/plain";
	public static final String TEXT_PLAIN_STRING = "text/plain";
	public static final String CONTENT_JSON = "application/json";
	public static final String DATE_FORMAT_FOR_CIRC = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String INITIALIZED_PROPERTY = ".ncip.initialized";
	public static final String SCHEME = "Scheme";
	public static final String ITEM_BARCODE = "Item Barcode";
	public static final String PAGE = "Page";
	public static final String ITEM = "Item";
	public static final String USER_BARCODE = "User Barcode";
	public static final String REQUEST_ID = "Request Id";
	public static final String CONFIGS = "configs";
	public static final String AGENCY_ID = "Agency ID";
	public static final String RESPONSE_INCLUDES_PHYSICAL_ADDRESS = "response.includes.physical.address";
	public static final String OK_CONFIG = "user.priv.ok.status"; 
	public static final String BLOCKED_CONFIG = "user.priv.blocked.status";
	public static final String EMAIL_STRING = "user.email.type";
	public static final String REQUEST_CANCELLED_STATUS = "Closed - Cancelled";
	public static final String REQUEST_CANCEL_ADDITIONAL_INFO = "NCIP cancel";
	public static final String REQUEST_CANCEL_PATRON_ADDITIONAL_INFO = "Patron did not pickup item";
	public static final String AUTH_TYPE_PIN = "pin";
	public static final String PATRON_GROUP = "patronGroup";
	
	
	//ENDPOINTS
	public static final String CHECK_IN_BY_BARCODE = "/circulation/check-in-by-barcode";
	public static final String CHECK_OUT_BY_BARCODE  = "/circulation/check-out-by-barcode";
	public static final String INSTANCE_URL = "/inventory/instances";
	public static final String HOLDINGS_URL = "/holdings-storage/holdings";
	public static final String ITEM_URL = "/inventory/items";
	public static final String ITEM_SEARCH_URL = "/inventory/items?limit=1&query=hrid%3D%3D%22$hrid$%22";
	public static final String INSTANCE_SEARCH_URL = "/inventory/instances?limit=1&query=hrid%3D%3D%22$hrid$%22";
	public static final String REQUEST_URL = "/circulation/requests";
	public static final String OPEN_REQUEST_BY_ITEM_ID_URL = "/circulation/requests?limit=100&query=%28status%3D%3D%28%22Open%20-%20Awaiting%20pickup%22%20or%20%22Open%20-%20Awaiting%20delivery%22%20or%20%22Open%20-%20In%20transit%22%20or%20%22Open%20-%20Not%20yet%20filled%22%29%29%20and%20itemId%3D%3D";
	public static final String ITEM_SEARCH_BY_BARCODE_URL = "/inventory/items?limit=1&query=barcode%3D%3D%22$barcode$%22";
	public static final String ADDRESS_TYPES = "/addresstypes";
	public static final String PATRON_PIN_VERIFY = "/patron-pin/verify";
	public static final String FEE_OWNER_URL = "/owners?query=owner=%22Reshare-ILL%22&limit=1";
	public static final String FEE_FINE_BY_OWNER_AND_TYPE = "/feefines?query=ownerId==$ownerId$%20and%20feeFineType=%22$feeType$%22&limit=1";
	public static final String PATRON_GROUP_BY_ID = "/groups/";
	public static final String ACCOUNT_URL = "/accounts";
	
	public static final String DEFAULT_TIMEOUT = "30000";
	public static final String SERVICE_MGR_TIMEOUT = "service_manager_timeout_ms";
	public static final String CHARGE_DEFAULT_PATRON_FEE = "charge-default-patron-fee";
	public static final String DEFAULT_PAYMENT_STATUS = "Outstanding";
	public static final String DEFAULT_FEE_STATUS = "Open";

}
