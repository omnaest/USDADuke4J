/*

	Copyright 2017 Danny Kunz

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.


*/
package org.omnaest.usda.duke.domain.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ethnobot
{

	@JsonProperty("ETHNO")
	private String ethNo;

	@JsonProperty("ACTIVITY")
	private String activity;

	@JsonProperty("GENUS")
	private String genus;

	@JsonProperty("SPECIES")
	private String species;

	@JsonProperty("SPAUT")
	private String spaut;

	@JsonProperty("SPRANK")
	private String sprank;

	@JsonProperty("SPXNAM")
	private String spxnam;

	@JsonProperty("SPXAUT")
	private String spxaut;

	@JsonProperty("FAMILY")
	private String family;

	@JsonProperty("CNAME")
	private String cName;

	@JsonProperty("COUNTRY")
	private String country;

	@JsonProperty("REFERENCE")
	private String reference;

	@JsonProperty("LONGREF")
	private String longRef;

	@JsonProperty("EFFECTIVE")
	private String effective;

	@JsonProperty("TAXON")
	private String taxon;

	@JsonProperty("TAXAUTHOR")
	private String taxAuthour;

	@JsonProperty("USERID")
	private String userId;

	@JsonProperty("CREATED")
	private String created;

	@JsonProperty("MODIFIED")
	private String modified;

	public String getEthNo()
	{
		return this.ethNo;
	}

	public void setEthNo(String ethNo)
	{
		this.ethNo = ethNo;
	}

	public String getActivity()
	{
		return this.activity;
	}

	public void setActivity(String activity)
	{
		this.activity = activity;
	}

	public String getGenus()
	{
		return this.genus;
	}

	public void setGenus(String genus)
	{
		this.genus = genus;
	}

	public String getSpecies()
	{
		return this.species;
	}

	public void setSpecies(String species)
	{
		this.species = species;
	}

	public String getSpaut()
	{
		return this.spaut;
	}

	public void setSpaut(String spaut)
	{
		this.spaut = spaut;
	}

	public String getSprank()
	{
		return this.sprank;
	}

	public void setSprank(String sprank)
	{
		this.sprank = sprank;
	}

	public String getSpxnam()
	{
		return this.spxnam;
	}

	public void setSpxnam(String spxnam)
	{
		this.spxnam = spxnam;
	}

	public String getSpxaut()
	{
		return this.spxaut;
	}

	public void setSpxaut(String spxaut)
	{
		this.spxaut = spxaut;
	}

	public String getFamily()
	{
		return this.family;
	}

	public void setFamily(String family)
	{
		this.family = family;
	}

	public String getcName()
	{
		return this.cName;
	}

	public void setcName(String cName)
	{
		this.cName = cName;
	}

	public String getCountry()
	{
		return this.country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getReference()
	{
		return this.reference;
	}

	public void setReference(String reference)
	{
		this.reference = reference;
	}

	public String getLongRef()
	{
		return this.longRef;
	}

	public void setLongRef(String longRef)
	{
		this.longRef = longRef;
	}

	public String getEffective()
	{
		return this.effective;
	}

	public void setEffective(String effective)
	{
		this.effective = effective;
	}

	public String getTaxon()
	{
		return this.taxon;
	}

	public void setTaxon(String taxon)
	{
		this.taxon = taxon;
	}

	public String getTaxAuthour()
	{
		return this.taxAuthour;
	}

	public void setTaxAuthour(String taxAuthour)
	{
		this.taxAuthour = taxAuthour;
	}

	public String getUserId()
	{
		return this.userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getCreated()
	{
		return this.created;
	}

	public void setCreated(String created)
	{
		this.created = created;
	}

	public String getModified()
	{
		return this.modified;
	}

	public void setModified(String modified)
	{
		this.modified = modified;
	}

	@Override
	public String toString()
	{
		return "Ethnobot [ethNo=" + this.ethNo + ", activity=" + this.activity + ", genus=" + this.genus + ", species=" + this.species + ", spaut=" + this.spaut
				+ ", sprank=" + this.sprank + ", spxnam=" + this.spxnam + ", spxaut=" + this.spxaut + ", family=" + this.family + ", cName=" + this.cName
				+ ", country=" + this.country + ", reference=" + this.reference + ", longRef=" + this.longRef + ", effective=" + this.effective + ", taxon="
				+ this.taxon + ", taxAuthour=" + this.taxAuthour + ", userId=" + this.userId + ", created=" + this.created + ", modified=" + this.modified
				+ "]";
	}

}
