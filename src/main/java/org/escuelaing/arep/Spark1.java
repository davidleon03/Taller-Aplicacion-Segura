package org.escuelaing.arep;

import static spark.Spark.*;
public class Spark1 {
    /**

     Este método es el punto de entrada principal de la aplicación.
     Configura la seguridad de la aplicación utilizando el archivo KeyStore y la contraseña proporcionados por los métodos getKeyStore() y getPwdStore().
     Luego, configura el puerto en el que se ejecutará la aplicación utilizando el método getPort().
     Finalmente, configura las rutas de los endpoints que se utilizarán en la aplicación.
     La ruta "/local" devolverá un mensaje "Hello Local Maquina 2", mientras que la ruta "/aws" llamará al método URLreaderSecure.readSecureUrl() para obtener y devolver una URL segura.
     @param args - Los argumentos de línea de comandos (no utilizados en este método).
     */
    public static void main(String... args) {
        secure(getKeyStore(), getPwdStore() , null, null);
        port(getPort());
        get("/local", (req, res) -> "Hello Local Maquina 1");
        get("/aws", (req, res) -> URLreaderSecure.readSecureUrl(getUrl(), getKeyOtherStore(), getPwdStore()));
    }
    /**

     Este método devuelve la URL que se utilizará en la aplicación.
     Si la variable de entorno URL está configurada, devuelve el valor de PORT de la variable de entorno.
     De lo contrario, devuelve una URL predeterminada.
     @return String - La URL que se utilizará en la aplicación.
     */
    private static String getUrl() {
        if (System.getenv("URL") != null) {
            return System.getenv("PORT");
        }
        return "https://ec2-44-213-110-235.compute-1.amazonaws.com:5001/helloLocal";
    }
    /**

     Este método devuelve el puerto que se utilizará en la aplicación.
     Si la variable de entorno PORT está configurada, devuelve el valor de PORT de la variable de entorno como entero.
     De lo contrario, devuelve un valor predeterminado.
     @return int - El puerto que se utilizará en la aplicación.
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 3000;
    }
    /**

     Este método devuelve la ruta del archivo KeyStore que se utilizará en la aplicación.
     Si la variable de entorno KEYSTORE está configurada, devuelve el valor de KEYSTORE de la variable de entorno.
     De lo contrario, devuelve una ruta predeterminada.
     @return String - La ruta del archivo KeyStore que se utilizará en la aplicación.
     */
    public static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificados/spark1/ecikeystore1.p12";
    }
    /**

     Este método devuelve la ruta del archivo KeyStore que se utilizará en la aplicación.
     Si la variable de entorno KEYSTORE está configurada, devuelve el valor de KEYSTORE de la variable de entorno.
     De lo contrario, devuelve una ruta predeterminada.
     @return String - La ruta del archivo KeyStore que se utilizará en la aplicación.
     */
    public static String getKeyOtherStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificados/spark2/ecikeystore2.p12";
    }
    /**

     Este método devuelve la contraseña del archivo KeyStore que se utilizará en la aplicación.
     Si la variable de entorno PWDSTORE está configurada, devuelve el valor de PWDSTORE de la variable de entorno.
     De lo contrario, devuelve una contraseña predeterminada.
     @return String - La contraseña del archivo KeyStore que se utilizará en la aplicación.
     */
    public static String getPwdStore() {
        if (System.getenv("PWDSTORE") != null) {
            return System.getenv("PWDSTORE");
        }
        return "123456";
    }
}
