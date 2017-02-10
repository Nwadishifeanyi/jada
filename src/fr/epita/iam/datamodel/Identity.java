package fr.epita.iam.datamodel;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Identity {
	private String uid;
	private String displayName;
	private String email;
	private Date birthday;
	private Map<String, String> attributes = new HashMap<String, String>();
	private Set<Address> addresses;
	/**
	 * @param uid
	 * @param displayName
	 * @param email
	 */
	public Identity(String uid, String displayName, String email) {
		super();
		this.uid = uid;
		this.displayName = displayName;
		this.email = email;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setAttribute(String name, String value){
		this.attributes.put(name, value);
	}
	public void setAttributes(Map<String, String> attributes){
		this.attributes = attributes;
	}
	public Map<String, String> getAttributes(){
		return this.attributes;
	}
	
	
	public Set<Address> getAddresses() {
		return addresses;
	}
	
	public void setAddress(Address address){
		if (!addresses.contains(address)){
			addresses.add(address);
		}
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		StringBuilder attributesStr = new StringBuilder();
		attributesStr.append("Attributes:[");
		for (Map.Entry<String, String> entry : attributes.entrySet()){
			attributesStr.append(entry.getKey()+"= "+entry.getValue()+",");
		}
		attributesStr.append("]");
		return "Identity [uid=" + this.uid +
				", displayName=" + this.displayName +
				", email=" + this.email +
				", birthday= "+this.birthday+
				", " + attributesStr.toString()+"]";
	}
	
	
}
