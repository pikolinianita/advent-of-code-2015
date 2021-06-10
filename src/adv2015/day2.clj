(ns adv2015.day2
    (:require [clojure.pprint :as pp])
	(:gen-class))

(defn digitalize-line 
	"2x3x4 -> [2 3 4]"
	[line]
	(vec (map #(Integer/parseInt %) (re-seq #"\d+" line)))
)

(defn calculate-paper 
	"find the surface area of the box plus the area of the smallest side"
	[dim-vec]
	(let [side-a (* (dim-vec 1) (dim-vec 2))
		  side-b (* (dim-vec 0) (dim-vec 2))
          side-c (* (dim-vec 0) (dim-vec 1))]
	(+ (* 2 (+ side-a side-b side-c)) (min side-a side-b side-c))))

(defn calculate-ribbon 
	"the shortest distance around its sides plus the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present"
	[dim-vec]
	(+
	(* 2 (- (apply + dim-vec) (apply max dim-vec)));wrap around
	(apply * dim-vec))) ;bow
	

(defn day-2-p-1 [lines]
(->> lines
	(map digitalize-line)
	(map calculate-paper)
	(reduce +)))

(defn day-2-p-2 [lines]
(->> lines
	(map digitalize-line)
	(map calculate-ribbon)
	(reduce +)))

	
(defn get-answer [path-to-file]
	(let [lines  (clojure.string/split-lines (slurp path-to-file))]
	(println "Answer for first part is: " (day-2-p-1 lines))
	(println "Answer for second part is: " (day-2-p-2 lines))
))