(ns scannons-bot.core
  (:require [clj-http.client :as client], [clojure.data.json :as json]))

(defn f-slash [param] (str param \/))

(defn move [dir, amount] 
  (client/get (str "http://localhost:8080/move/luke/" 
                   (f-slash dir) 
                   (f-slash amount))))

(defn status [] 
  (client/get "http://localhost:8080/status")) 

(defn parse-body [fn-request] 
  (json/read-str (get (fn-request) :body)))


(defn play-game []
  (if (empty?  (parse-body status))
    (println "Game not running. Exiting")
    (println "recursing")))

(defn -main
  [& args]
  (println "Starting bot")
  (play-game))
