(ns adv2015.day15-test
  (:require [clojure.test :refer :all]
            [adv2015.day15 :refer :all]))
			
(deftest test-parser
	(testing "count" 
		(is (= 0 (calc 25 25 25 25 ))))
		
)