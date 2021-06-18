(ns adv2015.day12
    (:require [clojure.pprint :as pp]
				[clojure.string :as s])
	(:gen-class))
	
(defn remove-red-in-vectors 
"remove words red in vectors, and removes ears 'red' -> red"
	[string]
	(s/replace (s/replace (s/replace string "\"" "" ) ;"removed "" - for easier testing
							",red" ",n") 						 ; "red" can be after comma
				"[red" "[nx") 									 ; or after vector opening [
				)

(defn find-opening 
"takes position in string and finds opening { which enclose position"
[string position]
	(loop [pos position 
		   count 1]
		(let [curr-char (get string pos)]
		(cond
			(and (= count 1) (= curr-char \{))
				pos
			(= curr-char \{)
				(recur (dec pos) (dec count))
			(= curr-char \})
				(recur (dec pos) (inc count))
			:default 
				(recur (dec pos)  count)
	))))
	
(defn find-closing
"takes position in string and finds closing } which enclose position"
 [string position]
	(loop [pos position 
		   count 1]
		(let [curr-char (get string pos)]
		(cond
			(and (= count 1) (= curr-char \}))
				pos
			(= curr-char \})
				(recur (inc pos) (dec count))
			(= curr-char \{)
				(recur (inc pos) (inc count))
			:default 
				(recur (inc pos) count)
	))))

(defn remove-objects-with-red 
"removes objects in JSON {} which have field 'red'. input has to have no 'red' in vectors and word red without '' "
	[string] 
		(if-let [pos (s/index-of string "red")]
		(let [opening (find-opening string pos) 
			  closing (find-closing string pos)]
			 (recur (str (subs string 0 opening) (subs string (inc closing)))))
		 string))

(defn day-12-p-1 [file-content]
	(reduce + (map #(Integer/parseInt %) (re-seq #"\-*\d+" file-content))))	

(defn day-12-p-2 [file-content]
 (day-12-p-1 (remove-objects-with-red (remove-red-in-vectors file-content))))
	
(defn get-answer [path-to-file]
	(let [f (slurp path-to-file)]
		(println "Answer for first part is: " (day-12-p-1 f)) 
		(println "Answer for second part is: " (day-12-p-2 f))))
