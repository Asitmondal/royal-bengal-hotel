package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomersInfo extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTable table;
        JButton back ;
    CustomersInfo(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
        
        
        JLabel l1 = new JLabel ("Document Type");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel ("Number");
        l2.setBounds(160, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel ("Name");
        l3.setBounds(290, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel ("Gender");
        l4.setBounds(380, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel ("Country");
        l5.setBounds(500, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel ("Room Number");
        l6.setBounds(600, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel ("Checkin time");
        l7.setBounds(740, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel ("Deposit");
        l8.setBounds(880, 10, 100, 20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0, 40, 940, 400);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e1){
		e1.printStackTrace();
            }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(400, 500, 120, 30);
	add(back);
    
        setBounds(200, 150, 940, 570);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
        
        public static void main(String[] args) {
		new CustomersInfo();
	}
}
