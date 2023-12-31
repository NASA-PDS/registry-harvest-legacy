//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.22 at 08:05:55 PM PDT 
//


package gov.nasa.pds.harvest.search.policy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TitleContents complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TitleContents">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{https://pds.nasa.gov/software/pds4/harvest/v1}elementName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{https://pds.nasa.gov/software/pds4/harvest/v1}appendFilename"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TitleContents", propOrder = {
    "elementName"
})
public class TitleContents {

    protected List<ElementName> elementName;
    @XmlAttribute(name = "appendFilename", namespace = "https://pds.nasa.gov/software/pds4/harvest/v1")
    protected Boolean appendFilename;

    /**
     * Gets the value of the elementName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementName }
     * 
     * 
     */
    public List<ElementName> getElementName() {
        if (elementName == null) {
            elementName = new ArrayList<ElementName>();
        }
        return this.elementName;
    }

    /**
     * Gets the value of the appendFilename property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAppendFilename() {
        if (appendFilename == null) {
            return false;
        } else {
            return appendFilename;
        }
    }

    /**
     * Sets the value of the appendFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAppendFilename(Boolean value) {
        this.appendFilename = value;
    }

}
