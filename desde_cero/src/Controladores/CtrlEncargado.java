

package Controladores;
import Operaciones.*;
import Agregar.AgregarEncargado;
import Vistas.Borrar.BorrarEncargado;
import Vistas.modificar.ModificarEncargado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CtrlEncargado {
    AgregarEncargado vEncargado;
    BorrarEncargado bEncargado;
    ModificarEncargado mEncargado;
    public CtrlEncargado(AgregarEncargado ventana,BorrarEncargado bEncargado, ModificarEncargado mEncargado) {
        this.vEncargado = ventana;
        this.bEncargado=bEncargado;
        this.mEncargado=mEncargado;
        this.vEncargado.setVisible(true);
        
        cargarEscuchadores();
    }
    
    public void cargarEscuchadores()
    {
      this.vEncargado.getAgregar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              altaEncargado();
          }

          
      });
      this.bEncargado.getBorrar().addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              borraEncargado();
          }
      });
      this.mEncargado.getModificar().addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
          modificarEncargado();
          }
      });
      
    }
    
    
    public void altaEncargado(){
    
    Agregar.agregarEncargado(this.vEncargado.getIdenc().getText(),this.vEncargado.getNombre().getText()
            , this.vEncargado.getApellido().getText(), this.vEncargado.getImss().getText(), this.vEncargado.getFnac().getText(), 
            this.vEncargado.getTel().getText());
   
    }
    public void borraEncargado(){
    Eliminar.eliminarEncargado(this.bEncargado.getBorrar().getText());
    }
    public void modificarEncargado(){
    Modificar.modficarEncargado(this.mEncargado.getId_an().getText(), this.mEncargado.getNombre_new().getText(),
    this.mEncargado.getId_new().getText(), this.mEncargado.getApellido_new().getText(),
    this.mEncargado.getImss_new().getText(), this.mEncargado.getFecha_new().getText(), this.mEncargado.getTel_new().getText());
    }
}
