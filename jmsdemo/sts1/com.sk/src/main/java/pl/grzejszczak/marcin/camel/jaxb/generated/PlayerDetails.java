package pl.grzejszczak.marcin.camel.jaxb.generated;
//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
//Any modifications to this file will be lost upon recompilation of the source schema.
//Generated on: 2012.11.05 at 09:23:22 PM CET
//



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
* Java class for anonymous complex type.
*
*

The following schema fragment specifies the expected content contained within this class.
*
*

<pre> * <complexType>
*   <complexContent>
*     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       <sequence>
*         <element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         <element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         <element name="Position" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         <element name="Age" type="{http://www.w3.org/2001/XMLSchema}int"/>
*         <element name="TeamName" type="{http://www.w3.org/2001/XMLSchema}string"/>
*       </sequence>
*     </restriction>
*   </complexContent>
* </complexType>
* </pre>
*
*
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
 "name",
 "surname",
 "position",
 "age",
 "teamName"
})
@XmlRootElement(name = "PlayerDetails")
public class PlayerDetails {

 @XmlElement(name = "Name", required = true)
 protected String name;
 @XmlElement(name = "Surname", required = true)
 protected String surname;
 @XmlElement(name = "Position", required = true)
 protected String position;
 @XmlElement(name = "Age")
 protected int age;
 @XmlElement(name = "TeamName", required = true)
 protected String teamName;

 /**
  * Gets the value of the name property.
  *
  * @return
  *     possible object is
  *     {@link String }
  *    
  */
 public String getName() {
     return name;
 }

 /**
  * Sets the value of the name property.
  *
  * @param value
  *     allowed object is
  *     {@link String }
  *    
  */
 public void setName(String value) {
     this.name = value;
 }

 /**
  * Gets the value of the surname property.
  *
  * @return
  *     possible object is
  *     {@link String }
  *    
  */
 public String getSurname() {
     return surname;
 }

 /**
  * Sets the value of the surname property.
  *
  * @param value
  *     allowed object is
  *     {@link String }
  *    
  */
 public void setSurname(String value) {
     this.surname = value;
 }

 /**
  * Gets the value of the position property.
  *
  * @return
  *     possible object is
  *     {@link PositionType }
  *    
  */
 public String getPosition() {
     return position;
 }

 /**
  * Sets the value of the position property.
  *
  * @param value
  *     allowed object is
  *     {@link PositionType }
  *    
  */
 public void setPosition(String value) {
     this.position = value;
 }

 /**
  * Gets the value of the age property.
  *
  */
 public int getAge() {
     return age;
 }

 /**
  * Sets the value of the age property.
  *
  */
 public void setAge(int value) {
     this.age = value;
 }

 /**
  * Gets the value of the teamName property.
  *
  * @return
  *     possible object is
  *     {@link String }
  *    
  */
 public String getTeamName() {
     return teamName;
 }

 /**
  * Sets the value of the teamName property.
  *
  * @param value
  *     allowed object is
  *     {@link String }
  *    
  */
 public void setTeamName(String value) {
     this.teamName = value;
 }

}
