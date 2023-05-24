import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class  Model extends JFrame implements ActionListener {

    private JLabel label1, label2, label3;
    private JTextField textfield1, textfield2;
    private JButton boton1, boton2, boton3;
    private JComboBox combo1;
    private JTextArea textarea1;
    private JScrollPane scrollpane1;

    public Model(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Modelado");
        getContentPane().setBackground(new Color(255,0,0));
        
        label1 = new JLabel("Escribe el rendimiento:");
        label1.setBounds(30,30,250,30);
        label1.setForeground(new Color(255,255,255));
        label1.setFont(new Font("Andale Mono", 1, 14));
        add(label1);

        textfield1 = new JTextField();
        textfield1.setBounds(210,35,190,25);
        textfield1.setForeground(new Color(255,0,0));
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setFont(new Font("Andale Mono", 1, 14));
        add(textfield1);

        label2 = new JLabel("Escribe el saldo inicial:");
        label2.setBounds(30,70,250,30);
        label2.setForeground(new Color(255,255,255));
        label2.setFont(new Font("Andale Mono", 1, 14));
        add(label2);

        textfield2 = new JTextField();
        textfield2.setBounds(210,75,190,25);
        textfield2.setForeground(new Color(255,0,0));
        textfield2.setBackground(new Color(255,255,255));
        textfield2.setFont(new Font("Andale Mono", 1, 14));
        add(textfield2);

        label3 = new JLabel("Selecciona los años:");
        label3.setBounds(30,110,250,30);
        label3.setForeground(new Color(255,255,255));
        label3.setFont(new Font("Andale Mono", 1, 14));
        add(label3);

        combo1 = new JComboBox();
        combo1.setBounds(210,115,190,25);
        combo1.setForeground(new Color(255,0,0));
        combo1.setBackground(new Color(255,255,255));
        combo1.setFont(new Font("Andale Mono", 1, 14));
        add(combo1);
        combo1.addItem("");

        for(int i = 0; i <= 100; i++){

            combo1.addItem(String.valueOf(i));
        }

        textarea1 = new JTextArea();
        textarea1.setForeground(new Color(255,0,0));
        textarea1.setEditable(false);
        textarea1.setFont(new Font("Andale Mono", 1, 14));
        textarea1.setBackground(new Color(255,255,255));
        textarea1.setText("\n  Saldo Final: ");
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(30,155,370, 120);
        add(scrollpane1);

        boton1 = new JButton("CALCULAR");
        boton1.setBounds(50,300,150,30);
        boton1.setForeground(new Color(255,0,0));
        boton1.setBackground(new Color(255,255,255));
        boton1.setFont(new Font("Andale Mono", 1, 14));
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("NUEVO");
        boton2.setBounds(210,300,150,30);
        boton2.setForeground(new Color(255,0,0));
        boton2.setBackground(new Color(255,255,255));
        boton2.setFont(new Font("Andale Mono", 1, 14));
        add(boton2);
        boton2.addActionListener(this);

        boton3 = new JButton("SIGUIENTE");
        boton3.setBounds(100,340,150,30);
        boton3.setForeground(new Color(255,0,0));
        boton3.setBackground(new Color(255,255,255));
        boton3.setFont(new Font("Andale Mono", 1, 14));
        add(boton3);
        boton3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == boton1){

            try{

            String rendimiento_String = textfield1.getText().trim();
            String saldo_String = textfield2.getText().trim();
            String tiempo_String = combo1.getSelectedItem().toString();

            if(rendimiento_String.equals("") || saldo_String.equals("") || tiempo_String.equals("")){

                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

            } else {

            DecimalFormat limitado = new DecimalFormat("#.00");

            float rendimiento = Float.parseFloat(textfield1.getText().trim());
            float saldo = Float.parseFloat(textfield2.getText().trim());
            int tiempo = Integer.parseInt(combo1.getSelectedItem().toString());

            if(saldo <= 0){

                JOptionPane.showMessageDialog(null, "El Saldo es invalido");
                textfield2.setText("");

            } else {

                if(rendimiento <= 0  || rendimiento > 1){
                    JOptionPane.showMessageDialog(null, "El rendimiento es Invalido");
                    textfield1.setText("");

                } else {

                if(rendimiento < 0.01){

            float porcentaje1 = rendimiento * 100;
            
            String porcentaje = String.valueOf(limitado.format(porcentaje1));

            double resultado = saldo * (Math.exp(rendimiento * tiempo));

            String result = String.valueOf(limitado.format(resultado));

            textarea1.setText("\n  El saldo final en " + tiempo + "\n  años con un rendimiento de " + rendimiento +
            "  \n  equivalente al 0" + porcentaje + " % anual \n  es de: " + 
            result + " $");

                } else {

            float porcentaje1 = rendimiento * 100;
            
            String porcentaje = String.valueOf(limitado.format(porcentaje1));

            double resultado = saldo * (Math.exp(rendimiento * tiempo));

            String result = String.valueOf(limitado.format(resultado));

            textarea1.setText("\n  El saldo final en " + tiempo + "\n  años con un rendimiento de " + rendimiento +
            "  \n  equivalente al " + porcentaje + " % anual \n  es de: " + 
            result + " $");

            }

            }
            }
            }
        }

            catch(Exception err){

                JOptionPane.showMessageDialog(null, "Error, Vuelva a intentar");
                textfield1.setText("");
                textfield2.setText("");
                combo1.setSelectedIndex(0);

            }

        }

        if(e.getSource() == boton2){

            String rendimiento_String = textfield1.getText().trim();
            String saldo_String = textfield2.getText().trim();
            String tiempo_String = combo1.getSelectedItem().toString();

            if(rendimiento_String.equals("") && saldo_String.equals("") && tiempo_String.equals("")){

                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
                
            } else {

            textfield1.setText("");
            textfield2.setText("");
            combo1.setSelectedIndex(0);
            textarea1.setText("\n  Saldo Final: ");     
        }
    }


    if(e.getSource() == boton3){

        Model2 model2 = new Model2();
        model2.setBounds(0,0,450,450);
        model2.setVisible(true);
        model2.setResizable(false);
        model2.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    }
    
    public static void main(String args[]){

        Model model1 = new Model();
        model1.setBounds(0,0,450,450);
        model1.setVisible(true);
        model1.setResizable(false);
        model1.setLocationRelativeTo(null);
    }
}
