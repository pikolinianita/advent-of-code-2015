(ns adv2015.day9
	(:require [clojure.pprint :as pp])
  (:gen-class))
  
(defn find-pivot "find last place in vector where last < next"
	[v]
	(let [x (into [] (reverse v))]	
	 (first (keep-indexed #(if (< %2 (get x %1)) (- (count x) %1 2))
						(rest x)))
))
  
(defn find-place "find position of the smallest item larger than pivot with index larger than pivot"
  [pivot v]
  (when (some? pivot)
	(apply min (filter #(< (get v pivot) %) (subvec v pivot))))
)
  
(defn get-next-perm [v]
	(let [pivot (find-pivot v)
		  change-element (find-place pivot v) ]
	;(println v)
	;(println pivot)
	(when (some? pivot)
	(reduce into [[] (subvec v 0 pivot)
			[(last v)]
			[(get v pivot)]	
			(reverse (subvec v (inc pivot) (-(count v) 1)))])
)))
  
  (defn get-permutations [v]
	(loop [ result [] 
			perm v]
		(if (some? perm)
			(recur (conj result perm) (get-next-perm perm))
			result	
	))
  )
  
  (defn extract-data [str]
	(let [[p1 _ p2 _ dist] (clojure.string/split str #" ")
	]
	[(keyword p1) (keyword p2) (Integer/parseInt dist)] 
	))
  
  (defn make-square-array [n]
	(let [ ^"[[I" arrx (make-array Integer/TYPE n n)]
	;(println (class arrx))
	;(println (class (aget arrx 1 1)))
	;(pp/pprint arrx)
	arrx
  ))
  
   (defn get-answer [fpath]
	(let [lines  (map extract-data (clojure.string/split-lines (slurp fpath)))
		  cities-vec (distinct (flatten (map #( vector  (first %) (second %)) lines)))
		  cities-map (zipmap cities-vec (range))
		  ]
		
		
		(println cities-map)
		cities-map
	))