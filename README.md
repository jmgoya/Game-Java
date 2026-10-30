# Kit de la Game Jam Java

Kit base para la competencia de videojuegos. Requiere un JDK 11 o superior.

## Compilar y ejecutar

| Sistema | Compilar | Ejecutar la demo | Ejecutar otra clase |
| --- | --- | --- | --- |
| Linux / macOS | `./compilar.sh` | `./ejecutar.sh` | `./ejecutar.sh paquete.Clase` |
| Windows | `compilar.bat` | `ejecutar.bat` | `ejecutar.bat paquete.Clase` |

En un IDE (IntelliJ, Eclipse, NetBeans): abran la carpeta `src` como carpeta de fuentes y configuren la codificación en **UTF-8**.
Si ven caracteres raros en pantalla o en la consola, es la codificación.

## Primeros 10 minutos

1. Compilen y ejecuten la demo: `demo.Main`. Click crea pelotas, 1 a 5 cambia el material, R limpia.
2. Ejecuten `verificador.PruebaMisEstructuras`. Debe imprimir OK para Lista, Pila y Cola.
3. Lean `demo/EscenaDemo.java`: es el ejemplo mínimo de una escena con mundo, entidades y HUD.

## Paquetes

| Paquete | Contenido | ¿Se modifica? |
| --- | --- | --- |
| `motor` | Ventana, bucle de juego, entrada, escenas, mundo, temporizador | No |
| `contratos` | Interfaces `Actualizable`, `Dibujable`, `Colisionable`, `Estadisticas` | No |
| `estructuras` | Interfaces `Lista<T>`, `Pila<T>`, `Cola<T>` y la clase base `ListaBase<T>` | Aquí van sus TADs |
| `entidades` | Clase abstracta `Entidad` | No (se hereda) |
| `fisica` | `Cuerpo`, `Material`, `Fisica` | No (se hereda) |
| `provisorio` | Estructuras temporales para arrancar sin esperar a las propias | No se pueden usar en la entrega |
| `ui` | `Texto` y `HudBasico` de ejemplo | Se puede extender o reemplazar |
| `verificador` | Pruebas automáticas de sus TADs | No |
| `demo` | Ejemplo de uso del kit | Referencia |

Sus clases van en paquetes propios, por ejemplo `juego`, `ui` (nuevas clases) o el nombre del juego.
