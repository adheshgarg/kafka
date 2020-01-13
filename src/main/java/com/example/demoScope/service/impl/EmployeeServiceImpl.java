package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee = new Employee();

    //CSV READING STARTS------------------
    public ArrayList<Employee> readcsv() throws Exception {
        //CSVFile CSVFile = new CSVFile();
        ArrayList<Employee> arrayList = new ArrayList<Employee>();
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader("employee.csv"));
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        String values[] = new String[100];
        for (int i = 0; i < 100; i++) {
            //Employee e=new Employee();
            values = lines.get(i).split(",");
            System.out.println(Arrays.toString(values));
            ((Employee) employee).setFirstName((String) values[0]);
            ((Employee) employee).setLastName((String) values[1]);
            ((Employee) employee).setDateOfBirth((String) values[2]);
            ((Employee) employee).setExperience(new Double(values[3]).toString());

            employee.setFirstName(values[0]);
            employee.setLastName(values[1]);
            Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(values[2]);
            employee.setDateOfBirth(dateOfBirth);
            employee.setExperience((Integer.parseInt(values[3])));
        }
        return arrayList;
    }
    //CSV READING ENDS-----------------


    // XML starts here----------------------------------------------------------------



    public static ArrayList<Employee> employeeArray =new ArrayList<Employee>();

    public ArrayList<Employee> readXml()
    {
​
        try
        {
            File file = new File("employee.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("employee");
            int arraylen = nodeList.getLength();
​
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Employee employee=new Employee();
                    Element eElement = (Element) node;
                    firstName=eElement.getElementsByTagName("firstName").item(0).getTextContent();
                    employee.setFirstName(firstName);
                    lastName=eElement.getElementsByTagName("lastName").item(0).getTextContent();
                    employee.setLastName(lastName);
                    String q=eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    dateOfBirth=new SimpleDateFormat("dd/MM/yyyy").parse(q);
                    employee.setDateOfBirth(dateOfBirth);
                    experience=Integer.parseInt(eElement.getElementsByTagName("experience").item(0).getTextContent());
                    employee.setExperience(experience);
                    employeeArray.add(employee);
                }
​
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employeeArray;
    }


    //// XML ENDS----------------------------------------------------------------------

    /// JSON READ STARTS --------------------------------------------------------------
    public ArrayList<Employee> readJSON() throws Exception {
        ArrayList<Employee> employeeArray = new ArrayList();
        Object obj = new JSONParser().parse(new FileReader("employee.json"));

        JSONArray jsonArrayRead = (JSONArray) obj;

        for (int i = 0; i < 100; i++) {
            Employee emp = new Employee();


            JSONObject data = (JSONObject) jsonArrayRead.get(i);

            String dateOfBirth = (String) data.get("dateOfBirth");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");

            Date date = simpleDateFormat.parse(dateOfBirth);
            String firstname = (String) data.get("firstName");
            emp.setFirstName(firstname);

            String lastname = (String) data.get("lastName");
            emp.setLastName(lastname);

            emp.setDateOfBirth(date);

            long Experience = (long) data.get("experience");
            emp.setExperience(Experience);


            employeeArray.add(emp);


        }
        return employeeArray;
    }

    //JSON READ ENDS ----------------------------------------------------------------------------------

}
