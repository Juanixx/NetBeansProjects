package Controladores;

import Operaciones.*;
import Agregar.AgregarPelicula;
import Vistas.Borrar.BorrarPelicula;
import Vistas.modificar.ModificarPelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CtrlPeliculas {
    AgregarPelicula ventana;
    BorrarPelicula bPelicula;
    ModificarPelicula mPelicula;
    public CtrlPeliculas(AgregarPelicula ventana,BorrarPelicula bPelicula,ModificarPelicula mPelicula) {
        this.ventana = ventana;
        this.bPelicula=bPelicula;
        this.mPelicula=mPelicula;
        this.ventana.setVisible(true);
        
        cargarEscuchadores();
    }
    
    public void cargarEscuchadores()
    {
      this.ventana.getbAgregar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              altaPelicula();
          }

          
      });
      this.bPelicula.getBorrar().addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              borraPelicula();
          }
      });
      this.mPelicula.getModificar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              modificarPelicula();
          }
      });
    }
    
    
    public void altaPelicula(){
    
    Agregar.agregarPelicula(this.ventana.getId().getText(),this.ventana.getTitulo().getText(),
            this.ventana.getClas().getText(),this.ventana.getId_socio().getText());
    }
    public void borraPelicula(){
    Eliminar.eliminarPelicula(this.bPelicula.getBorrar().getText());
    }
    
    public void modificarPelicula(){
    Modificar.modficarPelicula(this.mPelicula.getIdant().getText(), this.mPelicula.getNombrenuevo().getText(),
    this.mPelicula.getIdnuevo().getText(), this.mPelicula.getClasificacionnueva().getText(),this.mPelicula.getNuevoidsocio().getText() );
    
    }
    
}
