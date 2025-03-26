import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFormEmployee extends JFrame implements ActionListener
 {
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3,b4,b5,b6;
    public MainFormEmployee()
    {


        l1 = new JLabel("           Employee Id         ");
        l2 = new JLabel("           Employee Name       ");
        l3 = new JLabel("           Employee Post       ");
        l4 = new JLabel("           Employee Salary     ");
        l5 = new JLabel("             Result              ");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);
        t5.setEditable(false);


        b1 = new JButton("Insert");
        b2 = new JButton("Delete");
        b3 = new JButton("Update");
        b4 = new JButton("Search");
        b5 = new JButton("Reset");
        b6 = new JButton("Employe Count");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(l5);
        add(t5);
        setSize(350, 300);
        setLayout(new GridLayout(8,2));
        setTitle("Student Form");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);



    }
    public void actionPerformed(ActionEvent e)
     {
            Employ employ = new Employ();
            try
            {
                employ.setE_id(Integer.parseInt(t1.getText()));
            }
            catch(NumberFormatException e1)
            {
                System.out.println(e1.getMessage());

            }
            employ.setName(t2.getText());
            employ.setPost(t3.getText());
            try
            {
                employ.setSalary(Double.parseDouble(t4.getText()));
            }
            catch (NumberFormatException ex)
            {
                System.out.print("Invalid input");
            }
            DBService db = new DBService();
            if(e.getSource()==b1)
            {
                if(db.addEmploy(employ))
                {
                    t5.setText("Employee added");
                }
                else
                {
                    t5.setText("Empolyee not added ");
                }
            }
            if(e.getSource()==b2)
            {
                if(db.deleteEmploy(employ))
                {

                    t5.setText("Employee record deleted");
                }
                else
                {
                    t5.setText("Employee record not deleted");
                }
            }
         if(e.getSource()==b3)
         {
                if(db.updateEmploy(employ))
                {
                    t5.setText("    Record updated");
                }
                else {
                    t5.setText("Record not updated ");
                }
         }
         if(e.getSource()==b4)
         {
                Employ employee=db.searchEmploy(employ);
                if(employee!=null)
                {
                    t1.setText(String.valueOf(employee.getE_id()));
                    t2.setText(employee.getName());
                    t3.setText(employee.getPost());
                    t4.setText(String.valueOf(employee.getSalary()));
                    t5.setText("    Data found");
                }
             else
             {
                 t5.setText("Data not found");
             }
         }
         if(e.getSource()==b5)
         {
             t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");
             t5.setText("");

         }
         if(e.getSource()==b6)
         {
             t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");

             t5.setText("Number of Employee "+String.valueOf(db.numberOfEmploy(employ)));
         }


    }

    public static void main(String[] args)
    {
        MainFormEmployee mf = new MainFormEmployee();
        mf.setVisible(true);
        mf.setLocation(150, 150);

        System.out.println("Hello from main");
    }

}
