(ns adv2015.day3-test
  (:require [clojure.test :refer :all]
            [adv2015.day3 :refer :all])) 
			
(deftest test-p1
	(testing "round" 
		(is (= 4 (day-3-p-1 "^>v<"  ))))
	(testing "two" 
		(is (= 2 (day-3-p-1 "^v^v^v^v^v"  ))))
	(testing "one char" 
		(is (= 2 (day-3-p-1 ">"  ))))
)

(deftest test-p2
	(testing "round not" 
		(is (= 3 (day-3-p-2 "^>v<"  ))))
	(testing "large" 
		(is (= 11 (day-3-p-2 "^v^v^v^v^v"  ))))
)