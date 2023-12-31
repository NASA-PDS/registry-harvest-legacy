package gov.nasa.pds.registry.model.wrapper;

import gov.nasa.pds.registry.model.Classification;
import gov.nasa.pds.registry.model.ExternalIdentifier;
import gov.nasa.pds.registry.model.ExtrinsicObject;
import gov.nasa.pds.registry.model.ObjectStatus;
import gov.nasa.pds.registry.model.Slot;

import java.util.Set;

/**
 * Implementation of Decorator Pattern to provide {@link ExtrinsicObject}
 * functions and methods down stream
 * 
 * @author jpadams
 *
 */
abstract class ExtrinsicObjectDecorator extends ExtrinsicObject {

	private static final long serialVersionUID = 2346145994576653308L;

    protected ExtrinsicObject decoratedExtrinsic; // the ExtrinsicObject being decorated
    
    public ExtrinsicObjectDecorator (ExtrinsicObject decoratedExtrinsic) {
        this.decoratedExtrinsic = decoratedExtrinsic;
    }
    
    @Override
	public String getGuid() {
		return this.decoratedExtrinsic.getGuid();
	}
    
    @Override
	public String getLid() {
		return this.decoratedExtrinsic.getLid();
	}
    
    @Override
	public String getName() {
		return this.decoratedExtrinsic.getName();
	}
	
    @Override
	public Slot getSlot(String slotName) {
		return this.decoratedExtrinsic.getSlot(slotName);
	}
    
    @Override
	public String getObjectType() {
		return this.decoratedExtrinsic.getObjectType();
	}
    
    @Override
    public String getContentVersion() {
    	return this.decoratedExtrinsic.getContentVersion();
    }
    
    @Override
    public String getDescription() {
    	return this.decoratedExtrinsic.getDescription();
    }
    
    @Override
    public String getHome() {
    	return this.decoratedExtrinsic.getHome();
    }
    
    @Override
    public String getMimeType() {
    	return this.decoratedExtrinsic.getMimeType();
    }
    
    @Override
    public Set<Slot> getSlots() {
    	return this.decoratedExtrinsic.getSlots();
    }
    
    @Override
    public String getVersionName() {
    	return this.decoratedExtrinsic.getVersionName();
    }
    
    @Override
    public Set<ExternalIdentifier> getExternalIdentifiers() {
    	return this.decoratedExtrinsic.getExternalIdentifiers();
    }
    
    @Override
    public Set<Classification> getClassifications() {
    	return this.decoratedExtrinsic.getClassifications();
    }
    
    @Override
    public ObjectStatus getStatus() {
    	return this.decoratedExtrinsic.getStatus();
    }
}
