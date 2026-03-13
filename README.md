# EjerciciosArboles
Ejercicios usando estructura de datos Arbol General, Arbol Binario

Ejercicio: Gestión de un Árbol Genealógico
Implementar un sistema para gestionar un árbol genealógico utilizando un Árbol
General. Cada nodo del árbol representará una persona y podrá tener múltiples
hijos (descendientes directos).

Cada nodo debe almacenar:
▪ Nombre de la persona.
▪ Fecha de nacimiento.
▪ Género (opcional).

Contenido del ejercicio:
- Función para agregar personas al árbol,
estableciendo relaciones padre/madre-hijo(a).
- Búsqueda de Antepasados
- Listado de Descendientes
- Eliminación de una Rama Familiar
- Profundidad de la Generación
- Recorrido por Generaciones



Ejercicio: Simulación de un Torneo de Cuartos de Final con un Árbol Binario
Implementar un sistema que modele las rondas de cuartos de final, semifinales y
final de un torneo utilizando un árbol binario. Cada nodo del árbol representa un
partido entre dos equipos, donde los ganadores avanzan a la siguiente ronda.

Requisitos del Ejercicio

1. Construcción del Árbol:
o Crea un árbol binario con 8 equipos iniciales, distribuidos en 4
partidos de cuartos de final (nodos hoja).
o Los nodos internos representarán semifinales (2 partidos) y la final
(1 partido).
2. Simulación de Partidos:
o Cada nodo almacena los dos equipos que compiten y el ganador.
o Implementa una función que simule los partidos:
▪ En cuartos de final, el ganador se elige aleatoriamente.
▪ Los ganadores de cada ronda avanzan automáticamente a la
siguiente (semifinales y final).
3. Determinación del Campeón:
o Simula todas las rondas del torneo, desde cuartos hasta la final, y
muestra el equipo campeón.
4. Visualización del Bracket:
o Muestra el árbol en formato de bracket, indicando en cada partido:
▪ Equipos participantes.
▪ Ganador.
▪ Ronda (cuartos, semifinales, final).

