package com;
import model.Account;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("/Customer")

public class AccountService {
	Account Obj = new Account();
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	 {
	 return Obj.readInquiry();
	 }
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertcustomermanagement(@FormParam("cust_name") String cust_name,
	@FormParam("address") String address,
	 @FormParam("nic") String nic,
	 @FormParam("district") String district,
	@FormParam("mobile") String mobile,
	@FormParam("e_service") String e_service,
	@FormParam("wire_install") String wire_install
	)
	{
	 String output = Obj.insertcustomermanagement(cust_name,address,nic,district,mobile,e_service,wire_install);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updatecustomermanagement(String customerData)
	{
	//Convert the input string to a JSON object
	 JsonObject Object = new JsonParser().parse(customerData).getAsJsonObject();
	 
	 //Read the values from the JSON object
	 String acc_no = Object.get("acc_no").getAsString();
	 String cust_name = Object.get("cust_name").getAsString();
	 String address = Object.get("address").getAsString();
	 String nic = Object.get("nic").getAsString();
	 String district = Object.get("district").getAsString();
	 String mobile = Object.get("mobile").getAsString();
	 String e_service = Object.get("e_service").getAsString();
	 String wire_install = Object.get("wire_install").getAsString();
	 
	 String output = Obj.updatecustomermanagement(acc_no,cust_name,address,nic,district,mobile,e_service,wire_install);
	return output;
	}

	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteinquirymanagement(String customerData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(customerData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String acc_no = doc.select("acc_no").text();
	 String output = Obj.deletecustomermanagement(acc_no);
	return output;
	}

	
}
