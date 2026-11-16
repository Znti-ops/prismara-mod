# Prismara — concepto

**Qué es:** un mod de Fabric para Minecraft 26.3 sobre un reino refractado: arrecifes de cristal flotantes bajo una aurora viva. La luz se parte en colores y cada color tiene una criatura, un peligro y una recompensa.

**Paleta:** magenta #FF3DCB · cian #3DF2FF · lima #B6FF3D · violeta #7B3DFF · oro #FFD23D.

## Plan por fases
| Fase | Contenido | Estado |
|------|-----------|--------|
| 1 | Proyecto Gradle 26.3, prismita (mena, bloque, fragmento), pestaña creativa, Códice con 5 capítulos | hecha |
| 2 | Códice al entrar por primera vez (y receta para recuperarlo), mena en el mundo, 2 criaturas con modelo, textura, IA, loot y spawn natural | **incluida en este zip** |
| 3 | Dimensión (tipo de dimensión, bioma, portal de prismita) | pendiente |
| 4 | Resto de criaturas (6 en total), equipo y herramientas de prismita | pendiente |
| 5 | Jefe «Soberano del Espectro» (fases por color), equipo cromático, botones de demostración en el Códice | pendiente |

## Criaturas previstas (no implementadas aún)
Glimmerling (pasivo), Refract Wisp (neutral, flotante), Shardback (hostil terrestre), Chroma Stalker (hostil a distancia), Lumen Warden (élite) y el jefe Spectrum Sovereign.

## Notas técnicas
- Minecraft 26.3, Fabric Loader 0.20.1, Fabric API 0.166.2+26.3, Java 25 (valores de la plantilla oficial fabric-example-mod, rama 26.3).
- Los formatos de JSON (items, modelos, loot, recetas, tags) se copiaron de los datos vanilla 26.3.
- Las firmas de API del código se contrastaron con el código fuente de Fabric API 26.3 (tests y mods de prueba). Las clases vanilla que Fabric API no usa no se pudieron comprobar sin compilar: si el primer build falla, el error dice exactamente cuál.
