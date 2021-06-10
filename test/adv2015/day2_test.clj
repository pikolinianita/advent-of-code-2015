(ns adv2015.day2-test
  (:require [clojure.test :refer :all]
            [adv2015.day2 :refer :all])) 
			
(deftest test-p1
	(testing "small" 
		(is (= 58 (day-2-p-1 ["2x3x4"]  ))))
	(testing "large" 
		(is (= 43 (day-2-p-1 ["1x1x10"]  ))))
	(testing "two" 
		(is (= 101 (day-2-p-1 ["1x1x10" "2x3x4"]  ))))
)

(deftest test-p2
	(testing "small" 
		(is (= 34 (day-2-p-2 ["2x3x4"]  ))))
	(testing "large" 
		(is (= 14 (day-2-p-2 ["1x1x10"]  ))))
	(testing "two" 
		(is (= 48 (day-2-p-2 ["1x1x10" "2x3x4"]  ))))
)