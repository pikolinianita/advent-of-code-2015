(ns adv2015.day14
    (:require [clojure.pprint :as pp]
			  [clojure.string :as s])
	(:gen-class))
	
(def d14-time-1  2503)
	
(defrecord Renifer [name speed fly-time wait-time])

;(println (Renifer. "Rudolf" 22 8 165))	

(defn convert-line-to-renifer[line]
	(let [words (s/split line #" ")
		  ti (fn [s] (Integer/parseInt s))]
	(Renifer. (first words) (ti (nth words 3)) (ti (nth words 6)) (ti (nth words 13)))
	)
)

(defn distance-in-time [time ren]
	(let [cycle-time (+ (:fly-time ren) (:wait-time ren))
		  cycle-distance (* (:fly-time ren) (:speed ren))
		  process-left-time (fn [t-left] (if (< t-left (:fly-time ren)) (* (:speed ren) t-left) cycle-distance ))]
		(+ (* (quot time cycle-time) cycle-distance) (process-left-time (mod time cycle-time)))
		
	)
)


(defn day-14-p-1 [lines]
	(apply max (map (partial distance-in-time d14-time-1) (map convert-line-to-renifer lines)))
)

(defn day-14-p-2 [x]
"p2 not done"
)

(defn get-answer [path-to-file]
	(let [lines (s/split-lines (slurp path-to-file))]
		(println "Answer for first part is: " (day-14-p-1 lines)) 
		(println "Answer for second part is: " (day-14-p-2 lines))))


;(get-answer "day14input.txt")