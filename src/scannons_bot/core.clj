(ns scannons-bot.core
  (:require [clj-http.client :as client]))

(defn f-slash [param] (str param \/))

(defn move [dir, amount] 
  (client/get (str "http://localhost:8080/move/luke/" 
                   ( f-slash dir) 
                   (f-slash amount))))

(defn pau [] (println "hello-s"))

(defn status [] (client/get "http://localhost:8080/status")) 

(defn init []
  (get (status) :body))

(defn -main
  [& args]
  (println "Starting bot")
  (init))
