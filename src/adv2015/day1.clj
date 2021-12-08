(ns adv2015.day1
    (:require [clojure.pprint :as pp])
	(:gen-class))
	
	
(defn day-1-p-1 [s] 
	(let [freq (frequencies s)]
	freq
	(- (get freq \( ) (get freq \) ))
))

(defn day-1-p-2 [s]  
	(loop [counter 1 level 0 my-sequence s]
	(let [new-level (if (= (first my-sequence) \)) (dec level) (inc level))]
		(if (= new-level -1) 
		  counter
		  (recur (inc counter) new-level (rest my-sequence)))))) 

(defn get-answer [path-to-file]
	(let [s (slurp path-to-file)]
	(println "Answer for first part is: " (day-1-p-1 s))
	(println "Answer for second part is: " (day-1-p-2 s))
))