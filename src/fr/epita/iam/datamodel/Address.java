package fr.epita.iam.datamodel;


import java.util.Map;

public class Address {
	private String uid;
	private String street;
	private String city;
	private String zipCode;
	private Map<String, String> attributes;
	/**
	 * @param uid
	 * @param street
	 * @param city
	 * @param zipCode
	 */
	public Address(String uid, String street, String city, String zipCode) {
		super();
		this.uid = uid;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttribute(String key, String value) {
		if (!this.attributes.containsKey(key)){
			attributes.put(key, value);
		}
	}
	
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [uid=" + uid + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode
				+ ", attributes=" + attributes + "]";
	}
	
	
}