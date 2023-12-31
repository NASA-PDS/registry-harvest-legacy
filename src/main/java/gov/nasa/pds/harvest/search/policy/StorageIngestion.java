//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.22 at 08:05:55 PM PDT 
//


package gov.nasa.pds.harvest.search.policy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageIngestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageIngestion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{https://pds.nasa.gov/software/pds4/harvest/v1}serverUrl"/>
 *         &lt;element ref="{https://pds.nasa.gov/software/pds4/harvest/v1}dataTransferType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageIngestion", propOrder = {
    "serverUrl",
    "dataTransferType"
})
public class StorageIngestion {

    @XmlElement(required = true)
    protected String serverUrl;
    protected String dataTransferType;

    /**
     * Gets the value of the serverUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * Sets the value of the serverUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerUrl(String value) {
        this.serverUrl = value;
    }

    /**
     * Gets the value of the dataTransferType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataTransferType() {
        return dataTransferType;
    }

    /**
     * Sets the value of the dataTransferType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataTransferType(String value) {
        this.dataTransferType = value;
    }

}
