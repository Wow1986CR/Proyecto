package com.ucreativa.biblioteca.ui;

import com.ucreativa.biblioteca.entities.Retornante;
import com.ucreativa.biblioteca.repositories.FileRepository;
import com.ucreativa.biblioteca.services.BitacoraPrestamosService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

    public FrontEnd(String title){
        super(title);
    }

    public void build(){
        this.screenMaker();
        this.componentMaker();
        super.setVisible(true);
    }

    private void screenMaker(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400,200);
        super.setLayout(new GridLayout(7,2));
    }

    private void componentAg(Component component){
        super.getContentPane().add(component);
    }

    private void componentMaker(){
        //Labels:
        JLabel lblName = new JLabel("Nombre de la persona:");
        JLabel lblBookName = new JLabel("Nombre del libro:");
        JLabel lblPhoneNumber = new JLabel("Numero de contacto:");
        JLabel lblEmail = new JLabel("Correo Electronico:");
        JLabel lblIsDevolution = new JLabel("Es una devolucion de libro?");
        JLabel lblReference = new JLabel("Alguna referencia!?");

        //Texts:
        JTextField txtName = new JTextField();
        JTextField txtBookName = new JTextField();
        JTextField txtPhoneNumber = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtReference = new JTextField();
        JCheckBox txtIsDevolution = new JCheckBox();
        txtIsDevolution.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isPhoneRequired = (txtIsDevolution.isSelected())?"0":"";
                txtPhoneNumber.setText(isPhoneRequired);
                lblReference.setVisible(txtIsDevolution.isSelected());
                txtReference.setVisible(txtIsDevolution.isSelected());
                lblPhoneNumber.setVisible(!txtIsDevolution.isSelected());
                lblEmail.setVisible(!txtIsDevolution.isSelected());
                txtPhoneNumber.setVisible(!txtIsDevolution.isSelected());
                txtEmail.setVisible(!txtIsDevolution.isSelected());
            }
        });

        //Button:
        JButton save = new JButton("Guardar registro");
        save.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BitacoraPrestamosService service =new BitacoraPrestamosService(new FileRepository());
                try {
                    service.guardar(txtName.getText(),
                            txtBookName.getText(),
                            txtIsDevolution.isSelected(),
                            txtPhoneNumber.getText(),
                            txtEmail.getText(),
                            new Retornante("",txtReference.getText()));
                    txtName.setText("");
                    txtBookName.setText("");
                    txtPhoneNumber.setText("");
                    txtEmail.setText("");
                    txtIsDevolution.setText("");
                    txtReference.setText("");
                    String report = String.join("\n",service.get());
                    JOptionPane.showMessageDialog(((JButton)e.getSource()).getParent(),report);
                } catch (ErrorException error) {
                    JOptionPane.showMessageDialog(((JButton)e.getSource()).getParent(),error.getMessage());
                }
            }
        });

        //UI:
        this.componentAg(lblName);
        this.componentAg(txtName);
        this.componentAg(lblBookName);
        this.componentAg(txtBookName);
        this.componentAg(lblIsDevolution);
        this.componentAg(txtIsDevolution);
        this.componentAg(lblPhoneNumber);
        this.componentAg(txtPhoneNumber);
        this.componentAg(lblEmail);
        this.componentAg(txtEmail);
        this.componentAg(lblReference);
        this.componentAg(txtReference);
        this.componentAg(save);

    }//componentMaker()

}//class
