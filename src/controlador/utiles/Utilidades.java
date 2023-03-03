/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utiles;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Victor
 */
public class Utilidades {

    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    public static Field obtenetAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }
        return atributo;
    }

    public static Object transformarDato(Field atributo, String dato) {
        Object transformar = null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (atributo.getType().getSimpleName().equals("Integer")) {
                transformar = Integer.parseInt(dato);
            }
        } 
        else if (atributo.getType().isEnum()) {
            Enum enumeracion = Enum.valueOf((Class) atributo.getType(), dato.toString());
            transformar = enumeracion;
        }  
        else if(atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
            transformar = Boolean.parseBoolean(dato);
        }
        else {
            transformar = dato;
        }
        return transformar;
    }

    public static String encriptar(String dato) {

        return Base64.getEncoder().encodeToString(dato.getBytes());
    }

    public static String desencriptar(String dato) {
        return new String(Base64.getDecoder().decode(dato));
    }

    public static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncription = clave.getBytes("UTF-8");
        claveEncription = Arrays.copyOf(claveEncription, 16);
        SecretKeySpec keySpec = new SecretKeySpec(claveEncription, "AES");
        return keySpec;
    }

    public static String encriptarClave(final String datos, final String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = cipher.doFinal(datos.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    public static String decencriptarClave(final String datos, final String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decodeKey = Base64.getDecoder().decode(claveSecreta);
        SecretKey secretKeySpec = crearClave(new String(decodeKey));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] bytesEncriptados = Base64.getDecoder().decode(datos);//desencriptar(datos).getBytes();
        byte[] datosDessencriptados = cipher.doFinal(bytesEncriptados);
        return new String(datosDessencriptados);
    }

    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        cedula = (cedula.length() == 13) ? cedula.substring(0, 10) : cedula;
        
        try {

            if (cedula.length() == 10)
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {

                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } 
                    else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } 
                    else {
                        cedulaCorrecta = false;
                    }
                } 
                else {
                    cedulaCorrecta = false;
                }
            } 
            else {
                cedulaCorrecta = false;
            }
        } 
        catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } 
        catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    public static void main(String[] args) {

        String aux = "9999999998001";
        String ced = aux.substring(0, 10);
        String baj = aux.substring(10, 13);
        System.out.println(ced+" "+baj);
    }

    public static Boolean isNumbre(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    
    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
    
    public static Boolean isPrimitive(Class clase) {
        return clase.isPrimitive();
    }
    
    public static Boolean isObject(Class clase) {
        return (!isPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumbre(clase) && !isString(clase));
    }
}
