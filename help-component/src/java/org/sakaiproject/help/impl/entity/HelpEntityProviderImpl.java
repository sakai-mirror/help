package org.sakaiproject.help.impl.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.api.app.help.HelpManager;
import org.sakaiproject.api.app.help.Resource;
import org.sakaiproject.component.app.help.HelpManagerImpl;
import org.sakaiproject.component.app.help.model.ResourceBean;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.entitybroker.EntityReference;
import org.sakaiproject.entitybroker.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.AutoRegisterEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.RESTful;
import org.sakaiproject.entitybroker.entityprovider.extension.Formats;
import org.sakaiproject.entitybroker.entityprovider.search.Search;
import org.sakaiproject.help.logic.entity.HelpEntityProvider;

public class HelpEntityProviderImpl implements HelpEntityProvider, CoreEntityProvider, AutoRegisterEntityProvider, RESTful {

    private HelpManager helpManager;

    public static final String HELP_REF_REGEXP = "^/help/([A-Za-z0-9._-]+)$";

    private static final Log LOG = LogFactory.getLog(HelpEntityProviderImpl.class);
    
	public String getEntityPrefix() {
		 return ENTITY_PREFIX;
	}

	public boolean entityExists(String id) {
		
		LOG.debug("entityExists: " + id);
		// Check regexp matches for help id
		
		return true;
	}

	public String createEntity(EntityReference ref, Object entity,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSampleEntity() {
		LOG.debug("getSampleEntity: " );

		// TODO Auto-generated method stub
		return new ResourceBean();
	}

	public void updateEntity(EntityReference ref, Object entity,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		
	}

	public Object getEntity(EntityReference ref) {
		LOG.debug("getEntity: " + ref.getId());

		Resource resource = getHelpManager().getResourceByDocId(ref.getId());

		return resource;
	}

	  /**
	   * get the component manager through cover
	   * @return help manager
	   */
	  public HelpManager getHelpManager()
	  {
	    if (helpManager == null)
	    {
	    	helpManager = (HelpManager) ComponentManager.get(HelpManager.class.getName()); 
	    	return helpManager;
	    }
	    return helpManager;
	  }

	public void deleteEntity(EntityReference ref, Map<String, Object> params) {
		// TODO Auto-generated method stub
		
	}

	public List<?> getEntities(EntityReference ref, Search search) {
		List<Resource> resources = new ArrayList<Resource>();
		
		Resource doc1 = getHelpManager().getResourceByDocId("ardk");
		resources.add(doc1);
		
		return resources;
	}

	public String[] getHandledOutputFormats() {

		return new String[] {Formats.XML, Formats.JSON};
	}

	public String[] getHandledInputFormats() {
		// TODO Auto-generated method stub
		return null;
	}

}
