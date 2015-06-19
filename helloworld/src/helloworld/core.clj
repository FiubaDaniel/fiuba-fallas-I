(ns helloworld.core
 (:import [jline.console ConsoleReader]))

 (def memoria)
 (def ^:dynamic desempenio 1)
 (def ^:dynamic desorientacion 1)
 (def problemas)
 (def comprension)
 (def habla)
 (def ubicacion)
 (def juicio)
 (def iniciativa)
 (def personalidad)
 
 
(defn parse-int [s] (Integer/parseInt (re-find #"\A-?\d+" s)))
 
(defn -main []
  (print "Califique con valores de 1 a 5 las siguientes preguntas: [ 1-no posee; 2-baja frecuencia; 3-a veces; 4-seguido; 5-frecuentemente ]\n")
  (print "¿Presenta cambios de memoria que dificultan la vida cotidiana? ")
  (flush)
  (let [cr (ConsoleReader.) 
        memoria (.readCharacter cr)]
        (println (format " %c" (char memoria) )))
  (print "¿Presenta dificultad para planificar o resolver problemas? ")
  (flush)
  (let [cr (ConsoleReader.) 
        problemas (.readCharacter cr)]
        (println (format " %c" (char problemas) )))
  (print "¿Presenta dificultad para desempeñar tareas habituales en la casa, en el trabajo o en su tiempo libre? ")
  (flush)
  (let [cr (ConsoleReader.) 
        desempenio (.readCharacter cr)]
        (println (format " %c" (char desempenio) )))
  (print "¿Presenta desorientación de tiempo o lugar? ")
  (flush)
  (let [cr (ConsoleReader.) 
        desorientacion (.readCharacter cr)]
        (println (format " %c" (char desorientacion) )))
  (print "¿Presenta dificultad para comprender imágenes visuales y cómo objetos se relacionan uno al otro en el ambiente? ")
  (flush)
  (let [cr (ConsoleReader.) 
        comprension (.readCharacter cr)]
        (println (format " %c" (char comprension) )))
  (print "¿Presenta nuevos problemas con el uso de palabras en el habla o lo escrito? ")
  (flush)
  (let [cr (ConsoleReader.) 
        habla (.readCharacter cr)]
        (println (format " %c" (char habla) )))
  (print "¿Suele colocar objetos fuera de lugar y posee falta de habilidad para recordar donde lo puso? ")
  (flush)
  (let [cr (ConsoleReader.) 
        ubicacion (.readCharacter cr)]
        (println (format " %c" (char ubicacion) )))
  (print "¿Presenta disminución o falta del buen juicio? ")
  (flush)
  (let [cr (ConsoleReader.) 
        juicio (.readCharacter cr)]
        (println (format " %c" (char juicio) )))
  (print "¿Presenta pérdida de iniciativa para tomar parte en el trabajo o en las actividades sociales? ")
  (flush)
  (let [cr (ConsoleReader.) 
        iniciativa (.readCharacter cr)]
        (println (format " %c" (char iniciativa) )))
  (print "¿Presenta cambios en el humor o la personalidad? ")
  (flush)
  (let [cr (ConsoleReader.) 
        personalidad (.readCharacter cr)] 
        (println (format " %c" (char personalidad) )))
  
  (println (format "DESEMPENIO: %c" (char desempenio)))
  (if (and (= desempenio 3) (= desorientacion 3) )
	(print "Dificultades de orientación temporal ALTA\n")
	(print "Dificultades de orientación temporal BAJA O MEDIA\n"))
    
)

