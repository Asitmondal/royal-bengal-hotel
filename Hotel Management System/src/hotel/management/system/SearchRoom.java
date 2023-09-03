package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTable table;
        JButton back, submit;
        JComboBox bedType;
        JCheckBox available;
    SearchRoom(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        JLabel next = new JLabel ("Search for Room");
        next.setFont(new Font("Tahoma",Font.PLAIN, 20));
        next.setBounds(400, 30, 200, 30);
        add(next);
        
        JLabel lblbed = new JLabel ("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        bedType = new JComboBox(new String[] {"Single Bed", "Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox ("Only display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1 = new JLabel ("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel ("Availibility");
        l2.setBounds(270, 160, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel ("Cleaning Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel ("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel ("Bed Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e1){
		e1.printStackTrace();
            }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 500, 120, 30);
	add(submit);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(480, 500, 120, 30);
	add(back);
    
        setBounds(200, 150, 1000, 570);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
                
                conn c = new conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = c.s.executeQuery(query2);
                } else {
                    rs = c.s.executeQuery(query1);
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e1){
		e1.printStackTrace();
            }
            
        }else{
        setVisible(false);
        new Reception();
    }
    }
        
        public static void main(String[] args) {
		new SearchRoom();
	}
}

