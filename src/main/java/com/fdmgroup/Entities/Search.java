package com.fdmgroup.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "search_record")
public class Search {
	
	@Id 
	private int searchId;
	@Column
	private String username;
	private String gem;
	private String country;
	private int searchByGem; //1 = searchByGem, 0 = searchByCountry
	
	public Search(int searchId, String username, String target, int searchByGem) {
		
		if (searchByGem == 1) {
			
			this.searchId = searchId;
			this.username = username;
			this.gem = target;
			this.country = null;
			this.searchByGem = searchByGem;
		
		}else {
			
			this.searchId = searchId;
			this.username = username;
			this.country = target;
			this.gem = null;
			this.searchByGem = searchByGem;
		}
	}
	
	public Search() {
		
		
	}

	public int getSearchId() {
		return searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGem() {
		return gem;
	}

	public void setGem(String gem) {
		this.gem = gem;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int isSearchByGem() {
		return searchByGem;
	}

	public void setSearchByGem(int searchByGem) {
		this.searchByGem = searchByGem;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gem == null) ? 0 : gem.hashCode());
		result = prime * result + searchByGem;
		result = prime * result + searchId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Search other = (Search) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (gem == null) {
			if (other.gem != null)
				return false;
		} else if (!gem.equals(other.gem))
			return false;
		if (searchByGem != other.searchByGem)
			return false;
		if (searchId != other.searchId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		if (searchByGem == 1) {
			
			return "Search [search_id=" + searchId + ", username=" + username + ", gem=" + gem + ", searchByGem]";
		
		}else {
			
			return "Search [search_id=" + searchId + ", username=" + username + ", country=" + country + ", searchByCountry]";
		}
	}
	
	
	
	
}
