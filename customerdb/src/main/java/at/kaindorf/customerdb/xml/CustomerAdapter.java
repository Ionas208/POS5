package at.kaindorf.customerdb.xml;

import at.kaindorf.customerdb.pojos.Customer;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/*
    Created by: Jonas Seidl
    Date: 23.09.2021
    Time: 09:33
*/
public class CustomerAdapter extends XmlAdapter<Element, Customer> {
    @Override
    public Customer unmarshal(Element node) throws Exception {
        //System.out.println(node.toString());
        return null;
    }

    @Override
    public Element marshal(Customer customer) throws Exception {
        return null;
    }
}
