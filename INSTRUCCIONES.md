# Puppy Material · Módulos 5 y 6

Esta carpeta contiene el **proyecto completo basado en el ZIP original**, sin `.git`, `.gradle`, compilaciones ni credenciales. Conserva el paquete `com.example.puppymaterialdesign`, el tema `Theme.Puppy`, el RecyclerView y la Activity de favoritos.

## Instalación (recomendada)
1. Haz copia de seguridad de tu proyecto `PuppyMaterialDesign_Modulos5y6` ya abierto en Android Studio.
2. Cierra ese proyecto. Copia **el contenido** de esta carpeta sobre tu copia local (no sobre el proyecto original del Módulo 3). Reemplaza únicamente los archivos con igual nombre; las clases y los recursos nuevos se agregan.
3. No reemplaces `local.properties` de tu equipo: este paquete no contiene uno. Tampoco sobrescribas los archivos generados por Android Studio que no estén aquí.
4. Abre el proyecto o pulsa **Sync Project with Gradle Files**. Necesitarás Internet para resolver las dependencias nuevas.
5. Ejecuta la app en tu emulador. Pruébala antes de añadir claves SMTP.

## Qué probar
- Menú superior (tres puntos): Contacto y Acerca De; estrella: favoritos previos.
- Pestaña Mascotas: lista existente y rating; pestaña Perfil de Milo: avatar circular y 6 tarjetas en Grid de 2 columnas con huesos.
- Contacto: valida nombre, correo y mensaje; botón envía por JavaMail solo si configuras SMTP.
- Acerca de: editar la biografía y sustituir avatar_desarrollador.jpg por una foto propia si deseas.
- Las imágenes `milo_01.jpg` a `milo_06.jpg` son **ilustraciones de prueba**, no fotografías reales; puedes sustituirlas por fotos JPG conservando exactamente los nombres.

## Configuración de correo (SOLO prueba local)
En el archivo `local.properties` del proyecto Android Studio agrega SIN COMILLAS:

```
smtp.user=tu_cuenta@gmail.com
smtp.pass=CLAVE_DE_APLICACION
smtp.to=tu_cuenta@gmail.com
```

Usa una **contraseña de aplicación** habilitada por tu proveedor (no la contraseña principal). Este ejemplo emplea SMTP Gmail, TLS, puerto 587. Si no se configuran las propiedades, el formulario informará que falta la configuración; **no afirmará haber enviado correos**.

**ADVERTENCIA:** las propiedades se incorporan en BuildConfig y pueden extraerse de un APK. Mantén `local.properties` fuera de Git y **no distribuyas/publices APK con claves reales**. Usa una cuenta desechable de pruebas y revoca la clave al terminar. Para producción, mueve el envío a un backend con credenciales privadas.

## Cambios importantes
- `MainActivity.java` y `activity_main.xml` **se reemplazan**: ahora alojan ViewPager2 con dos Fragments.
- `menu_principal.xml`, `AndroidManifest.xml` y `app/build.gradle` **se reemplazan/actualizan**.
- `Mascota.java`, `MascotaAdapter.java`, `MascotasDataSet.java` y `FavoritosActivity.java` se conservan.
- `app/src/main/res/values/themes.xml` y `colors.xml` se conservan.
- La librería de correo usa `javax.mail` de `com.sun.mail:android-mail:1.6.7`, no clases `jakarta.mail`.

## Capturas sugeridas
Lista en Fragment, perfil con galería de 2 columnas, menú expandido, Contacto, Acerca de y Favoritos.
