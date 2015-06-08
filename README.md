# fiuba-fallas-I
Tp de fallas. Sistema experto desarrodo en clojure

Clojure

Instalación: 	

	1- Descargar el paquete de clojure: http://clojure.org/downloads 
	   Version 1.6.0. 
	2- Descomprimir en algun directorio elegido. 
	3- Ir al directorio donde se descomprimio y ejecutar el siguiente comando:
	   java -cp clojure-1.6.0.jar clojure.main 
	4- Opcional: Instalar leiningen. Permite crear script rapidamente. 
	   sudo apt-get install leiningen	
	
Trabajar por linea de comando (hello world):

	1- lein repl
	2- user=> (prn "Hello World")
	
Crear un scrip: 
	
	1- lein new helloworld (Crea un nuevo proyecto llamado "helloworld"). 
	2- Agregar main en project.clj. 
	   :main helloworld.core 	
	3- Agregar codigo en  el core.clj ubicado en la carpeta /src/helloworld/ 
	4- Correr el script desde la carpeta donde esta el projecto como: 
	   lein run 
