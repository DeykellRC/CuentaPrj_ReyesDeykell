import java.util.List;
import java.util.ArrayList;
import java.util.Scanner; 

public class PrincipalCuenta {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Cuenta> listaCuentas = new ArrayList<>();
        int actual = 0;
        boolean salir = false;

        System.out.println("============================================");
        System.out.println("    Administración de Cuentas Bancarias    ");
        System.out.println("============================================");
        
        while(!salir){
            System.out.println("");
            System.out.println("Menú Principal");
            System.out.println("(1) Crear cuenta");
            System.out.println("(2) Conocer la cantidad de cuentas creadas");
            System.out.println("(3) Listar cuentas");
            System.out.println("(4) Seleccionar cuenta actual");
            System.out.println("(5) Asignar el nombre de la cuenta habiente");
            System.out.println("(6) Depositar");
            System.out.println("(7) Retirar");
            System.out.println("(8) Consultar Saldo");
            System.out.println("(9) Consultar estado de la cuenta");
            System.out.println("(10) Salir");
            System.out.println("");
            System.out.print("Ingrese una opción: ");
            String opcion = scanner.nextLine().trim();
            
            switch(opcion){
                case "1": {
                    System.out.print("Ingrese el nombre de la cuenta: (Enter para asignar uno automáticamente)");
                    String lineaNombre = scanner.nextLine().trim();
                    System.out.print("Ingrese el saldo de la cuenta: ");
                    String lineaSaldo = scanner.nextLine().trim();
                    Cuenta cuenta;
                    double saldo;
                    try {
                        saldo = Double.parseDouble(lineaSaldo);
                    }catch (NumberFormatException e){
                        System.out.println("Número de saldo inválido.");
                        break;
                    }
                    
                    if (lineaNombre.isEmpty()){
                     cuenta = new Cuenta(saldo);
                    } else{
                        cuenta = new Cuenta(lineaNombre, saldo);
                    }
                    
                    listaCuentas.add(cuenta);
                    actual = listaCuentas.size() - 1;
                    System.out.println("Cuenta creada y seleccionada correctamente. (índice " + actual + ").");
                    break;
                }
                
                case "2":{
                    int cantidadCuentas = Cuenta.getCantCuentasCreadas();
                    System.out.println("La cantidad de cuentas creadas es: " + cantidadCuentas);
                    break;
                }
            
                case "3":{
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }else{
                        System.out.println(" Índice  ||    Código   ||    Saldo");
                        for (int i = 0; i < listaCuentas.size(); i++){
                            Cuenta cuenta = listaCuentas.get(i);
                            System.out.printf("    %d    ||    %s    ||    %.2f\n",
                            i,
                            cuenta.getCodCuenta(),
                            cuenta.getSaldo());
                        }
                    }
                    break;
                }
                
                case "4": {
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }
                    System.out.print("Ingrese el índice de la cuenta a seleccionar: ");
                    String indiceObtenido = scanner.nextLine().trim();
                    try{
                        int indice = Integer.parseInt(indiceObtenido);
                        if (indice >= 0 && indice < listaCuentas.size()){
                            actual = indice;
                            System.out.println("Cuenta de índice " + indice + " seleccionada correctamente.");
                        }else{
                            System.out.println("Índice fuera de rango.");
                        }
                    }catch(NumberFormatException e){
                        System.out.println("Índice inválido.");
                    }
                    break;
                }
                
                case "5": {
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }
                    System.out.print("Ingrese el nuevo nombre de la cuenta: ");
                    String nuevoNombre = scanner.nextLine().trim();
                    
                    Cuenta cuenta = listaCuentas.get(actual);
                    cuenta.setNombreCuentaHabiente(nuevoNombre);
                    System.out.println("El nombre de la cuenta ha sido cambiado correctamente.");
                    break;
                }
                
                case "6": {
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }
                    System.out.print("Ingrese el monto a depositar: ");
                    String montoObtenido = scanner.nextLine().trim();
                    try{
                        double monto = Double.parseDouble(montoObtenido);
                        Cuenta cuenta = listaCuentas.get(actual);
                        cuenta.depositar(monto);
                        System.out.println("El monto ha sido depositado correctamente. Nuevo saldo: " + cuenta.getSaldo());
                    }catch(NumberFormatException e){
                        System.out.println("Monto ingresado inválido.");
                    }
                    break;
                }  
                
                case "7": {
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }
                    System.out.print("Ingrese el monto a retirar: ");
                    String montoObtenido = scanner.nextLine().trim();
                    try{
                        double monto = Double.parseDouble(montoObtenido);
                        Cuenta cuenta = listaCuentas.get(actual);
                        double saldo = cuenta.getSaldo();
                        cuenta.retirar(monto);
                        double nuevoSaldo = cuenta.getSaldo();
                        if (saldo != nuevoSaldo){   
                            System.out.println("El monto ha sido retirado correctamente. Nuevo saldo: " + cuenta.getSaldo());
                        }else{
                            System.out.println("No es posible retirar el monto ingresado");
                        }
                    }catch(NumberFormatException e){
                        System.out.println("Monto ingresado inválido.");
                    }
                    break;
                }
                    
                case "8": {
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }
                    Cuenta cuenta = listaCuentas.get(actual);
                    double saldo = cuenta.getSaldo();
                    System.out.println("El saldo en la cuenta actual es: " + saldo);
                    break;
                }
                
                case "9": {
                    if(listaCuentas.isEmpty()){
                        System.out.print("Debe crear una cuenta para realizar esta opción.\n");
                        break;
                    }
                    Cuenta cuenta = listaCuentas.get(actual);
                    System.out.println("El estado de la cuenta actual es el siguente: \n" + cuenta.toString());
                    break;
                }
                
                case "10": {
                    salir = true;
                    System.out.println("Se ha salido del programa correctamente, ¡Hasta Pronto!");
                    break;
                }
                
                default:
                    System.out.println("Opción inválida.");
                
            }
        }
        scanner.close();
    }
}