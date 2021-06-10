(ns adv2015.day5
  (:require [clojure.pprint :as pp])
  (:gen-class))
  
  
(defn nice? [msg]
    (and 
		(< 2 (count (re-seq #"[aoeiu]" msg))) ; minimum 3 vowel
		(some? (re-seq #"(\w)\1+" msg))
		(nil? (re-seq #"ab|cd|pq|xy" msg))))
  
(defn nice2? [msg]
    (and 
		(some? (re-seq #"(\w)(\w)\1" msg))
		(some? (re-seq #"(\w)(\w)\w*\1\2" msg))))
  
(defn day-5 [pred? lines ]
	(count (filter pred? lines)))
  
(defn get-answer [path-to-file]
	(let [lines (clojure.string/split-lines (slurp path-to-file))]
	(println "Answer for first part is: " (day-5 nice? lines ))
	(println "Answer for second part is: " (day-5 nice2? lines ))))