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

(defn action[status]
  (println status)
  (let [opposition (get status "leftCannon")]
  (println opposition) ))

(defn play-game []
  (let [game-state (parse-body status)] 
    (if (empty?  game-state)
      (println "Game not running. Exiting")
      (action game-state))))

(defn -main
  [& args]
  (println "Starting bot")
  (play-game))
