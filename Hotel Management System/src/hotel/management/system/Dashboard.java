package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
    
    public Dashboard() {
        super("Royal Bengal Hotel");
	
        setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1550, 1000); 
        add(NewLabel);
        
        JLabel text = new JLabel("The Royal Bengal Hotel warmly welcomes you.");
	text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
	text.setBounds(190, 0, 1250, 100);
	NewLabel.add(text);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu hManagement = new JMenu("HOTEL MANAGEMENT");
        hManagement.setForeground(Color.BLUE);
	menuBar.add(hManagement);
		
        JMenuItem reception = new JMenuItem("RECEPTION");
        //reception.addActionListener(this);
	hManagement.add(reception);
		
	JMenu hAdmin = new JMenu("ADMIN");
        hAdmin.setForeground(Color.RED);
	menuBar.add(hAdmin);
        
        JMenuItem aEmployee = new JMenuItem("ADD EMPLOYEE");
	hAdmin.add(aEmployee);
        
        aEmployee.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        JMenuItem aRoom = new JMenuItem("ADD ROOMS");
	hAdmin.add(aRoom);
        
        aRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	reception.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
        
        
        JMenuItem aDriver = new JMenuItem("ADD DRIVERS");
	hAdmin.add(aDriver);
        
	aDriver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddDrivers().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
		
        setSize(1550,1000);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
