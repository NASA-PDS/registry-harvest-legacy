package gov.nasa.pds.registry.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Service instances describe services, such as web services, web sites, FTP
 * servers, etc.
 * 
 * @author pramirez
 * 
 */
@Entity
@XmlRootElement(name = "service", namespace = "http://registry.pds.nasa.gov")
@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Service extends RegistryObject {

  private static final long serialVersionUID = 2585847115001850718L;

  /**
   * A Service MAY have a serviceBindings attribute that defines the service
   * bindings that provide access to that Service.
   */
  @OneToMany(cascade = CascadeType.ALL)
  @XmlElementRef(name="serviceBinding", namespace = "http://registry.pds.nasa.gov")
  @OrderBy
  private Set<ServiceBinding> serviceBindings;
  
  public Service() {
    this.setObjectType(Service.class.getSimpleName());
  }

  public Set<ServiceBinding> getServiceBindings() {
    return serviceBindings;
  }

  public void setServiceBindings(Set<ServiceBinding> serviceBindings) {
    this.serviceBindings = serviceBindings;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
        + ((serviceBindings == null) ? 0 : serviceBindings.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Service other = (Service) obj;
    if (serviceBindings == null) {
      if (other.serviceBindings != null)
        return false;
    } else if (!serviceBindings.equals(other.serviceBindings))
      return false;
    return true;
  }

}
