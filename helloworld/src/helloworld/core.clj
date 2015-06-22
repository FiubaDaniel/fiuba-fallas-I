(ns helloworld.core
 (:import [jline.console ConsoleReader]))

; 0 --> BAJA
; 1 --> MEDIA
; 2 --> ALTA 
 
(defn -main []
  (flush)
  (print "Califique con valores de 1 a 5 las siguientes preguntas: [ 1-no posee; 2-baja frecuencia; 3-a veces; 4-seguido; 5-frecuentemente ]\n")
  (flush) 
  (print "¿Presenta cambios de memoria que dificultan la vida cotidiana? ")
  (flush)
  (let [cr (ConsoleReader.) 
        memoria (.readCharacter cr)]
        (println (format " %c" (char memoria)))
        (flush)
        (print "¿Presenta dificultad para planificar o resolver problemas? ") 
        (flush)
        (let [cr (ConsoleReader.) 
             problemas (.readCharacter cr)]
             (println (format " %c" (char problemas)))
             (flush)
             (print "¿Presenta dificultad para desempeñar tareas habituales en la casa, en el trabajo o en su tiempo libre?")
             (flush)
             (let [cr (ConsoleReader.) 
                  desempenio (.readCharacter cr)]
                  (println (format " %c" (char desempenio)))
                  (flush)
                  (print "¿Presenta desorientación de tiempo o lugar? ")  	 
                  (flush)
                  (let [cr (ConsoleReader.) 
					   desorientacion (.readCharacter cr)]
        			   (println (format " %c" (char desorientacion) ))
        			   (flush)
        			   (print "¿Presenta dificultad para comprender imágenes visuales y cómo objetos se relacionan uno al otro en el ambiente? ")
        			   (flush)
        			   (let [cr (ConsoleReader.) 
        					comprension (.readCharacter cr)]
							(println (format " %c" (char comprension) ))
							(flush)
							(print "¿Presenta nuevos problemas con el uso de palabras en el habla o lo escrito? ")
							(flush)
							(let [cr (ConsoleReader.) 
        						 habla (.readCharacter cr)]
        						(println (format " %c" (char habla) ))
        						(flush)
        						(print "¿Suele colocar objetos fuera de lugar y posee falta de habilidad para recordar donde lo puso? ")
        						(flush)
        						(let [cr (ConsoleReader.) 
        							 ubicacion (.readCharacter cr)]
                                     (println (format " %c" (char ubicacion) ))
                                     (flush)
									 (print "¿Presenta disminución o falta del buen juicio? ")
									 (flush)
									 (let [cr (ConsoleReader.) 
        								 juicio (.readCharacter cr)]
        								 (println (format " %c" (char juicio) ))
        								 (flush)
        								 (print "¿Presenta pérdida de iniciativa para tomar parte en el trabajo o en las actividades sociales? ")
        								 (flush)
        								 (let [cr (ConsoleReader.) 
     										  iniciativa (.readCharacter cr)]
        									  (println (format " %c" (char iniciativa) ))
        									  (flush)
        									  (print "¿Presenta cambios en el humor o la personalidad? ")
        									  (flush)
        									  (let [cr (ConsoleReader.) 
													personalidad (.readCharacter cr)] 
													(println (format " %c" (char personalidad) ))
													(def alta 0)
													(def medio 0)
													;# REGLA Nro 1
													(if (and (> (int desempenio) (int \3)) (> (int desorientacion) (int \3)) )
														(do 
															(def alta 1)
															(print "Dificultades de orientación temporal ALTA\n"))
														(if (and (= (int desempenio) (int \3)) (= (int desorientacion) (int \3)))
															(do
																(def medio 1)
																(print "Dificultades de orientación temporal MEDIA\n"))
															(if (or (< (int desempenio) (int \3)) (< (int desorientacion) (int \3)) )
																(do
																	(print "Dificultades de orientación temporal BAJA\n"))
																)))
																
													;# REGLA Nro 2
													(if (and (> (int desorientacion) (int \3)) (> (int ubicacion) (int \3)) )
														(do
															(if	(= (int alta) (int 1))
																(def alta 2)
																(def alta 1))
															(print "Dificultades de orientación espacial ALTA\n"))
														(if (and (> (int desempenio) (int \3)) (or (>= (int desorientacion) (int \3)) (>= (int ubicacion) (int \3))))
															(do
																(if (= (int alta) (int 1))
																	(def alta 2)
																	(if (= (int alta) (int 2))
																	(def alta 2)
																	(def alta 1)))
																(print "Dificultades de orientación espacial ALTA\n"))
															(if (and (= (int desempenio) (int \3)) (= (int desorientacion) (int \3)) )
																(do
																	(if (= (int medio) (int 1))
																		(def medio 2)
																		(def medio 1))
																	(print "Dificultades de orientación espacial MEDIA\n"))
																(if (or (< (int desempenio) (int \3)) (< (int desorientacion) (int \3)) )
																	(do 
																		(print "Dificultades de orientación espacial BAJA\n"))))))

													
													;# REGLA Nro 3
													(if (and (> (int comprension) (int \3)) (> (int desorientacion) (int \3)) )
														(do
															(if (= (int alta) (int 1))
																	(def alta 2)
																	(if (= (int alta) (int 2))
																	(def alta 2)
																	(def alta 1)))
															(print "Daños en aprendisaje ALTA\n"))
															(if (and (or (>= (int problemas) (int \4)) (>= (int iniciativa) (int \4))) (or (> (int comprension) (int \3)) (> (int desorientacion) (int \3)) ))
																(do 
																	(if (= (int alta) (int 1))
																		(def alta 2)
																		(if (= (int alta) (int 2))
																			(def alta 2)
																			(def alta 1)))
																	(print "Daños en aprendisaje ALTA\n"))
																(if (and (or (>= (int problemas) (int \4)) (>= (int iniciativa) (int \4)) (>= (int personalidad) (int \4))) (and (= (int comprension) (int \3)) (= (int desorientacion) (int \3)) ))
																	(do
																		(if	(= (int medio) (int 1))
																			(def medio 2)
																			(if (= (int medio) (int 2))
																				(def medio 3)
																				(def medio 1))
																		)
																		(print "Daños en aprendisaje MEDIA\n"))
																	(if (or (<= (int comprension) (int \3)) (<= (int desorientacion) (int \3)) )
																		(do
																			(print "Daños en aprendisaje BAJA\n"))))))
													
													
													;# REGLA Nro 4
													(if (and (> (int problemas) (int \3)) (> (int comprension) (int \3)) )
														(do
															(print "Daños en la atencion y calculo ALTA\n"))
														(if (and (or (>= (int desempenio) (int \4)) (>= (int ubicacion) (int \4)) (>= (int juicio) (int \4)) (>= (int iniciativa) (int \4)) ) (or (> (int problemas) (int \3)) (> (int comprension) (int \3)) ))
															(do
																(if (= (int alta) (int 1))
																	(def alta 2)
																	(if (= (int alta) (int 2))
																		(def alta 2)
																		(def alta 1)))
																(print "Daños en la atencion y calculo ALTA\n"))
																(if (and (or (= (int problemas) (int \3)) (= (int comprension) (int \3))) (or (>= (int desempenio) (int \3)) (>= (int ubicacion) (int \4)) (>= (int juicio) (int \3)) (>= (int iniciativa) (int \3))) )
																	(do
																		(if	(= (int medio) (int 1))
																			(def medio 2)
																			(if (= (int medio) (int 2))
																				(def medio 3)
																				(if (= (int medio) (int 3))
																					(def medio 4)
																					(def medio 1))))
																		(print "Daños en la atencion y calculo MEDIA\n"))
																		(if (or (< (int problemas) (int \3)) (< (int comprension) (int \3)) )
																			(do 
																				(print "Daños en la atencion y calculo BAJA\n"))))))
													
													;# REGLA Nro 5
													(if (and (> (int memoria) (int \3)) (> (int juicio) (int \3)))
														(do
															(if (= (int alta) (int 1))
																(def alta 2)
																(if (= (int alta) (int 2))
																	(def alta 2)
																	(def alta 1)))
															(print "Daños de memoria ALTA\n"))
														(if (and (> (int desempenio) (int \3)) (or (> (int memoria) (int \3)) (> (int juicio) (int \3))))
															(do
																(if (= (int alta) (int 1))
																	(def alta 2)
																	(if (= (int alta) (int 2))
																		(def alta 2)
																		(def alta 1)))
																(print "Daños de memoria ALTA\n"))
															(if (and (= (int memoria) (int \3)) (or (>= (int problemas) (int \3)) (>= (int desorientacion) (int \3)) (>= (int desempenio) (int \3))))  
																(do
																	(if	(= (int medio) (int 1))
																			(def medio 2)
																			(if (= (int medio) (int 2))
																				(def medio 3)
																				(if (= (int medio) (int 3))
																					(def medio 4)
																					(if (= (int medio) (int 4))
																						(def medio 4)
																						(def medio 1))))
																	)
																	(print "Daños de memoria MEDIA\n"))
																(if (or (< (int memoria) (int \3)) (< (int juicio) (int \3)) )
																	(do
																		(def regla5 0)
																		(print "Daños de memoria BAJA\n"))))))
													
													;# REGLA Nro 6
													(if (> (int habla) (int \3) )
														(do
															(if (= (int alta) (int 1))
																(def alta 2)
																(if (= (int alta) (int 2))
																	(def alta 2)
																	(def alta 1)))
															(print "Daños en el lenguaje ALTA\n"))
														(if (and (= (int habla) (int \3)) (> (int memoria) (int \3)))
															(do
																(if (= (int alta) (int 1))
																	(def alta 2)
																		(if (= (int alta) (int 2))
																		(def alta 2)
																		(def alta 1)))
																(print "Daños en el lenguaje ALTA\n"))
															(if (and (= (int habla) (int \3)) (= (int memoria) (int \3)))
																(do 
																	(if	(= (int medio) (int 1))
																			(def medio 2)
																			(if (= (int medio) (int 2))
																				(def medio 3)
																				(if (= (int medio) (int 3))
																					(def medio 4)
																					(if (= (int medio) (int 4))
																						(def medio 4)
																						(def medio 1))))
																	)
																	(print "Daños en el lenguaje MEDIA\n"))
																(if (or (< (int habla) (int \3)) (< (int memoria) (int \3)))
																	(do
																		(def regla6 0)
																		(print "Daños en el lenguaje BAJA\n"))))))
																		
													;# REGLA Nro7 
													;# Analisis de enfermedad alzheimer. 
													
													(if (= (int alta) (int 2))
														(print "Se recomienda realizar una visita médica.\n")
														(if (and (= (int  alta) (int 1)) (= (int  medio) (int 2)))
															(print "Se recomienda realizar una visita médica.\n")
															(if (= (int medio) (int 4))
																(print "Se recomienda realizar una visita médica.\n")
																(print "No es necesario realizar una visita medica por el momento.\n"))))
												)   
										 )
									)		
								)
							)           
						)       
				)			
			)
		)
	)    
)

