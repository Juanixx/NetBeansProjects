
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Carrera extends JFrame {
    JPanel[] paneles;
    JLabel[] labels;
    String[] nombres={"camello","murcielago","pajaro","ariel"};
    JButton PausarCamello,ReanudarCamello,MatarCamello;
    JButton PausarMurcielago,ReanudarMurcielago,MatarMurcielago;
    JButton PausarPajaro,ReanudarPajaro,MatarPajaro;
    JButton PausarAAriel,ReanudarAAriel,MatarAAriel;
    JButton ReiniciaCamello, ReiniciaMurcielago,ReiniciaPajaro, ReiniciaAriel, ReiniciarTodo;
    Animal camello;
            Animal murcielago;
            Animal pajaro;
            Animal ariel;
    int ANCHO=700;
    public Carrera(){
        
        setLayout(new GridLayout(0,1));
        paneles=new JPanel[4];
        labels=new JLabel[4];
        
        for(int n=0; n<4;n++){
        paneles[n]=new  JPanel();
        add (paneles[n]);
        labels[n]=new JLabel(nombres[n]);
        labels[n].setIcon(new ImageIcon(getClass().getResource(nombres[n]+".gif")));
        paneles[n].add(labels[n]);
        labels[n].setLocation(0,0);
        }
        PausarCamello=new JButton("Pausar");
        ReanudarCamello=new JButton("Reanudar");
        MatarCamello=new JButton("Matar");
        MatarMurcielago=new JButton("Matar");
        ReanudarMurcielago=new JButton("Reanudar");
        PausarMurcielago=new JButton("Pausar");
        MatarPajaro=new JButton("Matar");
        ReanudarPajaro=new JButton("Reanudar");
        PausarPajaro=new JButton("Pausar");
        MatarAAriel=new JButton("Matar");
        ReanudarAAriel=new JButton("Reanudar");
        PausarAAriel=new JButton("Pausar");
        ReiniciaCamello=new JButton("Reiniciar");
        ReiniciaMurcielago=new JButton("Reiniciar");
        ReiniciaPajaro=new JButton("Reiniciar");
        ReiniciaAriel=new JButton("Reiniciar");
        ReiniciarTodo=new JButton("Iniciar/Reiniciar todo");
        add(ReiniciarTodo);
        paneles[0].add(PausarCamello);
        paneles[0].add(ReanudarCamello);
        paneles[0].add(MatarCamello);
        paneles[0].add(ReiniciaCamello);
        
        paneles[1].add(PausarMurcielago);
        paneles[1].add(ReanudarMurcielago);
        paneles[1].add(MatarMurcielago);
        paneles[1].add(ReiniciaMurcielago);
        
        paneles[2].add(PausarPajaro);
        paneles[2].add(ReanudarPajaro);
        paneles[2].add(MatarPajaro);
        paneles[2].add(ReiniciaPajaro);
        
        
        paneles[3].add(PausarAAriel);
        paneles[3].add(ReanudarAAriel);
        paneles[3].add(MatarAAriel);
        paneles[3].add(ReiniciaAriel);
        this.ariel = new Animal("Ariel",ANCHO-150,labels[3]);
        this.pajaro = new Animal("Pajaro",ANCHO-150,labels[2]);
        this.murcielago = new Animal("Murcielago",ANCHO-150,labels[1]);
        this.camello = new Animal("Camello",ANCHO-150,labels[0]);
        
        PausarCamello.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                camello.suspend();
            }
        });
        
        ReanudarCamello.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                camello.resume();
            }
        });
         MatarCamello.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                camello.stop();
            }
        });
         ReiniciaCamello.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                camello.stop();
                camello =new Animal("Camello",ANCHO-150,labels[0]);
                
                camello.start();
                
            }
        });
        
         
         
         PausarMurcielago.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                murcielago.suspend();
            }
        });
        
        ReanudarMurcielago.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                murcielago.resume();
            }
        });
         MatarMurcielago.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                murcielago.stop();
            }
        });
         ReiniciaMurcielago.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                murcielago.stop();
                murcielago =new Animal("Murcielago",ANCHO-150,labels[1]);
                murcielago.start();
                
            }
        });
         
         
         
         PausarPajaro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pajaro.suspend();
            }
        });
        
        ReanudarPajaro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pajaro.resume();
            }
        });
         MatarPajaro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pajaro.stop();
            }
        });
         ReiniciaPajaro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pajaro.stop();
                pajaro =new Animal("Pajaro",ANCHO-150,labels[2]);
                
                pajaro.start();
                
            }
        });
         
         ReiniciarTodo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                camello.stop();
                murcielago.stop();
                pajaro.stop();
                ariel.stop();
                ariel = new Animal("Ariel",ANCHO-150,labels[3]);
        pajaro = new Animal("Pajaro",ANCHO-150,labels[2]);
        murcielago = new Animal("Murcielago",ANCHO-150,labels[1]);
        camello = new Animal("Camello",ANCHO-150,labels[0]);
                camello.start();
                murcielago.start();
                pajaro.start();
                ariel.start();
            }
        });
         
         
         
         
         PausarAAriel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ariel.suspend();
            }
        });
        
        ReanudarAAriel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ariel.resume();
            }
        });
         MatarAAriel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ariel.stop();
            }
        });
         ReiniciaAriel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ariel.stop();
                ariel =new Animal("Ariel",ANCHO-150,labels[3]);
                
                ariel.start();
                
            }
        });
         
         
         
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocation(200,250);
         setSize(ANCHO,650);
         setVisible(true);
    }
    
    public static void main(String[] args) {
        Carrera carrera=new Carrera();
        
    }
    
}
