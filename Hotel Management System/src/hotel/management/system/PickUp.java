package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickUp extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTable table;
        JButton back, submit;
        Choice typeofcar;
        JCheckBox available;
    PickUp(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        JLabel next = new JLabel ("PickUp Service");
        next.setFont(new Font("Tahoma",Font.PLAIN, 20));
        next.setBounds(400, 30, 200, 30);
        add(next);
        
        JLabel lblbed = new JLabel ("Type of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150, 100, 200, 25);
        add(typeofcar);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e){
		e.printStackTrace();
        }
        
        JLabel l1 = new JLabel ("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel ("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel ("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel ("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel ("Brand");
        l5.setBounds(630, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel ("Avalilability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel ("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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
                String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                
                conn c = new conn();
                ResultSet rs;
                rs = c.s.executeQuery(query);
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
		new PickUp();
	}
}


