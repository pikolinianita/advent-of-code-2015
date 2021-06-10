(ns adv2015.day1-test
  (:require [clojure.test :refer :all]
            [adv2015.day1 :refer :all]))  
			
(deftest test-p1
	(testing "zeero" 
		(is (= 0 (day-1-p-1 "(())"  ))))
	(testing "rwo" 
		(is (= 2 (day-1-p-1 "(()("  ))))
	(testing "minus-two" 
		(is (= -2 (day-1-p-1 ")())"  ))))
)

(deftest test-p2
	(testing "five" 
		(is (= 5 (day-1-p-2 "(()))"  )))))