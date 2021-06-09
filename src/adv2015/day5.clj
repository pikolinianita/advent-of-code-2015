(ns adv2015.day5
  (:require [clojure.pprint :as pp])
  (:gen-class))
  
  
  (defn nice? [msg]
    (and 
		(< 2 (count (re-seq #"[aoeiu]" msg))) ; minimum 3 vowel
		(some? (re-seq #"(\w)\1+" msg))
		(nil? (re-seq #"ab|cd|pq|xy" msg))
	)
  )
  
  (defn nice2? [msg]
    (and 
		(some? (re-seq #"(\w)(\w)\1" msg))
		(some? (re-seq #"(\w)(\w)\w*\1\2" msg))
	)
  )
  
  
  (defn nice-number [fpath]
	(count (filter nice? (clojure.string/split-lines (slurp fpath))))
  )
  
  (defn p2-nice-number [fpath]
	(->> fpath
		(slurp)
		(clojure.string/split-lines)
		(filter nice2?)
		(count))  
  )