(ns adv2015.day7-test
  (:require [clojure.test :refer :all]
            [adv2015.day7 :refer :all])) 

(defn reset-q [f]
        (do (reset! queque [])
			(reset! db {}))
        (f)
        (do ;(println " ----- ")
			;(println @db)
			;(println " ----- ")
			))		

(use-fixtures :each reset-q)
			
(deftest day7-p1

	(testing "day7:"
		(testing "part one parser"
			(let [result  (parse-line "123 -> x")]
				(is (= {:x {:value 123}} result ))
				(is (= [:x]  @queque ))  
				
			)
			(is (= {:d  {:need 2 :value [:AND :x :y] } } (parse-line "x AND y -> d")))
			(is (= {:h  {:need 1 :value [:NOT :x] }} (parse-line "NOT x -> h")))
			(is (= {:f  {:need 1 :value [:LSHIFT :x 2] }} (parse-line "x LSHIFT 2 -> f")))
			
		)))
		
	(deftest day7-p2	 
		(testing "part one parser v2"
			(let [result  (parse-line "123 -> x")]
				(is (= {:x {:value 123}} result ))
				(is (= [:x]  @queque )) 
			
			)) 
		

)  