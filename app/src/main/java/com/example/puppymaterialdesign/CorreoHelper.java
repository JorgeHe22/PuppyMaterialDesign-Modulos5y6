package com.example.puppymaterialdesign;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/** SMTP didáctico. Nunca introducir contraseñas personales en un repositorio. */
public final class CorreoHelper {
 private CorreoHelper(){}
 private static final ExecutorService EXECUTOR=Executors.newSingleThreadExecutor();
 public interface Resultado { void terminado(boolean exito,String detalle); }
 public static void enviar(String nombre,String correo,String comentario,Resultado callback){
  if(BuildConfig.SMTP_USER.isEmpty()||BuildConfig.SMTP_PASS.isEmpty()||BuildConfig.SMTP_TO.isEmpty()){
   callback.terminado(false,"Configura smtp.user, smtp.pass y smtp.to en local.properties según INSTRUCCIONES.md.");return;
  }
  EXECUTOR.execute(()->{
   try{
    Properties props=new Properties();
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.port","587");
    props.put("mail.smtp.connectiontimeout","10000");
    props.put("mail.smtp.timeout","10000");
    Session session=Session.getInstance(props,new Authenticator(){
      @Override protected PasswordAuthentication getPasswordAuthentication(){
       return new PasswordAuthentication(BuildConfig.SMTP_USER,BuildConfig.SMTP_PASS);
      }
    });
    MimeMessage mensaje=new MimeMessage(session);
    mensaje.setFrom(new InternetAddress(BuildConfig.SMTP_USER));
    mensaje.setRecipients(Message.RecipientType.TO,InternetAddress.parse(BuildConfig.SMTP_TO));
    mensaje.setReplyTo(new InternetAddress[]{new InternetAddress(correo)});
    mensaje.setSubject("Puppy: nuevo comentario","UTF-8");
    mensaje.setText("Nombre: "+nombre+"\nCorreo: "+correo+"\n\nComentario:\n"+comentario,"UTF-8");
    Transport.send(mensaje);
    callback.terminado(true,"Tu comentario se envió correctamente.");
   }catch(Exception e){callback.terminado(false,"No fue posible enviar el correo. Revisa conexión y configuración SMTP. Detalle: "+e.getClass().getSimpleName());}
  });
 }
}
