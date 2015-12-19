
package Controladores;
import Operaciones.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Agregar.AgregarCliente;
import Vistas.Borrar.BorrarCliente;
import Vistas.modificar.ModificarCliente;

public class CtrlClientes {
    AgregarCliente vCliente;
    BorrarCliente bCliente;
    ModificarCliente mCliente;
    public CtrlClientes(AgregarCliente vCliente,BorrarCliente bCliente,ModificarCliente mCliente) {
        this.vCliente = vCliente;
        this.bCliente=bCliente;
        this.mCliente=mCliente;
        this.vCliente.setVisible(true);
        
        cargarEscuchadores();
    }
    
    public void cargarEscuchadores()
    {
      this.vCliente.getAgregar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
           altaCliente();
          }
      });
              this.bCliente.getBorrar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              borraCliente();
              System.exit(0);
          }              
              }
              );
              this.mCliente.getModificar().addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              modificarCliente();
          }
      });
    }
    
    
    public void altaCliente(){
    
    Agregar.agregarCliente(this.vCliente.getId_cte().getText(),this.vCliente.getNombre().getText()
            , this.vCliente.getApellido().getText(), this.vCliente.getSexo().getText(), this.vCliente.getFnac().getText(), 
            this.vCliente.getTel().getText());
    }
    
    public void borraCliente(){
    Eliminar.eliminarCliente(this.bCliente.getBorrar().getText());
    }
    
    public void modificarCliente(){
    Modificar.modficarCliente(this.mCliente.getIdanterior().getText(), this.mCliente.getNombrenuevo().getText(),
            this.mCliente.getIdnuevo().getText(), this.mCliente.getApellidonuevo().getText(),
            this.mCliente.getSexonuevo().getText(), this.mCliente.getFechanueva().getText(), this.mCliente.getTelnuevo().getText());
    }
    
    
}
