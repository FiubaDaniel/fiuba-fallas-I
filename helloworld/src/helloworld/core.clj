(ns helloworld.core
 (:import [jline.console ConsoleReader]))

(defn -main []
  (print "Enter a keystroke: ")
  (flush)
  (let [cr (ConsoleReader.) 
        keyint (.readCharacter cr)]
    (println (format "Got %d ('%c')!" keyint (char keyint)))
    (if (= keyint 97) (print "Son iguales\n") (print "son distintos\n")) 
    (flush)))

