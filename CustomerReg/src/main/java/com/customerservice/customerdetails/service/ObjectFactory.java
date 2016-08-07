
package com.customerservice.customerdetails.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.customerservice.customerdetails.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServicePlan_QNAME = new QName("http://service.customerdetails.customerservice.com/", "servicePlan");
    private final static QName _GetServicePlansResponse_QNAME = new QName("http://service.customerdetails.customerservice.com/", "getServicePlansResponse");
    private final static QName _GetServicePlans_QNAME = new QName("http://service.customerdetails.customerservice.com/", "getServicePlans");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.customerservice.customerdetails.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServicePlan }
     * 
     */
    public ServicePlan createServicePlan() {
        return new ServicePlan();
    }

    /**
     * Create an instance of {@link GetServicePlans }
     * 
     */
    public GetServicePlans createGetServicePlans() {
        return new GetServicePlans();
    }

    /**
     * Create an instance of {@link GetServicePlansResponse }
     * 
     */
    public GetServicePlansResponse createGetServicePlansResponse() {
        return new GetServicePlansResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServicePlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.customerdetails.customerservice.com/", name = "servicePlan")
    public JAXBElement<ServicePlan> createServicePlan(ServicePlan value) {
        return new JAXBElement<ServicePlan>(_ServicePlan_QNAME, ServicePlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServicePlansResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.customerdetails.customerservice.com/", name = "getServicePlansResponse")
    public JAXBElement<GetServicePlansResponse> createGetServicePlansResponse(GetServicePlansResponse value) {
        return new JAXBElement<GetServicePlansResponse>(_GetServicePlansResponse_QNAME, GetServicePlansResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServicePlans }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.customerdetails.customerservice.com/", name = "getServicePlans")
    public JAXBElement<GetServicePlans> createGetServicePlans(GetServicePlans value) {
        return new JAXBElement<GetServicePlans>(_GetServicePlans_QNAME, GetServicePlans.class, null, value);
    }

}
