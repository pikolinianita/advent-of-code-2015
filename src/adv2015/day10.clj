(ns adv2015.day10
	(:gen-class))
	
(defn result-p1 
	([s n]
	(let [res (reduce #(str %1 (count %2) (first %2) ) "" (map first (re-seq #"(\w)\1*" s)))]
		(if (= n 1)
			res
			(do 
			;	(println n)
				(recur res (dec n)))
			)
	))
	([s n old]
	(let [res (reduce #(str %1 (count %2) (first %2) ) "" (map first (re-seq #"(\w)\1*" s)))]
		(if (= n 1)
			res
			(do 
			;	(println(float (/ (count res) old )))
				(recur res (dec n) (count res)))
			)
	))
)