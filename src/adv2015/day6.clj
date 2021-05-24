(ns adv2015.day6
  (:gen-class))
  
  
  (defn make-board [size]
	(vec (repeat size (vec (repeat size 0))))
  )
  
   (defn set-on [board xy-vec]
	(assoc-in board xy-vec 1)
  )
  
   (defn set-off [board xy-vec]
	(assoc-in board xy-vec 0)
  )
  
  (defn toggle [board xy-vec]
	(let [new-value (if (= 0 (get-in board xy-vec)) 1 0)]
	(assoc-in board xy-vec new-value)
  ))
    
  (defn make-vectors [x1 y1 x2 y2]
	(for [x (range x1 (inc x2))
		  y (range y1 (inc y2))]
		[x y]	
  ))
  
  (defn proc-board [board-arg line]
	(loop  [fun (cond (= (get line 6) \n) set-on
				      (= (get line 6) \f) set-off
					  :else toggle)
		    board board-arg			  
			vctrs (apply make-vectors (map #( Integer/parseInt  %) (re-seq #"\d+" line)))]
			
		(if (empty? vctrs)
		board
	    (recur fun (fun board (first vctrs)) (rest vctrs))
  )))
  
 (defn lights-fun [fpath]
  (loop [board (make-board 1000)
		lines (clojure.string/split-lines (slurp fpath))]
		(if (empty? lines)
			board 
			(recur (proc-board board (first lines)) (rest lines))) 
	))
 
  (defn get-answer [fpath]
	(get (frequencies (flatten (lights-fun fpath))) 1)
  )
 
  (defn lights-fun2 [fpath]
  (loop [board (make-board 1000)
		lines (clojure.string/split-lines (slurp fpath))]
		
	)) 
  
  
  (defn get-answer2 [fpath]
	(reduce + (flatten (lights-fun2 fpath)))
  )
  
  
  