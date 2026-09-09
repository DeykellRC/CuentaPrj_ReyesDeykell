import java.util.Date;

public class Cuenta{
    private String codCuenta = "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas = 0;
    
    public Cuenta(String nombreCuenta, double pSaldo){
        nombreCuentaHabiente = nombreCuenta;
        saldo = pSaldo;
        fechaCreacion = new Date().toString();
        cantDepositosRealizados = 0;
        cantRetirosExitososRealizados = 0;
        cantCuentasCreadas++;
        codCuenta = codCuenta + cantCuentasCreadas;
    }
    
    public Cuenta(double pSaldo){
        this("Cuenta-" + (cantCuentasCreadas + 1), pSaldo);
    }
    
    public void setNombreCuentaHabiente(String pNombreCuentaHabiente){
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
    }
    
    public String getCodCuenta(){
        return codCuenta;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public double depositar(double monto){
        saldo += monto;
        cantDepositosRealizados++;
        return saldo;
    }
    
    public double retirar(double monto){
        if (validarRetiro(monto)){
            cantRetirosExitososRealizados++;
            saldo -= monto;
            return saldo;
        }
        return saldo;
    }
    
    private boolean validarRetiro(double monto){
        return monto <= saldo;
    }
    
    public static int getCantCuentasCreadas(){
        return cantCuentasCreadas;
    }
    
    public String toString(){
        String estado = "";
        estado += "Código: " + codCuenta + "\n";
        estado += "Nombre de la cuenta habiente: " + nombreCuentaHabiente + "\n";
        estado += "Fecha de Creación: " + fechaCreacion + "\n";
        estado += "Saldo: " + saldo + "\n";
        estado += "Cantidad de depósitos realizados: " + cantDepositosRealizados + "\n";
        estado += "Cantidad de retiros exitosos realizados: " + cantRetirosExitososRealizados + "\n";
        return estado; 
    }
}













