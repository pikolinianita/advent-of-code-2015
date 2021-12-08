(ns adv2015.day10-test
  (:require [clojure.test :refer [deftest testing is]]
            [adv2015.day10 :refer :all])) 
			
			
(deftest test-examples
	(testing "one" 
		(is (= "11" (result-p1 "1" 1 ))))
	(testing "two" 
		(is  (= "21" (result-p1 "1" 2 ))))
	(testing "three" 
		(is (= "1211" (result-p1 "1" 3 ))))
	(testing "four" 
		(is (= "111221" (result-p1 "1" 4 ))))
	(testing "five" 
		(is (= "312211" (result-p1 "1" 5 ))))
	(testing "four" 
		(is (= "111221" (result-p1 "1211" 1 ))))
	(testing "five" 
		(is (= "312211" (result-p1 "111221" 1 ))))
	)