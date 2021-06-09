(ns adv2015.day8
  (:gen-class))
  
  (defn prep-str [str]
	(let [fstr str
		  n-chars (count fstr)
		  n-quot (count (re-seq #"\"" fstr)) ;"
		  n-esc-sl (count (re-seq #"\\\\" fstr))
		  n-esc-q (count (re-seq #"\\\"" fstr)) ;"
		  n-numbers (count (re-seq #"[^\\]\\x" fstr)) 
		  nr (count (re-seq #"\r" fstr))
		  result (+ n-quot n-esc-sl (* 3 n-numbers) )]
	(println fstr) 
	(println "n: " n-chars " q: "  n-quot " sl: "  n-esc-sl " eq: "  n-esc-q " num: " n-numbers " lines: " nr)
	(println "result: " result)
	result
))
  
  
  (defn get-answer [fpath]
	(let [lines  (clojure.string/split-lines (slurp fpath))]
		
		(map #(println % " " (count %) ": " (prep-str %)) lines)  
))

(defn get-answer2 [fpath]

	(let [fstr (slurp fpath)
		  n-chars (count fstr)
		  n-quot (count (re-seq #"\"" fstr)) ;"))
		  n-esc-sl (count (re-seq #"\\\\" fstr))
		  n-esc-q (count (re-seq #"\\\"" fstr)) ;"))
		  n-numbers (count (re-seq #"[^\\]((\\{2})*)\\x" fstr)) 
		  nr (count (re-seq #"\r" fstr))
		  result (+ n-quot n-esc-sl (* 3 n-numbers) )]
	(println fstr) 
	(println "n: " n-chars " q: "  n-quot " sl: "  n-esc-sl " eq: "  n-esc-q " num: " n-numbers " lines: " nr)
	(println "result: " result) 
	result
	 
))

(defn do-part-2 [str]
	(let [n-quot (count (re-seq #"\"" str)) ;"))
		  n-esc-sl (count (re-seq #"\\" str))
		  nr (count (re-seq #"\r" str))
		  result (+ n-quot n-esc-sl (* 2 (+ 1 nr)))
		]
		(println str " \n\rq: " n-quot  " sl: "  n-esc-sl " lines: "  nr " result: " result)   
		
	)
)

(defn  get-answer3 [fpath]
	(do-part-2 (slurp fpath)) 
)
