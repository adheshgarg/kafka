package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.ThreadInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "MyThreadXML")
public class MyThreadXML extends Thread implements ThreadInterface {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "Kafka_Employee_json";

    //KafkaProducer<String, String> producer = new KafkaProducer<String,String>(producerConfigs());


    @Autowired
    EmployeeRepository employeeRepository;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void read() {
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


                    String jsonString="";
                    ObjectMapper objectMapper=new ObjectMapper();
                    try{
                        jsonString=objectMapper.writeValueAsString(employee);
                        System.out.println(jsonString);
                    }
                    catch(IOException io){
                        io.printStackTrace();
                    }

                    ProducerService producerService=new ProducerService();
                    producerService.sendMessage(jsonString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public MyThreadXML() {
    }

    @Override
    public void run() {
        super.run();
        try {
            this.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
