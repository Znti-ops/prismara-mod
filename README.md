# Prismara (Fase 1)

Mod de Fabric para **Minecraft 26.3**. Contenido: Mena de prismita, Bloque de prismita, Fragmento de prismita y el **Códice de Prismara** (clic derecho para abrirlo).

## Compilar con GitHub Actions (sin instalar Java)
1. Crea un repositorio vacío en GitHub y sube **todo** el contenido de esta carpeta (incluida la carpeta oculta `.github`).
2. Entra en la pestaña **Actions**: el workflow `build` corre solo con cada push.
3. Si termina en verde, abre la ejecución y descarga el artefacto **Artifacts**: dentro está `build/libs`.
4. Usa el jar `prismara-0.1.0.jar` (el que **no** termina en `-sources`).
5. Si falla, abre el paso `build`, copia el error completo y pégamelo: lo corrijo.

## Instalar
En tu instancia Fabric 26.3 pon en `mods/`: `fabric-api-0.166.2+26.3.jar` y `prismara-0.1.0.jar`.

## Probar
Modo creativo → pestaña **Prismara**. Comprueba: se ven las texturas, el Códice abre la pantalla y los botones cambian de capítulo, la mena suelta fragmentos con pico de hierro, y 9 fragmentos fabrican el bloque.
