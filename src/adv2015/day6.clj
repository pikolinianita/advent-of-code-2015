(ns adv2015.day6
  (:gen-class))
    
  (defn make-board 
  "makes square board filled with 0's"
  [size]
	(vec (repeat size (vec (repeat size 0))))
  )
  
   (defn set-on "for day 6 first part" [board xy-vec]
	(assoc-in board xy-vec 1)
  )
  
   (defn set-off "for day 6 first part" [board xy-vec]
	(assoc-in board xy-vec 0)
  )
  
  (defn toggle "for day 6 first part" [board xy-vec]
	(let [new-value (if (= 0 (get-in board xy-vec)) 1 0)]
	(assoc-in board xy-vec new-value)
  ))
    
	(defn incr "for day 6 sec part" [amount board xy-vec ]
		(let [new-value (+ amount (get-in board xy-vec))]
			(assoc-in board xy-vec new-value))
	)
	
	(defn decr1 "for day 6 sec part" [board xy-vec]
		(let [ old-value (get-in board xy-vec)]
				(if (< 0 old-value) (assoc-in board xy-vec (dec old-value)) board))
	)
	
	(defn func-part1 [line]
		(cond 
			(= (get line 6) \n) set-on
			(= (get line 6) \f) set-off
			:else toggle)
	)
	
	(defn func-part2 [line]
		(cond 
			(= (get line 6) \n) (partial incr 1)
			(= (get line 6) \f) decr1
			:else (partial incr 2))
	)
	
  (defn make-vectors [x1 y1 x2 y2]
	(for [x (range x1 (inc x2))
		  y (range y1 (inc y2))]
		[y x]	
  ))
  
  (defn proc-board [fun-arg board-arg line]
	(loop  [fun (fun-arg line)
		    board board-arg			  
			vctrs (apply make-vectors (map #( Integer/parseInt  %) (re-seq #"\d+" line)))]
			
		(if (empty? vctrs)
		board
	    (recur fun (fun board (first vctrs)) (rest vctrs))
  )))
  
 (defn lights-fun [ fun lines-arg bsize]
  (loop [board (make-board bsize)
		lines lines-arg]
		(if (empty? lines)
			board 
			(recur (proc-board fun board (first lines)) (rest lines))) 
	))
 
  (defn get-answer [fpath]
	(let [lines  (clojure.string/split-lines (slurp fpath))]
	(get (frequencies (flatten (lights-fun func-part1 lines 1000))) 1)
  ))
  
  (defn get-answer2 [fpath]
  (let [lines  (clojure.string/split-lines (slurp fpath))]
	(reduce + (flatten (lights-fun func-part2 lines 1000)))
  ))
   