# Prismara (Fase 2)

Mod de Fabric para **Minecraft 26.3**. Esta versión (0.2.1) ya trae la Fase 1 dentro: no hay nada que "juntar" a mano.

## Qué hay
- Mena, bloque y fragmento de **prismita**. La mena ahora **se genera en el Overworld** (bajo tierra, y entre -48 y 48).
- **Códice de Prismara**: lo recibes **la primera vez que entras a un mundo**. Si mueres no te dan otro. Si lo pierdes: **Libro + Fragmento de prismita** (receta sin forma).
- **Glimmerling** (pasivo, prados y bosques floridos) y **Shardback** (hostil, todo el Overworld, suelta fragmentos).

## Compilar con GitHub Actions
Si ya tienes el repositorio de la Fase 1:
1. Descomprime este zip en tu PC.
2. En la página principal del repositorio: **Add file → Upload files**.
3. Arrastra **el contenido** de la carpeta descomprimida (`src`, `build.gradle`, `gradle.properties`, `README.md`...). Los archivos con la misma ruta se sobrescriben solos. La carpeta `.github` no cambió: si ya está en el repo, no hace falta volver a subirla.
4. Abajo: **Commit changes**. El build arranca solo.
5. Pestaña **Actions** → la ejecución más reciente → cuando termine en verde, descarga el artefacto **Artifacts**. Dentro está `prismara-0.2.1.jar` (el que **no** termina en `-sources`).
6. En `mods/` quita `prismara-0.1.0.jar` y pon `prismara-0.2.1.jar` (+ Fabric API 0.166.2+26.3).

Si prefieres Git en el PC: descomprime encima de tu carpeta del repo y ejecuta `git add -A`, `git commit -m "Fase 2"`, `git push`.

Si no tienes repositorio todavía: crea uno vacío y sube todo, incluida la carpeta oculta `.github`.

## Si el build falla
Abre el paso `build`, copia el error completo y pégamelo.

## Probar
- Crea un mundo **nuevo** (o borra tu mundo de prueba): debes empezar con el Códice en el inventario.
- Muere y reaparece: no te dan otro. Fabrícalo con Libro + Fragmento.
- `/summon prismara:glimmerling` y `/summon prismara:shardback` para verlos ya. Fíjate en que las patas se muevan y que no haya texturas moradas y negras.
- Para ver la mena: `/place feature prismara:prismite_ore` o excava; también puedes comprobar que aparece en el Overworld con un mundo nuevo.
