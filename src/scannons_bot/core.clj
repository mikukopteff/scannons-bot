(ns scannons-bot.core
  (:require [clj-http.client :as client]))

(def move (client/get "http://localhost:8080/move/luke/s/200"))

(defn init
  []
  (println move))

(defn -main
  [& args]
  (println "Starting bot")
  (init))
