package org.sakaiproject.help.impl.entity;

import org.sakaiproject.entitybroker.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.AutoRegisterEntityProvider;
import org.sakaiproject.help.logic.entity.HelpEntityProvider;

public class HelpEntityProviderImpl implements HelpEntityProvider, CoreEntityProvider, AutoRegisterEntityProvider {

	public String getEntityPrefix() {
		 return ENTITY_PREFIX;
	}

	public boolean entityExists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
