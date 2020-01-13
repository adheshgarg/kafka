package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class MyThreadXML extends Thread implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ArrayList<Employee> readCSV() throws Exception {
        return null;
    }

    public static ArrayList<Employee> employeeXML =new ArrayList<Employee>();


    @Override
    public ArrayList<Employee> readXML() {
        try
        {
            File file = new File("employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("employee");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Employee employee = new Employee();
                    Element eElement = (Element) node;
                    String firstName = eElement.getElementsByTagName("firstName").item(0).getTextContent();
                    employee.setFirstName(firstName);
                    String lastName = eElement.getElementsByTagName("lastName").item(0).getTextContent();
                    employee.setLastName(lastName);
                    String q = eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(q);
                    employee.setDateOfBirth(dateOfBirth);
                    long experience = Integer.parseInt(eElement.getElementsByTagName("experience").item(0).getTextContent());
                    employee.setExperience(experience);
                    employeeXML.add(employee);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeXML;
    }

    @Override
    public ArrayList<Employee> readJSON() {
        return null;
    }

    public MyThreadXML() {
    }

    @Override
    public void run() {
        super.run();
        try {
            this.readXML();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
