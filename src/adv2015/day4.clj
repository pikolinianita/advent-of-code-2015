(ns adv2015.day4
  (:require [clojure.pprint :as pp])
  (:gen-class))
  
(defn part1?
"does start with at least five zeroes?"
 [byte-arr]
  (and 
	(= 0 (get byte-arr 0))
	(= 0 (get byte-arr 1))
	(> 15 (get byte-arr 2))
	(< 0 (get byte-arr 2))))

(defn part2? 
  "does start with at least six zeroes?"
  [byte-arr]	
  (and 
	(= 0 (get byte-arr 0))
	(= 0 (get byte-arr 1))
	(= 0 (get byte-arr 2))))
	
  
(defn helper [mes count pred?]
	"run proper combinations one by one, stops when pred? fulfilled"
	(let [byte-arr (.digest (java.security.MessageDigest/getInstance "MD5") (.getBytes (str mes count)))]
		(if (pred? byte-arr)
			count
			(recur mes (inc count) pred?))))
	 
(defn day-3-p-1
	"find MD5 hashes which, in hexadecimal, start with at least five zeroes"
	[msg]
	(helper msg 0 part1?))
	
(defn day-3-p-2 
	"find MD5 hashes which, in hexadecimal, start with at least six zeroes"
	[msg]
	(helper msg 0 part2?))

(defn get-answer [message]
	(println "Answer for first part is: " (day-3-p-1 message)) 
	(println "Answer for second part is: " (day-3-p-2 message))
)