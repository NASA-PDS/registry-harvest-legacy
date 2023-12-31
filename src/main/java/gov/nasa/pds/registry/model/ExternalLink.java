package gov.nasa.pds.registry.model;

import java.net.URI;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ExternalLinks use URIs to associate content in the registry with content that
 * MAY reside outside the registry. For example, an organization submitting
 * an XML Schema could use an ExternalLink to associate the XML Schema with
 * the organization's home page.
 * 
 * @author pramirez
 * 
 */
@Entity
@XmlRootElement(name = "externalLink", namespace = "http://registry.pds.nasa.gov")
@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalLink extends RegistryObject {
  private static final long serialVersionUID = -1796281590029700135L;

  @XmlAttribute
  private URI externalURI;

  public ExternalLink() {
    this.setObjectType(ExternalLink.class.getSimpleName());
    this.setVersionName(null);
  }

  public URI getExternalURI() {
    return externalURI;
  }

  public void setExternalURI(URI externalURI) {
    this.externalURI = externalURI;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
        + ((externalURI == null) ? 0 : externalURI.hashCode());
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
    ExternalLink other = (ExternalLink) obj;
    if (externalURI == null) {
      if (other.externalURI != null)
        return false;
    } else if (!externalURI.equals(other.externalURI))
      return false;
    return true;
  }

}
