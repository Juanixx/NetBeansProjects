
package Controladores;
import Operaciones.*;
import Agregar.AgregarSocio;
import Vistas.Borrar.BorrarSocio;
import Vistas.modificar.ModificarSocio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlSocios {
    AgregarSocio ventana;
    BorrarSocio bSocio;
    ModificarSocio mSocio;
    public CtrlSocios(AgregarSocio ventana,BorrarSocio bSocio,ModificarSocio mSocio) {
        this.ventana = ventana;
        this.bSocio=bSocio;
        this.mSocio=mSocio;
        this.ventana.setVisible(true);
        
        cargarEscuchadores();
    }
    
    public void cargarEscuchadores()
    {
      this.ventana.getAgregar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
           altaSocio();
          }
      });
      this.bSocio.getBorrar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
          borraSocio();
          }
      });
      this.mSocio.getModificar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
          ModificarSocio();
          }
      });
    }
    
    
    public void altaSocio(){
    
    Agregar.agregarSocio(this.ventana.getId_soc().getText(), this.ventana.getNombre().getText(),
            this.ventana.getApellido().getText(), this.ventana.getTel().getText());
    
    }
    public void borraSocio(){
    Eliminar.eliminarSocio(this.bSocio.getBorrar().getText());
    }
    
    public void ModificarSocio(){
    Modificar.modficarSocio(this.mSocio.getId_ant().getText(), this.mSocio.getNombre_nuevo().getText(),
    this.mSocio.getId_nuevo().getText(), this.mSocio.getApellido_nuevo().getText(), this.mSocio.getTel_nuevo().getText());
    }
    
}
