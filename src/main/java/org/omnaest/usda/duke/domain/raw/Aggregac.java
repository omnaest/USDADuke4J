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

public class Aggregac
{
	@JsonProperty("AGGNO")
	private String aggNo;

	@JsonProperty("CHEM")
	private String chemical;

	@JsonProperty("ACTIVITY")
	private String activity;

	@JsonProperty("DOSAGE")
	private String dosage;

	@JsonProperty("REFERENCE")
	private String reference;

	@JsonProperty("MAJORACT")
	private String majorAct;

	@JsonProperty("USERID")
	private String userId;

	@JsonProperty("CREATED")
	private String created;

	@JsonProperty("MODIFIED")
	private String modified;

	public String getAggNo()
	{
		return this.aggNo;
	}

	public void setAggNo(String aggNo)
	{
		this.aggNo = aggNo;
	}

	public String getChemical()
	{
		return this.chemical;
	}

	public void setChemical(String chemical)
	{
		this.chemical = chemical;
	}

	public String getActivity()
	{
		return this.activity;
	}

	public void setActivity(String activity)
	{
		this.activity = activity;
	}

	public String getDosage()
	{
		return this.dosage;
	}

	public void setDosage(String dosage)
	{
		this.dosage = dosage;
	}

	public String getReference()
	{
		return this.reference;
	}

	public void setReference(String reference)
	{
		this.reference = reference;
	}

	public String getMajorAct()
	{
		return this.majorAct;
	}

	public void setMajorAct(String majorAct)
	{
		this.majorAct = majorAct;
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
		return "Aggregac [aggNo=" + this.aggNo + ", chemical=" + this.chemical + ", activity=" + this.activity + ", dosage=" + this.dosage + ", reference="
				+ this.reference + ", majorAct=" + this.majorAct + ", userId=" + this.userId + ", created=" + this.created + ", modified=" + this.modified
				+ "]";
	}

}
