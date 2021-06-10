(ns adv2015.day4-test
  (:require [clojure.test :refer :all]
            [adv2015.day4 :refer :all]))
			
(deftest day4 
	(testing "abcdef"
		(is (= 609043 (helper "abcdef" 609000 part1?))))
	(testing "pqrstuv"
		(is (= 1048970 (helper "pqrstuv" 1040000 part1?))))
)

(deftest day4-p2 
	(testing "abcdef"
		(is (= 6742839 (helper "abcdef" 6742500 part2?))))
	(testing "pqrstuv"
		(is (= 5714438 (helper "pqrstuv" 5714000 part2?))))
)