(ns adv2015.day7
  (:require [clojure.pprint :as pp])
  (:gen-class))
  
  
  (defn ttt [fpath]
	(clojure.string/split-lines (slurp fpath))
  )
  
  (def ops {
  :AND bit-and 
  :OR bit-or
  :NOT bit-not
  :LSHIFT bit-shift-left
  :RSHIFT bit-shift-right 
  })
  
  (def db (atom {}))
  
  (def queque (atom []))
  
   (defn make-keyword [this-key arg]
	 (if (re-find #"\d" arg)
		 (Integer/parseInt arg)
		 (let [key (keyword arg)]
			(when  (not (@db key)) 
				(swap! db assoc-in [key :need-by] this-key) )
			key
		 )
      )
	)
	
  ;TODO update other db keys that I miss something. 
  (defn count-need [old arg]
	(if (or (number? arg) ((@db arg) :value)) old (inc old))
   ) 
   

   
  
  (defn parse-line [line]
	(let [vals (re-seq #"\w+" line)
		  result-code (keyword (last vals))]
		;if numeric value supplied - put record into queque else... 
		 (if ( = 2 (count vals))
			(do (swap! queque conj result-code) {result-code {:value (Integer/parseInt (first vals))}})
			; ... else put command and arguments in proper (LISP) order  
		    (let [value  (if ( = 3 (count vals))
							   [:NOT (keyword (second vals ))]
							   [(keyword (second vals)) (make-keyword result-code (first vals )) (make-keyword result-code (nth vals 2))])
				  need	(reduce count-need 0 (rest value))		   
				]
				
					
				{result-code {:value value :need need}}		
		))) 
	) 
  
  
  
  (defn textts []
  (println (Integer/toBinaryString 123))
  
  (println (Integer/toBinaryString 456))
  
  (println "and")
  
  (println (Integer/toBinaryString (bit-and 123 456)))
  
  (println "not")
  
  (println (Integer/toBinaryString (bit-not 123)))
  (println (Integer/toBinaryString (bit-and 65535 (bit-not 123))))
  
 (println "666")
  
 (println ( Integer/toBinaryString 65535))
  (println ( Integer/toBinaryString ( - Integer/MAX_VALUE 65535)))
  
 )