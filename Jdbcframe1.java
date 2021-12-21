import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Jdbcframe1 extends JFrame implements ActionListener
{
public JLabel l1,l2,l3,l4,l5;
public JTextField t1,t2,t3,t4,t5;
public JButton b1;
Container c;
public Jdbcframe1()
{
setSize(180,400);
setTitle("STUDENT DETAILS");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c=getContentPane();
c.setLayout(new FlowLayout());
l1=new JLabel("Regno");
c.add(l1);
t1=new JTextField(10);
c.add(t1);
l2=new JLabel("Name");
c.add(l2);
t2=new JTextField(10);
c.add(t2);
l3=new JLabel("Dept");
c.add(l3);
t3=new JTextField(10);
c.add(t3);
l4=new JLabel("Course");
c.add(l4);
t4=new JTextField(10);
c.add(t4);
l5=new JLabel("Contact");
c.add(l5);
t5=new JTextField(12);
c.add(t5);
b1=new JButton("SAVE");
c.add(b1);
b1.addActionListener(this); 
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:student");
Statement st=con.createStatement();
PreparedStatement ps,ps1;
ps1=con.prepareStatement("select * from student where regno="+t1.getText());

ps=con.prepareStatement("insert into student(regno,name,dept,course,contact)values(?,?,?,?,?)");
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,t3.getText());
ps.setString(4,t4.getText());
ps.setString(5,t5.getText());
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"RECORD SAVED");
}
catch(SQLException sq)
{
System.out.println(sq);
System.out.println("\nHai this place is error occur");
}
catch(Exception e)
{
System.out.println(e);
}
}
}
public static void main(String args[])
{
Jdbcframe1 f=new Jdbcframe1();
}
}
