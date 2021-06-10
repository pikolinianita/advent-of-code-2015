(ns adv2015.day3
    (:require [clojure.pprint :as pp])
	(:gen-class))

(def ^:private moves {\< [-1 0], \> [1 0], \^ [0 1], \v [0 -1]})


(defn record-moves [collector point orders]
	(let [result-set (conj collector point)]
	(if (< 0 (count orders))
		(recur result-set (map + point (get moves (first orders))) (next orders))
		result-set
	)))

(defn day-3-p-1 [orders]
	(let [start-point '(0 0)
		  collector #{start-point}]
	(count(record-moves collector start-point orders))))

(defn day-3-p-2 [orders]
	(let [start-point '(0 0)
		  collector #{start-point}
		  collector-after-santa (record-moves collector start-point (take-nth 2 orders))]
	(count (record-moves collector-after-santa start-point (take-nth 2 (next orders))))))

	
(defn get-answer [path-to-file]
	(let [orders  (slurp path-to-file)]
	(println "Answer for first part is: " (day-3-p-1 orders))
	(println "Answer for second part is: " (day-3-p-2 orders))
))