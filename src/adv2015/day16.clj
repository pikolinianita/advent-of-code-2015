(ns adv2015.day16
    (:require [clojure.pprint :as pp]
			  [clojure.string :as s]
			   [clojure.test :as tst])
	(:gen-class))

(def MFCSAM {
		:children 3
		:cats 7
		:samoyeds 2
		:pomeranians 3
		:akitas 0
		:vizslas 0
		:goldfish 5
		:trees 3
		:cars 2
		:perfumes 1
})

(def OST_MFCSAM {
		:children [= 3]
		:cats [< 7 ]
		:samoyeds [= 2]
		:pomeranians [> 3]
		:akitas [= 0]
		:vizslas [= 0]
		:goldfish [> 5]
		:trees [< 3]
		:cars [= 2]
		:perfumes [= 1]
})

(defn MF-check [[k v]]
 (if  (= :Sue k) 
       v 
	   (if (= v (k MFCSAM)) true false)))
	   
(defn MF-check-p2 [[k v]]
 (if  (= :Sue k) 
       v 
	  (if (eval (concat (k OST_MFCSAM) [v])) true false)))

(defn parse-aunt [line & {:keys [fun] :or {fun MF-check}}]
	(let [words (s/split line #"[ :,]+")
			ti (fn [s] (Integer/parseInt s))
			key-and-int (fn [[v1 v2]] (vector (keyword v1) (ti v2)))
			verify-aunt (fn [vec] (if (every? true? (rest vec)) (first vec) nil))]
	
	(->> words
			(partition 2 2)
			(map key-and-int)
			(map fun)
			(verify-aunt)
	)))	

(defn day-16-p-1 [lines]
 (first (filter some? (map parse-aunt lines)))
)

(defn day-16-p-2 [lines]
(first (filter some? (map #(parse-aunt % :fun MF-check-p2) lines)))
)

(defn get-answer [path-to-file]
	(let [lines (s/split-lines (slurp path-to-file))]
		(println "Answer for first part is: " (day-16-p-1 lines)) 
		(println "Answer for second part is: " (day-16-p-2 lines))))
		
(get-answer "day16input.txt")	 	